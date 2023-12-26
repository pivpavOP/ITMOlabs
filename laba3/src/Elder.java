import java.util.Objects;

public class Elder extends Alive {
    private EldersSpecialisation eldersSpecialisation;

    public Elder(String name, EldersSpecialisation eldersSpecialisation) {
        this.name = name;
        this.eldersSpecialisation = eldersSpecialisation;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        if (eldersSpecialisation == EldersSpecialisation.DeafaultElder) {
            return "Старец";
        } else {
            return "Старец-Шаман";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Elder elder = (Elder) obj;
            return (Objects.equals(eldersSpecialisation, elder.eldersSpecialisation) && Objects.equals(name, elder.name));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eldersSpecialisation);
    }

    public EldersSpecialisation getEldersSpecialisation() {
        return eldersSpecialisation;
    }
}
