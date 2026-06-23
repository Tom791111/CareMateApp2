package service.impl;

import dao.HealthDao;
import dao.impl.HealthDaoImpl;
import service.HealthService;

public class HealthServiceImpl implements HealthService {

    private HealthDao healthDao = new HealthDaoImpl();

    @Override
    public void createHealth(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature) {

        healthDao.create(
                period,
                time,
                systolic,
                diastolic,
                temperature
        );
    }

    @Override
    public String readHealth() {
        return healthDao.read();
    }

    @Override
    public void updateHealth(
            String period,
            String time,
            String systolic,
            String diastolic,
            String temperature) {

        healthDao.update(
                period,
                time,
                systolic,
                diastolic,
                temperature
        );
    }

    @Override
    public void deleteHealth() {
        healthDao.delete();
    }
}