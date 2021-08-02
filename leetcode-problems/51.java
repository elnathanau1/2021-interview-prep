// https://leetcode.com/problems/n-queens/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        placeQueens(0, n, new int[n][n], result);
        return result;
    }
    
    public void placeQueens(int i, int n, int[][] state, List<List<String>> result){
        if (i == n) {
            result.add(stateToList(state, n));
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (state[i][j] == 0) {
                // place queen here
                placeQueen(state, i, j, n);
                placeQueens(i + 1, n, state, result);
                removeQueen(state, i, j);
            }
        }
    }
    
    public void placeQueen(int[][] state, int placeI, int placeJ, int n) {      
        for (int i = 0; i < state.length; i++) {
            state[i][placeJ] += 1;
        }
        
        for (int j = 0; j < state[0].length; j++) {
            state[placeI][j] += 1;
        }
        
        int tempI = placeI + 1;
        int tempJ = placeJ + 1;
        while (tempI < state.length && tempJ < state[0].length) {
            state[tempI][tempJ]++;
            tempI++;
            tempJ++;
        }
        
        tempI = placeI - 1;
        tempJ = placeJ - 1;
        while (tempI >= 0 && tempJ >= 0) {
            state[tempI][tempJ]++;
            tempI--;
            tempJ--;
        }
        
        
        tempI = placeI - 1;
        tempJ = placeJ + 1;
        while (tempI >= 0 && tempJ < state[0].length) {
            state[tempI][tempJ]++;
            tempI--;
            tempJ++;
        }
        
        tempI = placeI + 1;
        tempJ = placeJ - 1;
        while (tempI < state.length && tempJ >= 0) {
            state[tempI][tempJ]++;
            tempI++;
            tempJ--;
        }
        
        state[placeI][placeJ] = n+1;
    }
    
    
    public void removeQueen(int[][] state, int placeI, int placeJ) {      
        for (int i = 0; i < state.length; i++) {
            state[i][placeJ] -= 1;
        }
        
        for (int j = 0; j < state[0].length; j++) {
            state[placeI][j] -= 1;
        }
        
        int tempI = placeI + 1;
        int tempJ = placeJ + 1;
        while (tempI < state.length && tempJ < state[0].length) {
            state[tempI][tempJ]--;
            tempI++;
            tempJ++;
        }
        
        tempI = placeI - 1;
        tempJ = placeJ - 1;
        while (tempI >= 0 && tempJ >= 0) {
            state[tempI][tempJ]--;
            tempI--;
            tempJ--;
        }
        
        
        tempI = placeI - 1;
        tempJ = placeJ + 1;
        while (tempI >= 0 && tempJ < state[0].length) {
            state[tempI][tempJ]--;
            tempI--;
            tempJ++;
        }
        
        tempI = placeI + 1;
        tempJ = placeJ - 1;
        while (tempI < state.length && tempJ >= 0) {
            state[tempI][tempJ]--;
            tempI++;
            tempJ--;
        }
        
        state[placeI][placeJ] = 0;
    }

    public List<String> stateToList(int[][] state, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < state.length; i++) {
            String temp = "";
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] > n) temp += "Q";
                else temp += ".";
            }
            result.add(temp);
        }
        
        return result;
    }
}
