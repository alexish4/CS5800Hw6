import Flyweight.CharacterPropertiesFactory;
import Flyweight.Document;

import java.io.IOException;

public class FlyweightDriver {
    public static void main(String[] args) {
        flyWeightDriver();
    }

    public static void flyWeightDriver() {
        System.out.println("Flyweight Document Driver\n");

        CharacterPropertiesFactory characterPropertiesFactory = new CharacterPropertiesFactory();

        Document document = new Document();

        document.addCharacter('H', "Arial", 16, "Black", characterPropertiesFactory);
        document.addCharacter('e', "Arial", 16, "Black", characterPropertiesFactory);
        document.addCharacter('l', "Arial", 16, "Black", characterPropertiesFactory);
        document.addCharacter('l', "Arial", 16, "Black", characterPropertiesFactory);
        document.addCharacter('o', "Arial", 16, "Black", characterPropertiesFactory);

        document.addCharacter('W', "Calibre", 16, "Blue", characterPropertiesFactory);
        document.addCharacter('o', "Calibre", 16, "Blue", characterPropertiesFactory);
        document.addCharacter('r', "Calibre", 16, "Blue", characterPropertiesFactory);
        document.addCharacter('l', "Calibre", 16, "Blue", characterPropertiesFactory);
        document.addCharacter('d', "Calibre", 16, "Blue", characterPropertiesFactory);

        document.addCharacter('C', "Verdana", 14, "Blue", characterPropertiesFactory);
        document.addCharacter('S', "Verdana", 14, "Blue", characterPropertiesFactory);

        document.addCharacter('5', "Times New Roman", 12, "Red", characterPropertiesFactory);
        document.addCharacter('8', "Times New Roman", 12, "Red", characterPropertiesFactory);
        document.addCharacter('0', "Times New Roman", 12, "Red", characterPropertiesFactory);
        document.addCharacter('0', "Times New Roman", 12, "Red", characterPropertiesFactory);

        try {
            document.saveToFile("document.txt");
            System.out.println("Document saved successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Document loadedDocument = new Document();
        try {
            loadedDocument.loadFromFile("document.txt", characterPropertiesFactory);
            System.out.println("Loaded Document: \n");
            loadedDocument.displayCharacters();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
