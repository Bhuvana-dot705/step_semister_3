import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(
                    "Capacity cannot be negative"
            );
        }

        songs = new String[capacity];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song == null || song.isEmpty()) {
            System.out.println("Invalid song title");
            return;
        }

        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class songs {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Original playlist:");
        System.out.println(Arrays.toString(p.getSongs()));

        copy[0] = "Hacked";

        System.out.println("Modified copy:");
        System.out.println(Arrays.toString(copy));

        System.out.println("Actual playlist:");
        System.out.println(Arrays.toString(p.getSongs()));

        System.out.println("Song count: " + p.getSongCount());
    }
}