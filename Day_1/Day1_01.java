// Diamond Problem
// Java does not support multiple inheritance with classes
// So this topic is usually demonstrated with interfaces
// Q. A smart home system has deviceA and deviceB. Both devices have a same operation called "turnOn". 
// Sol: SmartDevice implements both methods/inheritance
interface DeviceA {
    default void turnOn() {
        System.out.println("Device A is turned on.");
    }
}
interface DeviceB {
    default void turnOn() {
        System.out.println("Device B is turned on.");
    }
}
class SmartDevice implements DeviceA, DeviceB {
    public void turnOn() {
        DeviceA.super.turnOn(); 
        DeviceB.super.turnOn();
    }
}
public class Day1_01 {
    public static void main(String[] args) {
        SmartDevice op= new SmartDevice();
        op.turnOn();
    }
}