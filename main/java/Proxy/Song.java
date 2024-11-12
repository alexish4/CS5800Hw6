package Proxy;

public class Song {
    private int songID;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(int songID, String title, String artist, String album, int duration) {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public int getSongID() {
        return songID;
    }

    public String toString() {
        return "Song: " + title + " - " + artist + " - " + album + " - " + duration;
    }
}
