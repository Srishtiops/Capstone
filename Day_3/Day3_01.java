
// public class Day3_01 {
//     public static void main(String[] args) {
//         int n = 40;

//         for(int i=2; i<40; i++){
//             System.out.println(i+ " : " +isPrime(i));
//         }
//     }
//     static boolean isPrime(int number){
//       int c = 2;
//         while(c < number){
//             if(number % c == 0){
//                 return false;
//             }
//             c++;
//         }
//         return true;
//     }

// }

//TIME COMPLEXITY: O(n*root(n))
public class Day3_01 {
    public static void main(String args[]){
        int n=40;
        for(int i=2;i<=n;i++)// 2 ---> n
        {
             System.out.println(i+" : "+isPrime(i));
        
        }

    }
    static boolean isPrime(int num){
        int c=2;
        while(c*c<=num){
           if(num%c==0){
               return false;
           }
           c++;
    }
    return true;
}
}
