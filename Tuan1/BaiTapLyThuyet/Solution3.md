COS226, Midterm f25, 2a
Xét biểu diễn parent-link dưới đây của một cấu trúc dữ liệu weighted quick union (link-by-size):
        `Lời Giải:  `
Với TH1 : (0,4) `Không Hợp Lệ`
ta thấy với đồ thị này thì gốc 0 đang trỏ vào gốc 4
nhưng nếu tách gốc 0 ra khỏi gốc 4 thì rõ ràng khi đó 2 nhánh của 0 và 4 đều có 4 giá trị liên thông.
Khi đó theo quy ước ta phải nối 4 vào 0 đây là điều không hợp lý.
Do đó trường hợp này không hợp lệ 

Với TH2 : (2,3) là điều không thể xảy ra 
Vì nếu khi nối 2 và 3 nếu 3 tách ngoài và nối vào gốc 2 khi đó gốc 3 phải trỏ vào gốc trùm của 2 tức là gốc 0.
Vậy trường hợp này `không hợp lệ`

Với TH3 : (4,0) `Hợp Lệ`
Ta thấy ở cây nếu trước đó gốc 0 chưa nối vào gốc 4.
Thì gốc 0 sẽ có 4 thành phần và gốc 4 cũng có 4 thành phần nhưng theo đề thì gốc q sẽ trỏ vào gốc p
Nên gốc 0 sẽ trỏ vào gốc 4. Vậy TH này hợp lệ. 

với TH4 : (4,5) `Hợp lệ`
Ta thấy nếu tách gốc 5 ra khỏi gốc 4 và thực hiện lệnh nối trên
Khi đó trùm của gốc 5 là chính nó và trùm của gốc 4 là chính nó 
Vì vậy gốc 5 sẽ được nối với gốc 4.
Do đó trường hợp này hợp lệ

TH5: (5,0) `Hợp lệ`
Nếu tách gốc 5 ra khỏi gốc 4 và thực hiện lệnh nối trên.
Khi đó trùm của gốc 5 là gốc 5 còn trùm của gốc 0 là gốc 4.
Theo `weighted quick union` thì ta có thể thấy gốc 5 sẽ trỏ vào trùm của gốc 0 là gốc 4 
Do đó trường hợp này hợp lệ

TH6: (5,7) `không hợp lệ`
Nếu tách gốc 5 ra khỏi gốc 4 thì hiển nhiên sẽ khồng được vì khi đó gốc 5 sẽ nối với gốc 7 và tạo thành một liên thồng 2 thành viên.
Vậy nếu tách  7 ra khỏi 5 và thực hiện lệnh trên. 
Khi đó theo `weighted quick union` thì sẽ nối trùm của gốc 7 vào trùm của gốc 5 vì nhánh 5 có nhiều đơn vị hơn.
Vì đó mà gốc 7 sẽ phải nối thẳng vào gốc 4.
Do đó trường hợp này không hợp lệ.

TH7: (6,4) : `không hợp lệ`
Ta thấy nếu lúc này gốc 6 chưa nối vào gốc 4 thì gốc 6 chỉ là 1 thành phần đơn lẽ với parrent tự trỏ vào nó.
Do vậy khi thực hiện lệnh union trên thì gốc 6 sẽ trỏ thẳng vào gốc 4 do gốc 4 có nhiều phần tử hơn.
Vì vậy trường hợp này hoàn toàn hợp lệ

TH8 (8,9) : `Hợp lệ`
Lúc này 8 và 9 đều là 2 nút đơn lẻ.
theo quy ước thì union(p,q) thì nút của q sẽ trỏ tới nút p do đó 9 sẽ trỏ tới 8 
Vì vậy trường hợp này hợp lệ 