// Implement HashMap
class Node<K, V>{
  final Object key;
  Object value;
  Node<K,V> next;
  Node(K key, V value){
    this.key = key;
    this.value = value;
    this.next = null;
  }
}
class HashMap<K, V>{
  Node<K, V>[] table;
  final int INITIAL_CAPACITY = 10;
  int size;

  HashMap(){
    this.table = new Node[INITIAL_CAPACITY];
    this.size = 0;
  }

  public void put(K key, V value){

  }
}
class Practice177{
  public static void main(String[] args) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    hashMap.put(3, 4);
  }
}
