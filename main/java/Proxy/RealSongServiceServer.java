package Proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongServiceServer implements SongService {
    private List<Song> songs;

    public RealSongServiceServer(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        Song result = null;

        for (Song song : songs) {
            if (songID == song.getSongID())
                result = song;
        }

        return result;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (title.equals(song.getTitle()))
                results.add(song);
        }

        return results;
    }

    @Override
    public List<Song> searchByAlbum(String albumName) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (albumName.equals(song.getAlbum()))
                results.add(song);
        }

        return results;
    }
}
