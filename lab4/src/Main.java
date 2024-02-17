import Classes.*;
import Enums.EldersSpecialisation;
import Enums.Place;
import Interfaces.Talker;

public class Main{
    public static void main(String[] args) {
        Talker storytaller = new Talker(){
            @Override
            public void findStoryOnTheBasreliefs(){
                System.out.println(toString() + " нашел надписи на барельефах и начал читать их:");
            }
            @Override
            public void scaredOfTheStoriesOnTheBasreliefs(){
                System.out.println(toString() + " пробрала дрожь от историй на барельефах");
            }
            @Override
            public String toString() {
                return "Рассказчик";
            }
        };
        storytaller.findStoryOnTheBasreliefs();

        Continents continents = new Continents(1);
        continents.bornCont(3);
        Shoggots shoggots = new Shoggots(Place.SeaDepth);
        shoggots.add(new Shoggots.Shoggot(6,30));
        shoggots.add(new Shoggots.Shoggot(6,30));
        Elders elders = new Elders(Place.SeaDepth);
        elders.add(new Elders.Elder("Lalo",EldersSpecialisation.DeafaultElder));
        elders.add(new Elders.Elder("Momo",EldersSpecialisation.DeafaultElder));
        elders.add(new Elders.Elder("Goga",EldersSpecialisation.DeafaultElder));
        elders.add(new Elders.Elder("Fofan",EldersSpecialisation.DeafaultElder));
        elders.add(new Elders.Elder("Duran",EldersSpecialisation.DeafaultElder));
        elders.add(new Elders.Elder("Baran",EldersSpecialisation.DeafaultElder));
        Shoggots shogots = new Shoggots(Place.Land);
        shogots.add(new Shoggots.Shoggot(2,30));
        shogots.add(new Shoggots.Shoggot(4,30));
        shogots.add(new Shoggots.Shoggot(6,30));
        shogots.add(new Shoggots.Shoggot(6,30));
        shogots.add(new Shoggots.Shoggot(6,30));
        shogots.add(new Shoggots.Shoggot(6,30));
        try {
            shoggots.setBrawl(true);
            elders.gypnonse(shoggots);
            elders.checkReasonsForSetPlace(continents, shoggots);
            elders.setPlace(Place.Land);
            elders.lostSecret();
            BigReptiles bigReptiles = new BigReptiles();
            elders.checkDangerFromReptiles(bigReptiles);
            elders.add(new Elders.Elder("Alex", EldersSpecialisation.Shaman));
            elders.gypnonse(shogots);
            elders.addTentaclesForShoggot(shogots, 5);
            elders.addTentaclesForShoggot(shogots, 5);
            elders.addTentaclesForShoggot(shogots, 5);
            shogots.addTentaclesForGroup(3);
            elders.gypnonse(shogots);
        }catch (GroupSize0Exception e){
            System.out.println("Проверьте численность общин Шогготов и Старцев, как минимум у одной общины численность = 0");
        }
        try {
            shogots.changeBodyFormForRandomShoggots();
            elders.startWar(shogots);
            storytaller.scaredOfTheStoriesOnTheBasreliefs();
        }catch (VolitionalImpulsIsFalseException e){
            System.out.println("У шоготов не выработался волевой импульс");
        }
    }
}