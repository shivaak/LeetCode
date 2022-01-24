import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheJavaImpl {

    private int capacity;

    Map<Integer, Integer> map = new LinkedHashMap<>(16,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry entry)  {
            return size() > capacity;
        }
    };

    public LRUCacheJavaImpl(int capacity) {
        this.capacity = capacity;
    }


    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }

}