** Copy từ gemini :v **

## 1. Selection Sort (Sắp xếp chọn)

### Cách hoạt động

* Chia mảng thành hai phần: nửa đầu đã có thứ tự và nửa sau chưa sắp xếp.
* Ở mỗi lượt bước $i$ (từ $0$ đến $n-2$):
1. Quét toàn bộ phần còn lại từ $i$ đến $n-1$ để tìm phần tử có giá trị nhỏ nhất toàn cục.
2. Hoán đổi (swap) phần tử nhỏ nhất đó với phần tử tại vị trí $i$.


* Sau $k$ bước, $k$ vị trí đầu tiên sẽ chứa chính xác $k$ phần tử nhỏ nhất của toàn bộ mảng theo thứ tự tăng dần.

### Dấu hiệu nhận diện trên vết dữ liệu trung gian

* **Đoạn đầu đã sắp xếp chứa đúng tập phần tử nhỏ nhất tuyệt đối:** Khác với Insertion sort (chỉ sắp xếp tương đối một tập con phần tử ban đầu), đoạn đầu của Selection sort trùng khớp hoàn toàn với đoạn đầu của mảng kết quả cuối cùng.
* **Đoạn sau bị xáo trộn:** Do mỗi bước chỉ thực hiện đúng một phép hoán đổi vị trí, thứ tự các phần tử chưa sắp xếp ở phía sau sẽ không giữ nguyên mà bị đảo lộn rải rác so với mảng gốc.

---

## 2. Insertion Sort (Sắp xếp chèn)

### Cách hoạt động

* Duyệt mảng tuần tự từ trái qua phải, xét từng phần tử thứ $i$ (từ vị trí 1 đến $n-1$).
* Coi đoạn từ $0$ đến $i-1$ là đã sắp xếp tương đối. Lấy giá trị $A[i]$ chèn lùi dần vào vị trí thích hợp trong đoạn này bằng cách dịch chuyển các phần tử lớn hơn nó sang phải một vị trí.
* Lặp lại cho đến hết mảng.

### Dấu hiệu nhận diện trên vết dữ liệu trung gian

* **Đoạn đầu đã sắp xếp nội bộ:** Đoạn từ vị trí $0$ đến $k$ có thứ tự tăng dần, nhưng **không nhất thiết** là các phần tử nhỏ nhất của cả mảng (chỉ là thứ tự tương đối của $k+1$ phần tử đầu tiên lấy từ mảng gốc).
* **Đoạn sau hoàn toàn bất động:** Toàn bộ các phần tử từ vị trí $k+1$ đến cuối giữ **nguyên vẹn 100% thứ tự ban đầu** của mảng gốc, vì con trỏ vòng lặp ngoài chưa từng chạm tới chúng.

---

## 3. Quicksort (Phân hoạch chuẩn / Hoare hoặc Lomuto)

### Cách hoạt động

* Thuật toán hoạt động theo nguyên lý chia để trị (Divide and Conquer):
1. **Chọn Pivot (chốt):** Trong biến thể kinh điển (chưa xáo ngẫu nhiên), pivot thường được chọn là phần tử đầu tiên hoặc cuối cùng của đoạn.
2. **Phân hoạch (Partition):** Dồn toàn bộ phần tử nhỏ hơn hoặc bằng pivot về bên trái, các phần tử lớn hơn hoặc bằng pivot về bên phải. Đưa pivot về đúng vị trí danh chính ngôn thuận của nó trong mảng.
3. **Đệ quy:** Tiếp tục gọi Quicksort trên nửa bên trái và nửa bên phải của pivot.



### Dấu hiệu nhận diện trên vết dữ liệu trung gian

* **Tồn tại một (hoặc nhiều) "phần tử phân cách" (Pivot cố định):**
* Giá trị pivot nằm ở vị trí $p$.
* Mọi phần tử đứng trước $p$ đều $\le A[p]$.
* Mọi phần tử đứng sau $p$ đều $\ge A[p]$.


* Cả hai nửa trái và phải của pivot nhìn chung vẫn còn lộn xộn (chưa có thứ tự hoàn chỉnh nếu mới qua 1 bước phân hoạch), nhưng ranh giới giá trị giữa hai bên là tuyệt đối.

