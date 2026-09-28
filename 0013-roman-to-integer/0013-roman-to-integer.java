class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        HashMap<String, Integer> mp1 = new HashMap<>();

        mp1.put("IV", 4);
        mp1.put("IX", 9);
        mp1.put("XL", 40);
        mp1.put("XC", 90);
        mp1.put("CD", 400);
        mp1.put("CM", 900);

        int n = s.length(), T = 0;

        for (int i = 0; i < n; ++i) {
            if (i + 1 < n) {
                StringBuilder C = new StringBuilder();
                C.append(s.charAt(i));
                C.append(s.charAt(i + 1));

                if (mp1.containsKey(C.toString())) {
                    T += mp1.get(C.toString());
                    ++i;
                    continue;
                }
            }

            T += mp.get(s.charAt(i));
        }

        return T;
    }
}