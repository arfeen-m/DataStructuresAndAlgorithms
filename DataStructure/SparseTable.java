
public class SparseTable {

	public static void main(String[] args) {
		
		int[] values = {1,2,-3,2,4,-1,5};
		
		SparseTable sparseTable = new SparseTable(values);
		
		System.out.println(sparseTable.queryMin(1, 4));
	}
	
	
	//# of elements in the original input array
	private int n;
	
	//Max power of 2 needed. floor(log2(n)
	private int P;
	
	//Fast log base 2 logarithm lookup table
	private int [] log2;
	
	//sparse table values
	private int[][] dp;
	
	// Index table (it) associated with values in the sparse table. 
	// TAble is only useful when we want to query min or max values in range [l,r]
	// Does not work for sum or gcd caluclations
	private int[][] it; 
	
	public SparseTable(int[] values){
		// Remember, writing this much logic in constructor is not best practice.
		// This script is a working example
		n = values.length;
		P = (int) (Math.log(n) / Math.log(2));
		dp = new int[P + 1][n];
		it = new int[P + 1][n];
		
		for(int i = 0; i < n; i++){
			dp[0][i] = values[i];
			it[0][i] = i;
		}
		
		log2 = new int[n + 1];
		
		for(int i = 2; i <= n ;i++){
			log2[i] = log2[i/2] + 1;
		}
		
		//build sparse table combining the values of the previous intervals
		for(int p = 1; p<= P;p++){
			for(int i = 0;i + (1 << p) <= n; i++){
				int leftInterval = dp[p-1][i];
				int rightInterval = dp[p-1][i + (1 << (p-1))];
				dp[p][i] =  Math.min(leftInterval, rightInterval);
			  
				//Propogate the index of the best value
				if(leftInterval <= rightInterval){
					it[p][i] = it[p-1][i];
				} else {
					it[p][i] = it[p-1][i + (1 << (p - 1))];
				}
			}
			
		}
	}
	
	//we can get 0( 1) query by finding the smallest power of 2 that fits within the interval length, k
	// We can query the intervals [l, l+k] and [r - k + 1, r] and apply the function again.
	//For this function we dont care about overlap, but for sum functions we would care about overlap.
	private int queryMin(int l, int r){
		int length = r - l + 1;
		int p = log2[length];
		int k = 1 << p; // 2 to the power of p
		return Math.min(dp[p][l], dp[p][r - k + 1]);
	}
	
	//returns minimum element index in the range
	public int queryMinIndex(int l, int r){
		int length = r - l + 1;
		int p = log2[length];
		int k = 1 << p; //2 to the power of p
		int leftInterval = dp[p][l];
		int rightInterval = dp[p][r - k + 1];
		if(leftInterval <= rightInterval){
			return it[p][l];
		} else {
			return it[p][r - k + 1];
		}
	}

}
