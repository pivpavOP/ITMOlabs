package Interfaces;

import Classes.Elder;
import Enums.EldersSpecialisation;

public interface EldersList {
    Elder getIndex(int index);
    boolean search(EldersSpecialisation eldersSpecialisation);
    void remove(EldersSpecialisation eldersSpecialisation);
    boolean removeInd(int index);
}
