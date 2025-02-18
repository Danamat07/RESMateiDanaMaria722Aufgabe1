import java.time.LocalDate;
import java.util.*;

public class Ninja {

        private final int id;
        private final String characterName;
        private final String stufe;
        private final String beschreibung;
        private final String datum;
        private final float kraftpunkte;

    public Ninja(int id, String characterName, String stufe, String beschreibung, String datum, float kraftpunkte) {
        this.id = id;
        this.characterName = characterName;
        this.stufe = stufe;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.kraftpunkte = kraftpunkte;
    }

    public int getId() {
        return id;
    }

    public float getKraftpunkte() {
        return kraftpunkte;
    }

    public String getDatum() {
        return datum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getStufe() {
        return stufe;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", stufe='" + stufe + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", datum=" + datum +
                ", kraftpunkte=" + kraftpunkte +
                '}';
    }
}
