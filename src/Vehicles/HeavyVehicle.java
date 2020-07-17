/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;


import InterfaceInput.Input;
import exceptions.NewException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO ADMIN
 */
public class HeavyVehicle extends Vehicle {
    private Double weight;

    @Override
    protected Map<Integer, String> getDefinedEngineTypes() {
        Map<Integer, String> engineTypes = new HashMap<>();
        engineTypes.put(1, "diesel");
        return engineTypes;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) throws NewException {
        if(weight <= 0) {
            throw new NewException("can not be 0 or negative");
        }
        this.weight = weight;
    }

    public void initialize() {
        System.out.println("Enter details for heavy vehicle");
        super.initialize();

        System.out.print("Set weight: ");
        Input.assignValueToField(() -> {
            double weight = Input.takeDoubleInput();
            this.setWeight(weight);
        });
    }

    public void show() {
        System.out.println("Vehicle type: Heavy");
        super.show();
        System.out.println("Weight: " + this.getWeight());
    }
}
