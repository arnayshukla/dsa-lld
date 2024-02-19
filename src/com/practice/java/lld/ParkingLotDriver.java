package com.practice.java.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8
 */
public class ParkingLotDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLotService service = new ParkingLotService();
        String input = sc.nextLine();
        while (true) {
            String[] inputArray = input.split(" ");
            String command = inputArray[0];
            switch (command) {
            case "create_parking_lot":
                service.createParkingLot(inputArray[1], Integer.valueOf(inputArray[2]).intValue(), Integer.valueOf(inputArray[3]).intValue());
                break;
            case "display":
                service.display(inputArray[1], VehicleType.valueOf(inputArray[2]));
                break;
            case "park_vehicle":
                service.parkVehicle(VehicleType.valueOf(inputArray[1]), inputArray[2], inputArray[3]);
                break;
            case "unpark_vehicle":
                service.unparkVehicle(inputArray[1]);
                break;
            case "exit":
                sc.close();
                System.exit(0);
            }
            input = sc.nextLine();
        }
    }

}

enum VehicleType {
    CAR, BIKE, TRUCK
}

class Vehicle{
    VehicleType vehicleType;
    String regNo;
    String color;

    public Vehicle() {}

    public Vehicle(VehicleType vehicleType, String regNo, String color) {
      this.vehicleType = vehicleType;
      this.regNo = regNo;
      this.color = color;
    }

    public VehicleType getVehicleType() {
      return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
      this.vehicleType = vehicleType;
    }
    public String getRegNo() {
      return regNo;
    }
    public void setRegNo(String regNo) {
      this.regNo = regNo;
    }
    public String getColor() {
      return color;
    }
    public void setColor(String color) {
      this.color = color;
    }

}

class ParkingSlot {
    int slotId;
    VehicleType vehicleType;
    Vehicle vehicle;
    boolean isOccupied;

    public ParkingSlot() {}

    
    public ParkingSlot(int slotId, VehicleType vehicleType, Vehicle vehicle, boolean isOccupied) {
      this.slotId = slotId;
      this.vehicleType = vehicleType;
      this.vehicle = vehicle;
      this.isOccupied = isOccupied;
    }

    public int getSlotId() {
      return slotId;
    }
    public void setSlotId(int slotId) {
      this.slotId = slotId;
    }
    public VehicleType getVehicleType() {
      return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
      this.vehicleType = vehicleType;
    }
    public Vehicle getVehicle() {
      return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
      this.vehicle = vehicle;
    }
    public boolean isOccupied() {
      return isOccupied;
    }
    public void setOccupied(boolean isOccupied) {
      this.isOccupied = isOccupied;
    }

}

class ParkingFloor {
    int floorId;
    List<ParkingSlot> parkingSlots;

    public ParkingFloor() {}

    public ParkingFloor(int floorId, List<ParkingSlot> parkingSlots) {
      this.floorId = floorId;
      this.parkingSlots = parkingSlots;
    }

    public int getFloorId() {
      return floorId;
    }

    public void setFloorId(int floorId) {
      this.floorId = floorId;
    }

    public List<ParkingSlot> getParkingSlots() {
      return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
      this.parkingSlots = parkingSlots;
    }

    
}

class ParkingLot {
    String id;
    List<ParkingFloor> parkingFloors;

    public ParkingLot() {}

    public ParkingLot(String id, List<ParkingFloor> parkingFloors) {
      this.id = id;
      this.parkingFloors = parkingFloors;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public List<ParkingFloor> getParkingFloors() {
      return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
      this.parkingFloors = parkingFloors;
    }
}

class ParkingLotService {

    ParkingLot parkingLot;
    List<String> tickets;

    void createParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor) {
        parkingLot = new ParkingLot();
        parkingLot.setId(parkingLotId);
        List<ParkingFloor> parkingFloors = createParkingFloors(noOfFloors, noOfSlotsPerFloor);
        parkingLot.setParkingFloors(parkingFloors);
        System.out.println("Created parking lot with " + noOfFloors + " floors and " + noOfSlotsPerFloor + " slots per floor");
    }

