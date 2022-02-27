import java.util.*;

class Solution {
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
  
  void generate(String digits, int i, String cur) {
    if (cur.length() == digits.length()) {
      result.add(cur);
      return;
    }
    char d = digits.charAt(i);
    char[] letters = keyMap.get(d).toCharArray();
    for (char c : letters) {
      generate(digits, i + 1, cur + c);
    }
  }
  
  public List<String> letterCombinations(String digits) {
    if (digits.length() > 0) {
      generate(digits, 0, "");
    }
    
    return result;
  }
}

