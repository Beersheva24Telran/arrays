package telran.util.test;

import java.util.Comparator;

public class ComparatorNumbers implements Comparator<Integer>{

    @Override
    public int compare(Integer arg0, Integer arg1) {
        return Integer.compare(arg0, arg1);
    }

}
