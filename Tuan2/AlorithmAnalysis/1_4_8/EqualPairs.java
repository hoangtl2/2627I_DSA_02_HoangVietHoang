/*
    1.4.8. Viết một chương trình tính số cặp số có giá trị bằng nhau từ một file chứa các số int.
    Nếu thuật toán của bạn đang là bậc hai,
    Hãy tìm cách sử dụng Arrays.sort() để có thuật toán NlogN. (Arrays.sort() là hàm sắp xếp mảng sử dụng thuật toán loại NlogN)

 */
/*
    Ý tưởng : sắp xếp mảng bằng Arrays.sort(x) mất O(nlogn)
    Khi đó các phần tử bằng nhau sẽ nằm kề, duyệt qua mảng 1 lần để xem độ dài các đoạn cạnh.
    Khi đó số cặp sẽ là k(k-1)/2
    Độ phức tạp thuật toán là O(NlogN) + O(N) =
 */
import java.util.Arrays;
import java.util.Scanner;

public class EqualPairs {
    public static int countPairs(int[] a) {
        Arrays.sort(a);
        int count = 0;
        int freq = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                freq++;
            } else {
                count += freq * (freq - 1) / 2;
                freq = 1;
            }
        }
        count += freq * (freq - 1) / 2;
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(countPairs(a));
        sc.close();
    }
}