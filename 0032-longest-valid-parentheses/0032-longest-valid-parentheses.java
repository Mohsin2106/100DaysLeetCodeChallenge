class Solution {
    class Pair {
        Character first ; Integer second;

        Pair(Character first , Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int [] arr = new int[n];

        Arrays.fill(arr , -1);

        Stack<Pair> stk = new Stack();

        for(int i = 0; i < n; ++i) {
            if(s.charAt(i) == ')') {
                if((stk.size() > 0) && (stk.peek().first.equals('('))) {
                     arr[i] = stk.peek().second;
                     stk.pop();
                } else {
                     stk.push(new Pair(')' , i));
                }
            } else {
                stk.push(new Pair('(' , i));
            }
        }

        // for(int i = 0; i < n; ++i)
        //   System.out.print(arr[i] + " ");

        // System.out.println();

        for(int i = n - 1; i >= 0; --i) {
            if(arr[i] != -1) {
                int end = arr[i];

                for(int j = i; j >= end; --j) {
                    arr[j] = 1;
                }

                i = end;
            }
        }

        // for(int i = 0; i < n; ++i)
        //   System.out.print(arr[i] + " ");

        // System.out.println();

        int Ans = 0 , cnt = 0;

        for(int i = 0; i < n; ++i) {
            if(arr[i] == 1) {
                ++cnt;
                Ans = Math.max(Ans , cnt);
            } else {
                cnt = 0;
            }
        }

        return Ans;
    }
}