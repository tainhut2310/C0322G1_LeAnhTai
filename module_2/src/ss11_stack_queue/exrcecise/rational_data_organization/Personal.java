package ss11_stack_queue.exrcecise.rational_data_organization;

public class Personal implements Comparable<Personal> {
    private int id;
    private String name;
    private boolean gender;
    private int year;

    public Personal() {
    }

    public Personal(int id, String name, boolean gender, int year) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + (isGender() ? "Nam" : "Nữ") +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Personal o) {
        if (this.getYear() > o.getYear()) {
            return 1;
        } else if (this.getYear() < o.getYear()) {
            return -1;
        } else {
            return 1;
        }
    }
}
