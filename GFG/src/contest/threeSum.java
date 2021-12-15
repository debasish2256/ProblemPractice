package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
	static List<List<Integer>> threeSum(int[] nums) {
		 /*  HashSet<List<Integer>> ans = new HashSet<>();
		    if(nums.length<3)
		        return new ArrayList(ans);
		    else{
		        Arrays.sort(nums);
		        for(int i=0;i<nums.length-2;i++){
		            int l = i+1,r = nums.length-1;
		            while(l<r){
		                int sum = nums[l]+nums[r]+nums[i];
		                if(sum==0)
		                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
		                if(sum<0)
		                    l++;
		                else
		                    r--;
		            }
		        }
		    }
		    return new ArrayList(ans);*/
		
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<>();
		for(int i=0;i<nums.length-2;i++) {
			if(i==0 ||(i>0 && nums[i]!=nums[i-1])) {
				int lo =i+1;
				int hi=nums.length-1;
				int sum=-nums[i];
				//two pointer concept 
				while(lo<hi) {
					if(nums[lo]+nums[hi]==sum) {
						res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
						while(lo<hi && nums[lo]==nums[lo+1]) lo++;
						while(lo<hi && nums[hi]==nums[hi-1]) hi--;
						lo++;
						hi--;
					}else if(nums[lo]+nums[hi]<sum) {
						lo++;
					}else {
						hi--;
					}
				}
			}
		}
		return res;
		}
	}
