package Interfaces;


import Classes.Shoggots;

public interface ShoggotsList {
    void add(Shoggots.Shoggot shoggot);

    boolean removeInd(int index);

    Shoggots.Shoggot getIndex(int index);
}
