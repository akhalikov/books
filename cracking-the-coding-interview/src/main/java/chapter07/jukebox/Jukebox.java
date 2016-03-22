package chapter07.jukebox;

import java.util.Set;

/**
 * Jukebox model
 *
 * Created by akhalikov on 23/03/16
 */
public class Jukebox {

  private CDPlayer cdPlayer;
  private Set<CD> cdCollection;
  private SongSelector songSelector;
  private User user;

  public Jukebox(CDPlayer cdPlayer, Set<CD> cdCollection,
                 SongSelector songSelector) {
    this.cdPlayer = cdPlayer;
    this.cdCollection = cdCollection;
    this.songSelector = songSelector;
  }

  public Song getCurrentSong() {
    // todo: to be completed

    return null;
  }

  public void selectCD(CD cd) {
    if (cdCollection.contains(cd)) {
      cdPlayer.setCd(cd);
      Playlist playlist = Playlist.of(cd);
      cdPlayer.setPlaylist(playlist);
    }
  }

  public void selectSong(int id) {
    // todo: to be completed
  }

  public void play() {
    // todo: to be completed
  }

  public void setUser(User user) {
    this.user = user;
  }
}
