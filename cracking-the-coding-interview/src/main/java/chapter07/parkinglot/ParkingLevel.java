package chapter07.parkinglot;

/**
 * Created by akhalikov on 03/03/16
 */
public class ParkingLevel {
  private ParkingSpot[] spots;
  private int availableSpots;
  private String levelId;

  public ParkingLevel(String levelId, int numSpots) {
    this.levelId = levelId;
    this.spots = new ParkingSpot[numSpots];
    createSpots(numSpots);
    availableSpots = numSpots;
  }

  /**
   * Park vehicle in this level
   * @param vehicle
   * @return false if failed
   */
  public boolean park(Vehicle vehicle) {
    if (availableSpots == 0)
      return false;

    int spotIndex = findAvailableSpot(vehicle);
    if (spotIndex < 0)
      return false;

    ParkingSpot spot = spots[spotIndex];

    String spotId = spot.getLevel().levelId + spot.getSpotNumber();
    System.out.println("Parking vehicle to a spot " + spotId);
    spot.park(vehicle);
    availableSpots--;

    return true;
  }

  /**
   * Find a spot to park this vehicle
   * @param vehicle
   * @return index of vehicle or -1 on failure
   */
  private int findAvailableSpot(Vehicle vehicle) {
    for (int i = 0; i < spots.length; i++) {
      ParkingSpot spot = spots[i];
      if (spot.canFitVehicle(vehicle))
        return i;
    }
    return -1;
  }

  public void spotFreed() {
    availableSpots++;
  }

  /**
   * Simple method to create spots
   * @param numSpots
   */
  private void createSpots(int numSpots) {
    for (int i = 0; i < numSpots; i++) {
      int spotNumber = i + 1;
      spots[i] = new ParkingSpot(this, Vehicle.VehicleSize.Compact, spotNumber, 0);
    }
  }

  public boolean hasAvailableSpots() {
    return availableSpots > 0;
  }
}
