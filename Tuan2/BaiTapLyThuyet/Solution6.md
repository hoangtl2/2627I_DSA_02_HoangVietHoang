COS226, Midterm f24, 2b

$$f(n) = n\log^2 n + 3n\sqrt{n} - 5n = n\log^2 n + 3n^{1.5} - 5n$$

**Lời Giải**

```
So sánh tốc độ tăng trưởng của các số hạng khi n tiến tới dường vô cùng
    
```
$3n\sqrt{n} = 3n^{1.5}$ = $3n\sqrt{n} = 3n^{1.5}$.

Số hạng $n\log^2 n$: VÌ bất kì số hạng đa thức bậc dương nào cũng đều tăng nhanh hơn hàm polulogarithm
 ($\sqrt{n} = n^{0.5}$ tăng nhanh hơn nhiều so với $\log^2 n$)

Do đó hiển nhiên $n^{1.5}$  sẽ tăng nhanh hơn so với $n\log^2 n$.

Số hạng -5n : bậc thấp hơn $n^{1.5}$

Do đó số hạng đại diễn sẽ là $3n\sqrt{n}$

**VẬY : **

$f(n) \sim 3n\sqrt{n}$

$f(n) = \Theta(n\sqrt{n}) = \Theta(n^{1.5})$

`Xét các đáp án`

$\sim n\sqrt{n}$ : saI vì thiếu hệ số

$\Theta(n\log^2 n)$: Sai vì tăng trưởng chậm hơn

$O(n^3)$ : Đúng vì n^3 lớn hơn $n^{1.5}$

$O(n\sqrt{n})$ : ĐÚng vì đây là chặn trên chặt

$O(n)$ : Sai vì tăng trưởng chậm hơn

$\Omega(\log n)$: Đúng vì $n^{1.5}$ tăng nhanh hơn $\log n$, nên $\log n$

