import java.util.*;

public class Person implements Comparable<Person> {

    private final String name;
    private final Date birthday;
    private final int passport;

    public Person(String name, Date birthday, int passport) {
        this.name = name;
        this.birthday = (Date) birthday.clone();
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return (Date) birthday.clone();
    }

    public int getPassport() {
        return passport;
    }

    public int calculateAge() {
        Calendar dateBirthday = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dateBirthday.setTime(this.birthday);
        dateBirthday.add(Calendar.DAY_OF_MONTH, -1);
        int age = today.get(Calendar.YEAR) - dateBirthday.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dateBirthday.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    @Override
    public int compareTo(Person second) {
        if (this.equals(second)) {
            return 0;
        }
        int comparableValue = calculateAge() - second.calculateAge();
        if (comparableValue == 0) {
            comparableValue = passport - second.passport;
        }
        return comparableValue / Math.abs(comparableValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (passport != person.passport) return false;
        if (!name.equals(person.name)) return false;
        return birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + passport;
        return result;
    }

    @Override
    public String toString() {
        return "Name=" + name + ", birthday=" + birthday + ", passport=" + passport;
    }
}