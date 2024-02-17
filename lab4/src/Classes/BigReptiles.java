package Classes;

import java.util.Objects;

public class BigReptiles extends Alive {

    private boolean danger;

    public BigReptiles() {
        super(null);
        this.danger = false;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    public boolean isDanger() {
        return danger;
    }

    @Override
    public String toString() {
        return "Большие рептилии";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            BigReptiles bigReptiles = (BigReptiles) obj;
            return (Objects.equals(name, bigReptiles.name) && Objects.equals(danger, bigReptiles.danger));
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
