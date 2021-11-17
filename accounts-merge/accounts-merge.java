class Solution {
    HashSet<String> visited = new HashSet<>();
    HashMap<String, List<String>> map = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {    
        for(List<String> account : accounts) {
            int accountSize = account.size();
            String firstEmail = account.get(1);
            
            for(int j = 2; j < accountSize; j++) {
                String email = account.get(j);
                
                if(!map.containsKey(firstEmail)){
                    map.put(firstEmail, new ArrayList<>());
                }
                map.get(firstEmail).add(email);
                
                if(!map.containsKey(email)){
                    map.put(email, new ArrayList<>());
                }
                map.get(email).add(firstEmail);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(List<String> account : accounts) {
            String accountName = account.get(0);
            String firstEmail = account.get(1);
            
            if(!visited.contains(firstEmail)){
                List<String> mergeAccount = new ArrayList<>();
                mergeAccount.add(accountName);
                dfs(mergeAccount, firstEmail);
                Collections.sort(mergeAccount.subList(1, mergeAccount.size()));
                result.add(mergeAccount);
            }
        }
        
        return result;
    }
    
    private void dfs(List<String> mergeAccount, String email) {
        visited.add(email);
        mergeAccount.add(email);
        
        if(!map.containsKey(email)){
            return;
        }
        
        for(String neighbour : map.get(email)){
            if(!visited.contains(neighbour)){
                dfs(mergeAccount, neighbour);
            }
        }
    }
}