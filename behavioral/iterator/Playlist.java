package behavioral.iterator;

public interface Playlist {
    SongIterator createIterator();
    void addSong(Song song);
    int getSize();
    String getPlaylistName();
}
