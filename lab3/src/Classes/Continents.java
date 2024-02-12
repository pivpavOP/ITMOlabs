package Classes;

import java.util.Objects;

public class Continents {
    private int count;

    public Continents(int count){
        this.count = count;
    }
    public void bornCont(int count) {
        this.count += count;
        System.out.println("Рождались новые " + toString());
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "материки";
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            return Objects.equals(count, ((Continents) obj).count);
        }
    }
}
