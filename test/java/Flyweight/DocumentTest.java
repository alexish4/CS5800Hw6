package Flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {
    private Document document;
    private CharacterPropertiesFactory characterPropertiesFactory;

    @BeforeEach
    void setUp() {
        document = new Document();
        characterPropertiesFactory = new CharacterPropertiesFactory();
    }

    @Test
    void addCharacter() {
        document.addCharacter('A', "Calibre", 12, "Blue", characterPropertiesFactory);
        assertEquals(1, document.getCharacters().size());

        Character character = document.getCharacters().get(0);
        assertEquals('A', character.getSymbol());
        assertEquals("Calibre", character.getProperties().getFont());
        assertEquals(12, character.getProperties().getFontSize());
        assertEquals("Blue", character.getProperties().getFontColor());
    }

    @Test
    void saveToFile() throws IOException {
        document.addCharacter('A', "Calibre", 12, "Blue", characterPropertiesFactory);
        document.addCharacter('B', "Arial", 12, "Red", characterPropertiesFactory);

        File file = File.createTempFile("Flyweight", ".txt");
        file.deleteOnExit();

        document.saveToFile(file.getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line1 = br.readLine();
            assertTrue(line1.contains("Calibre"));

            String line2 = br.readLine();
            assertTrue(line2.contains("Arial"));
        }
    }

    @Test
    void loadFromFile() throws IOException {
        File file = File.createTempFile("Flyweight", ".txt");
        file.deleteOnExit();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("H|Arial|16|Black\n");
            bw.write("e|Arial|16|Black\n");
        }

        document.loadFromFile(file.getAbsolutePath(), characterPropertiesFactory);

        assertEquals(2, document.getCharacters().size());
        assertEquals('H', document.getCharacters().get(0).getSymbol());
        assertEquals("Arial", document.getCharacters().get(0).getProperties().getFont());
        assertEquals('e', document.getCharacters().get(1).getSymbol());
        assertEquals("Arial", document.getCharacters().get(1).getProperties().getFont());
    }

    @Test
    void displayCharacters() {
        document.addCharacter('A', "Calibre", 12, "Blue", characterPropertiesFactory);
        document.addCharacter('B', "Arial", 12, "Red", characterPropertiesFactory);

        String expected = "A { Font: Calibre, Size: 12, Color: Blue }\n" +
                "B { Font: Arial, Size: 12, Color: Red }\n";
        String actual = document.displayCharacters();

        assertEquals(expected, actual);
    }
}