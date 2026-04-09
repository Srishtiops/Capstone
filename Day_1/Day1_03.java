// Q: Employee Management System
//    (Diamond Structure)
// This is a classic diamond structure A-->B,C-->D structure

// Q. Create a real-time employee notification system.
// * A = Employee
// * B = EmailNotification
// * C = SMSNotification
// * D = Manager
// Both B and C inherit from A.
interface Employee {
    void notifyEmployee();
}
interface EmailNotification {
    default void notifyEmployee() {
        System.out.println("Notification sent via Email.");
    }
}
interface SMSNotification {
    default void notifyEmployee() {
        System.out.println("Notification sent via SMS.");
    }
}


public class Day1_03 {
    public static void main(String[] args) {
        
    }
}