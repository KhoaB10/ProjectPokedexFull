# TÀI LIỆU CẤU TRÚC HỆ THỐNG POKÉDEX 3 (TOÀN DIỆN)

Tài liệu này cung cấp cái nhìn chi tiết về kiến trúc hệ thống, giải thích ý nghĩa từng đoạn mã và chức năng của 20 thành phần cốt lõi trong ứng dụng Pokedex 3.

---

## I. CHI TIẾT 20 THÀNH PHẦN CỐT LÕI (CODE-LEVEL)

### A. TẦNG DỮ LIỆU (DATA LAYER)

**1. PokemonDao.kt & ItemDao (Local Data Access):**
- `getAllPokemon()`: (Hàm) Trả về `Flow<List<Pokemon>>`. Tự động phát tín hiệu khi dữ liệu SQLite thay đổi.
- `insertAll(list)`: (Hàm) Lưu hàng loạt dữ liệu vào DB với chiến lược `REPLACE` để cập nhật thông tin mới nhất.
- `getPokemonById(id)`: (Hàm) Truy vấn trực tiếp một Pokemon (hỗ trợ ID chuỗi như "6.1").

**2. PokemonDatabase.kt (Room Database):**
- `pokemonDao()`, `itemDao()`: (Hàm Abstract) Cung cấp điểm truy cập vào các thực thể trong Database.
- `entities`: (Biến/Cấu hình) Khai báo danh sách các bảng (Pokemon, Item).

**3. PokeApiService.kt (Remote API):**
- `getPokemonList(limit, offset)`: (Hàm) Lấy danh sách thô từ PokeAPI.
- `getPokemonDetails(name)`: (Hàm) Lấy chỉ số, kỹ năng, hình ảnh.
- `getEvolutionChain(id)`: (Hàm) Lấy dữ liệu thô về cây tiến hóa.

**4. PokemonRepository.kt (Data Mediator):**
- `fetchAndCachePokemon()`: (Hàm) Logic chính: Kiểm tra API -> Mix với Custom Data -> Lưu Room.
- `parseEvolutionChain()`: (Hàm) Sử dụng đệ quy để biến cấu trúc cây tiến hóa lồng nhau của API thành danh sách phẳng dễ hiển thị.
- `extractIdFromUrl()`: (Hàm) Tiện ích để lấy ID từ URL của PokeAPI (do API không trả về ID trực tiếp trong danh sách).

**5. PokemonCustomData.kt (Manual Meta Data):**
- `assignments`: (Biến Map) Ánh xạ ID Pokemon với các thông tin thủ công như Tier (T0, T1), Role (Sweeper, Wall) và Tags.

### B. TẦNG MÔ HÌNH (MODEL LAYER)

**6. Item.kt (Item Entity):**
- `id`, `name`, `category`, `effect`: (Biến) Các thuộc tính cơ bản của vật phẩm trong game.

**7. Pokemon.kt (Pokemon Entity & Converters):**
- `id: String`: (Biến) Khóa chính. Dùng String để hỗ trợ các dạng Mega/Gigantamax.
- `pveTier`, `pvp1v1Tier`: (Biến) Lưu trữ xếp hạng sức mạnh.
- `Converters`: (Lớp nội bộ) Chứa hàm `fromMoveList`, `toMoveList` dùng GSON để nén đối tượng phức tạp thành chuỗi JSON lưu vào SQLite.

### C. TẦNG GIAO DIỆN (UI LAYER)

**8. MainAppLayout.kt:**
- `MainAppLayout`: (Composable) Quản lý `ModalNavigationDrawer` và `Scaffold`, tạo khung sườn nhất nhất quán cho toàn app.

**9. PrivacyFooter.kt & 10. PrivacyPolicySection.kt:**
- (Composable) Hiển thị thông tin pháp lý và bản quyền hình ảnh từ Nintendo/GameFreak.

**11. ShortcutCard.kt:**
- (Composable) Nhận vào `ShortcutItem` (title, icon, route) để vẽ các nút bấm nhanh tại trang chủ.

**12. NavGraph.kt (Navigation Central):**
- `PokedexNavGraph`: (Hàm) Định nghĩa `NavHost`, chứa tất cả các "Route" (đường dẫn) và logic truyền tham số giữa các màn hình.

