package main;

import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmnt {

    // Goods Bogie model
    public static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }
    }

    public boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        // allMatch returns true if all elements satisfy the predicate
        return bogies.stream().allMatch(bogie -> {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are flexible
        });
    }

    public static void main(String[] args) {
        UseCase12TrainConsistMgmnt app = new UseCase12TrainConsistMgmnt();
        System.out.println("=========================================");
        System.out.println(" UC12 Safety Compliance Check for Goods Bogies ");
        System.out.println("=========================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // Rule violation

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(b -> System.out.println(b.getType() + " -> " + b.getCargo()));

        boolean isSafe = app.checkSafetyCompliance(goodsBogies);
        System.out.println("\nSafety Compliance Status: " + isSafe);
        System.out.println("Train formation is " + (isSafe ? "SAFE." : "NOT SAFE."));
        System.out.println("\nUC12 safety validation completed...");
    }
}