---

## 4. Mergesort (Top-down - Sắp xếp trộn)

### Cách hoạt động

* Thuật toán chia để trị thuần túy dựa trên đệ quy:
1. **Chia (Divide):** Chia đôi mảng tại trung điểm $mid = \lfloor(L+R)/2\rfloor$.
2. **Trị (Conquer):** Đệ quy sắp xếp nửa trái, sau đó đệ quy sắp xếp nửa phải.
3. **Trộn (Merge):** Dùng mảng phụ để gộp hai nửa đã có thứ tự thành một mảng có thứ tự duy nhất.


* Do triển khai theo dạng đệ quy top-down (gọi xong toàn bộ cây nhánh trái rồi mới sang nhánh phải), nửa đầu của mảng thường sẽ được gộp xong hoàn chỉnh trước khi nửa sau hoàn thành.

### Dấu hiệu nhận diện trên vết dữ liệu trung gian

* **Cấu trúc khối độ dài lũy thừa của 2 (hoặc chia đều kích thước):**
* Dữ liệu xuất hiện các khối con độc lập có kích thước cố định (ví dụ: các block độ dài 2, 4, 6, 8 hoặc 12) mà bên trong mỗi khối con đã được sắp xếp tăng dần hoàn hảo.
* Các khối con đứng cạnh nhau chưa được gộp có thể có giá trị đan xen nhau (ví dụ: khối A kết thúc bằng 94, khối B ngay sau đó lại bắt đầu bằng 17).



---

## 5. Heapsort (Sắp xếp vun đống)

### Cách hoạt động

Gồm 2 giai đoạn chính:

1. **Build Heap:** Biến mảng ban đầu thành một Max-Heap (Cây nhị phân gần hoàn chỉnh biểu diễn qua mảng), trong đó mọi nút cha luôn có giá trị lớn hơn hoặc bằng các nút con của nó:

$$A[i] \ge A[2i + 1] \quad \text{và} \quad A[i] \ge A[2i + 2]$$


2. **Sortdown:** Lấy phần tử lớn nhất ở đỉnh heap ($A[0]$) hoán đổi về cuối mảng, giảm kích thước heap đi 1, sau đó gọi hàm chìm xuống (sift-down/heapify) để khôi phục tính chất heap cho phần còn lại. Lặp lại cho đến khi kích thước heap bằng 1.

### Dấu hiệu nhận diện trên vết dữ liệu trung gian

* **Bước sau khi Build-heap:**
* Phần tử lớn nhất toàn mảng chắc chắn nằm ở vị trí đầu tiên ($A[0]$).
* Không hề có thứ tự tăng dần ở bất kỳ đoạn nào rõ rệt, nhưng kiểm tra quan hệ chỉ số cha - con $(i \to 2i+1, 2i+2)$ luôn thấy cha $\ge$ con.


* **Bước trong quá trình Sortdown:**
* Đuôi mảng (từ $k$ đến $n-1$) chứa các phần tử lớn nhất đã được sắp xếp tăng dần.
* Đoạn đầu (từ $0$ đến $k-1$) tiếp tục duy trì cấu trúc Max-Heap.



---

## Bảng so sánh đặc trưng nhận diện nhanh

| Thuật toán | Vùng có thứ tự tăng dần | Vùng còn lại | Dấu hiệu đặc trưng nhất |
| --- | --- | --- | --- |
| **Insertion Sort** | Đầu mảng (tương đối) | Giữ nguyên thứ tự mảng gốc | Đuôi mảng không thay đổi so với input ban đầu. |
| **Selection Sort** | Đầu mảng (tuyệt đối) | Bị xáo trộn | Đầu mảng khớp hoàn toàn với mảng kết quả cuối cùng. |
| **Quicksort** | Chưa sắp xếp hoàn chỉnh | Chia thành 2 cụm giá trị | Tồn tại điểm chốt Pivot: bên trái $\le Pivot \le$ bên phải. |
| **Mergesort** | Từng block con liền kề | Chưa gộp giữa các block | Xuất hiện các khối con độ dài $2^k$ đã sắp xếp đứng cạnh nhau. |
| **Heapsort** | Đuôi mảng (nếu đang sortdown) | Cấu trúc Max-Heap ($A[i] \ge A[2i+1, 2i+2]$) | Phần tử lớn nhất nằm ở đầu mảng (ngay sau build heap). |


