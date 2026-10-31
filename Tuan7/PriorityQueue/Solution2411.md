# Problem 2.4.11
Giả sử ứng dụng của bạn sẽ có rất nhiều lệnh gọi insert, nhưng chỉ có vài lệnh xóa delMax. Cách cài đặt nào là hiệu quả nhất cho hàng đợi ưu tiên? heap, mảng không sắp thứ tự, hay mảng có sắp thứ tự?

**Lời giải **

RES : Mảng không thứ tự sẽ là hiệu quả nhất

So sánh các cách cài đặt theo trường hợp này :

1. Với mảng không có thứ tự khi gọi insert chỉ việc thêm phần tử vào cuối nên chỉ mất O(1) rất nhanh và delMax chỉ mất O(N) ( tìm kiếm phần tử rồi xóa ) nên tổng thể nếu thêm N phần tử và xóa thì cũng chỉ là O(N)

2. Đối với heap (Max-heap) Mỗi lần thêm 1 phần tử mới thì lại phải so sánh phần tử đó với nút cha và swim lên mất O(logN) và mỗi khi lấy ra 1 phần tử thì phải hoán đổi giữa  phần tử max và phần tử cuối rồi sink() xuống mất O(logM). Tuy cả 2 đều chạy mất khoảng O(logN) nhưng nếu khi thêm hàng triệu phần tử sẽ thành M(LogN) rất lâu. Do đó heap sẽ ở vị tri số 2 hiệu quả 

3. Đối với mảng sắp xếp săn thì đây sẽ là cách cài đặt chạy lâu nhất : Bởi mỗi lần sắp xếp vào tuy có thể chặt nhị phân để tìm phần tử để chèn O(LogN) nhưng cũng phải dịch chuyển các phần tử phía sau ra bên phải để có chỗ trống nên sẽ mất O(N) với đề insert nhiều thì sẽ khiến thuật toán chạy rất lâu 