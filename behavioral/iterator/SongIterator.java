package behavioral.iterator;

public class SongIterator implements Iterator<Song> {
    private Song[] songs;
    private int position = 0;
    
    public SongIterator(Song[] songs) {
        this.songs = songs;
    }
    
    @Override
    public boolean hasNext() {
        return position < songs.length && songs[position] != null;
    }
    
    @Override
    public Song next() {
        if (hasNext()) {
            return songs[position++];
        }
        return null;
    }
    
    @Override
    public void reset() {
        position = 0;
    }
}
