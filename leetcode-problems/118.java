// https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            if (i == 0) newRow.add(1);
            else if (i == 1) newRow.addAll(Arrays.asList(1, 1));
            else {
                newRow.add(1);
                for (int j = 1; j < i; j++){
                    newRow.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
                newRow.add(1);
                
            }
            triangle.add(newRow);
        }
        
        return triangle;
    }
}
