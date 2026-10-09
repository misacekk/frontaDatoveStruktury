public class Zak {
    private String name;
    private String surname;
    private int cisloChodu;

    public Zak(String name, String surname, int cisloChodu) {
        this.name = name;
        this.surname = surname;
        this.cisloChodu = cisloChodu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCisloChodu() {
        return cisloChodu;
    }

    public void setCisloChodu(int cisloChodu) {
        this.cisloChodu = cisloChodu;
    }

    public String getCeleJmeno() {
        return name + " " + surname;
    }
}