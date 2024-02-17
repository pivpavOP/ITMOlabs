package Enums;

public enum ShoggotBodyShape {
    LikeBall("Форма шара"), Standart("Стандартная форма тела");
    private String translation;

    ShoggotBodyShape(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
