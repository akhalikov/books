package chapter07.parkinglot;

/**
 * Created by akhalikov on 03/03/16
 */
public class ParkingSpot {
  private ParkingLevel level;
  private Vehicle.VehicleSize spotSize;
  private int spotNumber;
  private int row;
  private Vehicle vehicle;

  public ParkingSpot(ParkingLevel level, Vehicle.VehicleSize spotSize,
                     int spotNumber, int row) {
    this.level = level;
    this.spotSize = spotSize;
    this.spotNumber = spotNumber;
    this.row = row;
  }

  public boolean park(Vehicle vehicle) {
    vehicle.parkInSpot(this);
    this.vehicle = vehicle;
    return true;
  }

  public void unpark() {
    this.vehicle = null;
    level.spotFreed();
  }

  public boolean isAvailable() {
    return vehicle == null;
  }

  public boolean canFitVehicle(Vehicle vehicle) {
    return isAvailable()
      && spotSize == vehicle.size;
  }

  public ParkingLevel getLevel() {
    return level;
  }

  public Vehicle.VehicleSize getSpotSize() {
    return spotSize;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public int getRow() {
    return row;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }
}
