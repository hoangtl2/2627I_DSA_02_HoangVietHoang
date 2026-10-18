COS226, Midterm s25, 4

`Selection sort`

Thuật toán selection sort luôn thực hiện phép so sánh độc lập với thứ tự ban đầu của dữ liệu

Nên số phép so sánh sẽ là $$\frac{N(N - 1)}{2} = \frac{2n(2n - 1)}{2} = 2n^2 - n \sim 2n^2$$

Vậy đáp án là $ n^2 $

`Insertion sort`

Do các số từ 1 tới n đã được sắp xếp tăng dần xen kẽ các số n+1 tới 2n cũng sắp xếp tăng dần 

nên với mỗi số i, số n+i đứng trước số các số nhỏ hơn nó là i+1,I=2,..n

Vậy tổng phép so sánh là $$\sum_{i=1}^{n-1} (n - i) = (n-1) + (n-2) + \dots + 1 = \frac{n(n - 1)}{2} \sim \frac{1}{2}n^2$$

`Merge sort`

Do mảng sắp xếp xen kẽ đều đặn nên merge ở mỗi tầng đệ quy các phần tử phải thực hiện đủ các phép so sánh, tổng sẽ xấp xỉ N phép so sánh tại mỗi tầng đệ quy
và cây có độ sâu $\log_2 N = \log_2(2n) \approx 1 + \log_2 n$.

Vậy đáp án là $\sim 2n \log n$
