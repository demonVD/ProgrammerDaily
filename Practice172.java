// https://www.interviewbit.com/problems/hotel-bookings-possible/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Deque;
class Solution{
  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    ArrayList<Pair> arr = new ArrayList<>();
    for(int i = 0; i < arrive.size(); i++){
      arr.add(new Pair(arrive.get(i), true));
      arr.add(new Pair(depart.get(i), false));
    }
    Collections.sort(arr, (Pair x, Pair y) -> {
      if(x.time > y.time){
        return 1;
      }else if(x.time == y.time){
        if(y.isArrivalTime) return -1;
        return 0;
      }else{
        return -1;
      }
    });

    for(Pair i : arr){
      // System.out.println(i.time + " " + i.isArrivalTime);
      System.out.println(i);
    }
    int currActive = 0, maxActive = 0;
    for(int i = 0; i < arr.size(); i++){
      if(arr.get(i).isArrivalTime){
        currActive++;
        // maxActive = Math.max(currActive, maxActive);
      }
      else{
        currActive--;
      }
      if(currActive > K){
        return false;
      }
    }
    return true;
  }
}
class Pair{
  int time;
  boolean isArrivalTime;
  Pair(int time, boolean isArrivalTime){
    this.time = time;
    this.isArrivalTime = isArrivalTime;
  }
  @Override
  public String toString(){
    return this.time + " " + this.isArrivalTime;
  }
}
class Practice172{
  public static void main(String[] args) {
    ArrayList<Integer> arrive = new ArrayList<Integer>();
    arrive.add(1); arrive.add(2); arrive.add(3);
    ArrayList<Integer> depart = new ArrayList<Integer>();
    depart.add(2); depart.add(3); depart.add(4);
    int K = 1;
    Solution solution = new Solution();
    System.out.println(solution.hotel(arrive, depart, K));

  }
}
