/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import java.util.Map;
import InterfaceInput.Input;
import exceptions.NewException;
/**
 *
 * @author LENOVO ADMIN
 */
public abstract class Vehicle {
    private String modelNumber;
    private String engineType;
    private Integer enginePower;
    private Integer tireSize;

    private final Map<Integer, String> engineTypes;

    public Vehicle() {
        this.engineTypes = this.getDefinedEngineTypes();
    }

    public String getModelNumber() {
        return this.modelNumber;
    }

     public void setModelNumber(String modelNumber) throws NewException {
        if(modelNumber.isEmpty()) {
            throw new NewException("Wrong input");
        }
        this.modelNumber = modelNumber;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer typeNumber) throws NewException {
        String type = this.engineTypes.get(typeNumber);
        if(type == null) {
            //System.out.println("Hi");
            throw new NewException("Wrong input");
        }
        this.engineType = type;
    }

    public Integer getEnginePower() {
        return this.enginePower;
    }

    public void setEnginePower(Integer horsePower) throws NewException {
        if(horsePower <= 0) {
            throw new NewException("Horse power can not be 0 or negative");
        }
        this.enginePower = horsePower;
    }

    public Integer getTireSize() {
        return this.tireSize;
    }

public void setTireSize(Integer tireSize) throws NewException {
        if(tireSize <= 0) {
            throw new NewException("Tier size can not be 0 or negative");
        }
        this.tireSize = tireSize;
    }

    public Map<Integer, String> getEngineTypes() {
        return this.engineTypes;
    }

    protected abstract Map<Integer, String> getDefinedEngineTypes();

    public void initialize() {
        System.out.print("Enter model number: ");
        Input.assignValueToField(() -> {
            String modelNumber = Input.takeStringInput();
            this.setModelNumber(modelNumber);
        });

        if(this.engineTypes.size() > 1) {
            System.out.println("Enter engine type");
            for (Map.Entry<Integer, String> entry : this.getEngineTypes().entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
            Input.assignValueToField(() -> {
                int choice = Input.takeIntegerInput();
                this.setEngineType(choice);
            });
        }
        else {
            this.engineType = this.engineTypes.get(1);
        }

        System.out.print("Set engine power (hp): ");
        Input.assignValueToField(() -> {
            int enginePower = Input.takeIntegerInput();
            this.setEnginePower(enginePower);
        });

        System.out.print("Set tire size (inches): ");
        Input.assignValueToField(() -> {
            int tireSize = Input.takeIntegerInput();
            this.setTireSize(tireSize);
        });
    }

    public void show() {
        System.out.println("Model number: " + this.getModelNumber());
        System.out.println("Engine type: " + this.getEngineType());
        System.out.println("Engine power: " + this.getEnginePower() + " hp");
        System.out.println("Tire size: " + this.getTireSize() + "inch's");
    }
}
