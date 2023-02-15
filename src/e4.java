import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class e4 {
    public static void main(String[] args) {
        QReader input=new QReader();
        QWriter output=new QWriter();

        int n=input.nextInt();
        Integer[] array =new Integer[n];
        for (int i=0;i<n;i++){
            array[i]=input.nextInt();
        }
        Arrays.sort(array,Comparator.reverseOrder());

        long sum=0;
        for (int i=0;i<n;i++){
            sum+=array[i];
        }
        if (sum%2!=0){
            output.println("NO");
            output.println("NO");
            output.println("NO");
            output.close();
            return;
        }
        for (int i=0;i<n;i++){
            if (array[i]<0){
                output.println("NO");
                output.println("NO");
                output.println("NO");
                output.close();
                return;
            }
        }

        long[] hzh =new long[n];
        hzh[n-1]=array[n-1];
        for (int i=n-2;i>=0;i--) {
            hzh[i]=hzh[i+1]+array[i];
        }

        for (int i=0;i<n;i++){
            long sum1;
            if (i!=n-1){
            sum1=hzh[0]-hzh[i+1];}
            else{
                sum1=hzh[0];
            }
            long sum2=0;
            sum2+= (long) i *(i+1);

            int k=Arrays.binarySearch(array,i,Comparator.reverseOrder());
            if (k<0){
                k=-k-1-1;//为比i大的最右数组index
            }
            if (k>i){
                sum2+= (long) (k - i) *(i+1);
            }
            if (k>i){
                if (k<n-1){
            sum2+=hzh[k+1];}
            }
            else{
                if (i<n-1){
                sum2+=hzh[i+1];
                }
            }
            if (sum1>sum2){
                output.println("YES");
                output.println("NO");
                output.println("NO");
                output.close();
                return;
            }
        }
        if (hzh[0]== 2L *n-2){
        for (int i=0;i<n;i++){
            if (array[i]==0){
                  output.println("YES");
                  output.println("YES");
                  output.println("NO");
                  output.close();
                  return;
              }
            }
            output.println("YES");
            output.println("YES");
            output.println("YES");
            output.close();
            return;
        }
        output.println("YES");
        output.println("YES");
        output.println("NO");

        output.close();
    }
}
class QReader {
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

class QWriter implements Closeable {
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
