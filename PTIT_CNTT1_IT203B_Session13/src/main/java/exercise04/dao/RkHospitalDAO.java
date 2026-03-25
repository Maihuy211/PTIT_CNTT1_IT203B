package exercise04.dao;

import exercise04.database.DBConnect;
import exercise04.model.BenhNhan;
import exercise04.model.DichVu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RkHospitalDAO {
    public List<BenhNhan> getAll() {
        List<BenhNhan> list = new ArrayList<>();
        Map<Integer, BenhNhan> map = new HashMap<>();

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT bn.maBenhNhan, bn.tenBenhNhan, dv.maDichVu, dv.tenDichVu " +
                    "FROM BenhNhan bn LEFT JOIN DichVuSuDung dv " +
                    "ON bn.maBenhNhan = dv.maBenhNhan";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int maBN = rs.getInt("maBenhNhan");

                if (!map.containsKey(maBN)) {
                    BenhNhan bn = new BenhNhan();
                    bn.setMaBenhNhan(maBN);
                    bn.setTenBenhNhan(rs.getString("tenBenhNhan"));
                    map.put(maBN, bn);
                }

                BenhNhan bn = map.get(maBN);

                // Bẫy 2: tránh null dịch vụ
                int maDV = rs.getInt("maDichVu");
                if (maDV != 0) {
                    DichVu dv = new DichVu();
                    dv.setMaDichVu(maDV);
                    dv.setTenDichVu(rs.getString("tenDichVu"));
                    bn.getDsDichVu().add(dv);
                }
            }
            list.addAll(map.values());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
