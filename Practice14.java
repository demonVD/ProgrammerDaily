// FROG JUMP
class Solution{
  public boolean canCross(int[] stones) {
    int length = stones.length;
    if(length <2) return false;
    int unitsJumped = 0;
    // int unitsCanBeJumped = 0;
    int i =0;
    boolean isContinuedJumping = true;
    while(i<=length-1){
      int startingPoint = stones[i];
      // unitsCanBeJumped - (stones[i+1] + startingPoint);
      boolean isJumped = false;
      System.out.println("element : " + stones[i] + " " + i + " Starting Point " + startingPoint);
      System.out.println(
      i+1<length &&
      ((unitsJumped -1 <= (stones[i+1] - startingPoint))
      || (unitsJumped == (stones[i+1] - startingPoint))
      || (unitsJumped +1 == (stones[i+1] - startingPoint))));
      while(i+1<length && ((unitsJumped -1 == (stones[i+1] - startingPoint))
        || (unitsJumped == (stones[i+1] - startingPoint))
        ||(unitsJumped +1 == (stones[i+1] - startingPoint)))){
        i++;
        isJumped = true;
      }
      if(!isJumped) return false;
      isContinuedJumping = isJumped && isContinuedJumping;
      System.out.println("IS JUMPED : " + isJumped + "IS isContinuedJumping : " + isContinuedJumping);
      unitsJumped = stones[i] - startingPoint;
    }
    if(isContinuedJumping) return true;
    else return false;
  }
}

class Practice14{
  public static void main(String[] args){
    int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
    // {0, 1, 2, 3, 4, 8, 9, 11};
    //
    System.out.println(new Solution().canCross(stones));;
  }
}
