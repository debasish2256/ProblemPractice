package twoDArray;

public class equal_sum_subarrays {
    
		static int findSplitPoint(int arr[])
		{
		int n=arr.length;
		int leftSum = 0 ;
		int rightSum = 0 ;

		for (int i = 0; i < n; i++)
		{
			leftSum += arr[i] ;
		}
		for (int j = n-1 ; j >0 ; j-- ) {
			rightSum += arr[j] ;
			leftSum-= arr[j];
			if (leftSum == rightSum)
				return j-1 ;
		}
		return -1;
		}

		
		static void printTwoParts(int arr[])
		{
		
			int splitPoint = findSplitPoint(arr);
		
			
			for (int i = 0; i <=splitPoint; i++)
			{
			
				System.out.print(arr[i] + " ");
				
			}
			System.out.println();
			for (int i = splitPoint+1; i <arr.length; i++)
			{
			
				System.out.print(arr[i] + " ");
				
			}
		}

	
		
		public static void main (String[] args) {
		
		int arr[] = {1 , 2 , 3 , 4 , 5 , 5 };
		printTwoParts(arr);
		
		}

}
