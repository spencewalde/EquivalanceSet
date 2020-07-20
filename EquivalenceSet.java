package project_3;

import java.util.LinkedList;

public class EquivalenceSet {
    private LinkedList<String> data;

    public EquivalenceSet() {
        data = new LinkedList<>();
    }

    public boolean contains(String item) {
        return data.indexOf(item) > -1;
    }

    public int size() {
        return data.size();
    }

    public void add(String item) {
        data.add(item);
    }

    public void add(EquivalenceSet set) {
        Object[] items = set.toArray();
        for(int i=0; i<items.length; i++) {
            data.add(items[i].toString());
        }
    }

    public void clear() { data = new LinkedList<>(); }
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public String toString() {
        return "EquivalenceSet{" +
                "data=" + data +
                '}';
    }

}
