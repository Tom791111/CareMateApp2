package service;

public interface HealthService {

    void createHealth(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature);

    String readHealth();

    void updateHealth(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature);

    void deleteHealth();
}