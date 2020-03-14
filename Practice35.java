// Sieve of Eratosthenes
class Solution{
  public void printPrime(int n){
    boolean[] arr = new boolean[n-2];
    for(int i=2;i<n-2;i++){
      arr[i-2] = true;
    }
      // for(int i = 0;i<n-2;i++) System.out.print(arr[i]);
    for(int i=2;i<Math.sqrt(n-2);i++){
      if(arr[i-2]){
        for(int j = i*i;j<n;j= j+i){
          arr[j-2] = false;
        }
      }
    }

    for(int i = 0;i<n-2;i++) if(arr[i]) System.out.print((i+2)+" ");

  }
}
class Practice35{
  public static void main(String[] args) {
    new Solution().printPrime(45);
  }
}
