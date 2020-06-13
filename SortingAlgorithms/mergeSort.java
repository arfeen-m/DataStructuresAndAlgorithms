//stable sorting algorithm
//O(nlgn) time complexity 
public class mergeSort {

	public static void main(String[] args) {
		int[] input = new int[]{1,10,12,5,6,9};
		
		int[] arr = merSort(input,0,input.length -1);
		for(int i:arr){
			System.out.println(i + " ");
		}

	}

	private static int[] merSort(int[] input, int p, int r) {
		if(p < r){
			
			
			
			int q = (p+r) / 2;
			
			merSort(input, p,q);
			merSort(input, q+1,r);
			merge(input,p,q,r);
			
			
		}
		return input;
	}

	private static void merge(int[] input, int p, int q, int r) {
		
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] l = new int [n1];
		int[] m = new int [n2];
		
		for(int i = 0;i<n1;i++){
			l[i] = input[p + i];
		}
		
		for(int i = 0;i<n2;i++){
			m[i] = input[q + 1 + i];
		}
		
		int i,j,k;
		i = 0;
		j = 0;
		k = p;
		
		// Until we reach either end of either L or M, pick larger among
	    // elements L and M and place them in the correct position at A[p..r]
		
		while(i < n1 && j < n2){
			if(l[i] <= m[j]){
				input[k] = l[i];
				i++;
			} else {
				input[k] = m[j];
				j++;
			}
			k++;
		}
		
		while(i<n1){
			input[k] = l[i];
			i++;
			k++;
		}
		
		while(j<n2){
			input[k] = m[j];
			j++;
			k++;
		}

	}

}
