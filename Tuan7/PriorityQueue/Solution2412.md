# Problem 2.4.12

Giả sử ứng dụng của bạn sẽ có rất nhiều lệnh tìm max, nhưng chỉ có vài lệnh gọi insert và remove. Cách cài đặt nào là hiệu quả nhất cho hàng đợi ưu tiên? heap, mảng không sắp thứ tự, hay mảng có sắp thứ tự?

**Lời giải**

RES : **Heap (Max-heap)** sẽ là hiệu quả nhất.

So sánh các cách cài đặt theo trường hợp này :

1. **Đối với Heap (Max-heap) — Hiệu quả số 1:**
* Lệnh `findMax` chỉ mất **$O(1)$** vì chỉ cần đọc trực tiếp giá trị tại nút gốc `pq[1]`, đáp ứng cực nhanh cho hàng triệu lượt tìm kiếm.
* Vài lệnh `insert` chỉ mất **$O(\log N)$** (thao tác `swim`), vài lệnh `remove` cũng chỉ mất **$O(\log N)$** (thao tác `sink`). Do các lệnh thêm/xóa rất ít nên chi phí $\log N$ là không đáng kể. Heap vừa tìm max nhanh vừa chèn/xóa nhẹ nhàng.


2. **Đối với mảng có thứ tự — Hiệu quả số 2:**
* Lệnh `findMax` cũng rất nhanh mất **$O(1)$** (lấy ngay phần tử ở cuối mảng) và xóa `remove` cũng mất **$O(1)$**.
* Tuy nhiên, mỗi khi có lệnh `insert` (dù rất ít) thì vẫn phải mất **$O(N)$** để dịch chuyển các phần tử phía sau sang phải lấy chỗ trống chèn vào. Vì vướng thao tác dời mảng $O(N)$ này nên mảng có thứ tự vẫn kém hơn Heap một bậc.


3. **Đối với mảng không có thứ tự — Chạy lâu nhất (tệ nhất):**
* Do các phần tử nằm lộn xộn, mỗi lần gọi `findMax` đều bắt buộc phải duyệt qua toàn bộ $N$ phần tử để tìm số lớn nhất nên mất tới **$O(N)$**.
* Với đề bài có "rất nhiều lệnh tìm max", việc phải quét lại mảng $O(N)$ hàng triệu lần sẽ khiến ứng dụng bị nghẽn và chạy cực kỳ chậm.