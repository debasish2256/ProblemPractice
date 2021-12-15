package threading;

class myThread extends Thread{
	
}
public class getting_setting_names {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); //main
		myThread t=new myThread();
		System.out.println(t.getName()); //Thread-0
		//Now Setting Name for main
		Thread.currentThread().setName("I am Main Thread Only");
		System.out.println(Thread.currentThread().getName());
		//Setting Child Name
		t.setName("I am child Thread");
		System.out.println(t.getName());
		
	}

}