---

## 1. Counting Sort (Sắp xếp đếm)

### Nguyên lý hoạt động

* Áp dụng khi mảng chỉ chứa các số nguyên trong một phạm vi hẹp từ $0$ đến $K$ (hoặc $[min, max]$).
* **Bước 1 (Đếm tần suất):** Tạo mảng đếm $C$ kích thước $K+1$. Duyệt qua mảng gốc, với mỗi giá trị $x$, tăng $C[x]$ lên 1.
* **Bước 2 (Cộng dồn / Prefix sum):** Tính tổng tích lũy trên $C$: $C[i] = C[i] + C[i-1]$. Giá trị $C[i]$ lúc này biểu thị số lượng phần tử nhỏ hơn hoặc bằng $i$, tức là chỉ số kết thúc của giá trị $i$ trong mảng kết quả.
* **Bước 3 (Ghi kết quả):** Duyệt ngược mảng gốc từ phải sang trái, đặt phần tử $x$ vào vị trí $C[x] - 1$ của mảng kết quả rồi giảm $C[x]$ đi 1 (duyệt ngược để đảm bảo tính ổn định - Stable).

### Đặc điểm & Nhận diện

* **Độ phức tạp:** Thời gian $O(n + K)$, bộ nhớ phụ $O(n + K)$. Cực nhanh khi $K \approx n$, nhưng cực kỳ tốn RAM nếu $K \gg n$ (ví dụ: chỉ có 10 phần tử nhưng chứa số $10^9$).
* **Dấu hiệu nhận diện vết chạy:** Thường không hiển thị dạng mảng trung gian từng bước hoán đổi tại chỗ (in-place) như Quicksort, mà đi kèm với **bảng tần suất** hoặc mảng cộng dồn chỉ số.

---

## 2. Radix Sort (Sắp xếp theo cơ số)

### Nguyên lý hoạt động

* Dành cho các số nguyên hoặc chuỗi ký tự có độ dài cố định/hạn chế.
* Thuật toán phân rã từng khóa thành các chữ số (digits) theo một cơ số $B$ (thường là cơ số 10 hoặc cơ số $2^{16}$ trong lập trình thi đấu).
* **LSD (Least Significant Digit - Phổ biến nhất):**
1. Sắp xếp mảng theo chữ số hàng đơn vị bằng một thuật toán ổn định (thường là **Counting Sort** với $K = B - 1$).
2. Tiếp tục sắp xếp theo hàng chục, hàng trăm, ..., cho đến chữ số có trọng số cao nhất.
3. Nhờ tính chất ổn định (Stability) của bước con, các thứ tự đã thiết lập ở các hàng trước đó không bị phá vỡ khi sắp xếp ở hàng tiếp theo.



### Đặc điểm & Nhận diện

* **Độ phức tạp:** Thời gian $O(d \cdot (n + B))$, trong đó $d$ là số chữ số tối đa, bộ nhớ phụ $O(n + B)$.
* **Dấu hiệu nhận diện vết chạy:**
* Qua vòng lặp thứ 1: Tất cả phần tử được gom nhóm và sắp xếp tăng dần hoàn hảo **chỉ xét theo chữ số cuối cùng** (ví dụ: các số tận cùng là 0 đứng trước, rồi đến 1, 2,...).
* Qua vòng lặp thứ 2: Hai chữ số cuối cùng của mọi phần tử đã có thứ tự tăng dần.



---

## 3. Bucket Sort (Sắp xếp theo thùng)

### Nguyên lý hoạt động

* Phù hợp nhất khi dữ liệu là số thực được **phân phối đều** trong một khoảng xác định (thường là $[0, 1)$).
* **Bước 1 (Phân phối vào thùng):** Chia miền giá trị thành $k$ khoảng (thùng/bucket) bằng nhau. Duyệt mảng gốc và đưa từng phần tử vào thùng tương ứng dựa trên công thức băm đơn giản (ví dụ: $index = \lfloor n \times A[i] \rfloor$).
* **Bước 2 (Sắp xếp nội bộ thùng):** Sắp xếp từng thùng riêng lẻ (thường dùng Insertion Sort vì mỗi thùng có rất ít phần tử khi dữ liệu phân phối đều).
* **Bước 3 (Nối thùng):** Duyệt tuần tự qua các thùng từ nhỏ đến lớn và ghép các phần tử lại thành mảng hoàn chỉnh.

