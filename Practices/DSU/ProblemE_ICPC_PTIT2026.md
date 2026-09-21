# VÒNG CHUNG KẾT ICPC PTIT 2026

## BÀI E: TÍNH TỔNG TRÊN CÂY
*Time limit: 1s*

---

Cho một đồ thị dạng cây với $N$ đỉnh và $N - 1$ cạnh. Cạnh thứ $i$ có trọng số bằng $w_i$.

Với hai đỉnh $u, v$, kí hiệu $f(u, v)$ là trọng số cạnh lớn nhất trên đường đi ngắn nhất từ đỉnh $u$ tới đỉnh $v$. Hãy tính giá trị biểu thức sau:
DSU
$$\sum_{i=1}^{N-1} \sum_{j=i+1}^{N} f(i, j)$$

### Input
- Dòng đầu tiên là số lượng đỉnh $N$ ($2 \le N \le 100.000$).
- $N - 1$ dòng tiếp theo, mỗi dòng gồm 3 số nguyên $u_i, v_i, w_i$ ($1 \le w_i \le 10^7$) mô tả một cạnh của cây nối hai đỉnh $u_i, v_i$ với trọng số $w_i$.

### Output
- In ra một số nguyên duy nhất là giá trị tổng tìm được.

---

### Test ví dụ

| Input | Output |
| :--- | :--- |
| `3`<br>`1 2 100`<br>`2 3 200` | `500` |
| `5`<br>`1 2 10`<br>`2 3 20`<br>`4 2 50`<br>`3 5 140` | `760` |

#### Giải thích test 1:
- $f(1, 2) = 100$
- $f(2, 3) = 200$
- $f(1, 3) = 200$

Ta có: $100 + 200 + 200 = 500$.