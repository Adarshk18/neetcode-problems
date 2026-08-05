class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if(m+n!=s3.length()){
            return false;
        }

        boolean[] prev = new boolean[n+1];
        prev[0] = true;

        for(int j=1; j<=n; j++){
            prev[j] = prev[j-1] && (s2.charAt(j-1)==s3.charAt(j-1)); 
        }

        for(int i=1; i<=m; i++){
            boolean[] curr = new boolean[n+1];
            curr[0] = prev[0] && (s1.charAt(i-1)==s3.charAt(i-1));

            for(int j=1; j<=n; j++){
                boolean takefromS1 = prev[j] && (s1.charAt(i-1)==s3.charAt(i+j-1));
                boolean takefromS2 = curr[j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1));

                curr[j] = takefromS1 || takefromS2;
            }
            prev = curr;
        }
        return prev[n];
    }
}
