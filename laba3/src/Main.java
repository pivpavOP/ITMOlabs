public class Main{
    public static void main(String[] args) {
        NewContinents newContinents = new NewContinents();
        newContinents.bornCont(3);
        Shoggots shoggots = new Shoggots(Place.SeaDepth);
        shoggots.setBrawl(true);
        Elders elders = new Elders(Place.SeaDepth);
        elders.gypnonse(shoggots);
        elders.checkReasonsForSetPlace(newContinents,shoggots);
        elders.setPlace(Place.Land);
        elders.lostSecret();
        BigReptiles bigReptiles = new BigReptiles("Крокодилы");
        elders.checkDangerFromReptiles(bigReptiles);
        Shoggots shogots = new Shoggots(Place.Land);
        shogots.add(new Shoggot("1",2));
        shogots.add(new Shoggot("2",4));
        shogots.add(new Shoggot("3",6));
        shogots.add(new Shoggot("4",6));
        shogots.add(new Shoggot("5",6));
        shogots.add(new Shoggot("6",6));
        elders.add(new Elder("Alex",EldersSpecialisation.Shaman));
        elders.gypnonse(shogots);
        elders.addTentaclesForShoggot(shogots,5);
        elders.addTentaclesForShoggot(shogots,5);
        elders.addTentaclesForShoggot(shogots,5);
        shogots.addTentaclesForGroup(3);
        elders.gypnonse(shogots);

    }
}