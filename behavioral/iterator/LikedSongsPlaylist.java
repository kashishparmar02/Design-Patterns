package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class LikedSongsPlaylist implements Playlist {
    private List<Song> songs;
    private String playlistName;
    
    public LikedSongsPlaylist() {
        this.songs = new ArrayList<>();
        this.playlistName = "❤️ Liked Songs";
    }
    
    @Override
    public SongIterator createIterator() {
        return new SongIterator(songs.toArray(new Song[0]));
    }
    
    @Override
    public void addSong(Song song) {
        songs.add(song);
    }
    
    @Override
    public int getSize() {
        return songs.size();
    }
    
    @Override
    public String getPlaylistName() {
        return playlistName;
    }
    
    public void removeSong(Song song) {
        songs.remove(song);
    }
    
    public boolean contains(Song song) {
        return songs.contains(song);
    }
}
