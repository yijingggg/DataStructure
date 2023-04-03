public class T2Q1 {
    public static void main(String[] args) {

        Container<Integer> integerContainer = new Container<>();
        Container<String> stringContainer = new Container<>();

        integerContainer.add(50);
        stringContainer.add("Java");

        System.out.println("Value of integer: " + integerContainer.retrieve());
        System.out.println("Value of String: " + stringContainer.retrieve());
    }
}

class Container <T>{
    private T t;

    public Container(){

    }

    public void add(T item){
        this.t = item;
    }

    public T retrieve(){
        return t;
    }
}