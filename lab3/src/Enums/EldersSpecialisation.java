package Enums;

public enum EldersSpecialisation {
    Shaman("Шаман"),DeafaultElder("Обычный старец");
    private String translation;
    EldersSpecialisation(String translation){
        this.translation = translation;
    }
}
