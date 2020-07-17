/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;
import exceptions.NewException;
import InterfaceInput.Input;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO ADMIN
 */
public class SportsVehicle extends Vehicle {
    private Boolean turbo;

    @Override
    protected Map<Integer, String> getDefinedEngineTypes() {
        Map<Integer, String> engineTypes = new HashMap<>();
        engineTypes.put(1, "oil");
        return engineTypes;
    }

    public Boolean getTurbo() {
        return this.turbo;
    }

    public void setTurbo(Integer choice) throws NewException {
        if(choice != 1 && choice != 2) {
            throw new NewException("Wrong input");
        }
        this.turbo = choice == 1;
    }

    public void initialize() {
        System.out.println("Enter details for sports vehicle");
        super.initialize();
        System.out.println("Has turbo?\n1. Yes\n2. No");
        Input.assignValueToField(() -> {
            int choice = Input.takeMenuOptionInput(2);
            this.setTurbo(choice);
        });
    }

    public void show() {
        System.out.println("Vehicle type: Sports");
        super.show();
        if(this.getTurbo()) {
            System.out.println("Has turbo: Yes");
        }
        else {
            System.out.println("Has turbo: No");
        }
    }
}
