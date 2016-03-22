package chapter07.jukebox;

/**
 * Song
 */
public class Song {

  private int id;
  private String title;
  private CD cd;
  private int length;

  public Song(int id, String title, CD cd, int length) {
    this.id = id;
    this.title = title;
    this.cd = cd;
    this.length = length;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
}
