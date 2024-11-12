package Flyweight;

public class CharacterProperties {
    private String font;
    private int fontSize;
    private String fontColor;

    public CharacterProperties(String font, int fontSize, String fontColor) {
        this.font = font;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String displayProperties() {
        StringBuilder sb = new StringBuilder();

        sb.append("Font: ").append(font).append(", Size: ").append(fontSize)
                .append(", Color: ").append(fontColor);

        return sb.toString();
    }
}
