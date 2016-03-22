package chapter07.jukebox;

public abstract class CDPlayer {
  private Playlist playlist;
  private CD cd;

  public CDPlayer(Playlist playlist) {
    this.playlist = playlist;
  }

  public CDPlayer(CD cd) {
    this.cd = cd;
  }

  public CDPlayer(Playlist playlist, CD cd) {
    this.playlist = playlist;
    this.cd = cd;
  }

  public abstract void playSong(Song song);

  public boolean isEmpty() {
    return cd == null && playlist.isEmpty();
  }

  /** Getters and Setters **/

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public CD getCd() {
    return cd;
  }

  public void setCd(CD cd) {
    this.cd = cd;
  }
}
