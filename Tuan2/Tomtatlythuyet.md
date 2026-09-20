Ký hiệu xấp xỉ ~ (Tilde notation)
Chúng ta nói rằng f(N) ~ g(N) , đọc là f(N) xấp xỉ g(N) nếu tỉ số f(N)/g(N)  tiến về 1 khi N tiến ra vô cùng. Đây là một khái niệm toán học tổng quát áp dụng cho các hàm số và không bị giới hạn riêng trong thời gian chạy, bộ nhớ, hay bất kỳ phạm vi cụ thể nào khác.
Giả thuyết định luật lũy thừa (Power-law assumption)
Đối với các phân tích thực nghiệm trong môn học, chúng ta thường giả định rằng thời gian chạy tuân theo định luật lũy thừa: $T(N) ~ aNb. Việc suy luận thực nghiệm để đưa ra các giả thuyết chính xác cho những hàm thời gian chạy không tuân theo định luật lũy thừa nằm ngoài phạm vi của khóa học này.
Mô hình chi phí (Cost model)
Đối với các phân tích lý thuyết về thời gian chạy, chúng ta sẽ giả định một mô hình chi phí, cụ thể là có một (hoặc vài) thao tác nhất định sẽ chiếm phần lớn thời gian chạy của chương trình, ví dụ phép so sánh hay phép truy nhập mảng. Sau đó, chúng ta biểu diễn thời gian chạy dựa trên tổng số lần thao tác đó được thực hiện dưới dạng một hàm số theo kích thước đầu vào. Để đơn giản hóa, chúng ta thường biểu diễn tần suất đếm này bằng ký hiệu ~.
Tốc độ tăng trưởng (Order of growth)
Nếu chúng ta có hai hàm số f(N) và g(N), và f(N) ~ c g(N) với hằng số c > 0, chúng ta nói tốc độ tăng trưởng của f(N) là g(N). Thông thường, g(N) sẽ là một trong các hàm sau: 1, log N, N, N log N, N2, N3, hoặc 2N.
Hiệu năng phụ thuộc vào đầu vào (Performance depends on inputs)
Chúng ta có thể đặc trưng hóa hiệu năng của một thuật toán thông qua trường hợp tốt nhất (best case), trường hợp xấu nhất (worst case), và trường hợp trung bình (average case).
Độ khó của một bài toán (Difficulty of a problem)
Để hiểu được độ khó của một bài toán cụ thể, chúng ta thường xem xét tốc độ tăng trưởng trong trường hợp xấu nhất của thuật toán tối ưu nhất có thể cho bài toán đó. Chúng ta có thể chặn trên (upper bound) độ khó của bài toán bằng hiệu suất của thuật toán tốt nhất từng được biết đến. Việc tìm ra một cận dưới (lower bound) tốt cho một bài toán thường là một việc rất khó.
Ký hiệu Big Oh (O), Big Omega (Ω), Big Theta (Θ)
Các ký hiệu này thường được sử dụng phổ biến trong lý thuyết thuật toán. Chúng có bản chất tương tự như ký hiệu ~ nhưng bỏ qua các hệ số dẫn đầu (hằng số). Nhiều lập trình viên đang sử dụng ký hiệu Big-Oh một cách sai lệch khi cái họ thực sự muốn ám chỉ là tốc độ tăng trưởng (order of growth).
Khi một người nói "Thuật toán tìm kiếm nhị phân có độ phức tạp O(log N)", có thể hiểu theo những cách nào?
1. Theo cách hiểu thông dụng : … có thời gian chạy cỡ log N trong trường hợp tồi nhất. Đây là cách hiểu và cách nói chấp nhận được trong cộng đồng lập trình, nhưng nên phát biểu chính xác phải là "... có thời gian chạy logN trong trường hợp tồi nhất", thì rõ ràng đỡ lẫn lộn.
2. Chính xác toán học: … có thời gian chạy là hàm có cận trên O(logN), có thể là hằng số, tuyến tính, logN, không xác định là loại nào.
   Mỗi lần gặp tình huống này, bạn cần phân tích xem ý người nói là trường hợp nào trong hai trường hợp trên. Nên tốt nhất là nếu bạn là người nói, bạn nên nói chính xác luôn cho đỡ rủi ro hiểu nhầm.
   Khi một người nói "Thuật toán tìm kiếm nhị phân có độ phức tạp O(log N) trong trường hợp trung bình", có thể hiểu theo những cách nào?
   ý người ta là Θ(log N), chỉ là do thói quen mà dùng O
   người ta không biết nó chính xác là loại gì, chỉ biết không vượt quá logN
   Trong bài thi/kiểm tra thì nên hiểu kiểu gì? Chúng ta quy ước với nhau là sẽ hiểu theo kiểu chuẩn, chính xác toán học, thay vì hiểu kiểu thói quen (quen mồm)
   Tốc độ tăng trưởng trong trường hợp xấu nhất không phải là thông tin quyết định (Worst-case order of growth isn't everything)
   Một thuật toán có tốc độ tăng trưởng lý thuyết tốt hơn thuật toán khác không đồng nghĩa với việc nó sẽ chạy nhanh hơn trong thực tế. Chúng ta sẽ bắt gặp một số phản ví dụ đáng chú ý trong môn học, bao gồm việc so sánh giữa quicksort (sắp xếp nhanh) và mergesort (sắp xếp trộn).
   Phân tích bộ nhớ (Memory analysis)
   Bạn cần nắm vững cách tính toán lượng bộ nhớ tiêu thụ của một lớp (class) dựa trên mô hình bộ nhớ 64-bit được hướng dẫn trong sách giáo trình.
   Phân tích lý thuyết và thực nghiệm (Theoretical and empirical analysis)
   Các giả thuyết được tạo ra từ phân tích lý thuyết (hoặc từ các phỏng đoán như giả thuyết định luật lũy thừa của chúng ta) cần phải được xác thực bằng dữ liệu thực tế trước khi có thể hoàn toàn tin cậy.

