import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Example3 {
    public static void main(String[]args){
        Map<String, Integer> map = new HashMap<>();
        List<Future<Map<String, Integer>>> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        File dir = new File("./src/main/resources/InputExample3");
        File[] files = dir.listFiles();
        Callable<Map<String, Integer>> callableWorker;
        Future<Map<String, Integer>> future;

        for (File file: files){
            callableWorker = new Example2(file);
            future = executorService.submit(callableWorker);
            list.add(future);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Waiting ...
        }

        for (Future<Map<String, Integer>> f: list){
            try {
                f.get().forEach(
                        (key, value) -> {
                            Integer tmp = map.get(key);
                            map.put(key, (tmp==null) ? value : tmp + (Integer) value);
                        }
                );
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        //map.forEach((key, value) -> System.out.println(key + " " + value));
        List<Map.Entry<String, Integer>> listSorted = new ArrayList<>(map.entrySet());
        listSorted.sort(Map.Entry.comparingByValue());
        if (listSorted.size()<=10) {
            System.out.println("Top 10 words appear at least:");
            listSorted.forEach(
                    (e) -> System.out.println(e.getKey() + ": " + e.getValue())
            );
            System.out.println("Top 10 words appear most often:");
        }
        else {
            System.out.println("Top 10 words appear at least:");
            ListIterator<Map.Entry<String, Integer>> listIterator = listSorted.listIterator();
            int count = 0;
            do {
                Map.Entry<String, Integer> entry = listIterator.next();
                System.out.println(entry.getKey() + " " + entry.getValue());
                count++;
            }
            while (count<10);
            System.out.println("Top 10 words appear most often:");
            listIterator = listSorted.listIterator(listSorted.size());
            do {
                Map.Entry<String, Integer> entry = listIterator.previous();
                System.out.println(entry.getKey() + " " + entry.getValue());
                count--;
            }
            while (count>0);
        }

    }
}
