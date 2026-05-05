class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String t: tokens){
            if(isOperator(t)){
                int b = st.pop();
                int a = st.pop();

                switch (t){
                    case "+":
                    st.push(a+b);
                    break;

                    case "*":
                    st.push(a*b);
                    break;

                    case "-":
                    st.push(a-b);
                    break;

                    case "/":
                    st.push(a/b);
                    break;
                }
            }else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.peek();
    }

    private boolean isOperator(String s){
        return s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/");
    }
}
