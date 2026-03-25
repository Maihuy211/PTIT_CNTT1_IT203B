package exercise06;

import exercise06.business.HospitalBusiness;
import org.junit.jupiter.api.Test;

public class HospitalTest {

    @Test
    public void testXuatVienSuccess() {
        HospitalBusiness bs = new HospitalBusiness();

        // test thành công
        bs.xuatVien(101, 500000);
    }

    @Test
    public void testXuatVienFail() {
        HospitalBusiness bs = new HospitalBusiness();

        // test rollback (sửa SQL sai trong DAO trước)
        bs.xuatVien(101, 500000);
    }
}