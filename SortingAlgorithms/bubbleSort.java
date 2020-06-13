//Best case 0(n). Worst case 0(n^2)
//Stable sorting algorithm

public class bubbleSort {

	public static void main(String[] args) {
		int[] input = new int[]{1,4,2,3,4,6,7};
		
		int[] arr = bubSort(input);
		for(int i:arr){
			System.out.println(i + " ");
		}
}

	private static int[] bubSort(int[] input) {
		
		boolean isSorted = false;
		int lastUnsorted = input.length - 1;
		while(!isSorted){
			isSorted = true;
			for(int i = 0;i<lastUnsorted;i++){
				if(input[i] > input[i+1]){
					swap(input,i,i+1);
					isSorted = false;
				}
			}
			lastUnsorted --;  
		}
		
		return input;
	}
	
	private static void swap(int[] input, int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}