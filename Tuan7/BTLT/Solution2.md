`COS226, Midterm s25, 2b`

**Lời giải**:

Với thao tác DELETE-MAX trong maxheap:

1. Đổi chỗ nút gốc lớn nhất và nút cuối cùng pq[1] và pq[N] và giảm kích thước heap đi 1
2. Gọi hàm sink(i) để đưa phần tử mới ở gốc chìm xuống vị trí

Với đề bài ta có gốc pq[1] = 80 và nút cuối cùng ở vị trí N = 13 là pq[13] = 50

Đổi chỗ giữa 80 và 50 sau đó xóa 80 khỏi heap

HEAP hiện tại còn 12 phần tử bắt đầu gọi tới hàm sink ( sink(1) )

Mã nguồn của hàm sink(k):
```
private void sink(int k) {
    while (2*k <=n) {
        int j = 2 * k;
        if (j < n && less(j, j + 1)) j++; Tìm con lớn hơn
        ìf (!less(k,j)) break; nếu nút cha lớn hơn nút con thì break
        exch(k, j); Đổi chỗ 2 nút
        k = j; xét xuống nút dưới
        
```    

Vòng lặp đầu tiên :

Nút gốc là 50 2 nút con là 70 và 75

So sánh 70 và 75 thấy 75 lớn hơn nên j giữ nguyên

So sánh 50 và 75 thấy 50 nhỏ hơn 75 nên đổi chỗ giứa 50 và 75

Dịch vị trí nút k xuống

Vòng lặp số 2 

Nút cha k lúc này là 50

So sánh 2 nút con là 10 và 55, thấy 55 lớn hơn nên j++

So sánh 50 và 55 thấy 55 lớn hơn nên đổi chỗ giữa 50 và 55

Dịch nút k xuống

Vòng lặp số 3 :

Nút k lúc này là 50 

So sánh 2 nút con là 20 và 30 thấy 30 lớn hơn 20 nên j++

So sánh 50 và 30 thấy 50 lớn hơn 30 nên break kết thúc vòng lặp

** Vậy có 6 phép so sánh diễn ra ** 
