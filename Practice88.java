// LRU cache
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
class LRUCache{
	static Deque<Integer> dq;
	static HashSet<Integer> set;
	static int LRU_SIZE;
	LRUCache(int n){
		this.LRU_SIZE = n;
		dq = new LinkedList<Integer>();
		map = new HashSet<>();
	}
	public getResource(int i){
		if()
	}
}
class LRUCache {
 
    Map<Integer,Integer> map;
    int capacity;
    Deque<Integer> dp;
    
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       this.capacity = capacity;
       map = new HashMap<>();
       dq = new LinkedList<>();
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       if(map.containsKey(x)){
           int val = map.get(x);
           int index=0, i=0;
           Iterator<Integer> itr = dq.iterator();
           while(itr.hasNext()){
               if(itr.next()==val){
                   index = i;
               }
               i++;
           }
           dq.remove(index);
           dq.addFirst(val);
           return val;
       }
       else{
           return -1;
       }
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
       if(map.containsKey(x)){
        //   int i = map.get(x);
           int val = map.get(x);
           int index=0, i=0;
           Iterator<Integer> itr = dq.iterator();
           while(itr.hasNext()){
               if(itr.next()==val){
                   index = i;
               }
               i++;
           }
           dq.remove(index);
       }
       else{
       	if(dq.size()>=capacity){
       		int last = dq.removeLast();
       		map.remove(last);
       	}
       }
       dq.addFirst(y);
       map.put(x, x);
    }
}


