public class Main {
    public static void main(String[] args) {
        Patient paranoid = new Patient(true, true, Vaccine.PFIZER, false, "paranoid");
        Patient normal = new Patient(true, false, null, true, "normal");
        Patient doctor = new Patient(true, false, Vaccine.JANNSEN, true, "doctor");
        Patient reckless = new Patient(false, false, null, true, "reckless");
        Patient luckyBastard = new Patient(false, false, null, false, "luckyBastard");
        Patient[] patients = {paranoid, normal, doctor, reckless, luckyBastard};

        CovidTest coviRoulette = new CovidTest();

        for (Patient patient : patients) {
            System.out.println(coviRoulette.covidTest(patient) ? patient.getPatientName() + " - patient is infected" : patient.getPatientName() + " - patient is NOT infected");
            System.out.println(patient.getPatientName() + " have antibodies count: " + coviRoulette.countAntibodies(patient));
            System.out.println((patient.getVaccinated() == null) ? "No vaccine" : "Current vaccine: " + patient.getVaccinated().getName()); //добавил эту строку для красоты и проверки работы
            System.out.println("*****");
        }
    }
}
