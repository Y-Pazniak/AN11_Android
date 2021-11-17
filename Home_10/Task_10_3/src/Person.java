public class Person {
    private String name;

    public Person(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name == null ? 1 : (name.hashCode() * 31); //я сделал *31, чтобы хэшкод person не совпадал хэшкоду String с аналогичным именем (не знаю, правильно ли это)
        //например String johnS = new String("John");
        //и Person johnP = new Person("John"); - чтобы не был одинаковый хэшкод
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return person.getName().equals(name);
    }
}
