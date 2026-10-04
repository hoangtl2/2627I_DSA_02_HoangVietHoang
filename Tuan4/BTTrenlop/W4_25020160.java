import java.util.Scanner;
public class W4_25020160 {
    public static void merge_s(int[] arr, int[] temp, int l,int mid,int r){
        int i = l;
        int j = mid+1;
        int k=l;
        while(i<= mid && j <= r){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }
            else {
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=r){
            temp[k++] = arr[j++];
        }
        for (int p=l;p<=r;p++){
            arr[p]=temp[p];
        }
    }
    public static void MergeSort(int[] arr, int[] temp, int l,int r){
        if(l>=r) return;
        int mid = l + (r-l)/2;
        MergeSort(arr, temp,l,mid);
        MergeSort(arr,temp,mid +1,r);
        merge_s(arr,temp,l,mid,r);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];
        for(int i=0;i<n;i++){
            c[i]=sc.nextInt();
        }
        int[] temp=new int[n];
        MergeSort(c,temp,0,n-1);
        int res = 0;
        for(int i=0;i<n;i++){
            int remain = n-i;
            if(c[i]>=remain){
                res=remain;
                break;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
