package careercup.chapter07.parkinglot;

/**
 * Created by akhalikov on 03/03/16
 */
public class ParkingApp {
  public static void main(String[] args) {
    String[] levelIds = {"A", "B", "C"};
    int numLevels = levelIds.length;
    int numSpots = 20;

    ParkingLevel[] levels = new ParkingLevel[numLevels];
    for (int i = 0; i < numLevels; i++) {
      levels[i] = new ParkingLevel(levelIds[i], numSpots);
    }

    ParkingLot parkingLot = new ParkingLot(levels);

    Vehicle car = new Car("XYZ 1234");
    parkingLot.park(car);
  }
}
