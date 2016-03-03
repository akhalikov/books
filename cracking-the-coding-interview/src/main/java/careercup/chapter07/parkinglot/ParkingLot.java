package careercup.chapter07.parkinglot;

/**
 * Created by akhalikov on 03/03/16
 */
public class ParkingLot {
  private ParkingLevel[] levels;
  private int numLevels;

  public ParkingLot(ParkingLevel[] levels) {
    this.levels = levels;
  }

  /**
   * Park the vehicle in a spot (or multiple spots).
   * @return false if failed, true if parked.
   */
  public boolean park(Vehicle vehicle) {
    for (ParkingLevel level: levels) {
      if (level.hasAvailableSpots()) {
        level.park(vehicle);
        return true;
      }
    }
    return false;
  }

  public int getNumLevels() {
    return numLevels;
  }
}
