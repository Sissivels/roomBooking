package tablas;

public class Mitarbeiter {
    Integer mitarbeiter_id;
    String  mitarbeiter_name;
    String mitarbeiter_vorname;

    public Mitarbeiter(Integer mitarbeiter_id, String mitarbeiter_name, String mitarbeiter_vorname) {
        this.mitarbeiter_id = mitarbeiter_id;
        this.mitarbeiter_name = mitarbeiter_name;
        this.mitarbeiter_vorname = mitarbeiter_vorname;
    }

    public Integer getMitarbeiter_id() {
        return mitarbeiter_id;
    }

    public void setMitarbeiter_id(Integer mitarbeiter_id) {
        this.mitarbeiter_id = mitarbeiter_id;
    }

    public String getMitarbeiter_name() {
        return mitarbeiter_name;
    }

    public void setMitarbeiter_name(String mitarbeiter_name) {
        this.mitarbeiter_name = mitarbeiter_name;
    }

    public String getMitarbeiter_vorname() {
        return mitarbeiter_vorname;
    }

    public void setMitarbeiter_vorname(String mitarbeiter_vorname) {
        this.mitarbeiter_vorname = mitarbeiter_vorname;
    }
}
