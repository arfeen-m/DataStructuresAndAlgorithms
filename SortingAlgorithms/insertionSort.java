//sorting a hand in big two
//time complexity 0(n^2). space O(1)


public class insertionSort {
	
	public static void main(String[] args){
		int[] input = new int[]{1,4,1,3,2,2};
				
		int[] arr = insertSort(input);
		for(int i:arr){
			System.out.println(i + " ");
		}
	}

	private static int[] insertSort(int[] input) {
		int size = input.length;
	
		for(int i = 1; i<size;i++){
			int key = input[i];
			int j = i - 1;
			
			
			while(j >=0 && key < input[j]){
				input[j + 1] = input[j];
				j--;
			}
			
			input[j + 1] = key;
			
		}
		
		return input;
	}
}
