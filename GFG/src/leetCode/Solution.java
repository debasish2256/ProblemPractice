package leetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class Solution {
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i : nums) {
			if (i != val) {
				nums[count] = i;
				count++;
			}
		}
		return count;
	}

	public static int kernighans_algorithm(int s) {
		int count = 0;
		while (s != 0) {
			int rsbm = s & -s; // right most significant bit mask
			s = s - rsbm;
			// s = s & (s-1);
			count++;
		}
		return count;
	}

	/*
	 * public static int removeElement(int[] nums, int val) { int i=0,skip=0; int
	 * n=nums.length; while( i+skip < n){ nums[i] = nums[i+skip]; if(nums[i] == val)
	 * skip++; else i++; } return n-skip; }
	 */
	public static int power(int n) {
		int i = 1;
		while (2 * i <= n) {
			i = i * 2;
		}
		return i;
	}
	public static int josephus_special(int n) {
		int l = n - power(n);
		return 2 * l + 1;
	}

	public static void bit_manipulation(){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int i = scn.nextInt();
		int j = scn.nextInt();
		int k = scn.nextInt();
		int m = scn.nextInt();

		int onmask=(1 << i);
		int offmask=~(1 << j);
		int togglemask=( 1 << k);
		int checkmask=(1 << m);

		System.out.println(n|onmask);
		System.out.println(n&offmask);
		System.out.println(n^togglemask);
		System.out.println((n&checkmask)!=0?"true":"false");
	}
	private static void rsb_mask() {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		    int res=n & -n;
		int res=(n & (~n+1));
		System.out.println(Integer.toBinaryString(res));	
	}
	public static List<Integer> grayCode(int n) {
        if(n == 1){
            List<Integer> bcode = new ArrayList<>();
            bcode.add(0);
            bcode.add(1);
            return bcode;
        }
        List<Integer> codes = grayCode(n-1);
        List<Integer> code = new ArrayList<>();
        for(int i = 0; i < codes.size(); i++){
            int a = codes.get(i);//left shift by 1 to add 0 in the end
            code.add(a << 1);
        }     
        for(int i = codes.size()-1; i >= 0; i--){
            int a = codes.get(i);
            code.add((a << 1)^1); //left shift by 1 followed OR with 1 to add 1 in the end
        }       
        return code;
    }
	//O(2^N)
	public static List<Integer> grayCode_1(int n) {
        List<Integer> ret = new LinkedList<>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
    }
	///O(N-1)
	public static List<Integer> grayCode_2(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		List<Integer> lastGray = grayCode(n - 1);
		int addOnNum = 1 << (n - 1);
		result.addAll(lastGray);
		for (int i = lastGray.size() - 1; i >= 0; i--) {
			result.add(lastGray.get(i) + addOnNum);
		}
		return result;
	}
	//O(N)-|
	 /*public static int removeDuplicates(int[] nums) {
		TreeSet<String> tree = new TreeSet<>();
		for(int i:nums) {
			tree.add(String.valueOf(i));
		}
		return tree.size();  
	    }*/
	public static int removeDuplicates(int[] nums) {
		int index=1;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]!=nums[i+1]) {
				nums[index++]=nums[i+1];
			}
		}
		return index;
	}
