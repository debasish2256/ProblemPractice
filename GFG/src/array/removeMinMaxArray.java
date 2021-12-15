package array;

public class removeMinMaxArray {
	public static void main(String[] args) {
		System.out.println(minimumDeletions(new int[] {2,10,7,5,4,1,8,6}));
													// 1  2 3 4 5 6 7 8
	}

	public static int minimumDeletions(int[] nums) {
		   int minIndex = 0, maxIndex = 0, len = nums.length;
		    for (int i = 1 ; i < len; i++) {
		        if (nums[i] < nums[minIndex])
		            minIndex = i;
		        else if (nums[i] > nums[maxIndex])
		            maxIndex = i;
		    }
		    
		    // ......|.........|........
		    //   d1       d2        d3   
		    int d1 = Math.min(minIndex, maxIndex)+1;
		    int d3 = len-1-Math.max(minIndex, maxIndex)+1;
		    int d2 = len-d1-d3;
		    
		    return d1 < d3 ? d1 + Math.min(d2, d3) : d3 + Math.min(d1, d2); 
	}
}
