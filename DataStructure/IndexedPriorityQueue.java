import java.util.*; 

//Incomplete. Need to add swim and sink method. 
//Also need to method to accept/add values into array

public class IndexedPriorityQueue {
	
	public static class MinIndexedHeap{

		//current number of elements in heap
		private int sz;
		
		//max number of elements in heap
		private int n;

		//The inverse map(im) stores the indexes of the keys in range[0,sz] which makes up the priority queue.
		//(im) and (pm) are inverses of each other -> pm[im[i] = im[pm[i] = i
		private int[] im;
		
		//The position map (pm) maps the key indexes (ki) to where the position of that key is represented in the priority queue in the domain [0,sz];
		private int[] pm;
		
		//lookup array to track the children/parent indexes of each node
		private int[] child;
		private int[] parent;
		
		//values associated with the keys. This array is indexed by the key indexes (ki)
		private Object[] values;
		
		public MinIndexedHeap(int size){
			n = size;
			
			im = new int[n];
			pm = new int[n];
			child = new int[n];
			parent = new int[n];
			values = new Object[n];
			
			//Uses min/max heap array property.
			//child left = parent * 2 + 1
			//child left = parent * 2 + 2
			for(int i = 0; i < n; i++){
				parent[i] = (i - 1)/2;
				child[i] = i * 2 + 1;
				pm[i] = im[i] = -1;
			}
		}
		
		public int size(){
			return sz;
		}
		
		public boolean contains(int ki){
			return pm[ki] != -1;
		}
		
		public int peekMinKeyIndex(){
			return im[0];
		}
		
		
		public String toString(){
			List<Integer> lst = new  ArrayList<>(sz);
			for(int i = 0; i < sz; i++){
				lst.add(im[i]);
			}
			
			return lst.toString();
		}
		
	}

	public static void main(String[] args) {
		
		MinIndexedHeap minHeap = new MinIndexedHeap(5);
		
		System.out.println(minHeap.toString());
		 

	}

}
