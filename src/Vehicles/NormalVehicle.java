/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import exceptions.NewException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO ADMIN
 */
public class NormalVehicle extends Vehicle {
    @Override
    protected Map<Integer, String> getDefinedEngineTypes() {
        HashMap<Integer, String> engineTypes = new HashMap<>();
        engineTypes.put(1, "oil");
        engineTypes.put(2, "gas");
        engineTypes.put(3, "diesel");
        return engineTypes;
    }

    public void initialize() {
        System.out.println("Enter details for normal vehicle");
        super.initialize();
    }

    public void show() {
        System.out.println("Vehicle type: Normal");
        super.show();
    }
}
