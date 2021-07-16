// https://leetcode.com/problems/valid-number/

class State {
    Map<Input, Integer> map;
    boolean validState;
    
    public State() {
        map = new HashMap();
        this.validState = false;
    }
    
    public void addStateChange(Input i, int nextState){
        this.map.put(i, nextState);
    }
    
    public void setValidState() { this.validState = true; }
}

class Solution {
    private List<State> states;
    
    public boolean isNumber(String s) {
        setUpStates();
        List<Input> inputs = new ArrayList();
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') inputs.add(Input.PLUS_MINUS);
            else if (c == 'e' || c == 'E') inputs.add(Input.E);
            else if (c == '.') inputs.add(Input.DOT);
            else if (c >= 48 && c <= 57) inputs.add(Input.DIGIT);
            else return false;
        }
        
        State curr = states.get(0);
        for (Input input : inputs) {
            Integer nextStateIndex = curr.map.get(input);
            if (nextStateIndex == null) { return false; }
            curr = states.get(nextStateIndex);
        }
        
        return curr.validState;
    }
    
    private void setUpStates() {
        states = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            states.add(new State());
        }
        
        // default starting state
        states.get(0).addStateChange(Input.DIGIT, 2);
        states.get(0).addStateChange(Input.PLUS_MINUS, 1);
        states.get(0).addStateChange(Input.DOT, 3);
        
        states.get(1).addStateChange(Input.DIGIT, 2);
        states.get(1).addStateChange(Input.DOT, 3);
        
        // INTEGER final
        states.get(2).setValidState();
        states.get(2).addStateChange(Input.DOT, 4);
        states.get(2).addStateChange(Input.E, 6);
        states.get(2).addStateChange(Input.DIGIT, 2);
        
        states.get(3).addStateChange(Input.DIGIT, 5);
        
        states.get(4).setValidState();
        states.get(4).addStateChange(Input.DIGIT, 5);
        states.get(4).addStateChange(Input.E, 6);
        
        // DECIMAL final
        states.get(5).setValidState();
        states.get(5).addStateChange(Input.DIGIT, 5);
        states.get(5).addStateChange(Input.E, 6);
        
        states.get(6).addStateChange(Input.DIGIT, 7);
        states.get(6).addStateChange(Input.PLUS_MINUS, 8);
        
        // VALID NUMBER FINAL
        states.get(7).setValidState();
        states.get(7).addStateChange(Input.DIGIT, 7);
        
        states.get(8).addStateChange(Input.DIGIT, 7);
    }
    
}

enum Input {
    PLUS_MINUS,
    E,
    DOT,
    DIGIT
}
