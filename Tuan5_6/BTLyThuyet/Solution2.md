COS226, Midterm f25, 4

`Theo đoạn code ta thấy thuật toán mysterysort chính là Bubble Sort`

a, 

Với mỗi lần lặp Bubble Sort thì các phần tử ở cuối sẽ được sắp xếp theo thứ tự với phần tử lớn nhất sẽ ỏ cuối

Do đó đáp án chinh xác là :

**i phân tử cuối cùng trong mảng đã được sắp xếp theo thứ tự**

**i phần tử cuối cùng trong mảng là phần tử lớn nhât của mảng**

b,

Thuật toán trên chính là thuật toán sắp xếp tại chỗ.

Bởi chỉ sử dụng một bộ nhớ cố định cho các biến chỉ số i và j và cờ hiệu exchanged, hoán đổi trực tiếp trên mảng mà không cần thêm mảng phụ.

c,

Có thuật toán trên chỉ đỗi chỗ khi phần tử đứng sau thực sự nhỏ hơn phần tử phía trước nên khi 2 phần tử bằng nhau thì thuật toán không hoán đổi mà giữ nguyên vị trí

d,

`Số lần gọi hàm exch() để sắp xếp một mảng số nguyên có dạng [2,3,4,..n-1, n]
`

Do mảng này đã sắp xếp sẵn nên sẽ không gọi hàm exch() lần nào 

A.0

`Số lần gọi less() trong trường hợp tốt nhất (best case)`

Trong trường hợp tốt nhất, mảng đã được sắp xếp khi đó mảng dã được sắp xếp, j chạy từ 0 tới n - 2 và break.

Khi đó j đã lệnh less() đã được gọi n-1 lần. Số phép so sánh se là n - 1 ~ n

C. ~n

`Số lần gọi less() trong trường hợp tồi nhất (worst case)`

Với trường hợp xấu nhất là mảng ban đầu có thứ tự giảm dần.

Khi đó :

$$\sum_{i=0}^{n-1} (n - 1 - i) = (n - 1) + (n - 2) + \dots + 1 + 0 = \frac{n(n - 1)}{2} \sim \frac{1}{2} n^2$$

H. $\sim \frac{1}{2} n^2$