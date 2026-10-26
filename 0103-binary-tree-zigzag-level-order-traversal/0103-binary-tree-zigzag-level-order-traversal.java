class Solution {
    void dfs(TreeNode curr , int height , List<List<Integer>> Ans) {
        if(curr == null) 
            return;

        if(height >= Ans.size()) 
            Ans.add(new ArrayList<>());

        Ans.get(height).add(curr.val);    

        dfs(curr.left , height + 1 , Ans);
        dfs(curr.right , height + 1 , Ans);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> Ans = new ArrayList<>();

        dfs(root , 0 , Ans);

        for(int i = 1; i < Ans.size(); i += 2) 
           Collections.reverse(Ans.get(i));
        return Ans;        
    }
}