// rotate array
class Solution {
    public void rotate(int[] nums, int d) {
        int j, k, temp; 
        int n = nums.length;
        int g_c_d = gcd(d, n); 
        // int quo = n/k;
        for (int i = 0; i < g_c_d; i++) { 
            temp = nums[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                nums[j] = nums[k]; 
                j = k; 
            } 
            nums[j] = temp; 
        } 
        for(int i=0;i<nums.length;i++){
        	System.out.print(nums[i] + " ");
        }
        System.out.println();
    }	
    private int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 
    // public void 
}
class Practice203{
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		Solution solution = new Solution();
		solution.rotate(nums, 3);
	}
}