import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Example1 {
    Set<Integer> set_1 = new HashSet<>();
    Set<Integer> set_2 = new HashSet<>();

    public void generate(){
        Random rand = new Random();
        int upperbound = Integer.MAX_VALUE;
        int tmp;

        for (int i=1; i<=200000; i++){
            do {
                tmp = rand.nextInt(upperbound);
            }
            while (set_1.contains(tmp));
            set_1.add(tmp);

            do {
                tmp = rand.nextInt(upperbound);
            }
            while (set_2.contains(tmp));
            set_2.add(tmp);
        }

    }

    public Set<Integer> union(){
        Set<Integer> setTmp = new HashSet<>(set_1);
        setTmp.addAll(set_2);
        return setTmp;
    }

    public Set<Integer> intersection(){
        Set<Integer> setTmp = new HashSet<>();
        for (int x: set_2)
            if (set_1.contains(x)) {
                setTmp.add(x);
            }
        return setTmp;
    }
}
