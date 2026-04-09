// Q: Course schedular order(SImple DAG problem)
// Real : planning course completion order in a university
// Problem : given a course (0 to n-1) and prerequisites , return a valid order.
//Kahn's algorithm -  BFS based topological sort
import java.util.*;
public class Day4_01{

    public static void main(String[] args) {    
        // n--> number of nodes (o to n-1)
        int n = 4;
        //prereq --> edges(dependencies)
        //meaning : 0 --> 1, 0 --> 2, 1 --> 3, 2 --> 3
        int[][] prereq = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(toposort(n, prereq));
    }
    //Function to perform topological sort using Kahn's algorithm
    static List<Integer> toposort(int n, int[][] prereq){
        // create graph(adjacency list)
        List<List<Integer>> graph = new ArrayList<>();
        // we create agraph like --> graph [[], [], [], []]
        // each index represents a node
        for (int i = 0; i < n ; i++) {
           graph.add(new ArrayList<>());
        }

        //indegree array
        //stores incoming edges count.
        int [] indegree = new int[n];

        //build graph+ indegree
        // for each pair {a,b}
        // b --> a(b must be done before a).

        for(int[] p:prereq){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        //for input -{1,0}, {2,0},{3,1},{3,2}
        //graph becomes :
        // 0 -->[1,2]
        // 1 -->[3]
        //2 -->[3]
        //3 -->[]
        //indegree becomes:[0,1,1,2]

        //Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // add all nodes with indegree 0 
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                //queue initially --> 0
            }
        }
        //Result set
        //stores final topological order
        List<Integer> result = new ArrayList<>();

        //main BFS loop
        while (!q.isEmpty()) { //run until all nodes are processed
            //remove node from queue
            //take node with indegree 0
            int node = q.poll();

            //add to result: this is valid next node in order
            result.add(node);

            //process neighbors
            //go through all nodes dependent on current node
            for(int nei : graph.get(node)){
                //reduce indegree 
                indegree[nei]--;     //dependency is now resolved

                //add new independent nodes
                //if no dependencies left -- > add to queue
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        return result;
    }
}