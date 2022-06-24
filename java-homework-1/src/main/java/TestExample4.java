import io.vavr.Tuple2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TestExample4 {
    public static void main(String[] args){
        ArrayList<Tuple2<Integer, Integer>> list = new ArrayList();
        Example4 data1 = new Example4(800, 800, 400, 8000);
        list.addAll(data1.generate());
        Example4 data2 = new Example4(4000, 800, 500, 10000);
        list.addAll(data2.generate());
        Example4 data3 = new Example4(2400, 2400, 600, 12000);
        list.addAll(data2.generate());

        Collections.shuffle(list);

        File file = new File("./src/main/resources/output.txt");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            for (Tuple2<Integer, Integer> tuple: list) {
                fileWriter.write(tuple._1() + " " + tuple._2() + "\n");
            }
            fileWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
