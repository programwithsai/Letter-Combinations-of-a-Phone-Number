import java.util.*;

class OptimisedSolution {
  Map<Character, String> keyMap = Map.of(
  '2', "abc",
  '3', "def",
  '4', "ghi",
  '5', "jkl",
  '6', "mno",
  '7', "pqrs",
  '8', "tuv",
  '9', "wxyz");
  
  List<String> result = new ArrayList<>();
  
  void generate(String digits, int i, StringBuilder cur) {
    if (cur.length() == digits.length()) {
      result.add(cur.toString());
      return;
    }
    char d = digits.charAt(i);
    char[] letters = keyMap.get(d).toCharArray();
    for (char c : letters) {
      generate(digits, i + 1, cur.append(c));
      // After generating the combination, remove the appended character
      cur.deleteCharAt(cur.length() - 1);
    }
  }
  
  public List<String> letterCombinations(String digits) {
    if (digits.length() > 0) {
      generate(digits, 0, new StringBuilder(""));
    }
    
    return result;
  }
}
