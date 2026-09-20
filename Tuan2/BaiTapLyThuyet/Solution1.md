1 . COS226. s26. precept1 ]

        `Lời giải`
Câu 1:

```
for (int i = 10; i < n + 5; i += 2)
    op();
```

i bắt đầu chạy từ 10 tới khi < n + 5 và mỗi lần chạy tăng 2 đơn vị 

Do đó số lần chạy sẽ xấp xỉ (n+5)/2 - 5 = n/2 - 2.5

`Tilde` : ~ n/2

`Big Theta` : O(n)
<br>

Câu 2:

```
    for (int i = 1; i <= n * n * n; i *= 2)
        op();
```

i bắt đầu chạy từ 1 và gấp đôi qua mỗi vòng lặp

Vòng lặp dừng lại khi 2^k > n^3 

k xấp xỉ log2(n^3) = 3log2(n)

`Tilde` : ~ 3log2(b)

`Big Theta` : O(logn)
<br>

Câu 3:

```
    for (int i = 0; i < n; i++)
        for (int j = 0; j < 100; j++)
            op();
```

Vòng ngoại chạy n lần vòng trong luôn chạy cố định 100 lần nên tổng số lần gọi op() là 100n

`Tilde` : ~ 100n

`Big Theta` : O(n)
<br>

Câu 4: 

```commandline
    for (int i = 0; i * i < n; i++)
        for (int j = 1; j < n; j *= 3)
            op();
```

Vòng ngoài $i^2 < n \iff i < \sqrt{n}$, lặp $\approx \sqrt{n}$ lần.

Vòng trong : $j$ nhân $3$ mỗi lần đến $n$, lặp $\approx \log_3 n$ lần.

Tổng số lần là : $\sqrt{n} \log_3 n$.

`Tilde` : ~ \sqrt{n} \log_3 n$

`Big Theta` : ** $\Theta(\sqrt{n} \log n)$

<br>
Câu 5 :

```commandline
for (int i = 0; i < n; i++)
    for (int j = 1; j < n; j *= 2)
        op();
```

Vòng ngoài chạy n lần 

Vòng trong chạy $\approx$ log2(n) lần

Vậy tổng số lần gọi sẽ là nlog2(n) lần

`Tilde` : ~ nlog2(n) 

`Big Theta` : O(nlogn) 

<br> 
Câu 6 :

```
for (int i = 0; i < n; i++)
    for (int j = 0; j < 100; j++)
        for (int k = 0; k < n; k++)
            for (int l = k; l < n; l++)
                op();
```

Hai  vòng ngoài chạy tổng 100n lần 

Hai vòng trong :

Khi k = 0, l chạy n lần 

Khi k = 1, l chạy n -1 lần 

...

Tổng số lần sẽ là n + (n-1) + ... + 1 = n(n+1)/2 

Tổng số lần gọi sẽ là 100n*n(n+1)/2 = 50n^3 + 50n^2

`Tilde` : ~50n^3 

`Big Theta` : O(nlogn) 
