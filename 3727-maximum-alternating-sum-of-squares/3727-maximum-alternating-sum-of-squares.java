class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n= nums.length;
        long[] square = new long[n];

        for ( int i = 0 ; i < n ; i++){
            square[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(square);
        int mid = n/2;
        long answer = 0;

        for(int i = 0 ; i < mid ; i++ ){
            answer -= square[i];
        }
        for( int i = mid ; i< n ; i++){
            answer += square[i];
        }
        return answer;
        
    }

}