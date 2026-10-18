**COS226, Midterm f24, 7**

Selection sort

số phép so sánh là:

$$\frac{N(N - 1)}{2} = \frac{4n(4n - 1)}{2} = 8n^2  - 2n \sim 8n^2$$

Vậy đáp án là **$\sim 8n^2$**.

Insertion sort

Nửa đầu gồm toàn các số bằng nhau ($2n$), nửa sau các số đã xếp tăng dần nên bên trong mỗi nửa không có nghịch thế.

Mọi phần tử ở nửa sau đều có giá trị $\le n < 2n$, nên mỗi phần tử ở nửa sau đều nhỏ hơn tất cả $2n$ phần tử ở nửa đầu.

Vì nửa sau có $2n$ phần tử, mỗi phần tử khi chèn vào đều phải lùi qua toàn bộ $2n$ số của nửa đầu, nên tổng số phép so sánh xấp xỉ tổng số cặp nghịch thế:


$$(2n) \times (2n) = 4n^2$$


Vậy đáp án là **$\sim 4n^2$**.

Mergesort

Ở nửa đầu các phần tử bằng nhau và ở bước trộn cuối cùng toàn bộ nửa sau nhỏ hơn nửa đầu, nên một nửa mảng con luôn cạn trước và nửa còn lại sao chép thẳng không cần so sánh.

Mỗi tầng đệ quy chỉ tốn khoảng $\frac{N}{2} = 2n$ phép so sánh, cây có độ sâu $\log_2(4n) = 2 + \log_2 n$.

Tổng số phép so sánh là:


$$ 2n \log n$$


Vậy đáp án là **$\sim 2n \log n$**.

3-way quicksort

Sau khi tráo ngẫu nhiên, mảng xếp giảm dần nên phần tử đầu luôn là giá trị lớn nhất của đoạn ($2n$, rồi đến $n$, $n/2, \dots$).

Phân hoạch gom hết các phần tử bằng pivot vào giữa, đoạn lớn hơn rỗng, đoạn nhỏ hơn còn lại giảm một nửa kích thước sau mỗi lần đệ quy ($4n \to 2n \to n \to \dots \to 1$).

Tổng số phép so sánh là cấp số nhân lùi:


$$4n + 2n + n + \dots = 4n \left(1 + \frac{1}{2} + \frac{1}{4} + \dots\right) \le 8n = \Theta(n)$$


Vậy đáp án là **$\Theta(n)$**.