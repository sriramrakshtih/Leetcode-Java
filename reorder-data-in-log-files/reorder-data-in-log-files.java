class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
        Comparator<String> myComp = new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                String [] split1 = str1.split(" ", 2);
                String [] split2 = str2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                
                //case 1 - if both are ltrString
                if(!isDigit1 && !isDigit2){
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp != 0) {
                        return cmp;
                    } 
                    return split1[0].compareTo(split2[0]);
                } 
                
                //case 2
                if(!isDigit1 && isDigit2) {
                    return -1;
                } else if(isDigit1 && !isDigit2){
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        // for(int i = 0; i < logs.length; i++) {
        //     String [] split1 = logs[i].split(" ", 2);
        //     System.out.println(Arrays.toString(split1));
        // }
        
        //String [] split2 = str2.split(" ", 2);
        Arrays.sort(logs, myComp);
        return logs;
        //System.out.println(split2);
    }
}