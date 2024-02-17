package Classes;

import Enums.EldersSpecialisation;
import Enums.Place;
import Interfaces.EldersList;

import java.util.Objects;
import java.util.Random;

public class Elders implements EldersList {
    private Elder[] array = new Elder[10];
    private Magic magic = new Magic();
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
            for (int i = 0; i < size; i++) {
                newarray[i] = array[i];
            }
            array = newarray;
        }
        array[size] = elder;
        size++;
    }


    public void checkReasonsForSetPlace(Continents continents, Shoggots shoggots) {
        checkGroupFor0Size();
        if (continents.getCount() > 1 && shoggots.getBrawl()) {
            reasonsForSetPlace = 2;
        } else if ((continents.getCount() == 0 && !shoggots.getBrawl())) {
            reasonsForSetPlace = 0;
        } else {
            reasonsForSetPlace = 1;
        }
    }

    public void setPlace(Place place) {
        if (reasonsForSetPlace == 2) {
            Place oldPlace = this.place;
            this.place = place;
            reasonsForSetPlace = 0;
            System.out.println(toString() + " пересилились из " + oldPlace.getTranslation() + " на " + place.getTranslation());
        } else {
            System.out.println("причин для переселения недостаточно");
        }
    }

    public void lostSecret() {
        secretAboutMakeLifeFromOfUnlimitedMatter = false;
        System.out.println("Секрет по созданию жизни из неограниченной материи был утрачен");
    }

    public void gypnonse(Shoggots shoggots) {
        checkGroupFor0Size();
        magic.gypnonse(shoggots);
    }


    public void addTentaclesForShoggot(Shoggots shoggots, int countTentacles) {
        checkGroupFor0Size();
        magic.addTentaclesForShoggot(shoggots, countTentacles);
    }

    public void checkDangerFromReptiles(BigReptiles bigReptiles) {
        checkGroupFor0Size();
        if (bigReptiles.isDanger()) {
            System.out.println(bigReptiles.toString() + " создавали проблемы ");
        } else {
            System.out.println(bigReptiles.toString() + " не создавали проблем ");
        }
    }

    public void startWar(Shoggots shoggots) throws VolitionalImpulsIsFalseException {
        checkGroupFor0Size();
        if (shoggots.volitionalImpuls()) {
            class War {
                public void startWar(Elders elders, Shoggots shoggots) {
                    Random random = new Random();
                    System.out.println("Началась война");
                    for (int i = 0; true; i++) {
                        if (size == 0 || !(elders.search(EldersSpecialisation.Shaman))) {
                            System.out.println(elders.toString() + " проиграли войну " + shoggots.toString());
                            break;
                        } else if (shoggots.getSize() == 0) {
                            System.out.println(shoggots.toString() + " проиграли войну " + elders.toString());
                            break;
                        } else {
                            int target;
                            if (i % 2 == 0) {
                                target = random.nextInt(shoggots.getSize());
                                System.out.println(shoggots.getIndex(target).toString() + " был убит " + elders.toString());
                                shoggots.removeInd(target);
                            } else {
                                target = random.nextInt(size);
                                System.out.println(elders.getIndex(target).toString() + " был убит " + shoggots.toString());
                                removeInd(target);
                            }
                        }
                    }
                }
            }
            War war = new War();
            war.startWar(this, shoggots);
            return;
        }
        throw new VolitionalImpulsIsFalseException(shoggots.toString() + " не выработали волевой импульс, причины для войны нет");
    }

    private void checkGroupFor0Size() {
        if (size == 0) {
            throw new GroupSize0Exception("Община " + toString() + " пустая");
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

    public static class Elder extends Alive {
        private EldersSpecialisation eldersSpecialisation;

        public Elder(String name, EldersSpecialisation eldersSpecialisation) {
            super(name);
            this.eldersSpecialisation = eldersSpecialisation;
        }

        @Override
        public String getName() {
            return super.getName();
        }

        @Override
        public String toString() {
            return name + " " + eldersSpecialisation.getTranslation();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                return false;
            } else {
                Elders.Elder elder = (Classes.Elders.Elder) obj;
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

    private class Magic {

        public void gypnonse(Shoggots shoggots) {
            if ((!shoggots.volitionalImpuls()) && search(EldersSpecialisation.Shaman)) {
                if (shoggots.getBrawl()) {
                    shoggots.setBrawl(false);
                }
                System.out.println(new Elders(place).toString() + " загипнотизировали " + shoggots.toString());
            }
            System.out.println(new Elders(place).toString() + " не могли усмерить шогготов");
        }

        public void addTentaclesForShoggot(Shoggots shoggots, int countTentacles) {
            if (search(EldersSpecialisation.Shaman)) {
                Shoggots.Shoggot weak = shoggots.searchWeakShoggotInGroup();
                weak.addTentacles(countTentacles);
                if (!(secretAboutMakeLifeFromOfUnlimitedMatter)) {
                    weak.setWeight(weak.getWeight() - (5 * countTentacles));
                }
                shoggots.memoryAboutShamanSkills += 1;
                System.out.println(new Elders(place).toString() + " нарастили дополнительные щупальца " + shoggots.toString());
            } else {
                System.out.println(new Elders(place).toString() + " не смогли нарастить дополнительные щупальца " + shoggots.toString());
            }
        }
    }
}
