package Flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> characters = new ArrayList<>();

    public List<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(char symbol, String font, int fontSize, String fontColor, CharacterPropertiesFactory factory) {
        CharacterProperties characterProperties = factory.getCharacterProperties(font, fontSize, fontColor);
        Character character = new Character(symbol, characterProperties);
        characters.add(character);
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write(character.getSymbol() + "|" + character.getProperties().getFont() + "|"
                        + character.getProperties().getFontSize() + "|" + character.getProperties().getFontColor());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filename, CharacterPropertiesFactory factory) throws IOException {
        characters.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                char symbol = split[0].charAt(0);
                String font = split[1];
                int fontSize = Integer.parseInt(split[2]);
                String fontColor = split[3];
                addCharacter(symbol, font, fontSize, fontColor, factory);
            }
        }
    }

    public String displayCharacters() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Character character : characters) {
            stringBuilder.append(character.printSymbolAndProperties()).append("\n");
        }
        return stringBuilder.toString();
    }
}
