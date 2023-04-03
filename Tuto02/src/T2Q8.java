import java.util.ArrayList;

public class T2Q8 {
    public static void displayList(ArrayList<?> list){
        for(Object item:list){
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();

        // add some elements to the lists
        numOfCars.add(10);
        numOfCars.add(20);
        numOfCars.add(30);

        milesPerHour.add(60.0);
        milesPerHour.add(70.0);
        milesPerHour.add(80.0);

        System.out.println("Number of cars: ");
        displayList(numOfCars);
        System.out.println("\nMiles per hour: ");
        displayList(milesPerHour);
    }
}

