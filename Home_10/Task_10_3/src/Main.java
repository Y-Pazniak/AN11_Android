import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(); //а) Создать динамический массив (ArrayList), содержащий объекты класса Person
        fillPersons(persons, "Sarah Connor", "lieutenant Ripley", "Beatrix the Bride", "princess Leia");
        printPersons(persons); //б) Распечатать его содержимое используя foreach.
        changePersonName(persons, 1, "Lara Croft"); //в) Изменить имя второго Person.
        printPersons(persons);
        System.out.println(containsPerson(persons, new Person("Mia Wallace"))); //г) Создать нового Person и проверить есть ли такой Person в коллекции
        System.out.println(containsPerson(persons, persons.get(2))); //г) Создать нового Person и проверить есть ли такой Person в коллекции
        deleteLastPerson(persons); //д) Удалить последний Person.
        printPersons(persons);
        deleteAllPersons(persons); //е) Удалить все ящики.
        printPersons(persons);
    }

    public static void fillPersons(ArrayList<Person> persons, String... names) {
        if ((persons != null) && (names != null)) {
            for (String name : names) {
                if (!name.isEmpty()) {
                    persons.add(new Person(name));
                } else {
                    System.out.println("Name is empty");
                }
            }
        } else {
            System.out.println("Persons and names can not be null");
        }
    }

    public static void printPersons(final ArrayList<Person> persons) {
        if ((persons != null) && (!persons.isEmpty())) {
            for (Person person : persons) {
                System.out.println(person.getName());
            }
            System.out.println("*****");
        } else {
            System.out.println("Persons is empty or null");
        }
    }

    public static void changePersonName(final ArrayList<Person> persons, final int i, final String name) {
        if ((persons != null) && (name != null) && (!name.isEmpty())) {
            if (i < persons.size()) {
                Person temp = persons.get(i);
                temp.setName(name);
            } else {
                System.out.println("Too big integer, use less " + (persons.size()));
            }
        } else {
            System.out.println("Wrong name or list is null");
        }
    }

    private static boolean containsPerson(final ArrayList<Person> persons, final Person person) {
        if ((persons != null) && (person != null)) {
            return persons.contains(person);
        } else {
            System.out.println("Wrong person or list");
            return false;
        }
    }

    public static void deleteLastPerson(final ArrayList<Person> persons) {
        if ((persons != null) && (!persons.isEmpty())) {
            persons.remove(persons.size() - 1);
        }
    }

    private static void deleteAllPersons(final ArrayList<Person> persons) {
        if ((persons != null) && (!persons.isEmpty())) {
            persons.removeAll(persons);
        }
    }
}
