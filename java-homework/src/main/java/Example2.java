import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Example2 implements Callable<Map<String, Integer>> {
    String text = "";
    Map<String, Integer> map = new HashMap<>();

    private File file;

    public Example2(File file){
        this.file = file;
    }

    public void readFile(){
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
                stringBuffer.append('\n');
            }
            fileReader.close();
            text = stringBuffer.toString();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Map<String, Integer> call(){
        this.readFile();
        text = text.trim();
        String[] arrayOfWords = text.split("[.,()?''`!-: \\t \\n \\s]+");
        for (String word: arrayOfWords){
            Integer tmp = map.get(word);
            map.put(word, (tmp == null) ? 1 : tmp+1);
        }
        return map;
    }
}
