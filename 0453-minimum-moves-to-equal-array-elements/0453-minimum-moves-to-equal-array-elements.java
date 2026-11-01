class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];

        for(int i =0; i < nums.length; i++){
            if(nums[i] < min ){
                min = nums[i];
            }
        }
        long moves = 0;

        for(int i = 0 ; i < nums.length ; i++){
            moves = moves + (nums[i] - min);
        }
        return (int) moves;
        
    }
}