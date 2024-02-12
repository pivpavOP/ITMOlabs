package Classes;

import Enums.Intelect;
import Enums.Place;
import Interfaces.ShoggotsList;

import java.util.Arrays;
import java.util.Objects;

public class Shoggots implements ShoggotsList {
    private Shoggot[] array = new Shoggot[10];
    private int size;
    private boolean brawl;
    private Intelect groupIq;
    private Place place;
    protected int memoryAboutShamanSkills;

    public Shoggots(Place place) {
        this.place = place;
        brawl = false;
        groupIq = Intelect.LOW;
        size = 0;
        memoryAboutShamanSkills = 0;
    }

    @Override
    public Shoggot getIndex(int index) {
        return array[index];
    }


    @Override
    public void add(Shoggot shoggot) {
        if (size >= array.length) {
            //array = Arrays.copyOf(array, array.length * 2);
            Shoggot[] newarray = new Shoggot[array.length * 2];
            for(int i = 0;i < size;i++){
                newarray[i] = array[i];
            }
            array = newarray;
        }
        array[size] = shoggot;
        if (size > 1 && size < 5) {
            groupIq = Intelect.NORMAL;
        } else if (size >= 5) {
            groupIq = Intelect.HIGH;
            System.out.println(toString() + " путем размножения делением получили " + groupIq.getTranslate());
            setBrawl(true);
        }
        size++;
    }

    @Override
    public boolean removeInd(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public void setBrawl(boolean brawl) {
        this.brawl = brawl;
        if (brawl) {
            System.out.println("Шогготы разбушевались");
        } else {
            System.out.println("Шогготы спокойны");
        }
    }

    public boolean getBrawl() {
        return brawl;
    }

    public Shoggot searchWeakShoggotInGroup() {
        int index = 0;
        int mintentacles = 1000000000;
        for (int i = 0; i < size; i++) {
            if (array[i].getTentacles() < mintentacles) {
                index = i;
                mintentacles = array[i].getTentacles();
            }
        }
        return getIndex(index);
    }

    public void addTentaclesForGroup(int countTentacles) {
        if (memoryAboutShamanSkills >= 3) {
            searchWeakShoggotInGroup().addTentacles(countTentacles);
            System.out.println(toString() + " нарастили дополнительные щупальца ");
        } else {
            System.out.println(toString() + " не смогли нарастить дополнительные щупальца ");
        }
    }

    public boolean volitionalImpuls() {
        if (groupIq == Intelect.HIGH && memoryAboutShamanSkills >= 3) {
            System.out.println(toString() + " получили волевой импульс и не слушаются");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Шогготы";
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, brawl, groupIq, place, memoryAboutShamanSkills);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            try {
                for (int i = 0; i < size; i++) {
                    if (!(getIndex(i).equals(((Shoggots) obj).getIndex(i)))) {
                        return false;
                    }
                }
                return true;
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
    }
}
