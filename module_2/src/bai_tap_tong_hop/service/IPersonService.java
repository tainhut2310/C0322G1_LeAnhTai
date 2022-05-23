package bai_tap_tong_hop.service;

public interface IPersonService {
    void timeKeeping(); // nên tạo ra một interface có phương thức là chấm công bởi vì chỉ có nhân viên quản lý và nhân viên
    // implement lại phương thức này vì nếu viết phương thức ở lớp cha thì trước đó nhân viên công nhật đã extends từ lớp cha
    // nên khi triển khai phương thức ở lớp cha thì vô tình class nhân viên công nhật sẽ override lại phương thức đó dẫn đến dư thừa

    // Khi một nhóm đối tượng không có cùng bản chất nhưng có những hành vi chung nên dùng interface
    // Khi 1 nhóm đối tượng có cùng bản chất kế thừa từ 1 class thì class đó nên là abstract class
}
