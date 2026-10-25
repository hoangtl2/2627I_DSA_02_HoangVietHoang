# Bài 2.4.1: Max Priority Queue

**Dãy thao tác:** `P R I O * R * * * I * T * Y * * * Q U E * * * U * E`

### Quá trình thực hiện:
- `P R I O` $\to$ Thêm P, R, I, O
- `*` $\to$ Lấy ra **R**
- `R` $\to$ Thêm R
- `* * *` $\to$ Lấy ra **R, P, O**
- `I` $\to$ Thêm I
- `*` $\to$ Lấy ra **I**
- `T` $\to$ Thêm T
- `*` $\to$ Lấy ra **T**
- `Y` $\to$ Thêm Y
- `* * *` $\to$ Lấy ra **Y, I** *(dấu `*` thứ 3 hàng đợi rỗng)*
- `Q U E` $\to$ Thêm Q, U, E
- `* * *` $\to$ Lấy ra **U, Q, E**
- `U` $\to$ Thêm U
- `*` $\to$ Lấy ra **U**
- `E` $\to$ Thêm E

### Kết quả:
Chuỗi ký tự thu được: **`R R P O I T Y I U Q E U`**