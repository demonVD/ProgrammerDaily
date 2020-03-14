import java.util.HashMap;
class Pair{
	int n1, n2;
	Pair(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
}
class Solution{
	HashMap<Pair, Integer> hcf; 
	Solution(){
		hcf = new HashMap<>();
	}
	private void init(int n){
		System.out.println("Inside INit");
		hcf.put(new Pair(n, n), n);
		hcf.put(new Pair(1, n), 1);
		hcf.put(new Pair(n, 1), 1);	
	}
	public int countIntegers(int n){
		// init(n);
		int count = 0;
		for(int i=1;i<=n;i++){
			int f = gcdExtended(i, n, 1, 1);
			System.out.println("GCD : " + f);
			if((f!=1) && (f!=i)){
				count++;
			}
		}
		return count;
	}
	/*private int gcd(int a, int b) 
	{ 
		System.out.println("GCD OF " + a + " " + b);
		if (b == 0) 
			return a; 
		Pair pair1 = new Pair(b, a%b);
		Pair pair2 = new Pair(a%b, b);
		if(hcf.containsKey(pair1) || hcf.containsKey(pair2) ){
			System.out.println("Inside IF");
		}
		else{
			System.out.println("Inside ELSE");
			int k = gcd(b, a % b); 
			hcf.put(pair1, k);
			hcf.put(pair2, k);
		}
		return hcf.get(pair1);
	} */
	public int gcdExtended(int a, int b, int x, int y) 
    { 
        // Base Case 
        if (a == 0) 
        { 
            x = 0; 
            y = 1; 
            return b; 
        } 
  
        int x1=1, y1=1; // To store results of recursive call 
        int gcd = gcdExtended(b%a, a, x1, y1); 
  
        // Update x and y using results of recursive 
        // call 
        x = y1 - (b/a) * x1; 
        y = x1; 
  
        return gcd; 
    } 
}
class Practice125{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(new Solution().countIntegers(n));
	}
}