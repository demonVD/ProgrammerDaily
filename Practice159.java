// https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
class Solution{
  public int solve(ArrayList<String> A) {
    final int LEFTBOUND = 1;
    final int RIGHTBOUND = 2;
    int length = A.size();
    float sum = 0;
    int count = 0;
    for(int i = 0; i < length; i++){
      sum += Float.parseFloat(A.get(i));
      count++;
      while(count == 3){
        if(sum > LEFTBOUND && sum < RIGHTBOUND){
          return 1;
        }
        else if(sum > RIGHTBOUND){
          sum -= Float.parseFloat(A.get(i))
        }
        else if(sum < LEFTBOUND){
          sum
        }
      }
    }
  }
}
class Practice159{
  public static void main(String[] args) {

  }
}
