import java.io.*;

public class CharEncodingTest{
    public static void main(String[] args){
        try{
            File fileDir = new File("./input.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

            String str;

            while((str = in.readLine()) != null){
                System.out.println(str);
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
