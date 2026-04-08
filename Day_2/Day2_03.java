class Order{
    int orderId;
    String customerType;
    double orderValue;
    int deliveryTime;

    public Order(int orderId, String customerType , double orderValue, int deliveryTime){
        this.orderId = orderId;
        this.customerType = customerType;
        this.orderValue = orderValue;
        this.deliveryTime = deliveryTime;
    }
    public String toString(){
        return "{"+ orderId + ", "+customerType+", "+orderValue+", "+deliveryTime+"}";
    }
}

public class Day2_03 {

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Regular", 500.0, 5),
            new Order(102, "Prime", 300.0, 3),
            new Order(103, "Prime", 700.0, 4),
            new Order(104, "Regular", 500.0, 2),
            new Order(105, "Prime", 700.0, 2)
        };
        mergeSort(orders, 0, orders.length - 1);
        for(Order o : orders){
            System.out.println(o);
        }
    }

    static void mergeSort(Order[] orders, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(orders, left, mid);
            mergeSort(orders, mid + 1, right);
            merge(orders, left, mid, right);
        }
    }

    static void merge(Order[] orders, int left, int mid, int right) {
        int n1 = mid - left + 1;   //length of the first halves
        int n2 = right - mid;    //length of the second halves

        //create two temporary arrays
        Order[] L = new Order[n1];
        Order[] R = new Order[n2];
        
        //traverse the left array from 0 to n1
        for (int i = 0; i < n1; i++){
            //copying the elements
            L[i] = orders[left + i];
        }

        //traverse the right array from 0 to n2
        for (int j = 0; j < n2; j++){
            R[j] = orders[mid + 1 + j];
        }

        //create some pointers
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (compare(L[i], R[j]) <= 0) {
                orders[k++] = L[i++];
            } else {
                orders[k++] = R[j++];
            }
        }

        while (i < n1) {
            orders[k++] = L[i++];
        }

        while (j < n2) {
            orders[k++] = R[j++];
        }

        //next while loops for the remaining data
        while(i< n1){
            orders[k++] = L[i++];
        }
        while(j< n2){
            orders[k++] = R[j++];
        }

    }
    static int compare(Order a, Order b){
        //1 Prime first
        if(!a.customerType.equals(b.customerType)){
            return a.customerType.equals("Prime") ? -1 : 1;
        }

        //2. higher order value first
        if(a.orderValue != b.orderValue){   
            return Double.compare(b.orderValue, a.orderValue);
        }

        //3. Shorter delivery time first
        if(a.deliveryTime != b.deliveryTime){
            return Integer.compare(a.deliveryTime, b.deliveryTime);
        }
        return 0; //maintain the stability
    }

}
