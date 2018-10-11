package ex05_online_radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfSongs = 0;
        List<Song> Songs = new LinkedList<>();

        int numOfInputs = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numOfInputs; i++) {
            Song song = null;
            String[] lineSplitted = reader.readLine().split(";");

            String artist = lineSplitted[0];
            String title = lineSplitted[1];
            String[] songLength = lineSplitted[2].split(":");
            try {
                if(songLength.length < 2) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }
                String minutes = songLength[0];
                String seconds = songLength[1];

                if(minutes.matches("\\D+") || seconds.matches("\\D+")) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }
                song = new Song(artist, title, Integer.parseInt(minutes), Integer.parseInt(seconds));
                if (song != null) {
                    Songs.add(song);
                    System.out.println("Song added.");
                    numOfSongs++;
                }
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }


        System.out.printf("Songs added: %d%n", numOfSongs);

        int allHours = 0;
        int allMinutes = 0;
        int allSeconds = 0;
        for (Song song : Songs) {
            allSeconds += song.getSeconds();
            if(allSeconds > 59) {
                allSeconds -= 60;
                allMinutes += song.getMinutes() + 1;
            }
            else {
                allMinutes += song.getMinutes();
            }
            if(allMinutes > 59) {
                allHours += 1;
                allMinutes -= 60;
            }
        }
        System.out.printf("Playlist length: %dh %dm %ds", allHours, allMinutes, allSeconds);
    }
}
