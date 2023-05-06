class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String [] strArr = sentence.split(" ");
        int i = 0;
        for(String str : strArr){
            i++;
            if(str.startsWith(searchWord)) return i;
        }
        return -1;
    }
}