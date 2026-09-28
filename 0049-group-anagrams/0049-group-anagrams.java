class Solution {
    public List<List<String>> groupAnagrams(String[] S) {
        int n = S.length;

        HashMap<String , ArrayList<String>> mp = new HashMap<>();

        for(int i = 0; i < n; ++i) {
            String X = S[i];

            char [] C =  X.toCharArray();

            Arrays.sort(C);

            String S1 = new String(C);

            if(mp.containsKey(S1)) {
                mp.get(S1).add(S[i]);
            } else {
                ArrayList<String> A = new ArrayList<>();
                A.add(S[i]);
                mp.put(S1 , A);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String , ArrayList<String>> C : mp.entrySet()) {
            ans.add(C.getValue());
        }

        return ans;
    }
}