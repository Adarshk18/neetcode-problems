class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int prev = 1;
        int prev2 =0;

        for(int i=n-1; i>=0; i--){
            int curr = 0;

            if(s.charAt(i)!='0'){
                curr = prev;

                if(i+1<n){
                    int num = (s.charAt(i)-'0') * 10 + (s.charAt(i+1)-'0');

                    if(num>=10 && num<=26){
                        curr += prev2;
                    }
                }
                
            }
            prev2 = prev;
                prev = curr;
        }
        return prev;
    }
}