**13. GuideScreen.kt (Bách khoa toàn thư):**
- `NatureTable`: (Composable) Bảng tra cứu 25 tính cách (Nature) và các chỉ số tăng/giảm tương ứng.
- `TypeEffectivenessTable`: (Composable) Ma trận tương khắc giữa 18 hệ Pokemon.

**14. HomeScreen.kt:**
- `HomeHeaderSection`: (Composable) Hiển thị lời chào và tổng quan ứng dụng.

**15. ItemScreen.kt & 16. ItemViewModel.kt:**
- `itemList`: (StateFlow) Danh sách vật phẩm đã qua lọc (theo tên hoặc danh mục).
- `loadNextPage()`: (Hàm) Xử lý phân trang cho danh sách vật phẩm.

**17. PokemonDetailScreen.kt (Chi tiết sâu):**
- `EvolutionTree`: (Composable) Vẽ sơ đồ tiến hóa dựa trên dữ liệu đệ quy từ Repository.
- `BaseStatsSection`: (Composable) Vẽ biểu đồ thanh (bar chart) cho các chỉ số HP, Atk, Def...

**18. PokemonScreen.kt (Danh sách chính):**
- `PokemonRow`: (Composable) Hiển thị một dòng Pokemon với đầy đủ hệ, chỉ số nhanh và Tier.
- `SortType (ID, NAME)`: (Enum) Định nghĩa các kiểu sắp xếp.

**19. PokemonViewModel.kt (Pokedex Logic):**
- `pokemonList`: (StateFlow) Luồng dữ liệu chính được quan sát từ Room.
- `loadNextPage()`: (Hàm) Tăng `currentOffset` và yêu cầu Repository tải thêm dữ liệu.

**20. TierScreen.kt (Ranking UI):**
- `TierRowUniform`: (Composable) Hiển thị một hàng cho một bậc (ví dụ Tier T0) trải dài qua các vai trò (Sweeper, Support, Wall).

---

## II. CÁC LUỒNG XỬ LÝ ĐẶC THU (DEEP DIVE LOGIC)

### 1. Luồng Offline-First (API ➔ Room ➔ UI)
Repository đóng vai trò kiểm soát. Khi UI yêu cầu dữ liệu, Repository sẽ:
1. Trả về dữ liệu hiện có trong Room ngay lập tức (thông qua Flow).
2. Song song đó, gọi API để lấy dữ liệu mới nhất.
3. Cập nhật dữ liệu mới vào Room. Flow sẽ tự động phát tín hiệu để UI vẽ lại mà không cần người dùng load lại trang.

### 2. Xử lý ID phức tạp (Mega, Regional & Alternate Forms)
Để quản lý hàng ngàn dạng Pokemon mà vẫn giữ được thứ tự bách khoa toàn thư, chúng tôi thiết kế hệ thống ID phân cấp:

- **ID Lưu trữ (Storage ID - Database Key)**: Dùng kiểu `String`. 
    - Pokemon gốc: `19` (Rattata), `386` (Deoxys).
    - Các dạng biến thể: `19.1` (Alola Rattata), `386.1` (Deoxys Attack), `6.2` (Mega Charizard Y).
- **Thứ tự sắp xếp (SortOrder)**: Sử dụng số thực (`6.0`, `6.0001`). 
    - Giúp các dạng biến thể luôn "đi kèm" ngay sau Pokemon gốc thay vì bị đẩy xuống cuối danh sách.

### 3. Thiết kế hệ thống lấy và đồng bộ dữ liệu (Sync & Persistence Design)
- **Giải pháp "N+1 Fetching" tối ưu**: Sử dụng `coroutineScope` và `async` để tải song song hàng chục yêu cầu chi tiết (về Move, Ability, Stats) cùng lúc.
- **Cơ chế "Phẳng hóa" cây tiến hóa (Evolution Flattening)**: Thiết kế hàm đệ quy `parseEvolutionChain` để biến đổi cấu trúc lồng nhau thành danh sách phẳng.
- **Bộ chuyển đổi dữ liệu phức tạp (Type Converters)**: Sử dụng GSON để "nén" các cấu trúc dữ liệu phức tạp thành chuỗi JSON khi lưu vào SQLite.

---
*Tài liệu này được cập nhật vào ngày 22/05/2026 dựa trên mã nguồn thực tế của dự án.*