### Đặc điểm & Nhận diện

* **Độ phức tạp:** Trung bình $O(n + k)$. Trường hợp xấu nhất $O(n^2)$ nếu tất cả phần tử dồn hết vào một thùng duy nhất. Bộ nhớ phụ $O(n + k)$.
* **Dấu hiệu nhận diện vết chạy:** Dữ liệu trung gian được tổ chức thành cấu trúc danh sách liên kết/mảng động nhiều tầng (mảng của các mảng con). Sau bước gom thùng, các giá trị trong mỗi thùng đều nằm trong một dải khoảng nhất định (ví dụ: Thùng 0 chứa $[0.0, 0.2)$, Thùng 1 chứa $[0.2, 0.4)$).

---

## 4. Shell Sort (Biến thể mở rộng của Insertion Sort)

### Nguyên lý hoạt động

* Khắc phục nhược điểm của Insertion Sort (mỗi lần chỉ dịch chuyển phần tử được 1 bước).
* Chọn một chuỗi bước nhảy (gap sequence) giảm dần, ví dụ: $h = \lfloor n/2 \rfloor, \dots, 1$ (chuỗi Shell) hoặc $3k+1$ (chuỗi Knuth).
* Ở mỗi bước với khoảng cách $h$, thuật toán thực hiện **$h$-sorting**: coi mảng gồm $h$ mảng con xen kẽ và chạy Insertion Sort trên từng mảng con đó (so sánh và hoán đổi các phần tử cách nhau khoảng cách $h$).

### Đặc điểm & Nhận diện

* **Độ phức tạp:** Tùy thuộc vào chuỗi gap, thường nằm trong khoảng $O(n^{1.3})$ đến $O(n \log^2 n)$, không tốn bộ nhớ phụ ($O(1)$).
* **Dấu hiệu nhận diện vết chạy:**
* Nếu chọn một khoảng cách $h$, các phần tử tại các chỉ số $i, i+h, i+2h, \dots$ sẽ tạo thành một dãy tăng dần độc lập.
* Mảng trông vẫn lộn xộn nhưng các phần tử rất nhỏ đã nhanh chóng bay về phía đầu mảng và các phần tử rất lớn đã bay về cuối mảng chỉ sau vài bước đầu.



---

## Bảng tổng kết phân loại thuật toán sắp xếp

| Thuật toán | Dựa trên so sánh? | Thời gian trung bình | Thời gian xấu nhất | Bộ nhớ phụ | Tính ổn định (Stable) | Trường hợp sử dụng tối ưu |
| --- | --- | --- | --- | --- | --- | --- |
| **Counting Sort** | Không | $O(n + K)$ | $O(n + K)$ | $O(n + K)$ | Có | Số nguyên, miền giá trị $K$ nhỏ ($K \le 10^7$). |
| **Radix Sort** | Không | $O(d(n + B))$ | $O(d(n + B))$ | $O(n + B)$ | Có | Số nguyên 32/64-bit hoặc chuỗi ký tự cố định. |
| **Bucket Sort** | Không (kết hợp) | $O(n + k)$ | $O(n^2)$ | $O(n + k)$ | Có | Số thực phân phối đều trong đoạn $[0, 1)$. |
| **Shell Sort** | Có | $O(n^{4/3})$ | $O(n^2)$ | $O(1)$ | Không | Mảng kích thước vừa phải, cần sắp xếp tại chỗ không tốn RAM. |
| **Quicksort** | Có | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ | Không | Dữ liệu ngẫu nhiên tổng quát, cache-friendly cao. |
| **Mergesort** | Có | $O(n \log n)$ | $O(n \log n)$ | $O(n)$ | Có | Cần đảm bảo thời gian $O(n \log n)$ và bảo toàn thứ tự ban đầu. |