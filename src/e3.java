import java.util.HashSet;
import java.util.Scanner;

public class e3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        node graph[]=new node[n];
        for (int i=0;i<n;i++){
            graph[i]=new node();
        }
        for (int i=0;i<m;i++) {
            int a = input.nextInt() - 1;
            int b = input.nextInt() - 1;
            if (a == b) {
                System.out.println("Bad");
                return;
            }
            if (graph[a].neighbor.contains(graph[b])) {
                System.out.println("Bad");
                return;
            }
            if (graph[b].neighbor.contains(graph[a])) {
                System.out.println("Bad");
                return;
            }
            graph[a].neighbor.add(graph[b]);
            graph[b].neighbor.add(graph[a]);
        }
        for (int i=0;i<n;i++){
            if (graph[i].isVisited!=1){
                if (!traversal(graph[i])){
                    System.out.println("Bad");
                    return;
                }
            }
        }
        System.out.println("Good");
        return;
    }

    public static boolean traversal(node cur){
        cur.isVisited=1;
        for (node nei: cur.neighbor){
            if (nei.isVisited==1){
                return false;
            }
            else{
                nei.neighbor.remove(cur);
                if (!traversal(nei)){
                    return false;
                }
            }
        }
        return true;
    }
}
class node{
    int isVisited=0;
    HashSet<node> neighbor=new HashSet<>();
}
