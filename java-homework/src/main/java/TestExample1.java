import java.util.HashSet;
import java.util.Set;

public class TestExample1 {
    public static void main(String [] args){
        Example1 example1 = new Example1();
        Set<Integer> unionSet;
        Set<Integer> intersectionSet;

        example1.generate();
        unionSet = example1.union();
        intersectionSet = example1.intersection();
        System.out.println("Number elements of union Set: " + unionSet.size());
        System.out.println("Number elements of intersection Set: " + intersectionSet.size());
    }

}
