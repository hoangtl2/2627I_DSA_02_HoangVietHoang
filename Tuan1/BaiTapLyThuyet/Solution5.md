Dưới đây có thể là biểu diễn parent-link của một cấu trúc dữ liệu weighted quick union hay không?
```
                  (5) 
                 /    \
               (0)    (7)
             /  |  \    \
           (2) (4) (6)  (9)
               /   / \
             (3) (1) (8)
```
            `Lời giải`
`Không thể `
Theo WQU thì khi nối cây nhỏ vào cây lớn thì kích thước của cây Tcon nào cũng khồng bao giờ được vượt quá một nửa tổng kích thước mà cây chứa nó 

`size(Tcon) <= 1/2 * size(Ttổng)`

Do đó việc cây này không thể là của WQU