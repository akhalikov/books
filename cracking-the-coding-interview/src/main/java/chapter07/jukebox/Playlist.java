package chapter07.jukebox;

import java.util.List;
import java.util.Queue;

public class Playlist {
  private Song song;
  private Queue<Song> songsQueue;

  private Playlist() {
  }

  public Playlist(Song song, Queue<Song> songsQueue) {
    this.song = song;
    this.songsQueue = songsQueue;
  }

  public Song getNextToPlay() {
    return songsQueue.peek();
  }

  public void enqueueSong(Song song) {
    songsQueue.add(song);
  }

  public boolean isEmpty() {
    return song == null && songsQueue.isEmpty();
  }

  public static Playlist of(CD cd) {
    Playlist playlist = new Playlist();
    List<Song> songs = cd.getSongs();
    playlist.song = songs.get(0);
    for (Song song: songs) {
      playlist.enqueueSong(song);
    }
    return playlist;
  }
}
