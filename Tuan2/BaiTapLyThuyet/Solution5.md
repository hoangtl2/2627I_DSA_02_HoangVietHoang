COS226, Midterm f24, 2a

```
for (int i = 1; i <= n; i++)
    for (int j = n; j >= i; j--)
        for (int k = 1; k <= n; k = k + n/100)
            System.out.println("hello");
```

**Lời Giải**

```
Xét vòng lặp io và j:
    Với i chạy từ 1 tới n 
    Với mỗi biễn i, biến j giảm dần từ n về i
    Khi i = 1: j chạy từ n về 1 ( n lần )
    Khi i = 2 : j chạy từ n về 2 ( n - 1 lần )
    ...
    Khi i = n : j chạy từ n về n ( 1 lần )    
    Vậy tổng số cặp (i,j) sẽ là tổng dãy số :
    n + (n-1) + ... + 1 = n(n+1)/2 ~ (n^2)/2
```

```
Xét vòng lặp k:
    Biến k bắt đầu tại 1 và dừng tại k<=n
    Bước nhảy của k là n/100
    Do đó vòng lặp này sẽ xấp xi :
        (n-1)/(n/100) +1 ~ n/(n/100) ~ 100 lần 

```

**Vậy tổng số lần `hello` ~ (n^2)/2 * 100 = 50*n^2 lần**