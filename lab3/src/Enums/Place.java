package Enums;

public enum Place {
    SeaDepth("глубины моря"), Land("Суша");
    private String translation;
    Place(String translation){this.translation = translation;}
    public String getTranslation(){
        return translation;
    }
}
