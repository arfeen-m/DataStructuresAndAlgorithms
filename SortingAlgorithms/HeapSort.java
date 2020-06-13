// Heap Sort in Java
  
  public class HeapSort {
  
    public static void main(String args[]) {
      int arr[] = { 3,4,9,5,2 };
  
      HeapSort hs = new HeapSort();
      hs.sort(arr);
      
      for(int i:arr){
		System.out.println(i + " ");
      }
    
    }

	private void sort(int[] arr) {
		
		int size = arr.length;
		
		//build max heap
		for(int i = size/2 - 1; i >= 0;i--){
			heapify(arr, size,i);
		}
		
		//Step 1: swap largest element with last element
		//Step 2: remove last element thereby reducing size of heap by 1
		//Step 3: Heapify the root element again so that we have highest element at root
			
		for(int i = size - 1; i>=0 ;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
		
			heapify(arr,i,0);
		}
		
	
	}

	private void heapify(int[] arr, int size, int i) {
		
		int largest = i;
		int l = i*2 + 1;
		int r = i*2 + 2;
		
		if(l < size && arr[l] > arr[largest]){
			largest = l;
		}
		if(r < size && arr[r] > arr[largest]){
			largest = r;
		}
		
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr,size,largest);
		}
		
	}
  }