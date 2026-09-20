1. COS 226, f25, precept 1. Tìm bug
    Hãy xem cài đặt không chính xác sau đây của hàm union() trong cấu trúc dữ liệu quick-find. 
    Lưu ý rằng mảng leader[] có độ dài n được khởi tạo với leader[i] = i cho mọi i, và hàm find(i) trả về giá trị leader[i].
    Hãy một giá trị cho số lượng phần tử n, 
    một chuỗi các phép toán union(), một số nguyên 0 ≤ i < n và một số nguyên 0 ≤ j < n, sao cho các phần tử i và j thuộc cùng một tập hợp nhưng  find(i) và find(j) trả về các giá trị khác nhau. Nói cách khác là tìm 1 testcase mà cài đặt trên chạy sai.
    ```
    public void union(int p, int q){
    {
        for (int i = 0; i < leader.length; i++)
            if(leader[i] == leader[p])
                leader[i]=leader[q];
    }
    ```
    Tìm 1 testcase mà code trên chạy sai.
            LỜI GIẢI :
    Ta thấy trong đoạn code trên, giá trị của `leader[p]` không dược lưu ở một biến tạm thời độc lập khác trước khi vòng lặp diễn ra.
    Do đó khi duyệt các chỉ số 'i' mà khi ấy `i=p` thì câu lệnh `leader[p]=leader[q]` sẽ khiến giá trị của leader[p] đổi. khi đó các giá trị ở phía sau mảng mà trước đó cùng nhánh với p sẽ không được gán vào q dẫn tới sai lệch kết quả.
    Vì vậy ở các lần so sánh sau 'leader[i]==leader[p]` sẽ trở nên vô giá trị.
    Điều đó cho thấy đoạn mã trên chỉ đúng khi giá trị p đứng ở cuối mảng ( so với các giá trị cùng nhánh với nó ) ở các TH còn lại sẽ gây sai lệch kết quả.
    Ví dụ :
    Số lượng phần tử : 3 
    Các phần tử trong mảng là : 0 1 2 
    Thao tác nối :
    ``` 
    union(1,0)
    union(0,2)
    ```
    Hai phần tử kiểm tra sẽ là i=0 và j =1 
    Diễn giải trạng thái leader qua từng bước:
    Ban đầu 0 1 2 
    Sau thao tác nối đầu tiên : 0 0 2 
    Sau thao tác số 2 là 2 0 2 
    Từ đõ, ta có thể thấy rằng dù leader của 1 là 0 nhưng khi leader của 0 là 2 thì leader của 1 vẫn khồng thay đối điều đó sẽ dẫn tới sự sai lệch.
    [File chạy lỗi: BuggyQuickFind.java](../Algorithm/BuggyQuickFind.java)
    [File mã nguồn đã fix: FixQuickFind.java](../Algorithm/FixQuickFInd.java)