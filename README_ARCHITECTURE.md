# Pokedex App Architecture Overview

Dự án được thiết kế theo kiến trúc chuẩn **MVVM (Model-View-ViewModel)** nhằm đảm bảo tính mở rộng, dễ bảo trì và tối ưu hiệu năng cho báo cáo kỹ thuật.

## 1. Sơ đồ kiến trúc hệ thống (Báo cáo)

```mermaid
flowchart TD
    %% Định nghĩa Style
    classDef viewLayer fill:#e1f5fe,stroke:#01579b,stroke-width:2px,color:#01579b
    classDef vmLayer fill:#fff9c4,stroke:#fbc02d,stroke-width:2px,color:#f57f17
    classDef modelLayer fill:#e8f5e9,stroke:#2e7d32,stroke-width:2px,color:#1b5e20
    classDef dataSource fill:#ffffff,stroke:#333,stroke-dasharray: 5 5

    %% TẦNG VIEW
    subgraph View_Layer ["Tầng View (Jetpack Compose UI)"]
        direction LR
        HS[HomeScreen]
        PS[PokemonScreen]
        PDS[DetailScreen]
        IS[ItemScreen]
    end

    %% TẦNG VIEWMODEL
    subgraph VM_Layer ["Tầng ViewModel"]
        direction LR
        PVM[PokemonViewModel]
        IVM[ItemViewModel]
    end

    %% TẦNG MODEL & DATA
    subgraph Model_Layer ["Tầng Model (Data & Repository)"]
        Repo[PokemonRepository]
        
        subgraph Data_Sources ["Data Sources"]
            API[PokeApiService]
            DB[(Room DB)]
            ML[ML Kit AI]
        end
    end

    %% KẾT NỐI (Kết nối các node đại diện)
    HS & PS & PDS & IS <--> PVM & IVM
    PVM & IVM --> Repo
    Repo --> API
    Repo <--> DB
    Repo --> ML

    %% Áp dụng Style
    class HS,PS,PDS,IS viewLayer
    class PVM,IVM vmLayer
    class Repo modelLayer
    class API,DB,ML dataSource
```

## 2. Tài liệu thiết kế luồng (Diagrams)

### 2.1. Sơ đồ luồng hoạt động (Activity Diagram)
Sơ đồ mô tả logic xử lý dữ liệu và AI với bố cục tối ưu: Chữ to rõ nét, các bước được nén gọn để vừa vặn trong khung hình báo cáo mà không cần phóng to/thu nhỏ.

```mermaid
flowchart TD
    %% Định nghĩa Style
    classDef s fill:#e1f5fe,stroke:#01579b,stroke-width:2px
    classDef p fill:#ffffff,stroke:#333,stroke-width:1px
    classDef d fill:#fff9c4,stroke:#fbc02d,stroke-width:1px
    classDef a fill:#e8f5e9,stroke:#2e7d32,stroke-width:2px

    %% LUỒNG CHÍNH
    Start([Bắt đầu]) --> Init[Init VM/Repo] --> DB{Dữ liệu?}
    
    DB -- "Trống" --> API[Tải & Lưu API]
    DB -- "Có" --> List[Hiện Danh sách]
    API --> List

    List --> Act{Thao tác?}
    Act -- "Lọc/Cuộn" --> API
    Act -- "Chọn" --> Det{Chi tiết?}
    
    Det -- "Chưa" --> Get[Tải & Lưu] --> Trans
    Det -- "Rồi" --> Trans{Đã dịch?}
    
    Trans -- "Chưa" --> AI[[AI: ML Kit]] --> Save[Lưu dịch] --> Final
    Trans -- "Rồi" --> Final([Màn hình Chi tiết])

    %% Áp dụng Style
    class Start,Final s
    class Init,API,List,Get,Save p
    class DB,Act,Det,Trans d
    class AI a
```

### 2.2. Sơ đồ tuần tự (Sequence Diagram)
Mô tả quy trình tương tác chi tiết giữa các thành phần, giữ phong cách "Ảnh 1" nhưng bổ sung đầy đủ logic như "Ảnh 2".

```mermaid
sequenceDiagram
    autonumber
    participant U as Người dùng
    participant V as View / ViewModel
    participant R as Repository
    participant D as Data (Room/API/AI)

    Note over U,D: 1. Khởi tạo & Hiển thị Danh sách
    V->>R: Truy vấn danh sách Pokemon
    R->>D: Kiểm tra Local DB (Room)
    alt DB chưa có dữ liệu
        R->>D: Gọi PokeAPI lấy danh sách
        D-->>R: Trả về JSON Data
        R->>D: Lưu vào Room Database
    else DB đã có dữ liệu
        D-->>R: Trả về danh sách từ Cache
    end
    R-->>V: Cập nhật StateFlow<List>
    V-->>U: Hiển thị danh sách từ Local DB

    Note over U,D: 2. Tương tác (Cuộn/Lọc/Tìm kiếm)
    alt Cuộn trang
        U->>V: Cuộn xuống cuối trang
        V->>R: Yêu cầu tải thêm trang mới
        R->>D: Gọi API bổ sung & Cập nhật DB
    else Tìm kiếm / Lọc
        U->>V: Nhập từ khóa / Chọn Type
        V->>V: Logic lọc: Reactive trên StateFlow
        V-->>U: Cập nhật danh sách hiển thị
    end

    Note over U,D: 3. Xem Chi tiết & Xử lý AI
    U->>V: Chọn 1 Pokemon cụ thể
    V->>R: Lấy thông tin chi tiết
    R->>D: Kiểm tra chi tiết trong DB
    alt Dữ liệu chi tiết chưa có
        R->>D: Gọi API lấy thông tin chi tiết
        D-->>R: Trả về Object chi tiết
        R->>D: Cập nhật chi tiết vào DB
    end
    
    R->>D: Kiểm tra bản dịch mô tả
    opt Chưa có bản dịch (Dữ liệu mới)
        R->>D: Google ML Kit: Dịch mô tả
        D-->>R: Trả về bản dịch Tiếng Việt
        R->>D: Lưu bản dịch vào DB
    end
    
    R-->>V: Cập nhật UI State (Detail)
    V-->>U: Hiển thị màn hình chi tiết hoàn chỉnh
```

## 3. Giải thích thành phần chính
- **Offline-First**: Ứng dụng luôn ưu tiên hiển thị dữ liệu từ Room DB để đảm bảo tốc độ.
- **AI Engine**: Sử dụng Google ML Kit để dịch thuật mô tả Pokemon hoàn toàn tự động.
- **Reactive UI**: Sử dụng StateFlow để cập nhật giao diện ngay khi dữ liệu thay đổi.
