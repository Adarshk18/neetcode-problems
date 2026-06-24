class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
            return res;
        }

        Map<Character, String> digitsToChar = new HashMap<>();
        digitsToChar.put('2', "abc");
        digitsToChar.put('3', "def");
        digitsToChar.put('4', "ghi");
        digitsToChar.put('5', "jkl");
        digitsToChar.put('6', "mno");
        digitsToChar.put('7', "pqrs");
        digitsToChar.put('8', "tuv");
        digitsToChar.put('9', "wxyz");

        backtrack(0, "", digits, digitsToChar);
        return res;

    }

    private void backtrack(int i, String currStr, String digits, Map<Character, String> digitsToChar){
        if(currStr.length()==digits.length()){
            res.add(currStr);
            return;
        }

        String letters = digitsToChar.get(digits.charAt(i));

        for(char c: letters.toCharArray()){
            backtrack(i+1, currStr+c, digits, digitsToChar);
        }
    }
}
