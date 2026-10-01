class Solution {

    public boolean isValid(String s) {
   
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        
        Stack<Character> stack = new Stack<>();
 
        for (char ch : s.toCharArray()) {
 
            if (map.containsKey(ch)) {
 
                if (stack.isEmpty()) {
                    return false;
                }

               
                char top = stack.pop();

             
                if (top != map.get(ch)) {
                    return false;
                }

            } else {

                
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}