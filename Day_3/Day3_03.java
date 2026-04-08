//Tower Of Hanoi
public class Day3_03 {
    public static void main(String[] args) {        
        int n = 4; //number of disks
        play(n, 'A', 'B', 'C');

    }

    static void play(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        play(n - 1, source, destination, helper);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        play(n - 1, helper, source, destination);
    }
}
