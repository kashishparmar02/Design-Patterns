# Iterator Pattern - Spotify-like Music Playlist Demo

## Overview
This implementation demonstrates the Iterator pattern using a realistic Spotify-like music playlist system with two different types of collections:

1. **Liked Songs Playlist** - Uses ArrayList (dynamic size)
2. **Top 10 Global Playlist** - Uses Array (fixed size)

## Key Components

### Core Classes
- `Song` - Represents a music track with title, artist, duration, and genre
- `Iterator<T>` - Generic iterator interface with hasNext(), next(), and reset() methods
- `SongIterator` - Concrete iterator implementation for Song objects
- `Playlist` - Interface for playlist collections

### Playlist Implementations
- `LikedSongsPlaylist` - Dynamic playlist using ArrayList
- `Top10GlobalPlaylist` - Fixed-size playlist using Array

## Pattern Benefits Demonstrated

1. **Uniform Interface**: Both playlists can be iterated using the same interface
2. **Data Structure Independence**: Client code doesn't need to know internal implementation
3. **Flexibility**: Easy to add new playlist types without changing client code
4. **Real-world Application**: Shows how the pattern applies to actual software systems

## Usage Example

```java
// Create playlists
LikedSongsPlaylist likedSongs = new LikedSongsPlaylist();
Top10GlobalPlaylist top10 = new Top10GlobalPlaylist();

// Add songs to playlists
likedSongs.addSong(new Song("Blinding Lights", "The Weeknd", 200, "Pop"));
top10.setSongAtPosition(0, new Song("Watermelon Sugar", "Harry Styles", 174, "Pop"));

// Iterate using same interface
SongIterator iterator1 = likedSongs.createIterator();
SongIterator iterator2 = top10.createIterator();

while (iterator1.hasNext()) {
    Song song = iterator1.next();
    System.out.println(song);
}
```

## Real-world Applications
- Music streaming services (Spotify, Apple Music)
- Social media feeds
- E-commerce product catalogs
- File system traversal
- Database result sets
