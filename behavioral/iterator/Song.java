package behavioral.iterator;

public class Song {
    private String title;
    private String artist;
    private int durationInSeconds;
    private String genre;
    
    public Song(String title, String artist, int durationInSeconds, String genre) {
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
        this.genre = genre;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public int getDurationInSeconds() {
        return durationInSeconds;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getFormattedDuration() {
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%s) [%s]", 
            artist, title, getFormattedDuration(), genre);
    }
}
