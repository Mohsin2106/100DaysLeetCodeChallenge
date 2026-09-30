class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int answer= 0;
        for(int house : houses ){
            int left = 0;
            int right = heaters.length - 1;
            while(left <=right){
                int mid = left + (right - left)/2;
                if(heaters[mid] < house){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            int distance = Integer.MAX_VALUE;
            if(left < heaters.length){
                distance = Math.min(distance , heaters[left] - house);
            }
            if( left >0){
                distance = Math.min(distance , house - heaters[left - 1]);
            }
            answer = Math.max(answer, distance);
        } 
        return answer;
    }
}