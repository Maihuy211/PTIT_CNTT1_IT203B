package exercise02.presentation;

import exercise02.business.DoctorBusiness;

public class Main {
    public static void main(String[] args) {
        int patientId = 1;
        double temperature = 36.5;
        int heartRate = 80;

        DoctorBusiness.update(patientId, temperature, heartRate);
    }
}
