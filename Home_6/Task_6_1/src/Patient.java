public class Patient {
    private boolean wearMask;
    private boolean remoteWork;
    private Vaccine vaccinated; //обновил это поле (раньше было стринг)
    private boolean hadCoronavirus;
    private String patientName;

    public Patient(boolean wearMask, boolean remoteWork, Vaccine vaccinated, boolean hadCoronavirus, String patientName) {
        this.wearMask = wearMask;
        this.remoteWork = remoteWork;
        this.vaccinated = vaccinated;
        this.hadCoronavirus = hadCoronavirus;
        this.patientName = patientName;
    }

    public boolean isWearMask() {
        return wearMask;
    }

    public boolean isRemoteWork() {
        return remoteWork;
    }

    public Vaccine getVaccinated() {
        return vaccinated;
    }

    public boolean isHadCoronavirus() {
        return hadCoronavirus;
    }

    public String getPatientName() {
        return patientName;
    }
}
