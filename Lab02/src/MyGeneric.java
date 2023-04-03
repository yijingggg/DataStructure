public class MyGeneric <E>{

    private E e;

    public MyGeneric(){
        //no arg constructor
    }

    public MyGeneric(E e){
        this.e = e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public E getE(){
        return e;
    }

    public static void main(String [] args){
        MyGeneric <String> strObj = new MyGeneric<>("Hola");
        MyGeneric <Integer> intObj = new MyGeneric<>(100);

        System.out.println("String object: "+strObj.getE());
        System.out.println("Integer object: "+intObj.getE());
    }
}
