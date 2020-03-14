// Trapping Rain Water
// LeetCode
class Solution{
  public int trap(int[] height){
    int length = height.length;
    int[] leftMax = new int[length];
    int[] rightMax = new int[length];
    // int left = 0;
    leftMax[0] = 0;
    for(int i=1;i<length;i++){
      // if(height[i])
      leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
    }
    rightMax[length-1] = 0;
    for(int i = length-2;i>=0;i--){
      rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
    }
    int area = 0;
    for(int i=0;i<length;i++){
      if(height[i] < Math.min(leftMax[i], rightMax[i])) area  = area + ( Math.min(leftMax[i], rightMax[i]) - height[i] );
    } 
    // System.out.println(area);
    return area;
  }
}
class Practice4{
  public static void main(String[] args){
    int[] height = {2, 1, 0, 1, 3, 2, 1, 2, 1};
    // {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Solution().trap(height));
  }
}
