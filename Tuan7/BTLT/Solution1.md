`COS226, Midterm f25, 2b`

Ta có hàm swim:  

```
private void swim(int k){
    while(k>1 && less(k / 2, k)){
        exch(k, k / 2);
    }
}
```
Ta thấy với swim, nút k chỉ so sánh với nút cha của nó và đổi chỗ với nút cha của nó khi nút cha nhỏ hơn nó.

Do vậy khi thay nút 0 bằng 77 thì 77 sẽ so sánh với 10 và đổi chỗ với 10

Sau đó 77 so sánh với 75 và đổi chỗ với 75

Cuối cùng so sánh với 80 và giữ nguyên kết thúc swim

**Vậy đáp án sẽ là 3 phép so sanh**