package behavioral.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Spotify-like Iterator Pattern Demo ===\n");
        
        // Create sample songs
        Song song1 = new Song("Blinding Lights", "The Weeknd", 200, "Pop");
        Song song2 = new Song("Watermelon Sugar", "Harry Styles", 174, "Pop");
        Song song3 = new Song("Levitating", "Dua Lipa", 203, "Pop");
        Song song4 = new Song("Good 4 U", "Olivia Rodrigo", 178, "Pop Rock");
        Song song5 = new Song("Stay", "The Kid LAROI & Justin Bieber", 141, "Pop");
        Song song6 = new Song("Industry Baby", "Lil Nas X ft. Jack Harlow", 212, "Hip Hop");
        Song song7 = new Song("Heat Waves", "Glass Animals", 238, "Indie Pop");
        Song song8 = new Song("Peaches", "Justin Bieber ft. Daniel Caesar", 198, "R&B");
        Song song9 = new Song("Kiss Me More", "Doja Cat ft. SZA", 208, "Pop");
        Song song10 = new Song("Montero", "Lil Nas X", 137, "Hip Hop");
        
        // Create Liked Songs Playlist
        LikedSongsPlaylist likedSongs = new LikedSongsPlaylist();
        likedSongs.addSong(song1);
        likedSongs.addSong(song3);
        likedSongs.addSong(song5);
        likedSongs.addSong(song7);
        likedSongs.addSong(song9);
        
        // Create Top 10 Global Playlist
        Top10GlobalPlaylist top10Global = new Top10GlobalPlaylist();
        top10Global.setSongAtPosition(0, song1);  // #1
        top10Global.setSongAtPosition(1, song2);  // #2
        top10Global.setSongAtPosition(2, song3);  // #3
        top10Global.setSongAtPosition(3, song4);  // #4
        top10Global.setSongAtPosition(4, song5);  // #5
        top10Global.setSongAtPosition(5, song6);  // #6
        top10Global.setSongAtPosition(6, song7);  // #7
        top10Global.setSongAtPosition(7, song8);  // #8
        top10Global.setSongAtPosition(8, song9);  // #9
        top10Global.setSongAtPosition(9, song10); // #10
        
        // Demo 1: Iterate through Liked Songs
        System.out.println(likedSongs.getPlaylistName() + " (" + likedSongs.getSize() + " songs)");
        System.out.println("=" + "=".repeat(50));
        iteratePlaylist(likedSongs);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Demo 2: Iterate through Top 10 Global
        System.out.println(top10Global.getPlaylistName() + " (" + top10Global.getSize() + " songs)");
        System.out.println("=" + "=".repeat(50));
        iteratePlaylist(top10Global);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
    }
    
    private static void iteratePlaylist(Playlist playlist) {
        SongIterator iterator = playlist.createIterator();
        int position = 1;
        
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (playlist instanceof Top10GlobalPlaylist) {
                System.out.println("#" + position + " " + song);
            } else {
                System.out.println(position + ". " + song);
            }
            position++;
        }
    }
}
