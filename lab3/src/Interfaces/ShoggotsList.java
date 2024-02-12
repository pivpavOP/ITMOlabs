package Interfaces;

import Classes.Shoggot;

public interface ShoggotsList {
    void add(Shoggot shoggot);
    boolean removeInd(int index);
    Shoggot getIndex(int index);
}
