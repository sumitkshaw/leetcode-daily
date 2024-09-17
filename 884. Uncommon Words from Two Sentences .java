class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words1 =s1.split(" ");
        String[] words2 =s2.split(" ");

        for (String word : words1){
            if (map.containsKey(word)){
                map.put(word, map.get(word)+1);
            } else{
                map.put(word, 1);
            }
        }

        for (String word : words2){
            if (map.containsKey(word)){
                map.put(word, map.get(word) +1);
            } else {
                map.put(word, 1);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) ==1){
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
