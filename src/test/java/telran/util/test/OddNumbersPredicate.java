package telran.util.test;

import java.util.function.Predicate;

public class OddNumbersPredicate implements Predicate<Integer>{

    @Override
    public boolean test(Integer arg0) {
        
        return arg0 % 2 != 0;
    }

}
