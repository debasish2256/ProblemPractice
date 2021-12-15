package contest;

import java.util.ArrayList;
import java.util.Scanner;

public class spiralTraverseMatrix {
	public static void main(String[] args) {
		/*Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0) {
			int r=sc.nextInt();
			int c=sc.nextInt();
			int matrix[][]=new int[r][c];
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					matrix[i][j]=sc.nextInt();
				}
			}*/
			Solution1 ob=new Solution1();
			ArrayList<Integer> ans =ob.spirallyTraverse(new int[][]{
				   {1, 2,  3,  4 },
		           {5, 6,  7,  8 },
		           {9, 10, 11, 12}
		           					}, 3, 4);
			for(Integer val: ans) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
//}


class Solution1
{
    static ArrayList<Integer> spirallyTraverse(int a[][], int bottom, int right)
    {	
    	ArrayList<Integer> res=new ArrayList<>();
    	
    	int i, top = 0, left = 0;

    	while (top < bottom && left < right) {
    		for (i = left; i < right; i++) {
    			res.add(a[top][i]);
    		}
    		top++;

    		for (i = top; i < bottom; i++) {
    			res.add(a[i][right - 1]);
    		}
    		right--;

    		if (top < bottom) {
    			for (i = right - 1; i >= left; i--) {
    				res.add(a[bottom - 1][i]);
    			}
    			bottom--;
    		}

    		if (left < right) {
    			for (i = bottom - 1; i >= top; i--) {
    				res.add(a[i][left]);
    			}
    			left++;
    		}
    	}
		return res;
    }
}