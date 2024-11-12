import Proxy.RealSongServiceServer;
import Proxy.Song;
import Proxy.SongServiceWithProxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyDriver {
    public static void main(String[] args) {
        proxyDriver();
    }

    public static void proxyDriver() {
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

        SongServiceWithProxy songServiceProxy = new SongServiceWithProxy(new RealSongServiceServer(songs));

        Song songResult;
        List<Song> songResultList;

        System.out.println("Result Before Cache:");
        songResult = songServiceProxy.searchById(2);
        System.out.println(songResult.toString() + "\n");

        System.out.println("Result After Cache:");
        songResult = songServiceProxy.searchById(2);
        System.out.println(songResult.toString() + "\n");

        System.out.println("Result Before Cache:");
        songResultList = songServiceProxy.searchByTitle("Soma");
        for (Song song : songResultList) {
            System.out.println(song.toString());
        }
        System.out.println();

        System.out.println("Result After Cache:");
        songResultList = songServiceProxy.searchByTitle("Soma");
        for (Song song : songResultList) {
            System.out.println(song.toString());
        }
        System.out.println();

        System.out.println("Result Before Cache:");
        songResultList = songServiceProxy.searchByAlbum("The Miseducation Of Lauryn Hill");
        for (Song song : songResultList) {
            System.out.println(song.toString());
        }
        System.out.println();

        System.out.println("Result After Cache:");
        songResultList = songServiceProxy.searchByAlbum("The Miseducation Of Lauryn Hill");
        for (Song song : songResultList) {
            System.out.println(song.toString());
        }
        System.out.println();
    }
}
