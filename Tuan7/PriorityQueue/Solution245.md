# Bài 2 4 5: Vẽ heap thu được khi thêm các khóa sau vào 1 heap max ban đầu rỗng 
E A S Y Q U E S T I O N

** Lời giải **

KQ: 

```mermaid
graph TD
    1["1: Y"] --- 2["2: T"]
    1 --- 3["3: U"]
    
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    
    3 --- 6["6: N"]
    3 --- 7["7: E"]
    
    4 --- 8["8: A"]
    4 --- 9["9: S"]
    
    5 --- 10["10: I"]
    5 --- 11["11: O"]
    
    6 --- 12["12: E"]
```

Theo từng bước thêm :

B1: Thêm E

```mermaid
graph TD
    1["1: E"]
```
B2:Thêm A

```mermaid
graph TD 
    1["1: E"] ---2["2: A"]
```

B3 : Thêm S vào vị trí 3 và swim lên 
```mermaid 
graph TD
    1["1: E"] --- 2["2: A"]
    1 --- 3["3: S"]
```

So sánh ta thấy S > E nên S swim lên vị trí E 

```mermaid 
graph TD 
    1["1: S"] --- 2["2: A"]
    1 --- 3["3: E"]
```

B4: Thêm Y vào vị trí k = 4 và so sánh để swim lên
```mermaid 
graph TD 
    1["1: S"] --- 2["2: A"]
    1 --- 3["3: E"]
    2 --- 4["4: Y"]
```

So sánh ta thấy Y > A nên swap(A,Y), so sánh Y>S swap(Y,S)

```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: E"]
    2 --- 4["4: A"]
```
B5 : Thêm Q vào và swim lên

```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: E"]
    2 --- 4["4: A"]
    2 --- 5["5: Q"]
```

B6 : Thêm U vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: E"]
    2 --- 4["4: A"]
    2 --- 5["5: Q"]
    3 --- 6["6: U"]
```
So sánh thấy U > E ta swim U lên

```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: U"]
    2 --- 4["4: A"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
```

B7 : Thêm E vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: U"]
    2 --- 4["4: A"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
```

B8 : Thêm S vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: U"]
    2 --- 4["4: A"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: S"]
```
So sánh thấy S > A ta swim S lên

```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
```

B9: Thêm T vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: S"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
    4 --- 9["9: T"]
```
Ta thấy T > S nên T swim lên
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: T"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
    4 --- 9["9: S"]
```

B10 : Thêm I vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: T"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
    4 --- 9["9: S"]
    5 --- 10["10: I"]
```

Bước 11 : Thêm O vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: T"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
    4 --- 9["9: S"]
    5 --- 10["10: I"]
    5 --- 11["11: O"]
```

Bước 12 : Thêm N vào 
```mermaid 
graph TD 
    1["1: Y"] --- 2["2: T"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: E"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
    4 --- 9["9: S"]
    5 --- 10["10: I"]
    5 --- 11["11: O"]
    6 --- 12["12: N"]
```
so sánh ta thấy N > E swim N lên 

```mermaid 
graph TD 
    1["1: Y"] --- 2["2: T"]
    1 --- 3["3: U"]
    2 --- 4["4: S"]
    2 --- 5["5: Q"]
    3 --- 6["6: N"]
    3 --- 7["7: E"]
    4 --- 8["8: A"]
    4 --- 9["9: S"]
    5 --- 10["10: I"]
    5 --- 11["11: O"]
    6 --- 12["12: EE"]
```