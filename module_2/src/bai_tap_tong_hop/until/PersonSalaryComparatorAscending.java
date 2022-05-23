package bai_tap_tong_hop.until;

import bai_tap_tong_hop.model.NhanVien;

import java.util.Comparator;

public class PersonSalaryComparatorAscending implements Comparator<NhanVien> {

//    nên sử dụng Comparator khi có điều kiện sắp xếp theo nhiều tiêu chí
//    Khi so sánh với 1 tiêu chí thì nên sử dụng comparable, không phải tạo thêm class
//    chỉ sử dụng Comparator thì không sao, có thể linh động được khi so sánh thay đổi với nhiều tiêu chí khác
    // khi so sánh từ 2 tiêu chí trở lên thì bắt buộc dùng comparator
    // khi so sánh chỉ có 1 tiêu chí thì sử dụng comparable

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (o1.employeeSalaryCalculation() > o2.employeeSalaryCalculation()) {
            return 1;
        } else if (o1.employeeSalaryCalculation() < o2.employeeSalaryCalculation()) {
            return -1;
        } else {
            return 1;
        }
    }
}
