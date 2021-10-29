public class CovidTest {
    public boolean covidTest(Patient patient){
        int count = 10;
        int virusThreat = (int)(Math.random()*100);
        if (patient.isWearMask()) count += 20;
        if (patient.isRemoteWork()) count += 20;
        if (patient.isHadCoronavirus()) count += 20;
        if (patient.getVaccinated() != null) count += 20;

        return count < virusThreat;
    }

    public int countAntibodies(Patient patient){
        int count = 0;
        if (patient.isHadCoronavirus()) count += (int)(10 + Math.random()*20);
        if (patient.getVaccinated() != null) count += (int)(20 + Math.random()*60);

        return count;
    }
}
