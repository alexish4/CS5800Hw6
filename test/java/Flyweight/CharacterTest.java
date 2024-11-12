package Flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private CharacterPropertiesFactory characterPropertiesFactory;

    @BeforeEach
    void setUp() {
        characterPropertiesFactory = new CharacterPropertiesFactory();
    }

    @Test
    void printSymbolAndProperties() {
        CharacterProperties properties = characterPropertiesFactory
                .getCharacterProperties("Calibre", 16, "Red");

        Character character = new Character('C', properties);

        String expected = "C { Font: Calibre, Size: 16, Color: Red }";
        String actual = character.printSymbolAndProperties();

        assertEquals(expected, actual);
    }
}