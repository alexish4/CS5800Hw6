package Flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertiesFactoryTest {
    private CharacterPropertiesFactory characterPropertiesFactory;

    @BeforeEach
    void setUp() {
        characterPropertiesFactory = new CharacterPropertiesFactory();
    }

    @Test
    void getCharacterProperties() {
        CharacterProperties properties1 = characterPropertiesFactory.
                getCharacterProperties("Arial", 12, "Red");
        CharacterProperties properties2 = characterPropertiesFactory
                .getCharacterProperties("Arial", 12, "Red");

        assertSame(properties1, properties2);

        CharacterProperties properties3 = characterPropertiesFactory
                .getCharacterProperties("Times New Roman", 12, "Red");

        assertNotSame(properties1, properties3);
    }
}