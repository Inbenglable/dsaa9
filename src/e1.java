import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class e1 {
    public static void main(String[] args) {
        QReader input=new QReader();
        QWriter output=new QWriter();
        int n=input.nextInt();
        int m=input.nextInt();
        int q=input.nextInt();

        int [][]adj =new int[n][n];//1则有，0无

        for (int i=0;i<m;i++){
            int a1=input.nextInt()-1;
            int a2=input.nextInt()-1;

            adj[a1][a2]=1;
            adj[a2][a1]=1;
        }
        for (int i=0;i<q;i++){
            int a1=input.nextInt()-1;
            int a2=input.nextInt()-1;
            if (adj[a1][a2]==1){
                output.println("Yes");
            }
            else{
                output.println("No");
            }
        }
output.close();
    }
}
