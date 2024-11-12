package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private final Map<String, CharacterProperties> characterPropertiesMap = new HashMap<>();

    public CharacterProperties getCharacterProperties(String font, int fontSize, String fontColor) {
        String key = font + fontSize + fontColor;

        if(!characterPropertiesMap.containsKey(key)) {
            characterPropertiesMap.put(key, new CharacterProperties(font, fontSize, fontColor));
        }

        return characterPropertiesMap.get(key);
    }
}
