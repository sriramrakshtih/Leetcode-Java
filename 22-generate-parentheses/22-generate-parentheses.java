class Solution {
    List<String> result; 
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder currString = new StringBuilder();
        dp(currString, n, n);
        return result;
    }

    void dp(StringBuilder currString, int openChar, int closeChar) {
        if (openChar == 0 && closeChar == 0) {
            result.add(currString.toString());
        }
        if (openChar > 0) {
            currString.append('(');
            dp(currString, openChar - 1, closeChar);
            currString.deleteCharAt(currString.length()-1);
        } 
        if (currString.length() != 0 && closeChar > 0 && openChar != closeChar) {
             currString.append(')');
            dp(currString, openChar, closeChar - 1);
             currString.deleteCharAt(currString.length()-1);
        }
       
    }
}