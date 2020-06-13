/*
 * [2,5,3,0,2,3,0,3]
 * 
 * 
 * 
 * 
 * 
 */


public class countingSort {

	public static void main(String[] args) {
		int[] input = new int[]{1,2,4,3,1,5,8};
		
		int[] arr = countSort(input);
		for(int i:arr){
			System.out.println(i + " ");
		}

	}
	
	private static int[] countSort(int [] arr){
		//
		
		//for simplicity we are using digits in the range of 0-9
		int[] countArr = new int[10];
		
		//create a count for digits 0-9 in newly created array
		for(int a:arr){
			countArr[a]++;
		}
		
		//add value from previous index to current
		for(int i = 1;i<countArr.length;i++){
			countArr[i] += countArr[i-1]; 
		}
		
		//create final ordered array
		int[] result = new int[arr.length];
		
		//Take value from  index position in arr and find number at countArr.
		//We use this as a placement for the new array position.
		//Remember the new result array is meant to hold position of each ordered element (which is why we take away 1)
		//We them subtract our countArr.
		for(int i = arr.length - 1;i>=0;i--){
 			int placement = countArr[arr[i]]-1; 
			result[placement] = arr[i];
			countArr[arr[i]]--;
		}
			
			
		return result;
	}

}