//on way to add zero at end
	public static void moveZeroes(int[] arr) {

	    int count=0;
	     for(int i=0;i<arr.length;i++)
	     {
	         if(arr[i]!=0)
	         {
	             arr[count++]=arr[i];
	         }
	     }
	     for(int i=count;i<arr.length;i++){
	         arr[i]=0;
	     }
		for (int j = 0; j < arr.length; j++)
			System.out.print(arr[j]);
	}
	 /*int c=0;
     for(int i=0;i<nums.length;i++){
         if(nums[i]!=0){
             nums[c]=nums[i];
             c++; 
         }
     }
     for(int i=c;i<nums.length;i++){
         nums[i]=0;
     }*/
	//O(N)
	public int findDuplicate(int[] nums) 
	{
	    HashSet<Integer> hs = new HashSet<Integer>();
	    for(int i=0;i<nums.length;i++)
	    {
	        if(hs.contains(nums[i]))
	            return nums[i];
	        else
	            hs.add(nums[i]);
	    }
	    return -1;
	}
	//O(N)
	/*public static int findDuplicate(int[] nums) {
        for (int n : nums) {
            if (nums[Math.abs(n)] < 0) {
                return Math.abs(n);
            } else {
                nums[Math.abs(n)] *= -1;
            }
        }
        return -1;
    }*/

	public static int[] plusOne(int[] digits) {
		int strlen = digits.length;
		for (int i = strlen - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;
			} else {
				digits[i] = 0;
			}
		}
		if(digits[0]==0) {
			int[] res=new int[strlen+1];
			res[0]=1;
			return res;
		}
		return digits;
	}
	public static int divide(int dividend, int divisor) {
		if (dividend == 1 << 31 && divisor == -1)
			return Integer.MAX_VALUE;
		boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int result = 0;
		while (dividend - divisor >= 0) {
			int count = 0;
			while (dividend - (divisor << 1 << count) >= 0) {
				count++;
			}
			result += 1 << count;
			dividend -= divisor << count;
		}
		return sign ? result : -result;
	}
	public static int mySqrt(int x) {
	    long y=0;
		while(y*y<=x) {
			y++;
		}
		return (int) (y-1);   
    }
	public static void sortColors(int[] nums) {
		int zero=0,one=0,two=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) zero++;
			if(nums[i]==1) one++;
			if(nums[i]==1) two++;
		}
		for(int i=0;i<zero;i++) {
			nums[i]=0;
		}
		for(int i=zero;i<(zero+one);i++) {
			nums[i]=1;
		}
		for(int i=(zero+one);i<(zero+one+two);i++) {
			nums[i]=2;
		}
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]);
    }
	public static boolean canJump(int[] nums) {
		int goodIndex=nums.length-1;
		for(int i=nums.length-2;i>=0;i--)
		{
			if((i+nums[i])>=goodIndex)
				goodIndex=i;
		}
		return goodIndex==0;
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int curr_gas=0;
        int prev_gas=0;
        for(int i=0;i<gas.length;i++){
            curr_gas+=(gas[i]-cost[i]);
            if(curr_gas<0){
                start=i+1;
                prev_gas+=curr_gas;
                curr_gas=0;
            }
        }
      return ((prev_gas + curr_gas) >= 0 ? start : -1); 
    }
	
	//239. Sliding Window Maximum(O(N*K)) -TLE
	public static int[] sliding_window_maximum1(int[] nums, int k){
		int ans[]=new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++) {
			int max=nums[i];
			for(int j=1;j<k;j++) {
				if(nums[i+j]>max)
					max=nums[i+j];
			}
			ans[i]=max;
		}
		return ans;
	}
	//239. Sliding Window Maximum(O(N))
	public static int[] sliding_window_maximum2(int[] nums, int k){
		int n = nums.length;
		Deque<Integer> dq = new LinkedList<Integer>();
		int ans[]=new int[n-k+1];
		int i=0;
		for(;i<k;i++) {
			//check first empty and check curr element of queue is less than given array
			while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for(;i<n;i++) {
			ans[i-k]=nums[dq.peekFirst()];
			while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		ans[i-k]=nums[dq.peekFirst()];
		return ans;
	}
	
//	295. Find Median from Data Stream
//	13. Roman to Integer
	
	public static int romanToInt(String s) {
		int sum=0;
		int n=s.length();
		final Map<Character,
        Integer> roman = new HashMap<Character,Integer>()
		{{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}};
        for(int i = 0; i < n; i++)
        { 
            // If present value is less than next value,
            // subtract present from next value and add the
            // resultant to the sum variable.
            if (i != n - 1 && roman.get(s.charAt(i)) <
                              roman.get(s.charAt(i + 1)))
            {
                sum += roman.get(s.charAt(i + 1)) -
                       roman.get(s.charAt(i));
                i++;
            }
            else
            {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;
    }
	
//	215. Kth Largest Element in an Array
	public static int findKthLargest(int[] nums, int k) {
		int n=nums.length;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for (int i=0;i<n;i++) {
			if(i<k) {
				pq.add(nums[i]);
			} else {
				if(pq.peek()<nums[i]) {
					pq.poll();
					pq.add(nums[i]);
				}
			}
		}
		ArrayList<Integer> res=new ArrayList<>(pq);
		Collections.sort(res,Collections.reverseOrder());
		return res.get(k-1);
    }
	
	//matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
	public boolean searchMatrixColumnWise(int[][] matrix, int target) {
	       if(matrix.length == 0 || matrix[0].length==0) return false;
	        int m=matrix.length,n=matrix[0].length;
	        int r=0,c=n-1;
	        while(c>=0 && r<m) {
	        	//check with last element
	        	if(matrix[r][c]==target) return true;
	        	else if(matrix[r][c]<target) r++;
	        	else c--;
	        }
			return false; 
	    }
	
	//2D Matrix Search
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int r=0,c=n-1;
        while(c>=0 && r<m) {
        	//check with last element
        	if(matrix[r][c]==target) return true;
        	else if(matrix[r][c]>target) c--;
        	else r++;
        }
		return false;
	}	
	public static boolean searchMatrixBinarySearchApproach(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int start=0, end=m*n-1;
        while(start<=end) {
        	//check with flatten the matrix in an array
        	int mid=start+(end-start)/2;
        	if(matrix[mid/n][mid%n]==target) return true;
        	else if(matrix[mid/n][mid%n]<target) start=mid+1;
        	else end =mid-1;
        }
		return false;
    }
	
	
	//59. Spiral Matrix II
	public static int[][] spiralMatrix(int n) {
		int mat[][]=new int[n][n];
		//take four pointer
		int left=0,top=0,right=n-1,bottom=n-1;
		int val=1;
		while(val<=n*n) {
			for(int i=left;i<=right;i++) {
				mat[top][i]=val++;
			}
			top++;
			for(int i=top;i<=bottom;i++) {
				mat[i][right]=val++;
			}
			right--;
			for(int i=right;i>=left;i--) {
				mat[bottom][i]=val++;
			}
			bottom--;
			for(int i=bottom;i>=top;i--) {
				mat[i][left]=val++;
			}
			left++;
		}
	return mat;      
	}
	
	
//	498. Diagonal Traverse
    public static int[] findDiagonalOrder(int[][] mat) {
		if(mat.length == 0)
			return new int[0];
		int m=mat.length,n=mat[0].length,r=0,c=0;
		int[] result=new int[m*n];
		for(int i=0;i<result.length;i++) {
			result[i]=mat[r][c];
			if((r+c)%2==0) {
				if(c==n-1) {
					r++;
				}else if(r==0) {
					c++;
				}else {
					r--;
					c++;
				}
			}else if(r==m-1) {
				c++;
			}else if(c==0) {
				r++;
			}else {
				r++;
				c--;
			}
		}
		return result;
    }
	
    public static int[] findDiagonalOrder1(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new int[0];
        int n = matrix[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i + j, k -> new ArrayList<>()).add(matrix[i][j]);
            }
        }
        
        //iterating map and check the modulo reverse by alternate
        List<Integer> result = new ArrayList<Integer>();
        for (int k = 0; k < m + n - 1; k++) {
            List<Integer> list = map.get(k);
            if (k % 2 == 0)
                Collections.reverse(list);
            result.addAll(list);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
    
//    130. Surrounded Regions
    public static void surrounded_regions(char[][] b) {
    	int m=b.length;
    	if (m==0) return;
    	int n=b[0].length;
    	for(int i=0;i<n;i++) {
    		if(b[0][i]=='O') 
    			dfs(b,0,i);
    		if(b[m-1][i]=='O') 
    			dfs(b,m-1,i);
    	}
    	for(int i=0;i<m;i++) {
    		if(b[i][0]=='O') 
    			dfs(b,i,0);
    		if(b[i][n-1]=='O') 
    			dfs(b,i,n-1);
    	}
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(b[i][j]=='O')
    				b[i][j]='X';
    			if(b[i][j]=='P')
    				b[i][j]='O';
    			System.out.print(b[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    private static void dfs(char[][] b, int x, int y) {
    	if(x>=0 && x<b.length && y>=0  && y<b[0].length && b[x][y]=='O') {
    		b[x][y]='P';
    		dfs(b,x+1,y);
    		dfs(b,x,y+1);
    		dfs(b,x-1,y);
    		dfs(b,x,y-1);
    	}else return;
    }

//    1329. Sort the Matrix Diagonally
    public static int[][] diagonalSort(int[][] mat) {
		int m=mat.length;
		int n=mat[0].length;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
    	
    	
    	return mat;
    }
    

	private static int myAtoi(String str) {
		int index=0,sign=1,total=0,n=str.length();
		//remove space
//		str=str.trim();
		while(index<n && str.charAt(index)==' ')
			index++;
		//handle signs
		if(index<n && (str.charAt(index)=='+' || str.charAt(index)=='-')) {
			sign=str.charAt(index++)=='+' ? 1:-1;
		}
		//convert number and avoid overflow
		while(index<n) {
			int digit=str.charAt(index)-'0';
			if(digit<0 || digit >9) break;
			
			if(total>Integer.MAX_VALUE/10 ||total==Integer.MAX_VALUE/10 && Integer.MAX_VALUE % 10 < digit)
				return sign==1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
			
			total=10*total+digit;
			index++;
		}
		return total*sign;
	}
    
	public static void main(String[] args) {
		int s[] = {4,1,2,1,2};
		char[] c= {0x01,0x21};
		String s1=String.valueOf(c);
		// System.out.println(removeElement(s,3));
		// System.out.println(kernighans_algorithm(58));
//		System.out.println(josephus_special(4));
//		Solution.bit_manipulation();
//		Solution.rsb_mask();
//		System.out.println(Solution.grayCode_2(2));
//		System.out.println(removeDuplicates(s)); 
//		Solution.moveZeroes(s);
//		System.out.println(findDuplicate(s));
//		System.out.println(1<<0);
//		System.out.println(plusOne(s));
//		System.out.println(divide(10,3));
//		System.out.println(mySqrt(8));
//		Solution.sortColors(s);
//		System.out.println(canJump(s));
//		System.out.println(singleNumber(s));
//		System.out.println(Integer.toHexString(c[0])+Integer.toHexString(c[1]));
		int gas[]= {1,2,3,4,5};
		int cost[]={3,4,5,1,2};
//		System.out.println(canCompleteCircuit(gas,cost));
		int[] nums={1,3,-1,-3,5,3,6,7};
//		display(sliding_window_maximum2(nums,3));
//		makeNegativeNumberAside(nums);
//		int nums1[] = {3,2,1,5,6,4};
//		System.out.println(findKthLargest(nums1,2));
		String s11 = "MCMXCIV";
//		System.out.println(romanToInt(s11));
		int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
//		System.out.println(searchMatrix(matrix,target));
//		System.out.println(searchMatrixBinarySearchApproach(matrix,target));
//		printTwoDMat(spiralMatrix(3));
		int [][] dmatrix = {{1,2,3},{4,5,6},{7,8,9}};
//		printOneDarray(findDiagonalOrder(dmatrix));
//		printOneDarray(findDiagonalOrder1(dmatrix));
		char[][] board= {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		surrounded_regions(board);
		int [][] dmat= {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
//		printTwoDMat(diagonalSort(dmat));
		String str=" 000236546.h5r56iu Hi Hello";
		System.out.println(myAtoi(str));
	}


	private static void printTwoDMat(int[][] twoDmat) {
		if(twoDmat.getClass().getSimpleName().equals("int[][]")) {
			for(int i=0;i<twoDmat.length;i++) {
				for(int j=0;j<twoDmat.length;j++)
					System.out.print(twoDmat[i][j]+ " ");
				System.out.println();
			}
		}
	}

	private static void printOneDarray(int[] array) {
		String res="";
		for(int i=0;i<array.length;i++) {
			res+=array[i]+",";
		}
		System.out.println(res.subSequence(0, res.lastIndexOf(",")));
	}

	private static void makeNegativeNumberAside(int[] nums) {
		{
			int j = 0, temp;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] >= 0) {
					if (i != j) {
						temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}
					j++;
				}
			}
			
		}
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
	}

	private static String toUnicode(char ch) {
		return String.format("\\u%04x", (int) ch);
	}
	
}