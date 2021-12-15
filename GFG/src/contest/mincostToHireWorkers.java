package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class mincostToHireWorkers {
	
	public static void main(String[] args) {
		int []quality = {3,1,10,1}, wage = {4,8,2,2,7};
		int k = 3;
		System.out.println(mincostToHireWorkers(quality,wage,k));
	}
	
	
    public static int mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[] ratio = new double[quality.length];
        Integer[] order = new Integer[quality.length];
        for(int i=0;i<quality.length;i++){
            ratio[i] = (double)wage[i]/quality[i];
            order[i] = i;
        }
        Arrays.sort(order,(o1,o2)->(Double.compare(ratio[o1],ratio[o2])));

        double minCost = Double.MAX_VALUE;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        double qSum = 0;
        for(int index:order){
            if(que.size()==k){
                qSum-= que.remove();
            }
            que.add(quality[index]);
            qSum+=quality[index];
            if(que.size()==k){
                minCost = Math.min(minCost,qSum*ratio[index]);
            }
        }
        
        return (int)minCost;
        
    }
}