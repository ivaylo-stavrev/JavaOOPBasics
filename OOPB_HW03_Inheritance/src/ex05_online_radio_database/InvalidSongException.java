package ex05_online_radio_database;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String message) {
        super(message);
    }
}
