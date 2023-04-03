public class tuto1_Q4 {
    public static void main(String[] args) {

    }
}

abstract class Vehicle {
    protected double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    abstract void accelerate();

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void pedalToTheMetal() {
        while (true) {
            accelerate();
            if (maxSpeed - currentSpeed == 0) {
                break;
            }
        }
    }
}



