class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination, 
                           List<String> result, Map<Character, String> digitToLetters) {
        if (index == digits.length()) { // Base case: If all digits are processed
            result.add(currentCombination.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(index)); // Get possible letters for current digit
        for (char letter : letters.toCharArray()) { 
            currentCombination.append(letter);  // Choose a letter
            backtrack(digits, index + 1, currentCombination, result, digitToLetters); // Explore next digit
            currentCombination.deleteCharAt(currentCombination.length() - 1); // Undo choice (Backtrack)
        }
    }
}
