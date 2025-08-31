package behavioral.iterator;

public class Top10GlobalPlaylist implements Playlist {
    private Song[] topSongs;
    private String playlistName;
    private int currentSize;
    
    public Top10GlobalPlaylist() {
        this.topSongs = new Song[10];
        this.playlistName = "🌍 Top 10 Global";
        this.currentSize = 0;
    }
    
    @Override
    public SongIterator createIterator() {
        return new SongIterator(topSongs);
    }
    
    @Override
    public void addSong(Song song) {
        if (currentSize < 10) {
            topSongs[currentSize] = song;
            currentSize++;
        } else {
            // Replace the last song (simulate chart movement)
            topSongs[9] = song;
        }
    }
    
    @Override
    public int getSize() {
        return currentSize;
    }
    
    @Override
    public String getPlaylistName() {
        return playlistName;
    }
    
    public void setSongAtPosition(int position, Song song) {
        if (position >= 0 && position < 10) {
            topSongs[position] = song;
            if (position >= currentSize) {
                currentSize = position + 1;
            }
        }
    }
    
    public Song getSongAtPosition(int position) {
        if (position >= 0 && position < currentSize) {
            return topSongs[position];
        }
        return null;
    }
}
