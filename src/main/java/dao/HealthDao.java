package dao;

public interface HealthDao {

    void create(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature);

    String read();

    void update(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature);

    void delete();
}