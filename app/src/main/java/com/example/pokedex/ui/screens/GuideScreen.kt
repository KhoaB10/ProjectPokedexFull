package com.example.pokedex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.components.PrivacyPolicySection
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun GuideScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E26))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Breadcrumbs
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        ) {
            Text(
                text = "Home",
                color = Color(0xFF00B0FF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Text(
                text = " > ",
                color = Color(0xFFB0B0B0),
                fontSize = 12.sp
            )
            Text(
                text = "Giới thiệu về game",
                color = Color(0xFFB0B0B0),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Giới thiệu về game",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = "Tất cả những gì bạn cần biết về pokemon.",
            color = Color(0xFFB0B0B0),
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(
            text = "Last updated: 22/05/2026",
            color = Color(0xFFB0B0B0),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "Giới thiệu về game",
            content = "Pokémon là một tựa game nhập vai đánh theo lượt mang đậm phong cách JRPG cổ điển. Trò chơi được chia thành hai chế độ chính: thế giới bên ngoài và chiến đấu. Trong thế giới bên ngoài, bạn sẽ di chuyển quanh bản đồ và khi chạm trán với một Pokémon hoang dã hoặc bị một nhà huấn luyện khác bắt gặp, bạn sẽ 'chuyển' vào chế độ chiến đấu, nơi bạn phải chỉ huy đội hình Pokémon của mình để đánh bại đối thủ thông qua các màn giao tranh theo lượt.\n" +
                    "\n" +
                    "Chúng ta sẽ nói chi tiết hơn về chế độ thế giới bên ngoài (hay còn gọi là thám hiểm) và cơ chế chiến đấu ở một phần riêng biệt ở phía dưới của bài hướng dẫn này."
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "POKEMON",
            content = "Pokémon là các sinh vật chiến đấu chính mà bạn có thể điều khiển trong trò chơi. Chúng chủ yếu được thu thập thông qua việc ném Poké Ball để thu phục khi bạn khám phá thế giới tự nhiên. Tuy nhiên, một số Pokémon đặc biệt có thể nhận được miễn phí thông qua tiến trình cốt truyện, các món quà từ NPC hoặc các sự kiện trong game.",
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Chỉ số Pokémon",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val stats = listOf(
                    "HP" to "Đây là sinh lực hay sức chịu đựng tổng thể của Pokémon. Khi nhận sát thương, lượng HP sẽ giảm xuống. Nếu HP tụt về mức 0, Pokémon sẽ rơi vào trạng thái bất tỉnh (Faint) và không thể tiếp tục chiến đấu",
                    "ATK" to "Xác định lượng sát thương gây ra khi Pokémon sử dụng các chiêu thức phân loại vật lý (Physical Moves). Đây thường là các đòn đánh mang tính chất va chạm, tiếp xúc trực tiếp như đấm, đá, cắn, hoặc húc",
                    "DEF" to "Quyết định khả năng chống chịu của Pokémon trước các đòn tấn công vật lý của đối thủ. Chỉ số này càng cao, lượng HP mất đi khi trúng đòn vật lý sẽ càng thấp.",
                    "Special ATK" to "Xác định lượng sát thương gây ra khi Pokémon sử dụng các chiêu thức phân loại đặc biệt (Special Moves). Đây thường là các đòn đánh dựa trên năng lượng, nguyên tố phóng ra từ xa như phun lửa, bắn tia nước, hoặc phóng sét",
                    "Special Defense" to "Quyết định khả năng chống chịu trước các đòn tấn công đặc biệt. Tương tự như Defense, Sp. Def càng cao thì lượng máu mất đi khi trúng các chiêu thức hệ năng lượng từ đối phương sẽ càng ít",
                    "Speed" to "Quyết định thứ tự ra đòn trong một hiệp đấu. Theo quy tắc thông thường, Pokémon nào có chỉ số Speed cao hơn trên sân sẽ được quyền hành động và tấn công trước (trừ trường hợp có sự can thiệp của các chiêu thức ưu tiên tấn công trước - Priority Moves như Quick Attack)."
                )

                stats.forEach { (label, desc) ->
                    Row(modifier = Modifier.padding(vertical = 2.dp)) {
                        Text(text = "• ", color = Color.White, fontSize = 15.sp)
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(label)
                                }
                                append(" - $desc")
                            },
                            color = Color.White,
                            fontSize = 15.sp,
                            lineHeight = 22.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Hệ Pokémon",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Mỗi Pokémon trong game đều mang một hoặc hai Hệ (Type) nhất định. Hệ của Pokémon quyết định hiệu quả của các chiêu thức khi tấn công và khả năng phòng thủ của chúng trước các đòn đánh từ đối thủ.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Hiện tại có 18 hệ trong trò chơi:",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val types = listOf(
                    "Normal" to Color(0xFFA8A77A),
                    "Fire" to Color(0xFFEE8130),
                    "Water" to Color(0xFF6390F0),
                    "Grass" to Color(0xFF7AC74C),
                    "Electric" to Color(0xFFF7D02C),
                    "Ice" to Color(0xFF96D9D6),
                    "Fighting" to Color(0xFFC22E28),
                    "Poison" to Color(0xFFA33EA1),
                    "Ground" to Color(0xFFE2BF65),
                    "Flying" to Color(0xFFA98FF3),
                    "Psychic" to Color(0xFFF95587),
                    "Bug" to Color(0xFFA6B91A),
                    "Rock" to Color(0xFFB6A136),
                    "Ghost" to Color(0xFF735797),
                    "Dragon" to Color(0xFF6F35FC),
                    "Dark" to Color(0xFF705746),
                    "Steel" to Color(0xFFB7B7CE),
                    "Fairy" to Color(0xFFD685AD)
                )

                types.forEach { (name, color) ->
                    Row(
                        modifier = Modifier.padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "• ", color = Color.White, fontSize = 15.sp)
                        Text(
                            text = name,
                            color = color,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))


            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "Sự phát triển của POKEMON",
            content = "Việc phát triển Pokémon là yếu tố cốt lõi giúp bạn vượt qua những thử thách khó khăn trong game. Quá trình này không chỉ dừng lại ở việc tăng cấp mà còn bao gồm nhiều cơ chế chuyên sâu khác.",
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))

                // Tiến hóa
                Text(
                    text = "Tiến hóa (Evolution)",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Tiến hóa trong Pokémon là một quá trình biến đổi sinh học đặc biệt, trong đó một Pokémon thay đổi vĩnh viễn thành một loài khác có hình thái phát triển hơn và mạnh mẽ hơn. Khi quá trình này xảy ra, Pokémon thường sẽ có sự lột xác lớn về ngoại hình, gia tăng đáng kể các chỉ số cơ bản (Base Stats), và đôi khi thay đổi cả hệ (Type), đặc tính (Ability) cũng như danh sách chiêu thức (Movepool) có thể học được. Khác với tiến hóa siêu cấp (Mega Evolution) hay hóa khổng lồ (Dynamax/Gigantamax) chỉ là những hình thái biến đổi tạm thời trong trận đấu, tiến hóa thông thường là một quá trình không thể đảo ngược. Khi một Pokémon đã tiến hóa, nó sẽ giữ nguyên hình dạng mới đó mãi mãi. Người chơi hoàn toàn có quyền chủ động ngăn chặn quá trình này bằng cách nhấn nút B trên máy chơi game khi hoạt ảnh tiến hóa đang diễn ra, hoặc cho Pokémon cầm vật phẩm Everstone (Đá Bất Biến) để giữ nguyên hình dáng nhỏ nhắn ban đầu nhằm học các chiêu thức mạnh sớm hơn.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Base Stats
                Text(
                    text = "Chỉ số cơ bản (Base Stats)",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Chỉ số cơ bản, hay Base Stats, là những giá trị ẩn được lập trình sẵn và cố định cho từng loài Pokémon cụ thể, đóng vai trò như một bộ gen đặc trưng định hình sức mạnh bẩm sinh của loài đó. Trong thế giới game, mọi cá thể thuộc cùng một loài và cùng một hình thái tiến hóa sẽ luôn sở hữu chung một bộ chỉ số cơ bản giống hệt nhau. Đây chính là yếu tố cốt lõi nhất quyết định điểm mạnh và điểm yếu bẩm sinh của một Pokémon trước khi xét đến các yếu tố mang tính cá nhân hóa như điểm nỗ lực (EVs) hay tiềm năng cá thể (IVs). Nhờ có hệ thống chỉ số cơ bản này mà mỗi loài sinh vật đều mang một bản sắc chiến đấu riêng biệt không thể nhầm lẫn.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // IVs
                Text(
                    text = "Chỉ số cá thể (IVs - Individual Values)",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Chỉ số cá thể hay còn được gọi tắt là IVs, đóng vai trò như hệ gen di truyền bẩm sinh của từng cá thể Pokémon riêng biệt. Mặc dù hai sinh vật có thể hoàn toàn giống nhau về loài, có cùng cấp độ, cùng bản tính và cùng bộ chỉ số cơ bản, sức mạnh của chúng vẫn sẽ có sự chênh lệch nhất định nhờ vào IVs. Ngay tại khoảnh khắc một quả trứng nở ra, hoặc khi bạn chạm trán một Pokémon hoang dã trong tự nhiên, hệ thống sẽ tự động gán ngẫu nhiên một giá trị từ 0 đến 31 cho mỗi hạng mục trong sáu chỉ số cốt lõi. Giá trị này đại diện cho tiềm năng phát triển tự nhiên của sinh vật, trong đó mức 31 được xem là điểm số hoàn hảo tuyệt đối cho một chỉ số.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // EVs
                Text(
                    text = "Chỉ số nỗ lực (EVs - Effort Values)",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Điểm nỗ lực, hay EVs (Effort Values), là những chỉ số ẩn tượng trưng cho quá trình rèn luyện và tích lũy kinh nghiệm chiến đấu thực tế của Pokémon. Khác với chỉ số cơ bản (Base Stats) được quy định chặt chẽ bởi giống loài, hay chỉ số cá thể (IVs) mang tính di truyền bẩm sinh, EVs là yếu tố hoàn toàn nằm trong tầm kiểm soát và do người chơi chủ động định hướng. Mỗi khi đánh bại một Pokémon đối phương, cá thể của bạn không chỉ nhận được điểm kinh nghiệm để thăng cấp mà còn thu về một lượng điểm nỗ lực nhất định, phụ thuộc trực tiếp vào chủng loại của sinh vật vừa bị hạ gục. Hệ thống trò chơi thiết lập những quy tắc giới hạn rất chặt chẽ về lượng điểm nỗ lực mà một sinh vật có thể hấp thụ nhằm đảm bảo tính cân bằng chiến thuật. Một cá thể Pokémon chỉ có thể tích lũy tối đa 510 điểm nỗ lực tổng cộng cho tất cả sáu chỉ số. Đồng thời, một hạng mục chỉ số đơn lẻ cũng bị giới hạn sức chứa và chỉ được phép nhận tối đa 252 điểm. Dựa trên công thức tính toán sức mạnh khi Pokémon đạt đến cấp độ 100, cứ mỗi 4 điểm EVs được đầu tư vào một hạng mục, sinh vật đó sẽ được cộng thêm chính xác một điểm thực tế vào chỉ số tương ứng. Như vậy, thông qua việc phân bổ EVs tối đa vào một chỉ số, người chơi có thể gia tăng đến 63 điểm thực tế, tạo ra một hố sâu chênh lệch sức mạnh vô cùng to lớn giữa một Pokémon được huấn luyện chiến đấu chuyên nghiệp và một cá thể bắt bừa ngoài tự nhiên. Bên cạnh việc hạ gục Pokémon hoang dã thủ công khá tốn thời gian, các nhà huấn luyện có thể đẩy nhanh tiến độ bằng cách sử dụng các loại thực phẩm bổ sung (Vitamins) như Protein, Calcium hay Carbos để bơm trực tiếp điểm nỗ lực. Mỗi lọ vitamin thường mang lại mười điểm, và ở các thế hệ game mới nhất, người chơi hoàn toàn có thể dùng tiền mua lượng lớn vitamin để đổ đầy một chỉ số lên mức tối đa ngay lập tức. Ngoài ra, tốc độ cày cuốc có thể được nhân lên nhiều lần nếu người chơi cho Pokémon đeo các trang bị tạ huấn luyện (Power Items) để tăng lượng điểm nhận được sau mỗi trận. Đặc biệt, nếu Pokémon may mắn bị nhiễm một loại virus hiếm có lợi mang tên Pokérus, lượng điểm nỗ lực thu về từ các trận chiến sẽ tự động được nhân đôi. Trong cuộc phiêu lưu dài ngày, những Pokémon trong đội hình chính thường vô tình đánh bại nhiều loài khác nhau và hấp thụ một mớ điểm nỗ lực hỗn tạp, làm lãng phí quỹ giới hạn 510 điểm quý giá. Để khắc phục sự cố này và tối ưu hóa lại sức mạnh, game cung cấp các công cụ giúp tẩy xóa điểm nỗ lực thừa thãi. Phương pháp truyền thống nhất là cho Pokémon ăn một nhóm quả mọng đặc biệt (EV-reducing Berries), mỗi quả sẽ tẩy đi mười điểm nỗ lực của một chỉ số nhất định đồng thời làm sinh vật đó vui vẻ hơn.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Nature
                Text(
                    text = "Tính Cách (Nature)",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Tính Cách, hay Nature, là một cơ chế phản ánh đặc điểm tính cách riêng biệt của mỗi cá thể Pokémon, được giới thiệu lần đầu từ thế hệ thứ ba. Trong số hai mươi lăm Tính Cách tồn tại trong thế giới game, có hai mươi Tính Cách sẽ tác động trực tiếp đến sự phát triển chỉ số của sinh vật bằng cách hoạt động như một hệ số nhân. Cụ thể, khi một Pokémon sở hữu những Tính Cách này, một chỉ số cốt lõi của chúng sẽ được tăng cường 10% sức mạnh ở mức tối đa, nhưng bù lại, một chỉ số khác sẽ bị giảm đi tương ứng 10%. Năm chỉ số có thể bị ảnh hưởng bởi quá trình cộng trừ này bao gồm tấn công, phòng thủ, tấn công đặc biệt, phòng thủ đặc biệt và tốc độ, trong khi lượng máu (HP) là ngoại lệ duy nhất không bao giờ bị tác động. Năm Tính Cách còn lại thuộc nhóm trung lập, không cộng thêm cũng không trừ đi bất kỳ chỉ số nào, tạo ra sự phát triển cân bằng nhưng hiếm khi được ưu chuộng trong môi trường thi đấu chuyên nghiệp.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )

                NatureTable()
                
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Cách xem bảng Tính cách:",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Hàng ngang trên cùng đại diện cho chỉ số bị Giảm (-), cột dọc ngoài cùng bên trái đại diện cho chỉ số được Tăng (+). Giao điểm giữa hàng và cột chính là tên Tính cách tương ứng. Các ô màu xám trên đường chéo là các Tính cách trung lập (không tăng giảm).",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "KHÁM PHÁ THẾ GIỚI (OVERWORLD)",
            content = "Thế giới Pokémon vô cùng rộng lớn với nhiều môi trường khác nhau từ đồng cỏ, rừng rậm đến hang động và biển cả.",
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Cơ Chế Bắt Pokémon",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Để thu phục một Pokémon, bạn cần sử dụng Poké Ball. Tỷ lệ thành công phụ thuộc vào ba yếu tố chính: Lượng máu hiện tại (càng thấp càng tốt), Trạng thái bất lợi (Ngủ và Đóng băng tăng tỷ lệ bắt cao nhất, sau đó là Tê liệt, Bỏng, Độc), và Chỉ số bắt giữ (Catch Rate) riêng biệt của loài đó.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Vật phẩm ẩn & NPC",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Đừng quên trò chuyện với mọi NPC bạn gặp, họ có thể cung cấp thông tin hữu ích, vật phẩm quý giá hoặc thậm chí là Pokémon. Hãy chú ý tìm kiếm các vật phẩm ẩn trên mặt đất, đôi khi chúng là những món đồ rất hiếm.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "VẬT PHẨM (ITEMS)",
            content = "Hệ thống vật phẩm đa dạng giúp bạn hồi phục, tăng sức mạnh hoặc hỗ trợ quá trình thu phục Pokémon.",
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))

                val items = listOf(
                    "Poké Balls" to "Có rất nhiều loại bóng như Great Ball (1.5x), Ultra Ball (2.0x). Các loại bóng chuyên dụng như Net Ball (3.5x với hệ Nước/Bọ), Quick Ball (5x nếu dùng ở lượt đầu), hay Dusk Ball (3x trong hang/ban đêm) là công cụ đắc lực cho các nhà huấn luyện.",
                    "Hồi phục (Medicine)" to "Potion và các cấp độ cao hơn dùng để hồi máu. Revive để hồi sinh Pokémon đã ngất. Full Heal giúp xóa bỏ mọi trạng thái bất lợi như Tê liệt hay Bỏng.",
                    "Vật phẩm cầm tay (Held Items)" to "Mỗi Pokémon có thể cầm một vật phẩm. Leftovers giúp hồi máu mỗi lượt, Life Orb tăng sát thương nhưng mất máu khi đánh, Choice Scarf tăng tốc độ nhưng chỉ được dùng một chiêu thức duy nhất.",
                    "Vật phẩm tiến hóa" to "Nhiều Pokémon chỉ tiến hóa khi sử dụng các loại đá nguyên tố (Fire Stone, Water Stone,...) hoặc trao đổi khi đang cầm vật phẩm đặc biệt (Metal Coat, King's Rock)."
                )

                items.forEach { (label, desc) ->
                    Row(modifier = Modifier.padding(vertical = 4.dp)) {
                        Text(text = "• ", color = Color.White, fontSize = 15.sp)
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF00B0FF))) {
                                    append(label)
                                }
                                append(": $desc")
                            },
                            color = Color.White,
                            fontSize = 15.sp,
                            lineHeight = 22.sp
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "CƠ CHẾ BẮT ĐẶC BIỆT",
            content = "Ngoài việc bắt Pokemon trên cỏ, trò chơi còn cung cấp nhiều phương thức khác để làm phong phú đội hình của bạn.",
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Câu cá & Lướt sóng",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Sử dụng cần câu (Rod) tại các vực nước để bắt các loài cá như Magikarp hay Feebas. Khi có kỹ năng Surf, bạn có thể cưỡi Pokémon trên mặt nước để gặp những loài sống ở đại dương xa xôi.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Text(
                    text = "Pokémon Huyền Thoại",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Đây là những sinh vật cực kỳ hiếm với tỷ lệ bắt mặc định rất thấp (thường chỉ 3). Lời khuyên là hãy chuẩn bị thật nhiều Ultra Ball/Timer Ball, đưa chúng về 1 HP (bằng chiêu False Swipe) và gây trạng thái Ngủ trước khi ném bóng. Master Ball là lựa chọn cuối cùng giúp bắt thành công 100%.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        GuideSection(
            title = "COMBAT",
            content = "Cơ chế chiến đấu cốt lõi của Pokémon xoay quanh hệ thống đánh theo lượt truyền thống. Trong mỗi một hiệp đấu, các huấn luyện viên sẽ có quyền lựa chọn một trong bốn hành động chính: chỉ định Pokémon tung chiêu thức, sử dụng vật phẩm hỗ trợ từ túi đồ, thu hồi Pokémon hiện tại để tung một cá thể khác ra sân, hoặc cố gắng bỏ chạy nếu đang đối đầu với Pokémon hoang dã. Khi mọi mệnh lệnh đã được đưa ra, hệ thống sẽ tự động giải quyết các hành động dựa trên quy tắc thứ tự nghiêm ngặt. Việc thay đổi Pokémon hoặc sử dụng vật phẩm luôn diễn ra trước tiên. Đối với việc tung chiêu thức, sinh vật nào sở hữu chỉ số tốc độ (Speed) cao hơn trên sân sẽ được quyền ra đòn trước. Tuy nhiên, quy luật này có thể bị phá vỡ bởi Độ ưu tiên (Priority) của chiêu thức.",
            extraContent = {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Hệ Sinh Thái Khắc Chế Nguyên Tố:",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Linh hồn của hệ thống combat chính là bảng tương sinh tương khắc giữa mười tám hệ (Type) nguyên tố khác nhau. Mỗi cá thể Pokémon mang trong mình một hoặc hai hệ nhất định, và mỗi chiêu thức tung ra cũng thuộc một hệ cụ thể. Khi đòn đánh trúng đích, sát thương sẽ được nhân lên gấp đôi (Super Effective) nếu hệ của chiêu thức khắc chế hệ của mục tiêu, hoặc bị giảm đi một nửa (Not Very Effective) nếu bị kháng lại. Trong trường hợp mục tiêu mang hai hệ cùng lúc, sát thương khắc chế có thể được nhân lên đến bốn lần hoặc giảm xuống chỉ còn một phần tư. Thậm chí, có những hệ hoàn toàn miễn nhiễm sát thương từ hệ khác. Ngoài ra, nếu một Pokémon sử dụng chiêu thức đồng nhất với hệ bẩm sinh của mình, đòn đánh đó sẽ được cộng thêm năm mươi phần trăm sức mạnh, được cộng đồng gọi là hiệu ứng STAB (Same-Type Attack Bonus).",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                TypeEffectivenessTable()
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Hệ Sinh Thái Khắc Chế Nguyên Tố:",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Mọi chiêu thức trong game được chia thành ba hạng mục phân biệt rõ ràng. Chiêu thức Vật lý (Physical) sẽ tính toán lượng máu mất đi dựa trên sự đụng độ giữa chỉ số tấn công của kẻ ra đòn và phòng thủ của kẻ chịu đòn. Chiêu thức Đặc biệt (Special) lại dùng chỉ số tấn công đặc biệt và phòng thủ đặc biệt để so tài năng lượng. Hạng mục thứ ba là nhóm chiêu Trạng thái (Status), không hề gây ra sát thương trực tiếp lên thanh máu mà được dùng để thay đổi cục diện trận đấu. Nhóm này bao gồm các đòn múa may, gầm gừ nhằm cường hóa sức mạnh cho phe ta, làm suy yếu chỉ số phe địch, hoặc thao túng thời tiết và môi trường trên sân đấu để tạo lợi thế chiến thuật lâu dài.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Hiệu Ứng Bất Lợi Lên Trạng Thái:",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Trận đấu không chỉ là cuộc thi xem ai gây sát thương to hơn, mà còn là nghệ thuật kiểm soát trạng thái của đối phương. Các hiệu ứng bất lợi vĩnh viễn (Non-volatile Status) như Bỏng, Độc, Tê liệt, Ngủ và Đóng băng sẽ bám theo Pokémon ngay cả khi chúng được rút về quả cầu Pokéball. Mỗi hiệu ứng mang một sự trừng phạt tàn khốc riêng: trạng thái Bỏng sẽ cắt giảm một nửa sức tấn công vật lý, Tê liệt làm tốc độ giảm đi một nửa và có tỷ lệ khiến sinh vật không thể ra đòn, trong khi Độc sẽ ăn mòn thanh máu qua từng hiệp. Song song đó là các hiệu ứng tạm thời (Volatile Status) như Lúng túng (Confusion) khiến Pokémon tự đánh vào bản thân, hoặc Bị khuất phục (Flinch) làm mất trắng một lượt đi, tạo ra những biến số lật kèo vô cùng bất ngờ.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Đặc Tính Bẩm Sinh Và Vật Phẩm Cầm Tay:",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Sự đa dạng của combat còn được khuếch đại bởi Đặc tính (Ability) và Vật phẩm cầm tay (Held Items). Đặc tính là những kỹ năng bị động được kích hoạt tự động khi thỏa mãn điều kiện nhất định. Có những đặc tính giúp tăng sát thương khi lượng máu còn thấp, phản lại sát thương khi bị chạm vào, hoặc gọi ra một cơn mưa giông ngay khi vừa xuất hiện trên sân. Kết hợp cùng đặc tính là vật phẩm cầm tay do người chơi trang bị, mỗi món đồ mang một hiệu ứng chiến thuật riêng. Một mẩu Thức ăn thừa (Leftovers) giúp hồi phục máu mỗi lượt, một chiếc Khăn choàng (Choice Scarf) ép tốc độ lên mức cực hạn nhưng khóa chết sinh vật vào một chiêu thức duy nhất, hay các loại quả mọng tự động kích hoạt để giải độc khi cần thiết.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Các Cơ Chế Đột Phá Lực Chiến Thế Hệ:",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Theo từng thế hệ, hệ thống combat lại được cấy ghép thêm những cơ chế sức mạnh độc quyền nhằm tạo ra điểm nhấn riêng. Thế hệ thứ sáu mang đến Mega Evolution, cho phép một Pokémon lột xác tạm thời ngay giữa trận đấu để thăng tiến chỉ số vượt bậc. Thế hệ thứ bảy giới thiệu Z-Moves, những tuyệt kỹ tối thượng với sát thương hủy diệt chỉ được dùng một lần duy nhất. Thế hệ thứ tám phổ biến hiện tượng Dynamax/Gigantamax, biến Pokémon thành những gã khổng lồ với lượng máu nhân đôi cùng các chiêu thức diện rộng. Gần đây nhất, thế hệ thứ chín trình làng hiện tượng Terastallize, cho phép Pokémon thay đổi hệ bẩm sinh của mình thành một hệ hoàn toàn mới ngay trong hiệp đấu, tạo ra những pha đánh lừa ngoạn mục nhằm né tránh các đòn khắc chế chí mạng từ đối thủ.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        PrivacyPolicySection()
    }
}

@Composable
fun NatureTable() {
    val stats = listOf("Attack", "Defense", "Sp. Atk", "Sp. Def", "Speed")
    val natures = listOf(
        listOf("Hardy", "Lonely", "Adamant", "Naughty", "Brave"),
        listOf("Bold", "Docile", "Impish", "Lax", "Relaxed"),
        listOf("Modest", "Mild", "Bashful", "Rash", "Quiet"),
        listOf("Calm", "Gentle", "Careful", "Quirky", "Sassy"),
        listOf("Timid", "Hasty", "Jolly", "Naive", "Serious")
    )

    Box(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
        Column(modifier = Modifier.padding(vertical = 12.dp)) {
            // Header Row (Decreased Stats -)
            Row {
                Box(modifier = Modifier.size(width = 100.dp, height = 35.dp))
                stats.forEach { stat ->
                    Box(
                        modifier = Modifier
                            .size(width = 90.dp, height = 35.dp)
                            .padding(1.dp)
                            .background(Color(0xFF32323E), shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("- $stat", color = Color(0xFFF44336), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Nature Rows (+ Increased Stats)
            natures.forEachIndexed { rowIndex, rowNatures ->
                Row {
                    // Row Header (+ Stat)
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 35.dp)
                            .padding(1.dp)
                            .background(Color(0xFF32323E), shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("+ ${stats[rowIndex]}", color = Color(0xFF4CAF50), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }

                    rowNatures.forEachIndexed { colIndex, nature ->
                        val isNeutral = rowIndex == colIndex
                        Box(
                            modifier = Modifier
                                .size(width = 90.dp, height = 35.dp)
                                .padding(1.dp)
                                .background(
                                    if (isNeutral) Color(0xFFB0BEC5) else Color(0xFFFFFDE7),
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = nature,
                                color = if (isNeutral) Color.Black else Color(0xFF5D4037),
                                fontSize = 12.sp,
                                fontWeight = if (isNeutral) FontWeight.Bold else FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GuideSection(
    title: String,
    content: String,
    extraContent: @Composable (() -> Unit)? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Box(modifier = Modifier.size(14.dp).background(Color(0xFF00B0FF)))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp
            )
        }

        HorizontalDivider(
            color = Color(0xFF00B0FF),
            thickness = 2.dp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = content,
            color = Color.White,
            fontSize = 15.sp,
            lineHeight = 22.sp
        )

        extraContent?.invoke()
    }
}

@Composable
fun TypeEffectivenessTable() {
    val types = listOf(
        TypeData("NORMAL", "NOR", Color(0xFFA8A77A)),
        TypeData("FIRE", "FIR", Color(0xFFEE8130)),
        TypeData("WATER", "WAT", Color(0xFF6390F0)),
        TypeData("ELECTRIC", "ELE", Color(0xFFF7D02C)),
        TypeData("GRASS", "GRA", Color(0xFF7AC74C)),
        TypeData("ICE", "ICE", Color(0xFF96D9D6)),
        TypeData("FIGHTING", "FIG", Color(0xFFC22E28)),
        TypeData("POISON", "POI", Color(0xFFA33EA1)),
        TypeData("GROUND", "GRO", Color(0xFFE2BF65)),
        TypeData("FLYING", "FLY", Color(0xFFA98FF3)),
        TypeData("PSYCHIC", "PSY", Color(0xFFF95587)),
        TypeData("BUG", "BUG", Color(0xFFA6B91A)),
        TypeData("ROCK", "ROC", Color(0xFFB6A136)),
        TypeData("GHOST", "GHO", Color(0xFF735797)),
        TypeData("DRAGON", "DRA", Color(0xFF6F35FC)),
        TypeData("DARK", "DAR", Color(0xFF705746)),
        TypeData("STEEL", "STE", Color(0xFFB7B7CE)),
        TypeData("FAIRY", "FAI", Color(0xFFD685AD))
    )

    val effectiveness = mapOf(
        "NORMAL" to mapOf("ROC" to "½", "GHO" to "0", "STE" to "½"),
        "FIRE" to mapOf("FIR" to "½", "WAT" to "½", "GRA" to "2", "ICE" to "2", "BUG" to "2", "ROC" to "½", "DRA" to "½", "STE" to "2"),
        "WATER" to mapOf("FIR" to "2", "WAT" to "½", "GRA" to "½", "GRO" to "2", "ROC" to "2", "DRA" to "½"),
        "ELECTRIC" to mapOf("WAT" to "2", "ELE" to "½", "GRA" to "½", "GRO" to "0", "FLY" to "2", "DRA" to "½"),
        "GRASS" to mapOf("FIR" to "½", "WAT" to "2", "GRA" to "½", "POI" to "½", "GRO" to "2", "FLY" to "½", "BUG" to "½", "ROC" to "2", "DRA" to "½", "STE" to "½"),
        "ICE" to mapOf("FIR" to "½", "WAT" to "½", "GRA" to "2", "ICE" to "½", "GRO" to "2", "FLY" to "2", "DRA" to "2", "STE" to "½"),
        "FIGHTING" to mapOf("NOR" to "2", "ICE" to "2", "ROC" to "2", "DAR" to "2", "STE" to "2", "POI" to "½", "FLY" to "½", "PSY" to "½", "BUG" to "½", "FAI" to "½", "GHO" to "0"),
        "POISON" to mapOf("GRA" to "2", "FAI" to "2", "POI" to "½", "GRO" to "½", "ROC" to "½", "GHO" to "½", "STE" to "0"),
        "GROUND" to mapOf("FIR" to "2", "ELE" to "2", "POI" to "2", "ROC" to "2", "STE" to "2", "GRA" to "½", "BUG" to "½", "FLY" to "0"),
        "FLYING" to mapOf("GRA" to "2", "FIG" to "2", "BUG" to "2", "ELE" to "½", "ROC" to "½", "STE" to "½"),
        "PSYCHIC" to mapOf("FIG" to "2", "POI" to "2", "PSY" to "½", "STE" to "½", "DAR" to "0"),
        "BUG" to mapOf("GRA" to "2", "PSY" to "2", "DAR" to "2", "FIR" to "½", "FIG" to "½", "POI" to "½", "FLY" to "½", "GHO" to "½", "STE" to "½", "FAI" to "½"),
        "ROCK" to mapOf("FIR" to "2", "ICE" to "2", "FLY" to "2", "BUG" to "2", "FIG" to "½", "GRO" to "½", "STE" to "½"),
        "GHOST" to mapOf("PSY" to "2", "GHO" to "2", "DAR" to "½", "NOR" to "0"),
        "DRAGON" to mapOf("DRA" to "2", "STE" to "½", "FAI" to "0"),
        "DARK" to mapOf("PSY" to "2", "GHO" to "2", "FIG" to "½", "DAR" to "½", "FAI" to "½"),
        "STEEL" to mapOf("ICE" to "2", "ROC" to "2", "FAI" to "2", "FIR" to "½", "WAT" to "½", "ELE" to "½", "STE" to "½"),
        "FAIRY" to mapOf("FIG" to "2", "DRA" to "2", "DAR" to "2", "FIR" to "½", "POI" to "½", "STE" to "½")
    )

    Box(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
        Column {
            // Header Row
            Row {
                Box(modifier = Modifier.size(width = 80.dp, height = 30.dp))
                types.forEach { type ->
                    Box(
                        modifier = Modifier
                            .size(35.dp, 30.dp)
                            .padding(1.dp)
                            .background(type.color, shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(type.abbr, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Type Rows
            types.forEach { attacker ->
                Row {
                    // Row Header
                    Box(
                        modifier = Modifier
                            .size(width = 80.dp, height = 30.dp)
                            .padding(1.dp)
                            .background(attacker.color, shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(attacker.name, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }

                    // Effectiveness Cells
                    types.forEach { defender ->
                        val value = effectiveness[attacker.name]?.get(defender.abbr) ?: ""
                        
                        // Sử dụng bảng màu Vàng Kem & Pastel để bảng cực sáng và thẩm mỹ
                        val (bgColor, textColor) = when (value) {
                            "2" -> Color(0xFF4CAF50) to Color.White        // 2x: Xanh lá tươi
                            "½" -> Color(0xFFF44336) to Color.White        // 1/2x: Đỏ rực
                            "0" -> Color(0xFF263238) to Color.White        // 0x: Xám đen sâu
                            else -> Color(0xFFFFFDE7) to Color(0xFF5D4037) // 1x: Vàng Kem Sáng + Chữ Nâu đậm rõ nét
                        }
                        
                        // Hiển thị "1" rõ ràng giúp bảng nhìn chuyên nghiệp và đầy đặn
                        val displayValue = if (value.isEmpty()) "1" else value

                        Box(
                            modifier = Modifier
                                .size(35.dp, 30.dp)
                                .padding(1.dp)
                                .background(bgColor, shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = displayValue,
                                color = textColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold // Chữ số đậm, sắc nét
                            )
                        }
                    }
                }
            }
        }
    }
}

data class TypeData(val name: String, val abbr: String, val color: Color)

@Preview(showBackground = true)
@Composable
fun GuideScreenPreview() {
    PokedexTheme {
        GuideScreen(navController = rememberNavController())
    }
}
