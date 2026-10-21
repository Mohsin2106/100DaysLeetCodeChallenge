class Solution {
    public int minOperations(String inputString) {
        int stringLength = inputString.length();
        boolean isSorted = true;

        char minimumCharacter = inputString.charAt(0);
        char maximumCharacter = inputString.charAt(0);

        for (int index = 1; index < stringLength; index++) {
            char currentCharacter = inputString.charAt(index);

            if (currentCharacter < inputString.charAt(index - 1)) {
                isSorted = false;
            }

            if (currentCharacter < minimumCharacter) {
                minimumCharacter = currentCharacter;
            }

            if (currentCharacter > maximumCharacter) {
                maximumCharacter = currentCharacter;
            }
        }

        if (isSorted) {
            return 0;
        }

        if (stringLength == 2) {
            return -1;
        }

        if (inputString.charAt(0) == minimumCharacter
                || inputString.charAt(stringLength - 1) == maximumCharacter) {
            return 1;
        }

        for (int index = 1; index < stringLength - 1; index++) {
            char currentCharacter = inputString.charAt(index);

            if (currentCharacter == minimumCharacter
                    || currentCharacter == maximumCharacter) {
                return 2;
            }
        }

        return 3;
    }
}