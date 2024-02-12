package Classes;

import java.util.Objects;

public class Shoggot extends Alive {

    private int tentacles;

    public Shoggot(String name, int tentacles) {
        this.tentacles = tentacles;
        this.name = name;
    }

    public int getTentacles() {
        return tentacles;
    }

    public void addTentacles(int tentacles) {
        this.tentacles += tentacles;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Шоггот";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Shoggot shoggot = (Shoggot) obj;
            return (Objects.equals(name, shoggot.name) && Objects.equals(tentacles, shoggot.tentacles));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tentacles);
    }
}