    private List<ParkingFloor> createParkingFloors(int noOfFloors, int noOfSlotsPerFloor) {
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 1; i <= noOfFloors; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorId(i);
            List<ParkingSlot> parkingSlot = createParkingSlots(noOfSlotsPerFloor);
            parkingFloor.setParkingSlots(parkingSlot);
            parkingFloors.add(parkingFloor);
        }
        return parkingFloors;
        
    }

    private List<ParkingSlot> createParkingSlots(int noOfSlotsPerFloor) {
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for (int i = 1; i <= noOfSlotsPerFloor; i ++) {
            ParkingSlot parkingSlot = new ParkingSlot();
            parkingSlot.setSlotId(i);
            if (i == 1) parkingSlot.setVehicleType(VehicleType.TRUCK);
            else if (i == 2 || i == 3) parkingSlot.setVehicleType(VehicleType.BIKE);
            else parkingSlot.setVehicleType(VehicleType.CAR);
            parkingSlot.setOccupied(false);
            parkingSlots.add(parkingSlot);
        }
        return parkingSlots;
    }

    void display(String displayType, VehicleType vehicleType) {
        switch (displayType) {
            case "free_count":
                displayFreeCount(vehicleType);
                break;
            case "free_slots":
                displaySlot(vehicleType, false);
                break;
            case "occupied_slots":
                displaySlot(vehicleType, true);
                break;
        }
    }

    void displayFreeCount(VehicleType vehicleType) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (ParkingFloor parkingFloor : parkingFloors) {
            int count = 0;
            List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
            for (ParkingSlot parkingSlot : parkingSlots) {
                if (parkingSlot.getVehicleType().equals(vehicleType) && !parkingSlot.isOccupied) count++;
            }
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + parkingFloor.getFloorId()+ " : " + count);
        }
    }

    void displaySlot(VehicleType vehicleType, boolean occupiedSlot) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (ParkingFloor parkingFloor : parkingFloors) {
            List<Integer> slotIds = new ArrayList<>();
            List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
            for (ParkingSlot parkingSlot : parkingSlots) {
                if (parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.isOccupied == occupiedSlot) slotIds.add(parkingSlot.getSlotId());
            }
            String slotsId = slotIds.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println((occupiedSlot ? "Occupied" : "Free") + " slots for " + vehicleType + " on Floor " + parkingFloor.getFloorId()+ " : " + slotsId);
        }
    }

    void parkVehicle(VehicleType vehicleType, String regNo, String color) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (ParkingFloor parkingFloor: parkingFloors) {
            List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
            for (ParkingSlot parkingSlot : parkingSlots) {
                if (parkingSlot.getVehicleType().equals(vehicleType) && !parkingSlot.isOccupied) {
                    Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
                    parkingSlot.setVehicle(vehicle);
                    parkingSlot.setOccupied(true);
                    System.out.println("Parked vehicle. Ticket ID: " + parkingLot.getId() + "_ "
                            + parkingFloor.getFloorId() + "_" + parkingSlot.getSlotId());
                    return;
                }
            }
        }
        System.out.println("Parking Lot Full");
    }

    public void unparkVehicle(String ticket) {
        String[] ticketDetails = ticket.split("_"); 
        unparkVehicle(Integer.valueOf(ticketDetails[1]).intValue(), Integer.valueOf(ticketDetails[2]).intValue());
    }

    void unparkVehicle(int floorNo, int slotNo) {
        try {
            ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(floorNo - 1);
            if (Objects.nonNull(parkingFloor)) {
                ParkingSlot parkingSlot = parkingFloor.getParkingSlots().get(slotNo - 1);
                if (!parkingSlot.isOccupied) {
                    System.out.println("Invalid Ticket");
                    return;
                }
                Vehicle vehicle = parkingSlot.getVehicle();
                System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegNo() + " and Color: " + vehicle.getColor());
                parkingSlot.setOccupied(false);
                parkingSlot.setVehicle(null);
            }
        } catch (Exception e) {
            System.out.println("Invalid Ticket");
        }
    }
}
