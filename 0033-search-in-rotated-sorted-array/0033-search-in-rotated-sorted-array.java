class Solution {
    public int search(int[] num, int target) {
        int low = 0;
        int high = num.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(num[mid]==target){
                return mid;
            }
            if(num[low] <= num[mid]){
                if(target >=num[low] && target < num[mid]){
                    high = mid -1;
                }else{
                    low = mid +1;
                }
            }else{
                if(target<=num[high] && target > num[mid]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
        
    }
}