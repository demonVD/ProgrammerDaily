// Trapping Rain water Problem
class Solution{
  public int trap(int[] height){
    int[] maxLeft = new int[height.length];
    int[] maxRight = new int[height.length];
    // int max = Integer.MIN_VALUE;
    maxLeft[0] = height[0];
    for(int i = 1; i < height.length; i++){
      /*
      if(height[i] > maxLeft[i-1]){
        maxLeft[i] = height[i];
      }
      else{
        maxLeft[i] = maxLeft[i-1];
      }
      */
      maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
    }
    maxRight[height.length-1] = height[height.length-1];
    for(int i = height.length - 2;i >= 0; i--){
      /*
      if(height[i] > maxRight[i+1]){
        maxRight[i] = height[i];
      }
      else{
        maxRight[i] = maxRight[i+1];
      }*/
      maxRight[i] = Math.max(maxRight[i+1], height[i]);
    }
    int totalWater = 0;
    for(int i = 0; i < height.length; i++){
      totalWater += (height[i] < Math.min(maxLeft[i], maxRight[i])) ? (Math.min(maxLeft[i], maxRight[i]) - height[i]) : 0;
    }
    return totalWater;
  }
}
class Solution2Pointers{
  public int trap(int[] height){
    int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
    int left = 0, right = height.length - 1;
    int totalWater = 0;
    while(left < right){
      if(height[left] < height[right]){
        if(leftMax < height[left]) {
          leftMax = height[left];
        }
        else{
          totalWater += leftMax - height[left];
        }
        left++;
      }
      else{
        if(rightMax < height[right]){
          rightMax = height[right];
        }
        else{
          totalWater += rightMax - height[right];
        }
        right--;
      }
    }
    return totalWater;
  }
}
class Practice174{
  public static void main(String[] args) {
    int[] height = {3, 0, 0, 2, 0, 4};
    // {1, 1, 1, 1, 0, 1};
    // {3, 0, 0, 2, 0, 4};
    Solution solution = new Solution();
    System.out.println(solution.trap(height));
    Solution2Pointers solution2 = new Solution2Pointers();
    System.out.println(solution2.trap(height));
  }
}
