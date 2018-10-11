package ex05_online_radio_database;

public class Song {
    private String artist;
    private String name;
    private int minutes;
    private int seconds;

    public Song() { }

    public Song(String artist, String name, int minutes, int seconds) {
        setArtist(artist);
        setName(name);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    protected void setArtist(String artist) {
        if((artist.length() < 3) || (artist.length() > 20)) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artist = artist;
    }

    protected void setName(String name) {
        if((name.length() < 3) || (name.length() > 30)) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.name = name;
    }

    protected void setMinutes(int minutes) {
        if((minutes < 0) || (minutes > 14)) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    protected void setSeconds(int seconds) {
        if((seconds < 0) || (seconds > 59)) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    protected int getMinutes() {
        return this.minutes;
    }

    protected int getSeconds() {
        return this.seconds;
    }

}
