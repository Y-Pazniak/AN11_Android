public enum Vaccine { //я добавил этот енам-класс
    PFIZER ("Pfizer"),
    JANNSEN("Johnson & Johnson"),
    MODERNA("Moderna"),
    ASTRAZENECA ("AstraZeneca");

    private String name;
    Vaccine(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
