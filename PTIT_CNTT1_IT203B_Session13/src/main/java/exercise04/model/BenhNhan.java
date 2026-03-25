package exercise04.model;

import java.util.ArrayList;
import java.util.List;

public class BenhNhan {
    private int maBenhNhan;
    private String tenBenhNhan;
    private List<DichVu> dsDichVu = new ArrayList<>();

    public BenhNhan() {
    }

    public BenhNhan(int maBenhNhan, String tenBenhNhan, List<DichVu> dsDichVu) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.dsDichVu = dsDichVu;
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }
}
