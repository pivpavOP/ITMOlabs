package Interfaces;

import Classes.Elders.Elder;
import Classes.Elders;
import Enums.EldersSpecialisation;

public interface EldersList {
    Elders.Elder getIndex(int index);

    boolean search(EldersSpecialisation eldersSpecialisation);

    void remove(EldersSpecialisation eldersSpecialisation);

    boolean removeInd(int index);
}
