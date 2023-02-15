import java.io.*;
import java.util.StringTokenizer;

public class e2 {
    static int[]node;
    static direc []graphic;
    static direc []graphic_point;
    static int [] graphic_num;
    public static void main(String[] args) {
        QReader2 input=new QReader2();
        QWriter2 output=new QWriter2();

        int n=input.nextInt();
        node=new int[n];
        graphic=new direc[n];
        for (int i=0;i<n;i++){
            node[i]=i;
            graphic[i]=new direc(i);
        }

        int m=input.nextInt();
        graphic_point=new direc[n];
        graphic_num =new int[n];
        for (int i=0;i<n;i++){
            graphic_point[i]=graphic[i];
            graphic_num[i]=1;
        }

        for (int i=0;i<m;i++){
            int a1=input.nextInt()-1;
            int a2=input.nextInt()-1;
            graphic_point[a2].next=new direc(a1);
            graphic_point[a2]=graphic_point[a2].next;
            graphic_num[a2]++;
        }
        for (int i=n-1;i>=0;i--){
            passAll(i);
        }
        for (int i=0;i<n;i++){

            output.print(String.format("%d ",node[i]+1));
        }
        output.close();
    }
    public static void passAll(int start){
        direc cur=graphic[start];
        for (int i = 0; i< graphic_num[start]; i++){
                if (node[cur.index]<node[start]){
                    node[cur.index]=node[start];
                    passAll(cur.index);
                }
                cur=cur.next;
        }
    }
}
class direc{
    direc next;
    int index;
    public direc(int index){
        this.index=index;
    }
}
class QReader2 {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter2 implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
