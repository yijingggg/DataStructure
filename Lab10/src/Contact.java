public class Contact implements Comparable<Contact>{
    private String firstName, lastName, phone;

    public Contact(String first, String last, String telephone){
        firstName = first;
        lastName = last;
        phone = telephone;
    }

    public String toString(){
        return String.format("%-10s,%-10s%15s",lastName ,firstName ,phone);
    }

    public int compareTo(Contact other){
        int result;
        if(lastName.equals(other.lastName))
            result = firstName.compareTo(other.firstName);
        else
            result = lastName.compareTo(other.lastName);
        return result;
    }
}
