package main;

// 1. Define the Custom Runtime Exception
class CargoSafetyException extends Exception {
    public CargoSafetyException(String message) {
        super(message);
    }
}

public class UseCase15TrainConsistMgmnt {

    public static class GoodsBogie {
        String type;
        String cargo = "Empty";

        public GoodsBogie(String type) { this.type = type; }

        // 2. Logic to assign cargo with safety checks
        public void assignCargo(String newCargo) throws CargoSafetyException {
            if (type.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Safety Alert: Rectangular bogies cannot carry Petroleum!");
            }
            this.cargo = newCargo;
        }

        public String getCargo() { return cargo; }
    }

    public static void main(String[] args) {
        GoodsBogie rectBogie = new GoodsBogie("Rectangular");

        // 3. Structured Exception Handling
        try {
            System.out.println("Action: Attempting to assign Petroleum to Rectangular bogie...");
            rectBogie.assignCargo("Petroleum");
            System.out.println("Cargo assigned successfully.");
        } catch (CargoSafetyException e) {
            // 4. Handle the error without crashing
            System.err.println("Handled Error: " + e.getMessage());
        } finally {
            // 5. Always execute cleanup/logging
            System.out.println("System: Cargo validation check completed.");
        }

        System.out.println("\nStatus: Program is still running. Next task can proceed...");
    }
}