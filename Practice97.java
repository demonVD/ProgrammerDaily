class Demo{
	String a;
	String b;

	public int hashCode(){
		return a.hashCode();
	}
}
class Practice97{
	public static void main(String[] args) {
		Demo obj1 = new Demo();
		Demo obj2 = new Demo();
		// System.out.println(obj1.hashCode());
		// System.out.println(obj2.hashCode());
		// System.out.println(obj1.equals(obj2));
		obj1.a = "abc";
		obj2.a = "abb";
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}
}