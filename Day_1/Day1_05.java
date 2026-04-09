// 2D Array Rotation Clockwise 90 degrees
// Step 1: Transpose the matrix
// Step 2: Reverse each row
// Modifications: 
// 1. Add the coordinates of the elements after rotation.check whether odd or even.
//    Find difference between sum of elements at coordinates whose sum was odd and whose sum was even.

import java.util.*;

public class Day1_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (square matrix n x n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        rotateMatrix(matrix);

        System.out.println("Rotated Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Check coordinates and calculate sums
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    evenSum += matrix[i][j];
                } else {
                    oddSum += matrix[i][j];
                }
            }
        }

        System.out.println("Difference between sums: " + (oddSum - evenSum));


        sc.close();
    }

    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}