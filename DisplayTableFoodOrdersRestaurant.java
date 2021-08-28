/* Given the array orders, which represents the orders that customers have done in a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item customer orders.

Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered. The first column is the table number and the remaining columns correspond to each food item in alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the food items. Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order. */

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<String, HashMap<String, Integer>> tm = new TreeMap<>((String s1, String s2) -> Integer.parseInt(s1)-Integer.parseInt(s2));
        TreeSet<String> ts = new TreeSet<>();
        for(int i=0;i<orders.size();i++) {
            List<String> order = orders.get(i);
            HashMap<String, Integer> foodFreq = tm.getOrDefault(order.get(1), new HashMap<>());
            int currCount = foodFreq.getOrDefault(order.get(2),0)+1;
            foodFreq.put(order.get(2),currCount);
            tm.put(order.get(1), foodFreq);
            ts.add(order.get(2));
        }
        List<List<String>> res = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for(String food : ts) {
            header.add(food);
        }
        res.add(header);
        for(Map.Entry<String, HashMap<String, Integer>> table : tm.entrySet()) {
            String tableNo = table.getKey();
            HashMap<String, Integer> foods = table.getValue();
            List<String> curr = new ArrayList<>();
            curr.add(tableNo);
            for(String food : ts) {
                int count = foods.getOrDefault(food,0);
                curr.add(String.valueOf(count));
            }
            res.add(curr);
        }
        return res;
    }
}