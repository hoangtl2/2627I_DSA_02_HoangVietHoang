# Problem 2.4.13

Hãy mô tả một cách tránh phải kiểm tra `j < N` tại hàm `sink()`.

**Lời giải**

RES : Đặt một **khóa lính canh (sentinel key)** tại vị trí `pq[N + 1]` có giá trị nhỏ hơn hoặc bằng `pq[N]` (hoặc nhỏ hơn mọi phần tử trong heap).

Chi tiết theo chuẩn `algs4`:

1. **Bản chất của phép kiểm tra `j < N`:**
* Trong `sink()`, phép thử `j < N` chỉ cần thiết khi $2k = N$, tức là nút hiện tại chỉ có một con trái duy nhất tại $j = N$ và không có con phải tại $j + 1 = N + 1$.
* Nếu không kiểm tra `j < N`, hàm sẽ gọi `less(N, N + 1)` và truy cập vào ô nằm ngoài phạm vi heap.


2. **Cách loại bỏ bằng phần tử lính canh:**
* Gán `pq[N + 1]` bằng một giá trị lính canh nhỏ hơn hoặc bằng `pq[N]`.
* Khi $j = N$, lời gọi `less(j, j + 1)` (tức so sánh `pq[N]` với lính canh) luôn trả về `false`.
* Vì vậy, biến $j$ không bao giờ bị tăng lên thành $N + 1$, cho phép ta bỏ hoàn toàn điều kiện `j < N` và chỉ cần viết gọn:
```java
if (less(j, j + 1)) j++;

```

