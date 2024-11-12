package Flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertiesTest {
    private CharacterProperties characterProperties;

    @BeforeEach
    void setUp() {
        characterProperties = new CharacterProperties("Arial", 14, "Red");
    }

    @Test
    void setFont() {
        characterProperties.setFont("Calibre");
        assertEquals("Calibre", characterProperties.getFont());
    }

    @Test
    void setFontSize() {
        characterProperties.setFontSize(10);
        assertEquals(10, characterProperties.getFontSize());
    }

    @Test
    void setFontColor() {
        characterProperties.setFontColor("Blue");
        assertEquals("Blue", characterProperties.getFontColor());
    }

    @Test
    void displayProperties() {
        String expected = "Font: Arial, Size: 14, Color: Red";
        String actual = characterProperties.displayProperties();

        assertEquals(expected, actual);
    }
}