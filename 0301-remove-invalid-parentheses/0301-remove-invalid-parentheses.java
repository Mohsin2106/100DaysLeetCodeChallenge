class Solution {

    HashSet<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;
        int balance = 0;

       
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } 
            else if (ch == ')') {

                if (balance > 0) {
                    balance--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        leftRemove = balance;

       
        backtrack(s, 0, "", 0, leftRemove, rightRemove);

        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, String current,
                           int balance, int leftRemove, int rightRemove) {

      
        if (index == s.length()) {

            if (balance == 0 && leftRemove == 0 && rightRemove == 0) {
                result.add(current);
            }

            return;
        }

        char ch = s.charAt(index);

        
        if (ch == '(') {

          
            if (leftRemove > 0) {
                backtrack(
                    s,
                    index + 1,
                    current,
                    balance,
                    leftRemove - 1,
                    rightRemove
                );
            }

          
            backtrack(
                s,
                index + 1,
                current + ch,
                balance + 1,
                leftRemove,
                rightRemove
            );
        }

        
        else if (ch == ')') {

           
            if (rightRemove > 0) {
                backtrack(
                    s,
                    index + 1,
                    current,
                    balance,
                    leftRemove,
                    rightRemove - 1
                );
            }

            // Option 2: Keep ')' only if we have '(' available
            if (balance > 0) {
                backtrack(
                    s,
                    index + 1,
                    current + ch,
                    balance - 1,
                    leftRemove,
                    rightRemove
                );
            }
        }

      
        else {
            backtrack(
                s,
                index + 1,
                current + ch,
                balance,
                leftRemove,
                rightRemove
            );
        }
    }
}