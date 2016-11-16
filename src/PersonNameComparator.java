import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        return first.getName().compareTo(second.getName());
    }

}