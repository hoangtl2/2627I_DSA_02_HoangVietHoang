```commandline
a[ ]
       lo mid  hi   0  1  2  3  4  5  6  7  8  9 10 11
                    E  A  S  Y  Q  U  E  S  T  I  O  N
merge(  0,  0,  1)  A  E  S  Y  Q  U  E  S  T  I  O  N
merge(  0,  1,  2)  A  E  S  Y  Q  U  E  S  T  I  O  N
merge(  3,  3,  4)  A  E  S  Q  Y  U  E  S  T  I  O  N
merge(  3,  4,  5)  A  E  S  Q  U  Y  E  S  T  I  O  N
merge(  0,  2,  5)  A  E  Q  S  U  Y  E  S  T  I  O  N
merge(  6,  6,  7)  A  E  Q  S  U  Y  E  S  T  I  O  N
merge(  6,  7,  8)  A  E  Q  S  U  Y  E  S  T  I  O  N
merge(  9,  9, 10)  A  E  Q  S  U  Y  E  S  T  I  O  N
merge(  9, 10, 11)  A  E  Q  S  U  Y  E  S  T  I  N  O
merge(  6,  8, 11)  A  E  Q  S  U  Y  E  I  N  O  S  T
merge(  0,  5, 11)  A  E  E  I  N  O  Q  S  S  T  U  Y
```

merge(0, 0, 1): Trộn E và A $\rightarrow$ A E

merge(0, 1, 2): Trộn A E và S $\rightarrow$ A E S

merge(3, 3, 4): Trộn Y và Q $\rightarrow$ Q Y

merge(3, 4, 5): Trộn Q Y và U $\rightarrow$ Q U Y

merge(0, 2, 5): Trộn A E S và Q U Y $\rightarrow$ A E Q S U Y (Xong nửa trái 0–5)

merge(6, 6, 7): Trộn E và S $\rightarrow$ E S

merge(6, 7, 8): Trộn E S và T $\rightarrow$ E S T

merge(9, 9, 10): Trộn I và O $\rightarrow$ I O

merge(9, 10, 11): Trộn I O và N $\rightarrow$ I N O

merge(6, 8, 11): Trộn E S T và I N O $\rightarrow$ E I N O S T (Xong nửa phải 6–11)

merge(0, 5, 11): Trộn A E Q S U Y và E I N O S T $\rightarrow$ A E E I N O Q S S T U Y (mảng hoàn tất sắp xếp)