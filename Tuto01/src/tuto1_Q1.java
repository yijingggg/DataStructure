public class tuto1_Q1 {
    public static void main(String[] args) {

        Telephone[] telephone = new Telephone[5];

        for (int i = 0; i < telephone.length; i++) {

            telephone[i] = new Telephone("03", 79676300 + i);
            System.out.println(telephone[i].makeFullNumber());
        }
    }
}

class Telephone {

    private String areaCode;
    private int number;
    private int numberOfTelephoneObject = 0;

    public Telephone(String areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject ++;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfTelephoneObject() {
        return numberOfTelephoneObject;
    }

    public String makeFullNumber() {
        return getAreaCode() + "-" + getNumber();
    }
}