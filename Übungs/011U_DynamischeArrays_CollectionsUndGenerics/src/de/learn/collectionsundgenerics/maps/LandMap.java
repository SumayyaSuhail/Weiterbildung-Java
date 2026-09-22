package de.learn.collectionsundgenerics.maps;


import java.util.HashMap;
import java.util.Map;

public class LandMap {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Deutschland",  "Berlin");
        capitals.put("Indien", "New Delhi");
        capitals.put("Österreich", "Wien");
        capitals.put("England", "London");

        System.out.println(capitals.size());
        capitals.forEach((land, stadt) -> System.out.println(land + "-" + stadt));
        System.out.println();

        capitals.remove("England");
        capitals.remove("Indien", "New Delhi");
        capitals.forEach((land, stadt) -> System.out.println(land + "-" + stadt));
        System.out.println();

        System.out.println(capitals.get("Deutschland"));
    }
}
