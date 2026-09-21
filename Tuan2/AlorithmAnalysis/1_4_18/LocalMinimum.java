/*
    1.4.18. Local minimum of array.
    Viết một chương trình nhận input là một mảng a[] gồm N giá trị int phân biệt,
    Tìm một cực tiểu địa phương (local minimum) là chỉ số i sao cho a[i] nhỏ hơn a[i-1] và < a[i+1].
    Chương trình chỉ nên dùng ~2lgN phép so sánh trong trường hợp tồi nhất.

 */

/*
    Ý tưởng : Chặt nhị phân ở mảng chưa sắp
    mid = l + (r-l)/2
    so sánh mid với mid-1 nếu mid-1 bé hơn -> sẽ có cực tiểu đp ở bên trái tiếp tục chặt nhị phân về phìa trái
    bên phải tương tự
    Khi đó ta se đạt đc độ phức tạp theo yêu cầu đề bài
 */
import java.util.Scanner;
public class LocalMinimum {
    public static int findLocalMinimum(int[] a) {
        if (a == null || a.length == 0) return -1;
        int n = a.length;
        if (n == 1) return 0;
        if (a[0] < a[1]) return 0;
        if (a[n - 1] < a[n - 2]) return n - 1;
        int l = 1;
        int r = n - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > a[mid - 1]) {
                r = mid - 1;
            }
            else if (a[mid] > a[mid + 1]) {
                l = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int index = findLocalMinimum(a);
        if (index != -1) {
            System.out.println(a[index]);
        } else {
            System.out.println();
        }
        sc.close();
    }
}