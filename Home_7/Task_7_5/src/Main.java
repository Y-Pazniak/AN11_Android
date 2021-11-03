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
            boolean haveCovid = coviRoulette.covidTest(patient);
            int antibodiesCount = coviRoulette.countAntibodies(patient);
            //я сделал три аргумента и вынес результат теста и к-во антител в отдельные переменные, потому что высокая вероятность, что в программе результаты тестов пациентов будут использоваться где-то еще
            //если мы будем передавать аргументом тест, то во время составления письма будут генериться новые данные - это может внести путаницу
            System.out.println(Util.createMessage(patient, haveCovid, antibodiesCount));
        }
    }
}
