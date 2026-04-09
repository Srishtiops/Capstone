// Infosys Question
// You are given an array A of n integers and q queries.
// Each query can be of the following 2 types:
//    Type 1 Query: (1,l,r) - Replace A[i] with (i-l+1)*A[l] for each index i, where l<=i<=r.
//    Type 2 Query: (2,l,r) - Calculate the sum of the elements in A from index l to r.
//
// Find the sum of answers to all the type 2 queries. Since the answer can be large, return it modulo 10^9 + 7.

import java.util.*;
public class Day1_06{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("\nEnter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter "+(i+1)+" element: ");
            A[i] = sc.nextInt();
        }
        System.out.print("\nEnter the number of queries: ");
        int query = sc.nextInt();
        int totalSum = 0;
        for(int q=1;q<=query;q++){
            System.out.print("\nEnter the type of "+q+" query: ");
            int type = sc.nextInt();
            System.out.print("Enter the start index of "+q+" query: ");
            int L = sc.nextInt();
            System.out.print("Enter the end index of "+q+" query: ");
            int R = sc.nextInt();
            if(type==1){
                for(int i=L;i<=R;i++){
                    A[i]=(i-L+1)*A[L];
                }
            }
            else if(type==2){
                int sum=0;
                for(int i=L;i<=R;i++){
                    sum+=A[i];
                }
                totalSum+=sum;
            }
        }
        System.out.println("Total sum of all type 2 queries is: " + totalSum);
        sc.close();
    }
}

