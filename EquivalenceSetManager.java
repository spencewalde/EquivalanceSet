package project_3;

public class EquivalenceSetManager {
    public EquivalenceSet[] sets;

    public EquivalenceSetManager() {
        sets = new EquivalenceSet[4];

        for(int i=0; i<sets.length; i++)
            sets[i]=new EquivalenceSet();
    }

    public void add(String firstItem, String secondItem) {
        int firstIndex = indexOf(firstItem);
        int secondIndex = indexOf(secondItem);

        if(firstIndex == -1 && secondIndex == -1) {
            int set = getFirstEmptySet();
            if(set==-1) return; //no empty sets

            sets[set].add(firstItem);
            sets[set].add(secondItem);
        }
        else if(firstIndex>-1 && secondIndex>-1 && firstIndex!=secondIndex) {
             int firstSet = Math.min(firstIndex,secondIndex);
             int secondSet = Math.max(firstIndex,secondIndex);

             sets[firstSet].add(sets[secondSet]);
             sets[secondSet].clear();
        }
        else if(firstIndex>-1 || secondIndex>-1) {
            int set = Math.max(firstIndex, secondIndex);

            sets[set].add(secondItem);
        }
    }

    public void print(String firstItem, String secondItem) {
        int firstIndex = indexOf(firstItem);
        int secondIndex = indexOf(secondItem);

        if(firstIndex==-1)
            System.out.println("First item not found.");
        else if(firstIndex>-1)
            System.out.println(sets[firstIndex].toString());

        if(secondIndex>-1 && firstIndex!=secondIndex)
            System.out.println(sets[secondIndex].toString());
        else if(secondIndex==-1)
            System.out.println("Second item not found.");
    }

    public void print() {
        for (int i = 0; i < sets.length; i++)
            System.out.println(sets[i].toString());

    }
    private int getFirstEmptySet() {
        for(int i=0; i<sets.length; i++)
            if(sets[i].size()==0)
                return i;

            return -1;
    }

    private int indexOf(String item) {
        for(int i=0; i<sets.length; i++) {
            if (sets[i].contains(item))
                return i;
        }
        return -1;
    }

}
