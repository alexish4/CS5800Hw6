package Proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private Song song;

    @BeforeEach
    void setUp() {
        song = new Song(1, "There Is a Light That Never Goes Out", "The Smiths",
                "The Queen Is Dead", 233);
    }

    @Test
    void testToString() {
        String expected = "Song: There Is a Light That Never Goes Out - The Smiths - The Queen Is Dead - 233";
        String actual = song.toString();
        assertEquals(expected, actual);
    }
}