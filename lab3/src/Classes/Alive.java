package Classes;

import java.util.Objects;

public abstract class Alive {
    protected String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Живое существо " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Alive alive = (Alive) obj;
            return Objects.equals(name, alive.name);
        }
    }

    protected void a() {

    };

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
