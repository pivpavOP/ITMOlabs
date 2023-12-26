public class BigReptiles extends Alive {

    private boolean danger;

    public BigReptiles(String name) {
        this.name = name;
        this.danger = false;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    public boolean getDanger() {
        return danger;
    }

    @Override
    public String toString() {
        return "Большие рептилии";
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
