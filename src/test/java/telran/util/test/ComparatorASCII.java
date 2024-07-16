package telran.util.test;

import java.util.Comparator;

public class ComparatorASCII implements Comparator<String> {

    @Override
    public int compare(String arg0, String arg1) {
        return arg0.compareTo(arg1);
    }

}
