package chapter07.jukebox;

import java.util.List;
import java.util.Optional;

/**
 * CD
 */
public class CD {
  private String artist;
  private List<Song> songs;
  private int numberOfTracks;

  public CD(String artist, List<Song> songs) {
    this.artist = artist;
    this.songs = songs;
    this.numberOfTracks = songs.size();
  }

  public Song getFirstSong() {
    return songs.get(0);
  }

  public Optional<Song> getSongByTitle(String title) {
    for (Song song: songs) {
      if (song.getTitle() != null && song.getTitle().equals(title))
        return Optional.of(song);
    }
    return Optional.empty();
  }

  public List<Song> getSongs() {
    return songs;
  }
}
