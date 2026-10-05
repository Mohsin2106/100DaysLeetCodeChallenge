class Solution {
    public int scoreOfParentheses(String s) {
        Stack < Integer> stk = new Stack<>();
        stk.push(0);

        for( char ch : s.toCharArray()){
            if( ch == '('){
                stk.push(0);
            
            }else{
                int value = stk.pop();
                int score ;
                if(value == 0){
                    score = 1;
                }else {
                    score = 2 * value;
                }
                stk.push(stk.pop() + score);
            }
        } 
        return stk.peek();
        
    }
}