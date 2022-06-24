import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TestExample2 {
    public static void main(String[]args){
        File fileInp = new File("./src/main/resources/file1.txt");
        Example2 example2 = new Example2(fileInp);
        Map map = example2.call();

        try{
            File file = new File("./src/main/resources/output.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            map.forEach((key, value) ->{
                try{
                    fileWriter.write(key + " " + value +"\n");
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            });
            fileWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
