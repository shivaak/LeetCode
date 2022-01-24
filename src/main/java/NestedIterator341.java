import java.util.*;

public class NestedIterator341 implements Iterator<Integer> {

    private List<NestedInteger> nestedList;
    private List<NestedInteger> flattenList = new ArrayList<>();
    private int currentIndex = 0;

    public NestedIterator341(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        makeFlattenList(nestedList);
    }

    @Override
    public Integer next() {
        NestedInteger current = flattenList.get(currentIndex);
        currentIndex++;
        return current.getInteger();
    }

    @Override
    public boolean hasNext() {
        if(currentIndex>=flattenList.size()){
            return false;
        }
        return true;
    }

    private void makeFlattenList(List<NestedInteger> nestedList){

        for(NestedInteger i : nestedList){
            if(i.isInteger()) {
                flattenList.add(i);
            } else{
                makeFlattenList(i.getList());
            }
        }
    }
}


interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
 }
