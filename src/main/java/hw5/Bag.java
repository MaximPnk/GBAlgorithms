package hw5;

import java.util.*;

public class Bag {

    public static void main(String[] args) {
        List<Thing> things = getThings();
        List<Thing> try1 = takeEverythingAndRun(8, things);
        List<Thing> try2 = takeEverythingAndRun(1, things);

        System.out.println(try1);
        System.out.println(try1.stream().mapToInt(Thing::getPrice).sum());
        System.out.println(try2);
        System.out.println(try2.stream().mapToInt(Thing::getPrice).sum());
    }

    private static List<Thing> getThings() {
        List<Thing> things = new ArrayList<>();

        things.add(new Thing("Book", 600, 1));
        things.add(new Thing("Binoculars", 5000, 2));
        things.add(new Thing("Medicine", 1500, 4));
        things.add(new Thing("Notebook", 40000, 2));
        things.add(new Thing("Hat", 500, 1));

        return things;
    }

    private static List<Thing> takeEverythingAndRun(int maxWeight, List<Thing> things) {
        List<List<Thing>> options = new ArrayList<>();
        anagram(options, things);

        return options.stream().distinct()
                    .filter(list -> list.stream().mapToInt(Thing::getWeight).sum() <= maxWeight)
                    .max(Comparator.comparingInt(list -> list.stream().mapToInt(Thing::getPrice).sum()))
                    .orElse(Collections.emptyList());
    }

    private static void anagram(List<List<Thing>> options, List<Thing> things) {
        if (things.size() == 1) {
            options.add(new ArrayList<>(things));
        } else {
            for (int i = 0; i < things.size(); i++) {
                options.add(new ArrayList<>(things));
                anagram(options, things.subList(1, things.size()));
                things.add(things.remove(0));
            }
        }
    }


}
