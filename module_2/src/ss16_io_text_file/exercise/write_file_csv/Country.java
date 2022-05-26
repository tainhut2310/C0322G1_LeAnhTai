package ss16_io_text_file.exercise.write_file_csv;

public class Country {
    private int id;
    private String acronym;
    private String nameCountry;

    public Country() {
    }

    public Country(int id, String acronym, String nameCountry) {
        this.id = id;
        this.acronym = acronym;
        this.nameCountry = nameCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", acronym='" + acronym + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
