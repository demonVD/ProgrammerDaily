// Multitreading Java
class MultitreadingDemo extends Thread {
	
	public void run(){
		System.out.println("Started " + Thread.currentThread().getId());
	}

}
class Practice96{
	public static void main(String[] args) {
		
		for(int i=0;i<8;i++){
			MultitreadingDemo obj = new MultitreadingDemo();
			obj.start();
		}
	}
}