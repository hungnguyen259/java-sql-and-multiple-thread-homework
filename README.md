# java-and-sql-homework

1\. Sử dụng Set để tìm tập giao và tập hợp giữa 2 tập hợp (tự tạo ra 2 tập hợp, mỗi tập hợp 200.000 phần tử không trùng nhau và các phần tử là một số Integer ngẫu nhiên, 2 tập hợp phải có phần tử trùng nhau) trong khoảng thời gian ngắn nhất.

2\. Cho một văn bản bất kỳ, đặt ở file input.txt. Hãy đọc file và đếm số lần xuất hiện của từng từ (mỗi từ phân biệt nhau bằng dấu cách) rồi ghi vào file output.txt.

3\. Lập trình đếm từ đa luồng cho bài 2 với dữ liệu vào là một folder chứa nhiều file text. Hãy xử lý song song các file và tìm top 10 từ xuất hiện nhiều nhất, và top 10 từ xuất hiện ít nhất của toàn bộ dữ liệu có trong folder. Lưu ý, chỉ được chạy tối đa 6 luồng cùng lúc.

4\. Sinh ngẫu nhiên 30.000 điểm trên mặt phẳng tọa độ 2 chiều số nguyên. Sao cho 8.000 điểm đầu tiên có cách điểm A(800, 800) một độ dài không quá 400 đơn vị, 10.000 điểm tiếp theo cách điểm B(4000,800) không quá 500 đơn vị, và 12.000 điểm cuối cùng cách điểm C(2400, 2400) không quá 600 đơn vị. Trộn ngẫu nhiên 30.000 điểm này, sau đó ghi ra file output4.txt

5\. Trong file Maze.java có chứa bản đồ mê cung, hãy implement hàm solve dựa trên một phương pháp tìm đường nào đó. Hãy chọn các phương pháp có độ phức tạp (số bước thực hiện) càng nhỏ càng tốt và đánh dấu đường đi bằng cách thay số 0 bằng số 2 trên ma trận mê cung. Lưu ý, bài tập này có xét cách viết code, comment, viết java doc, đặt tên biến/hàm, tổ chức project...

SQL:

Cho 2 lớp country và city có các thuộc tính như duới đây. Một quốc gia chỉ có 1 thủ đô và nhiều thành phố:

Country:

+ String code (mã quốc gia)

+ String name 

+ String continent (mã lục địa)

+ double surfaceArea (diện tích bề mặt)

+ int population (dân số)

+ double gnp (GRoss National Product)

+ int caputal (mã thành phố là thủ đô đất nước này)

City:

+ int countryCode

+ int id

+ String name

int population (dân số của thành phố)

Tự tạo dữ liệu dựa trên bảng trên và thực hiện các câu truy vấn sau:

1\. Tìm thành phố đông dân nhất của mỗi quốc gia

2\. TÌm thành phố đông dân nhất của mỗi lục địa

3\. Tìm thành phố là thủ đô và đông dân nhất

4\. TÌm thành phố là thủ đô, đông dân nhất của mỗi lục địa

5\. Sắp xếp các quốc gia theo số lượng thành phố giảm dần

6\. Sắp xếp các quốc gia theo mật độ dân số giảm dần
