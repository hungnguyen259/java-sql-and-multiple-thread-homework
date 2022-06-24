import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.Random;

public class Example4 {
    private int distance, numberOfPoints;
    private int x, y;

    public Example4 (int x, int y, int distance, int numberOfPoints){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.numberOfPoints = numberOfPoints;
    }

    public ArrayList<Tuple2<Integer, Integer>> generate(){
        ArrayList<Tuple2<Integer, Integer>> list = new ArrayList<>();
        Random random = new Random();
        int randX, randY;
        int distanceY;
        for (int i=1; i<=numberOfPoints; i++){
            randX = random.nextInt(2*distance + 1) + x - distance;
            distanceY = (int) Math.sqrt(distance*distance - (x - randX)*(x - randX));
            randY = random.nextInt(2*distanceY + 1) + y - distanceY;
            list.add(new Tuple2(randX, randY));
        }
        return list;
    }
}


