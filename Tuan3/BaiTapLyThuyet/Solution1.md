COS226, Midterm f24, 6

`Self-printing queue là loại hàng đợi chứa các số nguyên, được cài đặt bằng một danh sách liên kết và cứ sau ba thao tác (enqueue hoặc dequeue) lại tự in nội dung của queue ra input chuẩn. Ví dụ chuỗi enqueue(0), dequeue(), enqueue(0) sẽ in ra 0.`

**Lời Giải**

a) `dequeue()`
`enqueue(0)` -> 0

`enqueue(1)` -> (0,1)

`dequeue()` -> (1)

**Sau 3 thao tác in ra queue** `1`

`enqueue(2)` -> (1,2)

`enqueue(3)` -> (1,2,3)

`dequeue()` -> (2,3)

**Sau 3 thao tác in ra queue** `2 3`

`enqueue(4)` -> (2,3,4)

`enqueue(5)` -> (2,3,4,5)

`dequeue()` -> (3,4,5)

**Sau 3 thao tác in ra queue** `3 4 5`

`enqueue(6)` -> (3,4,5,6)

`enqueue(7)` -> (3.4.5.6.7)

`dequeue()` -> (4,5,6,7)

**Sau 3 thao tác in ra queue** '4 5 6 7'

**RESULT: ** `1 2 3 3 4 5 4 5 6 7` 

<br>
b)

**RESULT: ** O(n)

`Nguyên nhân : Bởi nếu khi lệnh enqueue này rơi vào đúng thao tác thứ 3 (các thao tác là enqueue hoặc dequeue thì mảng sẽ tự in ra tất cả các phần tử khác trong mảng do đó mỗi lần in 1 phần tử là 1 lệnh do đó n phần tử sẽ là n lệnh`

`Bởi vậy trong trường hợp tồi tệ nhất của thao tác enqueue ẽ có thời gian chạy là O(n)`

<br>
c)

`Do thao tác có cả enqueue và dequeue nên số lượng phần tử trong mảng sẽ không thể vượt quá số lượng của enqueue`

`Mỗi 3 thao tác sẽ có 1 phần in và sẽ không in ra quá 3k phần tử`

**Tổng thời gian in cho toàn bộ n thao tác trong trường hợp xấu nhất sẽ là: **

$$\sum_{k=1}^{\lfloor n/3 \rfloor} \Theta(3k) = \Theta\left(\sum_{k=1}^{n/3} k\right) = \Theta\left(\left(\frac{n}{3}\right)^2\right) = \Theta(n^2)$$

`Tổng các thao tác thêm bớt sẽ là n lần`

**Vậy tổng thời gian cho n thao tác là: ** O(n)+O(n^2) = O(n^2))

Vậy thời gian trên mỗi thao tác là O(n^2)/n = O(n) 

