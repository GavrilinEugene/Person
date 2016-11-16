import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testGetName() {
        Person person = new Person("Evgenii", createDate(1993, 7, 26), 156455605);
        assertEquals("Evgenii", person.getName());
    }

    @Test
    public void testGetBirthday() {
        Person person = new Person("Evgenii", createDate(1993, 7, 26), 156455605);
        assertEquals(createDate(1993, 7, 26).toString(), person.getBirthday().toString());
    }

    @Test
    public void testGetPassport() {
        Person person = new Person("Evgenii", createDate(1993, 7, 26), 156455605);
        assertEquals(156455605, person.getPassport());
    }

    @Test
    public void testCalculateAge() {
        Person person = new Person("Evgenii", createDate(1993, 7, 26), 156455605);
        // after 2017/7/26 it won't pass...
        assertEquals(23, person.calculateAge());
    }

    @Test
    public void testCompareTo() {
        Person person = new Person("Evgenii", createDate(1993, 7, 26), 156455605);
        Person another = new Person("Alex", createDate(1992, 8, 21), 17624602);
        int res = person.compareTo(another);
        assertEquals(-1, res);

        person = new Person("Alexey", createDate(1988, 4, 12), 17624602);
        another = new Person("Victor", createDate(1990, 6, 23), 156455605);
        res = person.compareTo(another);
        assertEquals(1, res);
    }

    private static Date createDate(int year, int month, int day) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
}
