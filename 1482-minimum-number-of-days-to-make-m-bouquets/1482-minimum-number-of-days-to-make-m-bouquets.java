class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        if ( (long) m * k >bloomDay.length){
            return -1;
        }
        for ( int day : bloomDay){
            low = Math.min(low,day);
            high = Math.max(high , day);
        }
        while(low<=high){
            int mid = low + (high - low )/2;
            if ( possible(bloomDay , m , k ,mid)){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    boolean possible(int[]bloomDay, int m , int k, int day){
        int flower = 0;
        int bouquets = 0;
        for (int  bloom :bloomDay){
            if (bloom <=day){
                flower  ++;
                if (flower == k){
                    bouquets++;
                    flower = 0;
                }

            } else {
                flower = 0;
            }
        }
        return bouquets >=m;
    }
}