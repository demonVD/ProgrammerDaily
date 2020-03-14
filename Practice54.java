// Create a job scheduler that takes a function f and a integer n as argument and call function f n times
class Solution{
	void jobScheduler(functionalInterface f, int n){
		for(int i=0;i<n;i++){
			f.display();
		}
	}
}
class Practice54{
	public static void main(String[] args) {
		Solution solution = new Solution();
		// functionalInterface f = ()->{
		// 	System.out.println("Helo");
		// };
		solution.jobScheduler(() -> {
			System.out.println("Hello");
		}, 5);
	}
}
interface functionalInterface {
	void display();
}