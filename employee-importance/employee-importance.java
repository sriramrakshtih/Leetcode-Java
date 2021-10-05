/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        return dfs(id);
    }
    
    private int dfs(int eid) {
        Employee employee = map.get(eid);
        int res = 0;
        res += employee.importance;
        for(Integer subId : employee.subordinates){
            res += dfs(subId);
        }
        
        return res;
    }
}