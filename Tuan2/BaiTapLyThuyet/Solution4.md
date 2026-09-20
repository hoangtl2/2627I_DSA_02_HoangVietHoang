COS226, Midterm s25, 1

```
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // the root of the red-black BST
    private int n;                 // number of key-value pairs
    ...

    private class Node {
        private Key key;           // the key
        private Value value;       // the associated value
        private Node parent;       // link to parent
        private Node left;         // link to left subtree
        private Node right;        // link to right subtree
        private int count;         // number of nodes in subtree
    }
}
```

**Lời giải**

```
    Note:
    Object Header : 16 bytes - Đối tượng nào cũng có 
    Kiểu nguyên thủy :
        boolean, byte : 1 byte
        char, short : 2 bytes
        int, float 4 bytes
        long, double : 8 bytes
        Con trỏ tham chiếu (Reference) 8 bytes. vd root, key , value
        inner class refernce : 8 bytes. vd 1 class B nằm trong class A mà không có chữ static thì java ngầm tạo ra một con trỏ ẩn về instance của A
        Padding (Đệm bộ nhớ) 0-7 
```

**Xét đối tường BST**

Object header : 16 bytes

Tham chiếu : root : 8 bytes

Biến nguyên thủy int n : 4 bytes

Tạm tính sẽ là 16 + 8 + 4 = 28 bytes

Vì 28 không chia hết cho 8 nên JVM đệm thêm 4 bytes padding => 32 bytes

**Xét đối tượng Node lớp trong**

Object Header : 16 bytes

Con trỏ ẩn về BST ( inner class referemce ) : 8 bytes

5 tham chiếu key, value, parent, left, right : 5*8=40 bytes

Biến nguyên thủy int count : 4 bytes

Tạm tính sẽ là 16 + 8 + 40 + 4 = 68 bytes

Vì 68 khồng chia hết cho 8 nên JVM đệm thêm 4 bytes padding 

68 + 4 = 72 bytes

Một cây chứa n cặp key-value sẽ có đúng n đối tượng Node 

Vậy **TỔNG BỘ NHỚ = 72n + 32 (bytes) 

`Khi n quá lớn : ` 72n bytes