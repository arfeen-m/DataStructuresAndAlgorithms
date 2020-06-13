import java.util.ArrayList;
import java.util.List;


public class Heap {

	public static void main(String[] args) {
		
		List<Integer> array = new ArrayList<>();
		int size = array.size();
		
		Heap h = new Heap();
		h.insert(array,3);
		h.insert(array,4);
		h.insert(array,9);
		h.insert(array,5);
		
		h.insert(array,2);
		
		h.delete(array,3);
	}

	private void delete(List<Integer> array, int num) {
		int size = array.size();
		int i;
		for (i = 0;i<size;i++){
			if(num == array.get(i)){
				break;
			}
		}
		
		int temp = array.get(i);
		array.set(i,array.get(size-1));
		array.set(size-1,temp);
		
		array.remove(size - 1);
		for(int j = size/2 - 1;j >=0;j--){
			heapify(array,j);
		}
		
	}

	private void insert(List<Integer> array, int num) {
		int size = array.size();
		if(size == 0){
			array.add(num);
		} else {
			array.add(num);
			for(int i = (size / 2) - 1;i >=0;i--){
				heapify(array,i);
			}
		}
	}

	private void heapify(List<Integer> array, int i) {
		int size = array.size();
		int largest = i;
		
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if(l < size && array.get(l) > array.get(largest)){
			largest = l;
		}
		if(r < size && array.get(r) > array.get(largest)){
			largest = r;
		}
		
		if(largest != i) {
			int temp = array.get(largest);
			array.set(largest,array.get(i));
			array.set(i, temp);
			
			heapify(array,largest);
		}
		
	}

}
