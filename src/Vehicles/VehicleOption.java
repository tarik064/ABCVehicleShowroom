/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;
/**
 *
 * @author LENOVO ADMIN
 * @param <T>
 */
public class VehicleOption<T extends Vehicle> {
    private final Class<T> cls;
    private final String name;

    public VehicleOption(Class<T> cls, String name) {
        this.cls = cls;
        this.name = name;
    }

    public Class<T> getCls() {
        return cls;
    }

    public String getName() {
        return name;
    }

    public Vehicle getInstanceByClass() {
        try {
            return  cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}
