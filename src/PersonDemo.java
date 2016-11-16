import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PersonDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        String[] arrayOfNames = {"Evgenii", "Alex", "Victor", "Elena", "Vlad"};
        Person[] arrayOfPerson = randomData(arrayOfNames);

        System.out.println("Persons:");
        printPersons(arrayOfPerson);

        System.out.println("\nSort by age:");
        Arrays.sort(arrayOfPerson);
        printPersons(arrayOfPerson);

        System.out.println("\nSort by name:");
        Arrays.sort(arrayOfPerson, new PersonNameComparator());
        printPersons(arrayOfPerson);

    }

    private static Person[] randomData(String[] arrayOfNames) {
        Random rnd = ThreadLocalRandom.current();
        Person[] ret = new Person[5];
        for (int i = 0; i < 5; i++) {
            Date date = createDate(1993 + (4 * i / 3), rnd.nextInt(12) + 1, rnd.nextInt(31) + 1);
            int passport = rnd.nextInt(2000000000);
            ret[i] = new Person(arrayOfNames[i], date, passport);
        }
        return ret;
    }

    private static void printPersons(Person[] array) {
        for (Person numberPerson : array) {
            System.out.println(numberPerson.getName() + ". Age = " + numberPerson.calculateAge());
        }
    }

    private static Date createDate(int year, int month, int day) {
        checkDay(day);
        checkMonth(month);
        checkYear(year);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    private static void checkDay(int day) throws IllegalArgumentException {
        if (day > 31 || day < 1) {
            throw new IllegalArgumentException("Invalid day format");
        }
    }

    private static void checkYear(int year) throws IllegalArgumentException {
        if (year > 2016 || year < 1) {
            throw new IllegalArgumentException("Invalid year format");
        }
    }

    private static void checkMonth(int month) throws IllegalArgumentException {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Invalid month format");
        }
    }
}