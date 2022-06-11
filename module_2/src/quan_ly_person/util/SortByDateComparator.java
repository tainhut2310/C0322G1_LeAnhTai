package quan_ly_person.util;

import quan_ly_person.model.Person;

import java.util.Comparator;

public class SortByDateComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getBirthday().compareTo(o2.getBirthday()) > 0) {
            return 1;
        } else if (o1.getBirthday().compareTo(o2.getBirthday()) < 0) {
            return -1;
        } else {
            if(o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
