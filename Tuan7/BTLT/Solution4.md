# COS226, Midterm f25, 1b

---

## **Lời giải**

Đoạn mã đề chính là việc sử dụng hàng dợi ưu tiên **MinPQ** để thực hiện việc sắp xếp mảng (**Heapsort**):

1. Đưa lần lượt $n$ phần tử vào heap qua `insert`
2. Lấy lần lượt $n$ phần tử nhỏ nhất thông qua hàm `delMin`

---

### **Hàm `insert(x)` :**

```java
public void insert(Key x) {
    pq[++n] = x; // Nhét x vào vị trí cuối cùng 
    swim(n);\    // Gọi swwim để đưa x lên đúng vị trí
    // Đánh số từ 1 tới n
```

### **Hàm `delMin` của MinPQ:**

```java
public Key delMin() {
    Key min = pq[1]; // Lấy phần tử nhỏ nhất ở gốc ( do đây là min-heap )
    exch(1, n--);    // swap gốc và phần tử cuối cùng
    sink(1);         // gọi sink để đẩy phần tử mới chìm xuống
    return min;
}
```

---

> ### **Note :**
>
> Hàm **swim** và **sink** trong **min - heap** đảo ngược hoàn toàn so với **max - heap**
>
> **Do đó :**
> 1. Hàm **swim** chỉ so sánh với **nút cha** của nó, nếu nút cha lớn hơn nút hiện tại thì ta đổi số để số nhỏ *"swim"* lên
> 2. Hàm **sink** sẽ so sánh với **2 nút con** của nó ( ban đầu so sánh 2 nút con để chọn ra nút con nhỏ hơn sau đó sẽ so sánh nút cha ( nút hiện tại ) với nút con nhỏ hơn nếu nút cha lớn hơn thì swap với nút con )

---

### **Từ đó ta xét 2 vòng lặp :**

* **Vòng lặp 1**, chạy $n$ lần `insert`. Ở bước thứ $i$, phần tử mới được đưa vào đáy cây có kích thước $i$ và gọi hàm `swim()`. Với **TH tồi nhất**, mõi phần tử thêm vào đều nhỏ hơn các phần tử trước đó nên phần tử đó phải bơi từ lá lên tận gốc và tốn $\approx \log_2 i$ bước. Vậy độ phức tạp sẽ là :

$$\sum_{i=1}^{n} \Theta(\log i) = \Theta(\log(n!)) = \Theta(n \log n)$$

* **Vòng lặp 2**, chạy $n$ lần `delMin`. Ở bước thứ $i$, phần tử gốc được lấy ra, phần tử cuối cùng được chuyển lên gốc và gọi hàm `sink()` trên cây heap kích thước $n - i$. Trong **TH tồi nhất**, phần tử này càn phải chìm xuống tận đáy, khoảng $\approx 2 \log_2(n - i)$ bước. Vậy độ phức tạp sẽ là :

$$\sum_{i=1}^{n} \Theta(\log i) = \Theta(n \log n)$$

---

### **Ta xét chi phí thay đổi kích thước 2 mảng :**

* **Khi chèn phần tử**, mảng sẽ nhân đôi phần tử khi đầy, vậy tôingr số lần sao chép phần tử qua tất cả các lần nhân đôi trong toàn bộ vòng lặp là 1 cấp số nhân :

$$1 + 2 + 4 + 8 + \dots + n < 2n = O(n)$$

* **Khi xóa**, mảng giảm 1 nửa khi số phần tử chiếm 1/4 dung lượng, tương tự đây cũng là 1 cấp số nhân lùi :

$$O(n) + O(n/2) + O(n/4) + \dots = O(n)$$

---

### **Vậy tổng thời gian chạy là :**

$$T(n) = \Theta(n \log n) + O(n) = \Theta(n \log n)$$