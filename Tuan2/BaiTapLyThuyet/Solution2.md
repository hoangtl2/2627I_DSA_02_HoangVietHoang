COS226, Midterm f25, 1c

Hàm op() được gọi bao nhiêu lần (tính theo n)?

```commandline
 for (int i = 0; i < n * n; i++)
    for (int j = i + 1; j < n * n; j++)
        for (int k = 1; k <= n * n; k = k * 2) 
            op();
```

**Lời giải**

Đặt M = n^2 

Biến i chạy từ 0 tới M - 1 

Biến j chạy từ i + 1 tới M - 1

Ta thấy đây là việc chọn ra cặp (i,j) sao cho 0 <= i < j < M

Vậy số cặp (i,j) được thực thi là MC2 = M(M-1)/2 = n^2(n^2 - 1)/2 = (n^4)/2 - (n^2)/2 ~ (n^4)/2

Xét vòng lặp k

Biến k nhân đôi cho đến khi k <= n^2

Cậy số lần thực thi sẽ là 2log2(n)

Vậy Tổng ~ (n^4)/2 * 2log2(n) = n^4 * log2(n)

