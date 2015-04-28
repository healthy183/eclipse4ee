package javas.auditions.tarenas;

class C{
	
	public C(){
		System.out.println();
		System.out.println("this is c");
		System.out.println();
	}
}

class A{
	
	
	
    static {
         System.out.print("1");
         }
    private static C c = new C();
    
    public A(){
         System.out.print("2");}
  }
 class B extends A{
	 
	 private static C c = new C();
	 
    static {
        System.out.print("a");}
    public B(){
        System.out.print("b");}

  }
 


public class StaticAndContaint {


	
	public static void main(String[] args) {

		 A ab=new B();// 执行到此处，屏幕打印：1a2b
	     ab=new B();//执行到此处，屏幕打印：2b
	}

}
