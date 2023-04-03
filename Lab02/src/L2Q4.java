public class L2Q4 <T>{
    public static void main(String[] args) {

        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }

    public static <T extends Comparable<T>> String minmax(T [] arr){
         if(arr==null || arr.length==0){
             return "";
         }

         T minValue = arr[0];
         T maxValue = arr[0];
         for(int i =1; i<arr.length; i++){
             if((arr[i].compareTo(minValue))<0){
                 minValue = arr[i];
             }
             if((arr[i].compareTo(maxValue))>0){
                 maxValue = arr[i];
             }
         }

        return "Min = " + minValue + "\tMax = " +maxValue;
    }
}
