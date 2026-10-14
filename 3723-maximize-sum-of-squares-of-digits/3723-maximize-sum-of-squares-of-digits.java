class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num){
            return "";
        }
        StringBuilder answer = new StringBuilder();

        while (sum >= 9){
            answer.append('9');
            sum -=9;
        }
        if(sum > 0){
            answer.append(sum);
        }
        while(answer.length() < num){
            answer.append('0');
        }
        return answer.toString();
        
    }
}