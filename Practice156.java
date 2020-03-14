// verify Prime
class Solution{
  public int isPrime(int A) {
    for(int i = 2; i <= Math.sqrt(A); i++){
      if(A%i == 0){
        return 0;
      }
    }
    return 1;
  }
}
class Practice156{
  public static void main(String[] args) {
    int A = 5;
    Solution solution = new Solution();
    System.out.println(solution.isPrime(Integer.parseInt(args[0])));
  }
}
