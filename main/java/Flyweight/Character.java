package Flyweight;

public class Character {
    private final char symbol;
    private final CharacterProperties properties;

    public Character(char symbol, CharacterProperties properties) {
        this.symbol = symbol;
        this.properties = properties;
    }

    public String printSymbolAndProperties() {
        StringBuilder sb = new StringBuilder();

        sb.append(symbol).append(" { ").append(properties.displayProperties()).append(" }");

        System.out.println(sb.toString());

        return sb.toString();
    }

    public char getSymbol() {
        return symbol;
    }

    public CharacterProperties getProperties() {
        return properties;
    }
}
