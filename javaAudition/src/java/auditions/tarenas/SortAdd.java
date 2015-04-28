package java.auditions.tarenas;

public class SortAdd {


	public int add(int i){
		
		if(i == 0 || i == 1)
			return i;
		
		int sum = 0;
		
		for(int j = 1;j<=i;j++){
			
			if(j%2 == 1){
				sum += j;
			}else{
				sum -= j;
			}
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {

		//SortAdd sortAdd = new SortAdd();
		//System.out.println(sortAdd.add(10));
		System.out.println("sbv");
	}

}
