package chapter07.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhalikov on 03/03/16
 */
public abstract class Vehicle {
  enum VehicleSize {
    Motorcycle,
    Compact,
    Large
  }

  protected VehicleSize size;
  protected int spotsNeeded;
  protected String licensePlate;
  protected List<ParkingSpot> parkingSpots = new ArrayList<>();

  public Vehicle(VehicleSize size, int spotsNeeded, String licensePlate) {
    this.size = size;
    this.spotsNeeded = spotsNeeded;
    this.licensePlate = licensePlate;
  }

  public void parkInSpot(ParkingSpot spot) {
    parkingSpots.add(spot);
  }

  public void clearSpots() {
  }
}
