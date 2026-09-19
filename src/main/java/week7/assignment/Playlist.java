package week7.assignment;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        this.songs = new String[maxSongs];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount++] = title;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";
        System.out.println("Original first song: " + playlist.getSongs()[0]);
        System.out.println("Song count: " + playlist.getSongCount());
    }
}
