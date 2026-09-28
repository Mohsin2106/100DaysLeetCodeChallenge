class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for( int i = triangle.size() -2 ; i >=0 ; i--){
            for ( int j = 0 ; j < triangle.get(i).size() ; j++){
                int left = triangle.get(i+1).get(j);
                int right = triangle.get(i+1).get(j+1);
                int smaller = Math.min(left,right);
                triangle.get(i).set(j , triangle.get(i).get(j) + smaller);
            }
        }
        return triangle.get(0).get(0);

        
    }
}