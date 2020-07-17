/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcvehicleshowroom;


import InterfaceInput.Input;
import Vehicles.VehicleOption;
import Vehicles.HeavyVehicle;
import Vehicles.NormalVehicle;
import Vehicles.SportsVehicle;
import Vehicles.Vehicle;
import exceptions.NewException;
import java.util.*;
/**
 *
 * @author LENOVO ADMIN
 */
public class ABCVehicleShowroom {

     private Integer numberOfVisitor;
    private final List<Vehicle>  vehicles;
    private Map<Integer, VehicleOption<? extends Vehicle>> vehicleTypes;

    public ABCVehicleShowroom() {
        this.vehicles = new ArrayList<>();
    }

    public Integer getNumberOfVisitor() {
        return this.numberOfVisitor;
    }

    public void setNumberOfVisitor(Integer numberOfVisitor) {
        this.numberOfVisitor = numberOfVisitor;
    }

    public Map<Integer, VehicleOption<? extends Vehicle>> getVehicleTypes() {
        return this.vehicleTypes;
    }

    public void setVehicleTypes(Map<Integer, VehicleOption<? extends Vehicle>> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    
    public void addVehicle(){
        System.out.println("Enter vehicle type");
        this.vehicleTypes.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
         });
        VehicleOption<? extends Vehicle> vehicleOption = (VehicleOption<? extends Vehicle>) Input.getObjectByInputForVehicleType(this.vehicleTypes);

        Vehicle vehicle = vehicleOption.getInstanceByClass();
        vehicle.initialize();

        this.vehicles.add(vehicle);
        if(vehicle instanceof SportsVehicle) {
            int Visitors = this.getNumberOfVisitor();
            this.setNumberOfVisitor(Visitors + 20);
        }
        System.out.println("Vehicle added successfully\n");
    }

    public void removeVehicle() {
        if(this.vehicles.isEmpty()) {
            System.out.println("You have no vehicle to remove");
        }
        
        System.out.println("Enter serial number to remove");
        for(int i = 0; i < this.vehicles.size(); i++) {
            System.out.println(i + 1 + ". " + this.vehicles.get(i).getModelNumber());
        }
        int choice = Input.takeMenuOptionInput(this.vehicles.size());
        Vehicle vehicle = this.vehicles.get(choice - 1);
        if(vehicle instanceof SportsVehicle) {
            int Visitors = this.getNumberOfVisitor();
            this.setNumberOfVisitor(Visitors - 20);
        }
        vehicles.remove(vehicle);
        System.out.println("Vehicle removed successfully\n");
    }

    public void showList() {
        System.out.print("Number of current expected visitor: " + this.getNumberOfVisitor() + "\n");
        if(this.vehicles.isEmpty()) {
            System.out.println("No vehicle to show");
            return;
        }
        for(int i = 0; i < this.vehicles.size(); i++) {
            System.out.println(i + 1 + ". " + this.vehicles.get(i).getModelNumber());
        }
        System.out.println("");
    }

    public void showListWithDetails() {
        if(this.vehicles.isEmpty()) {
            System.out.println("No vehicle to show");
            return;
        }
        for(int i = 0; i < this.vehicles.size(); i++) {
            System.out.println("--- Vehicle " + (i + 1) + " ---");
            this.vehicles.get(i).show();
            System.out.println("");
        }
    }

    public void runApplication() {
        while (true) {
            System.out.println("Enter choice: ");
            System.out.println("1. Add vehicle");
            System.out.println("2. Remove vehicle");
            System.out.println("3. Show vehicle list with current expected visitor count");
            System.out.println("4. Show vehicle list with details");
            System.out.println("5. Exit");
            int choice = Input.takeMenuOptionInput(5);
            switch (choice) {
                case 1:
                    this.addVehicle();
                    break;
                case 2:
                    this.removeVehicle();
                    break;
                case 3:
                    this.showList();
                    break;
                case 4:
                    showListWithDetails();
                    break;
                case 5:
                    return;
            }
        }
    }

    public static Map<Integer, VehicleOption<? extends Vehicle>> getAvailableVehicleTypes() {
        Map<Integer, VehicleOption<? extends Vehicle>> vehicleTypes = new HashMap<>();
        List<VehicleOption<? extends Vehicle>> vehicleOptions = new ArrayList<>();
        vehicleOptions.add(new VehicleOption<>(NormalVehicle.class, "Normal"));
        vehicleOptions.add(new VehicleOption<>(SportsVehicle.class, "Sports"));
        vehicleOptions.add(new VehicleOption<>(HeavyVehicle.class, "Heavy"));
        int serial = 1;
        for(VehicleOption<? extends Vehicle> vehicleOption: vehicleOptions) {
            vehicleTypes.put(serial++, vehicleOption);
        }
        return vehicleTypes;
    }

    public static void main(String[] args) throws NewException {
        ABCVehicleShowroom application = new ABCVehicleShowroom();
        Map<Integer, VehicleOption<? extends Vehicle>> vehicleTypes = getAvailableVehicleTypes();
        application.setVehicleTypes(vehicleTypes);
        application.setNumberOfVisitor(30);
        application.runApplication();
    }
}
    

