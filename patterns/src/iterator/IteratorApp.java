package iterator;

public class IteratorApp {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator it = aggregate.getIterator();
        while(it.hasNext())
            System.out.println((String)it.next());
    }
}
interface Iterator{
    boolean hasNext();
    Object next();
}
interface Aggregate{
    Iterator getIterator();
}
class ConcreteAggregate implements Aggregate{
    private String[] collect = {"dima", "vasya", "petya"};

    public Iterator getIterator() {
        return new ConcreteIterator();
    }
    private class ConcreteIterator implements Iterator{
        private int index = 0;
        public boolean hasNext() {
            return index<collect.length;
        }
        public Object next() {
            return collect[index++];
        }
    }
}
