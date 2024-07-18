package telran.util.test;

public class Person implements Comparable<Person>{
    private long id;
    private String name;
    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Person arg0) {
        return Long.compare(id, arg0.id);
    }
    
}
