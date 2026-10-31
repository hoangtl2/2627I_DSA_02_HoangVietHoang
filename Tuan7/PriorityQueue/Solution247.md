# Problem 2.4.7

** Lời giải **

**Nguyên lý cốt lõi:**
Một nút ở độ sâu $d$ (với gốc ở $d = 0$) có đúng $d$ tổ tiên luôn lớn hơn nó, do đó nó chỉ có thể xếp từ hạng $d + 1$ trở đi ($d \le k - 1$). Đồng thời, vị trí gốc ($k=1$, $d=0$) luôn là phần tử lớn nhất. Do đó, phần tử lớn thứ $k$ ($k \ge 2$) chỉ có thể nằm ở các độ sâu:


$$1 \le d \le k - 1$$

Phân bố vị trí theo độ sâu trên heap kích thước $N = 31$:

* **$d = 0$:** Vị trí `1`
* **$d = 1$:** Vị trí `2, 3`
* **$d = 2$:** Vị trí `4 – 7`
* **$d = 3$:** Vị trí `8 – 15`
* **$d = 4$:** Vị trí `16 – 31`

---

### Kết quả

#### 1. Với $k = 2$ (Độ sâu $d = 1$)

* **(i) Có thể xuất hiện:** `2, 3`
* **(ii) Không thể xuất hiện:** `1` và `4 đến 31`

#### 2. Với $k = 3$ (Độ sâu $1 \le d \le 2$)

* **(i) Có thể xuất hiện:** `2 đến 7` (`2, 3, 4, 5, 6, 7`)
* **(ii) Không thể xuất hiện:** `1` và `8 đến 31`

#### 3. Với $k = 4$ (Độ sâu $1 \le d \le 3$)

* **(i) Có thể xuất hiện:** `2 đến 15` (`2, 3, 4, ..., 15`)
* **(ii) Không thể xuất hiện:** `1` và `16 đến 31`