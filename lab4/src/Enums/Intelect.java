package Enums;

public enum Intelect {
    LOW("низкий интелект"), NORMAL("средний интелект"), HIGH("высокий интелект");
    private String translate;

    Intelect(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
