import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GoldExperience {
    public static Stack<Stack<String>> minimumAnimals(List<String> parcels, List<String> owners) {
        Stack<Stack<String>> animals = new Stack<>();

        for (String owner : owners) {
            Stack<String> ownerStack = null;

            for (String parcel : parcels) {
                if (parcel.equals(owner)) {
                    if (ownerStack == null) {
                        ownerStack = new Stack<>();
                        animals.push(ownerStack);
                    }
                    ownerStack.push(parcel);
                }
            }
        }

        return animals;
    }

    private static int calculateMinAnimals(List<String> parcels, List<String> owners) {
        Map<String, Integer> ownerCounts = new HashMap<>();

        for (String owner : owners) {
            ownerCounts.put(owner, ownerCounts.getOrDefault(owner, 0) + 1);
        }

        int maxOwnerCount = 0;
        for (String owner : ownerCounts.keySet()) {
            int count = ownerCounts.get(owner);
            maxOwnerCount = Math.max(maxOwnerCount, count);
        }

        return maxOwnerCount;
    }



    public static void main(String[] args) {
        final int N = 6;
        final List<List<String>> parcelList = List.of(
                List.of("Jotaro", "Joseph", "Jolyne", "Jotaro", "Joseph",
                        "Jolyne", "Jotaro", "Joseph", "Jolyne", "Jotaro", "Joseph", "Jolyne",
                        "Jotaro", "Joseph", "Jolyne"),
                List.of("DIO"),
                List.of("Babyface", "Beach Boy", "Metallica", "King Crimson", "Beach Boy", "The Grateful Dead", "Beach Boy"),
                List.of("Whitesnake", "Whitesnake", "Whitesnake",
                        "Whitesnake", "Made in Heaven", "Made in Heaven", "Made in Heaven", "Made in Heaven", "C-Moon", "C-Moon", "C-Moon", "C-Moon"),
                List.of("Formaggio", "Formaggio", "Prosciutto", "Illuso",
                        "Melone", "Pesci", "Formaggio", "Ghiaccio", "Pesci", "Sale"),
                List.of("Koichi", "Hayato", "JoJo", "Iggy", "Giorno",
                        "Emporio", "Foo", "DIO", "DIO", "DIO", "DIO", "DIO", "Akira", "Bucciarati",
                        "Akira", "Akira")
        );
        final List<List<String>> ownerList = List.of(
                List.of("Jolyne", "Joseph", "Jotaro"),
                List.of("DIO"),
                List.of("Babyface", "Beach Boy", "King Crimson",
                        "Metallica", "The Grateful Dead"),
                List.of("C-Moon", "Made in Heaven", "Whitesnake"),
                List.of("Formaggio", "Ghiaccio", "Illuso", "Melone",
                        "Pesci", "Prosciutto", "Sale"),
                List.of("Akira", "Bucciarati", "DIO", "Emporio", "Foo",
                        "Giorno", "Hayato", "Iggy", "JoJo", "Koichi")
        );
        for (int i = 0; i < N; i++) {
            Stack<Stack<String>> animals = minimumAnimals(parcelList.get(i),
                    ownerList.get(i));
            System.out.printf("Case %d\n", i + 1);
            System.out.printf("Number of animals: %d\n", animals.size());
            for (int j = 0; j < animals.size(); j++)
                System.out.printf("Animal %d: %s\n", j + 1, animals.get(j));
            System.out.println();
        }
    }
}
