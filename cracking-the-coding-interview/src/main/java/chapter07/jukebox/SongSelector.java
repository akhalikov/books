package chapter07.jukebox;

import java.util.List;
import java.util.Optional;

public class SongSelector {
  private CDPlayer cdPlayer;
  private Song currentSong;

  public SongSelector(CDPlayer cdPlayer) {
    this.cdPlayer = cdPlayer;
  }

  public void selectSong(int songId) {
    Optional<Song> song = getSongFromCd(songId);
    if (song.isPresent()) {
      currentSong = song.get();
      Playlist playlist = cdPlayer.getPlaylist();
      playlist.enqueueSong(currentSong);
    }
  }

  private Optional<Song> getSongFromCd(int songId) {
    final CD cd = cdPlayer.getCd();
    final List<Song> songs = cd.getSongs();
    for (Song song: songs) {
      if (song.getId() == songId)
        return Optional.of(song);
    }
    return Optional.empty();
  }
}
