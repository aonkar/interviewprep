package com.example.demo5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BatSeller {

    public static void main(String[] args) {
        final Map<String, WeightPrice> batInfo = Map
                .of("b1", new WeightPrice(1, 2),
                        "b2", new WeightPrice(3, 5),
                        "b3", new WeightPrice(9, 5),
                        "b4", new WeightPrice(7, 9),
                        "b5", new WeightPrice(985, 5),
                        "b6", new WeightPrice(65, 8));
        final Map<String, WeightPrice> cricketerInfo = Map
                .of("c1", new WeightPrice(78, 2),
                        "c2", new WeightPrice(9, 7),
                        "c3", new WeightPrice(5, 9),
                        "c4", new WeightPrice(7, 5),
                        "c5", new WeightPrice(9, 5));
        final List<List<String>> batLists = new ArrayList<>();

        cricketerInfo.forEach((key, weightPrice) -> {
            final List<String> batList = batInfo.keySet()
                    .stream()
                    .filter(batKey -> batInfo.get(batKey).getPrice() <= weightPrice.getPrice()
                            && weightPrice.getWeight() <= batInfo.get(batKey).getWeight())
                    .collect(Collectors.toList());
            if (!batList.isEmpty()) {
                batLists.add(batList);
            }
        });
        System.out.println(batLists);
        final Set<String> availableBats = new HashSet<>();
        batLists.forEach(batList -> batList.forEach(bat -> availableBats.add(bat)));
        System.out.println(availableBats);

    }

    public static class WeightPrice {
        private int weight;
        private int price;

        public WeightPrice(final int weight,
                           final int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }
    }
}
