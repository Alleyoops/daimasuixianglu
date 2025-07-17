import java.util.ArrayList;

    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> list1 = new ArrayList<>(ransomNote.length());
        for (char c : ransomNote.toCharArray()) {
            list1.add(c);
        }
        
        List<Character> list2 = new ArrayList<>(magazine.length());
        for (char c : magazine.toCharArray()) {
            list2.add(c);
        }
        
        for(char c : list2){
            for (int i = 0; i < list1.size(); i++){
                if (c == list1.get(i)) {
                    list1.remove(i);
                    break;
                }
            }
        }
        return list1.isEmpty();
    }