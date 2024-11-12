package Proxy;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class SongServiceWithProxy implements SongService {
    private RealSongServiceServer realSongServiceServer;
    private Map<Integer, Song> cacheByID = new HashMap<>();
    private Map<String, List<Song>> cacheByTitle = new HashMap<>();
    private Map<String, List<Song>> cacheByAlbum = new HashMap<>();

    public SongServiceWithProxy(RealSongServiceServer realSongServiceServer) {
        this.realSongServiceServer = realSongServiceServer;
    }


    @Override
    public Song searchById(Integer songID) {
        long startTime = System.currentTimeMillis();
        long endTime;

        if (cacheByID.containsKey(songID)) {
            endTime = System.currentTimeMillis();
            System.out.println("Time taken for search is " + (endTime - startTime) + "\n");

            return cacheByID.get(songID);
        }

        Song song = realSongServiceServer.searchById(songID);
        cacheByID.put(songID, song);

        endTime = System.currentTimeMillis();
        System.out.println("Time taken for search is " + (endTime - startTime) + "\n");

        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        long startTime = System.currentTimeMillis();
        long endTime;

        if (cacheByTitle.containsKey(title)) {
            endTime = System.currentTimeMillis();
            System.out.println("Time taken for search is " + (endTime - startTime) + "\n");

            return cacheByTitle.get(title);
        }

        List<Song> songs = realSongServiceServer.searchByTitle(title);
        cacheByTitle.put(title, songs);

        endTime = System.currentTimeMillis();
        System.out.println("Time taken for search is " + (endTime - startTime) + "\n");

        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String albumName) {
        long startTime = System.currentTimeMillis();
        long endTime;

        if (cacheByAlbum.containsKey(albumName)) {
            endTime = System.currentTimeMillis();
            System.out.println("Time taken for search is " + (endTime - startTime) + "\n");

            return cacheByAlbum.get(albumName);
        }

        List<Song> songs = realSongServiceServer.searchByAlbum(albumName);
        cacheByAlbum.put(albumName, songs);

        endTime = System.currentTimeMillis();
        System.out.println("Time taken for search is " + (endTime - startTime) + "\n");

        return songs;
    }
}
