class Solution {

    Set<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    private void dfs(String exp) {

        int close = exp.indexOf('}');

        // No braces left
        if (close == -1) {
            set.add(exp);
            return;
        }

        // Find the matching '{'
        int open = exp.lastIndexOf('{', close);

        String left = exp.substring(0, open);
        String middle = exp.substring(open + 1, close);
        String right = exp.substring(close + 1);

        // Split choices by comma
        String[] choices = middle.split(",");

        for (String choice : choices) {
            dfs(left + choice + right);
        }
    }
}