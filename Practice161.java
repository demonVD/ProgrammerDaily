// null check in java
class Practice161{
  public static void main(String[] args) {
    B bObj = new B();
    bObj.functionB();
  }
}
class B{
  public void functionA(A aObj){
    aObj.a = 10;
    aObj = null;
  }
  public void functionB(){
    A aObj = new A(5);
    System.out.println("Before Null :: a value :: " + aObj.a);
    functionA(aObj);
    System.out.println("After Null :: a value :: " + aObj.a);
  }
}
class A{
  int a;
  A(int a){
    this.a = a;
  }
}
