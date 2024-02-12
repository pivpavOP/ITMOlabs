package Classes;

import Enums.EldersSpecialisation;
import Enums.Place;
import Interfaces.EldersList;

import java.util.Arrays;
import java.util.Objects;

public class Elders implements EldersList {
    private Elder[] array = new Elder[10];
    private int size;
    private int reasonsForSetPlace;
    private Place place;
    private boolean secretAboutMakeLifeFromOfUnlimitedMatter;

    public Elders(Place place) {
        this.place = place;
        secretAboutMakeLifeFromOfUnlimitedMatter = true;
        size = 0;
    }

    @Override
    public Elder getIndex(int index) {
        if (index < array.length && index >= 0) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean search(EldersSpecialisation eldersSpecialisation) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEldersSpecialisation().equals(eldersSpecialisation)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeInd(int index) {
        if (index < array.length && index >= 0) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void remove(EldersSpecialisation eldersSpecialisation) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEldersSpecialisation().equals(eldersSpecialisation)) {
                removeInd(i);
            }
        }

    }

    public void add(Elder elder) {
        if (size >= array.length) {
            //array = Arrays.copyOf(array, array.length * 2);
            Elder[] newarray = new Elder[array.length * 2];
            for(int i = 0; i < size;i++){
                newarray[i] = array[i];
            }
            array = newarray;
        }
        array[size] = elder;
        size++;
    }


    public void checkReasonsForSetPlace(Continents continents, Shoggots shoggots) {
        if (continents.getCount() > 1 && shoggots.getBrawl()) {
            reasonsForSetPlace = 2;
        } else if ((continents.getCount() == 0 && !shoggots.getBrawl())) {
            reasonsForSetPlace = 0;
        } else {
            reasonsForSetPlace = 1;
        }
    }

    public void setPlace(Place place) {
        if (reasonsForSetPlace > 1) {
            Place oldPlace = this.place;
            this.place = place;
            reasonsForSetPlace = 0;
            System.out.println(toString() + " пересилились из " + oldPlace.getTranslation() + " на " + place.getTranslation());
        } else if (reasonsForSetPlace == 1) {
            System.out.println("причин для переселения недостаточно");
        } else {
            System.out.println("причин для переселения нет");
        }
    }

    public void lostSecret() {
        secretAboutMakeLifeFromOfUnlimitedMatter = false;
        System.out.println("Секрет по созданию жизни из неограниченной материи был утрачен");
    }

    public void gypnonse(Shoggots shoggots) {
        if (!shoggots.volitionalImpuls()) {
            if (search(EldersSpecialisation.Shaman)) {
                if (shoggots.getBrawl()) {
                    System.out.println(toString() + " загипнотизировали " + shoggots.toString());
                    shoggots.setBrawl(false);
                } else {
                    System.out.println(toString() + " загипнотизировали " + shoggots.toString());
                }
            } else {
                System.out.println("Старцы не могли усмерить шогготов");
            }
        }
    }

    public void addTentaclesForShoggot(Shoggots shoggots, int countTentacles) {
        if (search(EldersSpecialisation.Shaman)) {
            shoggots.searchWeakShoggotInGroup().addTentacles(countTentacles);
            shoggots.memoryAboutShamanSkills += 1;
            System.out.println(toString() + " нарастили дополнительные щупальца " + shoggots.toString());
        } else {
            System.out.println(toString() + " не смогли нарастить дополнительные щупальца " + shoggots.toString());
        }
    }

    public void checkDangerFromReptiles(BigReptiles bigReptiles) {
        if (bigReptiles.isDanger()) {
            System.out.println(bigReptiles.toString() + " создавали проблемы ");
        } else {
            System.out.println(bigReptiles.toString() + " не создавали проблем ");
        }
    }

    @Override
    public String toString() {
        return "Старцы";
    }

    @Override
    public int hashCode() {
        return (Objects.hash(size, place, secretAboutMakeLifeFromOfUnlimitedMatter, reasonsForSetPlace));
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
                    if (!(getIndex(i).equals(((Elders) obj).getIndex(i)))) {
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
