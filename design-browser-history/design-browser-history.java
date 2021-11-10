class BrowserHistory {
    List<String> li = new ArrayList<>();
    int i = 0;
    public BrowserHistory(String homepage) {
        li.add(homepage);
    }
    
    public void visit(String url) {
        li.subList(i+1, li.size()).clear();
        li.add(url);
        i++;
    }
    
    public String back(int steps) {
        i = Math.max(i - steps, 0);
        return li.get(i);
                           
    }
    
    public String forward(int steps) {
        i = Math.min(i + steps, li.size() - 1);
        return li.get(i);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */