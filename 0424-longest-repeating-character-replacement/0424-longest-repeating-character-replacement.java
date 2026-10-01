class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int answer = 0;
        HashMap<Character , Integer> map = new HashMap<>();

        for( int right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);

            map.put(ch ,map.getOrDefault(ch , 0) +1);
            maxFreq = Math.max(maxFreq , map.get(ch));
            
            if( (right - left + 1 ) - maxFreq > k){
                char LeftChar = s.charAt(left);
                map.put(LeftChar ,map.get(LeftChar) - 1 );
                left++;
            }
            answer = Math.max(answer ,right - left + 1 );
        }
        return answer;
    }
}