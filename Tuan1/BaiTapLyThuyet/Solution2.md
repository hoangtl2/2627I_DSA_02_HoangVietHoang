COS226, Midterm f22<br>
Giả sử ta khởi tạo một cấu trúc dữ liệu union-find với n phần tử. Sau đó, ta thực hiện chuỗi các thao tác union() sau:  union(0, 1), union(0, 2), union(0, 3), ..., union(0, n-1).
<br>
Trả lời các câu hỏi sau:
<br>
(a) Cấu trúc dữ liệu thu được chứa tổng cộng bao nhiêu thành phần liên thông (tức là các tập hợp rời nhau)?
<br>
(b) Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp quick-find. Có bao nhiêu lần cập nhật mảng được thực hiện bởi các thao tác union() này (biểu diễn dưới dạng hàm của n theo ký hiệu xấp xỉ ~)? (Lưu ý: cài đặt quick-find cho union(p,q) của chúng ta không bao giờ thay đổi giá trị leader[q].)
<br>
(c) Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp quick-union, và ta gọi find(0) sau chuỗi thao tác nêu trên. Thao tác find(0) sẽ thực hiện bao nhiêu lần truy cập mảng (biểu diễn dưới dạng hàm của n theo ký hiệu Θ)? (Lưu ý: cài đặt quick-union cho union(p,q) của chúng ta không bao giờ thay đổi parent[q].)
<br>
(d) Giả sử cấu trúc dữ liệu được cài đặt theo phương pháp weighted quick-union, và ta gọi find(0) sau chuỗi thao tác nêu trên. Thao tác find(0) sẽ thực hiện bao nhiêu lần truy cập mảng (biểu diễn dưới dạng hàm của n theo ký hiệu Θ)? (Lưu ý: cài đặt weighted quick-union cho union(p,q) của chúng ta sẽ thay đổi parent[q] nếu hai cây có cùng kích thước.)
<br>
        `LỜI GIẢI`

<br>
a) 
<br>
Ta chỉ có duy nhất 1 thành phần liên thông do khi nối 0 với các số từ 1 đến n-1 thì hiển nhiên các nhánh đó sẽ nối liền lại với nhau và cuối cùng chỉ tạo 1 thành phần liên thông duy nhất từ 0 đến n-1
<br>

<br>
b)
<br>
Với bài này ta quy ước union(p,q) sẽ không thay đổi giá trị của q.
<br>
Nghĩa là luôn ghép các phần tử cùng liên thông với p vào liên thông với q.
<br>
Kiểm tra từng bước :
<br>`Ở đầu tiên` thì mọi phần tử đều mang nhãn chính là giá trị của chính nó. Do đó nhóm 0 có kich thước 1 chỉ gồm 0.<br>
`union(0,1)` Dổi tất cả phần tử của nhóm 0 sang nhóm 1. <br>
Lúc này cập nhật mảng 1 lần. Khi đó nhóm mang nhãn 1 và có kích thước 1 gồm {0,1}
<br>`union(0,2)` Đổi tất cả các phần tử nhóm 0 sàng nhóm 2.
<br>Khi này các phần tử của nhóm 0 mang nhãn 1 là 0 và 1 chuyển qua nhóm 2.
<br>Do đó lần này thực hiện 2 lần thay đổi mảng ở giá trị của 0 và 1
<br>Lúc này nhóm mới có kích thước là 3 và mang nhãn 2.
<br>....
<br>Từ đó ta có tới bước `union(0,k)` nhóm chứa 0 sẽ có k phần tử và thực hiện k lần cập nhần mảng
<br>Do đó khi tới bước cuối là `union(0, n-1) thì nhóm chứa 0 sẽ có n-1` phần tử và thực hiện n-1 lần cập nhật mảng
<br>Từ đó tổng số lần cập nhật mảng sẽ là S = 1 + 2 + 3 + ... + n-1 = (n-1)*n/2 

c)

Với quy ước không bao giờ thay đổi parrent[q].

`union(0,1)` Gốc 0 là 0 và gốc 1 là 1 thì ta gán `parrrent[0]=1`

`union(0,2)` Khi này gốc 0 là 1 và gốc 2 là 2 nên ta gán tiếp `parrent[1]=2`

Cứ như vậy cho tới khi `union(0, n-1)` thì cây sẽ là 1 chuổi 0->1->2->3-> ... -> n-1

Do đó khi sử dụng thao tác find(0) thì ban đầu sẽ bắt đầu từ 0 và vòng lặp cứ nhảy lên parrent của 0 và lên tiếp cho đến chuỗi này khi đó số thao tác thực hiện sẽ là n lần vì phải đọc mảng n lần từ 0 cho đến n-1

<br>
d) 

Với quy ước của đề rằng sẽ thay đổi parrent[q]

Khi đó ở bước `union(0,1)` thì 1 -> 0

`union(0,2)` Do cây gốc 0 có 2 giá trị là 0 và 1 nên 2 -> 0

`union(0,3)` Gốc có 3 giá trị rồi nên 3 -> 0 

Cứ như vậy cho tới cuối tất cả các giá trị đều làm con của 0

Và bởi đó nên parrent[0] = 0 

Vì thế find(0) dừng lại ở i = 0 luôn chỉ thực hiện 1 lần tra mảng 

Do đó chỉ thao tác find(0) thực hiện duy nhất 1 lần.


