package java.auditions.showStars;

public class StartAndPoint {

	public void show(){

		StringBuilder str = null;
		
		for(int i = 0;i<10;i++){
				
			str = new StringBuilder("");
			
			for(int j =0;j<i+1;i++){
				str.append("*");	
				
				for(int n = 0;n<i;n++){
					str.append(".");
					
				}
			}
			
			System.out.println(str);
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new StartAndPoint().show();
	}

}
