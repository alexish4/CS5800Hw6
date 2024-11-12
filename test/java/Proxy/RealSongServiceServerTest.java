package Proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RealSongServiceServerTest {
    private RealSongServiceServer realSongService;

    @BeforeEach
    void setUp() {
        List<Song> songs = new ArrayList<>();

        songs.add(new Song(1, "There Is a Light That Never Goes Out", "The Smiths",
                "The Queen Is Dead", 233));
        songs.add(new Song(2, "Mr. Brightside", "The Killers", "Hot Fuss", 200));
        songs.add(new Song(3, "Soma", "The Strokes", "Is This It", 203));
        songs.add(new Song(4, "Soma", "The Smashing Pumpkins", "Siamese Dream", 150));
        songs.add(new Song(5, "The Adults Are Talking", "The Strokes",
                "The New Abnormal", 150));
        songs.add(new Song(6, "Lost Ones", "Lauryn Hill",
                "The Miseducation Of Lauryn Hill", 174));
        songs.add(new Song(7, "Ex-Factor", "Lauryn Hill",
                "The Miseducation Of Lauryn Hill", 180));

        realSongService = new RealSongServiceServer(songs);
    }

    @Test
    void searchById() {
        Song song = realSongService.searchById(2);
        assertNotNull(song, "Song should not be null");

        String expected = "Mr. Brightside";
        String actual = song.getTitle();

        assertEquals(expected, actual);
    }

    @Test
    void searchByTitle() {
        List<Song> songs = realSongService.searchByTitle("Soma");
        assertNotNull(songs);
        assertFalse(songs.isEmpty());

        String expected = "Soma";
        String actual = songs.get(0).getTitle();

        assertEquals(expected, actual);
    }

    @Test
    void searchByAlbum() {
        List<Song> songs = realSongService.searchByAlbum("The Miseducation Of Lauryn Hill");
        assertNotNull(songs);
        assertFalse(songs.isEmpty());

        String expected = "Lost Ones";
        String actual = songs.get(0).getTitle();

        assertEquals(expected, actual);
    }
}