package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.HealthDao;
import util.DbConnection;

public class HealthDaoImpl implements HealthDao {

    @Override
    public void create(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature) {

        String sql = "INSERT INTO health_record "
                + "(period, measure_time, systolic, diastolic, temperature) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, period);
            ps.setString(2, time);
            ps.setInt(3, Integer.parseInt(systolic));
            ps.setInt(4, Integer.parseInt(diastolic));
            ps.setDouble(5, Double.parseDouble(temperature));

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {

        String sql = "SELECT * FROM health_record ORDER BY id DESC";

        String result = "";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                result += "編號：" + rs.getInt("id") + "\n";
                result += "時段：" + rs.getString("period") + "\n";
                result += "時間：" + rs.getString("measure_time") + "\n";
                result += "收縮壓：" + rs.getInt("systolic") + " mmHg\n";
                result += "舒張壓：" + rs.getInt("diastolic") + " mmHg\n";
                result += "體溫：" + rs.getDouble("temperature") + " °C\n";
                result += "建立時間：" + rs.getString("created_at") + "\n";
                result += "====================\n";
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            result = "讀取 MySQL 健康紀錄失敗";
        }

        if (result.equals("")) {
            result = "目前沒有健康紀錄";
        }

        return result;
    }

    @Override
    public void update(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature) {

        String sql = "UPDATE health_record SET "
                + "period = ?, "
                + "measure_time = ?, "
                + "systolic = ?, "
                + "diastolic = ?, "
                + "temperature = ? "
                + "ORDER BY id DESC LIMIT 1";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, period);
            ps.setString(2, time);
            ps.setInt(3, Integer.parseInt(systolic));
            ps.setInt(4, Integer.parseInt(diastolic));
            ps.setDouble(5, Double.parseDouble(temperature));

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {

        String sql = "DELETE FROM health_record";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}