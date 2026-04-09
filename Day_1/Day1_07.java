// Jack is always excited about Sunday.It is his favorite day when he gets to play all day.
// So everytime month starts,he counts the number of Sundays in that month. 
// Assuming first day of month can be any day of the week.
// Count the number of Sundays he will get to play within n number of days.

import java.util.*;
public class Day1_07{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of days in the month: ");
        int days = sc.nextInt();
        System.out.print("Enter the starting day of the month (1 for Sunday, 2 for Monday, ..., 7 for Saturday): ");
        int startDay = sc.nextInt();

        int sundays = countSundays(days, startDay);
        System.out.println("Jack will get to play on " + sundays + " Sundays.");
        sc.close();
    }
    static int countSundays(int days, int startDay) {
        int sundays = 0;
        for (int i = 1; i <= days; i++) {
            if ((startDay + i - 1) % 7 == 1) { 
                sundays++;
            }
        }
        return sundays;
    }
}