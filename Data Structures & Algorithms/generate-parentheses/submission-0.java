class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backtrack(0,0,n,stack,res);
        return res;
    }

    private void backtrack(int open , int close, int n , StringBuilder stack, List<String> res){
        if(open==n && close==n){
            res.add(stack.toString());
            return;
        }

        if(open < n){
            stack.append('(');
            backtrack(open+1, close, n, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }

        if(close < open){
            stack.append(')');
            backtrack(open , close+1, n, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
