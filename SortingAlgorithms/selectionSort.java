//Best && worst case : 0(n^2)
//Unstable sorting algorithm

public class selectionSort {

	public static void main(String[] args) {
		int[] input = new int[]{1,4,5,3,6,2,8,10,12,16};
		
		int[] arr = selSort(input);
		for(int i:arr){
			System.out.println(i + " ");
		}

	}

	private static int[] selSort(int[] input) {
		
		//iterate through
		for(int i = 0;i<input.length - 1;i++){
			int lowestIndex = i;
			for(int j = i+1; j<input.length ;j++){
				if(input[j] < input[lowestIndex]){
					lowestIndex = j;
				}
				
			
			}
			int temp = input[i]; 
			input[i] = input[lowestIndex];
			input[lowestIndex] = temp; 
		}
		
		return input;
		
	}

}
