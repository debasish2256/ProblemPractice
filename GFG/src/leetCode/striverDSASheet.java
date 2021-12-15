package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class striverDSASheet {

	public static void main(String[] args) {
		String str1="aabbcc";
		String str2="xxyyzz";
//		System.out.println(isIsomorphicString(str1,str2));
//		System.out.println(maxLevel(new int[]{8,9,6,5,7,3,2,1));
//		printOneDarray(twoSum(array,11));
		int nums[]= {1,0,-1,0,-2,2};
//		System.out.println(fourSum(nums,0));
//		System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
//		System.out.println(maxSubArraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		int arrays[] = {15,-2,2,-8,1,7,10,23};
//		System.out.println(largestSubArrayZeroSum(arrays,arrays.length));
//		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
	}
	
	
	//kadanes algo
	private static int maxSubArraySum(int[] nums) {
		int sum=0;
		int maximum=nums[0];
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			if(sum>maximum) maximum=sum;
			if(sum<0) sum=0;
		}
		return maximum;
	}
	
	private static int largestSubArrayZeroSum(int arr[], int n) {
		 HashMap<Integer,Integer> map=new HashMap<>();
		 int max_len=0;
		 int sum=0;
		 for(int i=0;i<n;i++) {
			sum+=arr[i];
			if(sum==0) {
				max_len =i+1;
			}
			else {
				if(map.get(sum)!=null) {
					max_len=Math.max(max_len, i-map.get(sum));
				}else {
					map.put(sum, i);
				}
			}
		 } 
		 return max_len;
	 }
	
	public static int lengthOfLongestSubstring(String s) {
		int left=0,right=0,length=0;
		int n=s.length();
		HashMap<Character,Integer> map=new HashMap<>();
		while(right<n) {
			if(map.containsKey(s.charAt(right))) {
				left=Math.max(left,map.get(s.charAt(right))+1);
			}
			map.put(s.charAt(right),right);
			length=Math.max(length, right-left+1);
			right++;
		}
		return length;
    }
	
	private static int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		Set<Integer> set=new HashSet<>();
		for(int number:nums) {
			set.add(number);
		}
		int longestStreak=0;
		for(int num:nums) {
			//check previous is exist or not
			if(!set.contains(num-1)) {
				int currentNum=num;
				int currentSreak=1;
				//check until next element not present streak is incremented
				while(set.contains(currentNum+1)) {
					currentNum+=1;
					currentSreak++;
				}
				longestStreak=Math.max(longestStreak, currentSreak);
			}
		}		
		return longestStreak; 
	}
	
	private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int start = j + 1, end = nums.length - 1;
                int cur = target - nums[i] - nums[j];
                int index = start;
                while(start < end) {
                    int twoSum = nums[start] + nums[end];
                    if(twoSum > cur || end < nums.length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                    } else if(twoSum < cur || start > index && nums[start] == nums[start - 1]) {
                        start++;
                    } else {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[start++]);
                        sol.add(nums[end--]);
                        res.add(sol);
                    }
                }
            }
        }
        return res;
    }
	
	private static int[] twoSum(int[] nums, int target) {
		int[] result =new int[2]; 
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			//mapping with subtract result and index
			if(map.containsKey(target-nums[i])) {
				result[0]=map.get(target-nums[i]);
				result[1]=i;
				return result;
			}
			//mapping with number and index
			map.put(nums[i], i);
		}
		return result;
	}

	private static int maxLevel(int[] box) {
		Arrays.sort(box);
		int ans=1;
		int preWidth=box[0];
		int preCount=1;
		
		int curCount=0;
		int curWidth=0;
		for(int i=1;i<box.length;i++) {
			curWidth+=box[i];
			curCount++;
			if(curWidth>preWidth && curCount>preCount) {
				preWidth=curWidth;
				preCount=curCount;
				curCount=0;
				curWidth=0;
				ans++;
			}
		}
		return ans;
	}

	private static void printOneDarray(int[] array) {
		String res="";
		for(int i=0;i<array.length;i++) {
			res+=array[i]+",";
		}
		System.out.println(res.subSequence(0, res.lastIndexOf(",")));
	}
	
	private static boolean isIsomorphicString(String s1, String s2) {
		int l1=s1.length();int l2=s2.length();
		if(l1!=l2) return false;

		int m1[] =new int[256];		int m2[] =new int[256];

		for(int i=0;i<l1;i++) {
			m1[s1.charAt(i)]++;
			m2[s2.charAt(i)]++;
			//check the m1 and m2 total count
			if (m1[s1.charAt(i)] !=m2[s2.charAt(i)])
			{
				return false;
			}
		}
		return true;
	}
	
	//O(N^2)
	private static int maxProfit(int[] prices) {
		int maxProfit =0;
		/*for(int i=0;i<prices.length;i++) {
			for(int j=i+1;j<prices.length;j++) {
				maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
			}
		}*/	
    //O(N)
		int minPrice=Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++) {
			minPrice=Math.min(minPrice,prices[i]);
			maxProfit=Math.max(maxProfit, prices[i]-minPrice);	
		}
		return maxProfit ;
    }
	
	//maximum height from the given array of objects
	

}
