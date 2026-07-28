class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res =0;

        for(int i=0; i<n; i++){
            //odd length
           res+= count(s,i,i);

            //even length
            res+=count(s,i,i+1);

        }
        return res;
    }

    private int count(String s, int left, int right){
        int n = s.length();
        int res =0;
        while(left>=0 && right <n && s.charAt(left)==s.charAt(right)){
            res++;
            left--;
            right++;
        }
        return res;
    }
}
