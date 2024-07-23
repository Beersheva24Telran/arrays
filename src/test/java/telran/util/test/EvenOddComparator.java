package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer arg0, Integer arg1) {
       boolean isArg0Even = arg0 % 2 == 0;
       boolean isArg1Even = arg1 % 2 == 0;
       boolean noSwapFlag = (isArg0Even && !isArg1Even) ||
       (isArg0Even && isArg1Even && arg0 <= arg1) ||
        (!isArg0Even && !isArg1Even && arg0 >= arg1);
       return noSwapFlag ? -1 : 1;
    }

}
