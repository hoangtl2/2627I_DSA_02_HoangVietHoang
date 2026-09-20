**COS226, Midterm f25, 1d**

Biểu thức nào mô tả đúng về hàm f (n) = 2n2 + 2n + 6 log2 n ?

**Lời Giải**

`Đánh giá chặn trên BigO`

f(n) = O(g(n)) nghĩa là f(n) tăng không nhanh hơn g(n) khi n -> dương vô cùng

O(logn) sai vì n^2 tăng nhanh hơn logn

O(n) sai vì n^2 tăng nhanh hơn n

O(n^2) đúng ( chặn trên gần nhất )

O(n^3) đúng vì O là chặn trên nên bậc cao hơn vẫn đúng

`Đánh giá trặn dưới Big Omega`

$f(n) = \Omega(g(n))$ nghĩa là f(n) tăng nhanh hơn hoặc bằng g(n) khi n tiến tới dương vô cùng

$\Omega(\log n)$: Đúng vì n^2 lớn hơn logn

$\Omega(n)$: Đúng vì n^2 lớn hơn n 

$\Omega(n^2)$: Đúng ( chặn dưới sát nhất )

$\Omega(n^3)$:  Sai vì n^2 không thể bị chặn dưới bởi n^3 

