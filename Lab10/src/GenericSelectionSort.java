public class GenericSelectionSort {
    public static void main(String[] args) {
        Contact[] friends = new Contact[7];
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[1] = new Contact("Alice", "Johnson", "610-555-1234");
        friends[2] = new Contact("Bob", "Davis", "610-555-5678");
        friends[3] = new Contact("Emily", "Brown", "610-555-9012");
        friends[4] = new Contact("David", "Miller", "610-555-3456");
        friends[5] = new Contact("Sarah", "Wilson", "610-555-7890");
        friends[6] = new Contact("Michael", "Taylor", "610-555-2345");

        selectionSort(friends);
        for (Contact friend : friends) {
            System.out.println(friend);
        }
    }

    public static<T extends Comparable<T>> void selectionSort(T[] list){
        for(int i=0;i<list.length;i++){
            T currentMin = list[i];
            int currentMinIndex = i;

            for(int j=i+1;j<list.length;j++){
                if(currentMin.compareTo(list[j])>0){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            T temp = list[i];
            list[i] = list[currentMinIndex];
            list[currentMinIndex] = temp;
        }
    }
}