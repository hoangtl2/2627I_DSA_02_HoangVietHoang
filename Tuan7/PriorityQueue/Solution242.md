Phản biện :

Ý tưởng này chỉ hoạt động khi tập dữ liệu chỉ thêm vào mà không xóa đi.
Khi áp dụng vào hàng đợi ưu tiên thì gặp 2 lỗi :
1. Mất max khi xóa. nếu phần tử lớn nhất bị xóa khỏi stack/queue. biến lưu max sẽ không còn đúng nữa. Khi này để tìm lại max cần duyệt lại 1 lần qua mảng.
2. Không thể xóa trực tiếp phần tử max, nếu max ở giữa hoặc cuối mảng.
3. 