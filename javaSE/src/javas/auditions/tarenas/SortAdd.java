package javas.auditions.tarenas;

public class SortAdd {


	public int add(int i){
		
		if(i == 0 || i == 1)
			return i;
		
		int sum = 0;
		String s = "";
		
		
		for(int j = 1;j<=i;j++){
			
		
			
			if(j%2 == 1){
				
				if(j != 1){
					sum =sum - j;
					s += "-"+j; 	
				}else{
					//sum =sum - j;
					sum = j;
					s += j;
				}
				
			}else{
				
				sum =sum+ j;
				s += "+"+j; 
			}
		}
		
		//System.out.println(sum);
		System.out.println(sum+"="+s);
		return sum;
	}
	
	
	public static void main(String[] args) {

		SortAdd sortAdd = new SortAdd();
		System.out.println(sortAdd.add(10));
		//System.out.println("sbv");
	}

}
