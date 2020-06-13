import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class bucketSort {

	public static void main(String[] args) {
		int[] input = new int[]{22,45,12,8,10,6,72,81,33,18,50,14};
		
		int[] arr = buckSort(input);
		for(double i:arr){
			System.out.println(i + " ");
		}
	}

	
	private static int[] buckSort(int[] input) {
		
		int size = 10; // bucket size from 0-9 for the current integer input
		
		
		List<List<Integer>> bucket = new ArrayList<>();
			
		
		for(int i = 0;i<size;i++){
			bucket.add(new ArrayList<>());
		}
		
		for(int i = 0; i < input.length;i++){
			int bucketIndex = (int) Math.floor(input[i]/size);
			bucket.get(bucketIndex).add(input[i]);
		}
		
		for(int i = 0;i<size;i++){
			Collections.sort(bucket.get(i));
		}
		
		int index = 0;
		for(int i = 0; i<size;i++){
			for(int j =0 , n = bucket.get(i).size();j<n;j++){
				input[index++] = bucket.get(i).get(j);
			}
		}
		
		return input;
	}

}
