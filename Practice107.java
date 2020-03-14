// Classical Sieve of Eratosthenes
// Return whether a number is prime or not
class Solution{
	private static int maxRange = 10000;
	private static boolean[] primeNumber = new boolean[maxRange+1];
	public static void markPrime(){
		for(int i=0;i<=maxRange;i++){
			primeNumber[i] = true;
		}
		for(int i=2;i*i<=maxRange;i++){
			if(primeNumber[i]){
				for(int j=i*i; j<=maxRange;j+=i){
					primeNumber[j] = false;
				}
			}
		}
	}
	public boolean sieve(int n) throws Exception {
		if(n>maxRange) throw new Exception();
		return primeNumber[n];
	}
	public void display(){
		for(int i=0;i<primeNumber.length;i++) System.out.print(primeNumber[i] + " ");
	}
}
class Practice107{
	public static void main(String[] args) throws Exception{
		Solution.markPrime();
		// new Solution().display();
		System.out.println(new Solution().sieve(Integer.parseInt(args[0])));
	}
}