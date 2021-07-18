// https://leetcode.com/problems/design-search-autocomplete-system/

class Node {
    char c;
    boolean isFinal;
    String finalString;
    int times;
    Map<Character, Node> next;
    
    public Node(char c, boolean isFinal, String finalString, int times) {
        this.c = c;
        this.isFinal = isFinal;
        this.finalString = finalString;
        this.times = times;
        this.next = new HashMap<>();
    }
    
    public void addFinalString(String finalString, int times) {
        this.isFinal = true;
        this.finalString = finalString;
        this.times = times;
    }
    
    public void addPossibleNode(char c, Node node) {
        this.next.put(c, node);
    }
}

class AutocompleteSystem {
    Node currentVal;
    Node rootNode;
    StringBuilder stringCache;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        generateTrie(sentences, times);
        this.currentVal = rootNode;
        this.stringCache = new StringBuilder();
    }
    
    private void generateTrie(String[] sentences, int[] times) {
        this.rootNode = new Node('/', false, null, 0);
        
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }
    
    private void addSentence(String sentence, int times) {
        char[] sentenceArr = sentence.toCharArray();
            
        List<Node> list = new ArrayList<>();
        for (int j = 0; j < sentenceArr.length; j++){
            char c = sentenceArr[j];
            Node tempNode = (j == sentenceArr.length - 1) ? new Node(c, true, sentence, times) : new Node(c, false, null, 0);
            if (j != 0) list.get(j-1).addPossibleNode(c, tempNode);
            list.add(tempNode);
        }

        Queue<Node> nodes = new LinkedList<>(list);
        Node tempNode = rootNode;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (tempNode.next.containsKey(node.c)){
                tempNode = tempNode.next.get(node.c);
                if (node.isFinal) {
                    if (tempNode.isFinal) tempNode.times += node.times;
                    else tempNode.addFinalString(node.finalString, node.times);
                }
            }
            else {
                tempNode.next.put(node.c, node);
                break;
            }
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            addSentence(stringCache.toString(), 1);
            stringCache = new StringBuilder();
            currentVal = rootNode;
            return new ArrayList<>();
        }
        
        stringCache.append(c);
        currentVal = currentVal.next.getOrDefault(c, new Node('/', false, "", 0));
        List<String> possibleSentences = getPossibleSentences();
        
        return possibleSentences;
    }
    
    private List<String> getPossibleSentences() {
        List<Node> sentences = new ArrayList<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentVal);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.isFinal) sentences.add(node);
            queue.addAll(node.next.values());
        }
        
        Collections.sort(sentences, new NodeCompare());
        
        List<String> returnList = new ArrayList();
        for (int i = 0; i < Math.min(sentences.size(), 3); i++) {
            returnList.add(sentences.get(i).finalString);
        }
        
        return returnList;
    }
}

class NodeCompare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        int diff = b.times - a.times;
        if (diff == 0) diff = a.finalString.compareTo(b.finalString);
        
        return diff;
    }
}
/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
