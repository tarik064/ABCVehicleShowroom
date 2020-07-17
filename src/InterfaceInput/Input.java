/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceInput;

/**
 *
 * @author LENOVO ADMIN
 */

import Vehicles.Vehicle;
import Vehicles.VehicleOption;
import exceptions.NewException;
import java.util.Map;
import java.util.Scanner;

public class Input {
    public static double takeInput(Boolean returnInt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            
                double input = returnInt ? scanner.nextInt() : scanner.nextDouble();
                return input;
            
        }
        
    }

    public static double takeDoubleInput() {
        return takeInput(false);
    }

    public static int takeIntegerInput() {
        return (int) takeInput(true);
    }

    public static String takeStringInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static Object getObjectByInputForVehicleType(Map<Integer, VehicleOption<? extends Vehicle>> map) {
        while (true) {
           
                int input = takeIntegerInput();
                Object object = map.get(input);
             
                return object;
           
        }
    }

    public static int takeMenuOptionInput(int optionLimit) {
        while (true) {
           
                int input = takeIntegerInput();
              
                return input;
          
        }
    }

    /**
     *
     * @param fieldTask
     */
    public static void assignValueToField(Interface fieldTask) {
        while (true) {
           try {
                fieldTask.execute();
                break;
            }
            catch (NewException ex) {
                ex.getMessage();
            }
        }
    }
}
