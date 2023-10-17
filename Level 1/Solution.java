class Solution {
    public static String solution(String x) {
        // string.to.chars
        char[] letters = x.toCharArray();

        // letter loop
        for (int i = 0; i < letters.length; i++) {
            char aletter = letters[i];

            // only if letter is lower case
            if (Character.isLowerCase(aletter)) {
                // decode for lower case
                char dletter = decodeLetters(aletter);
                // chars to decoded chars
                letters[i] = dletter;
            }
            // upper case not changed
        }

        // return string
        return new String(letters);
    }
    //decoding...
    private static char decodeLetters(char letter) {
        //offset?
        int intletter = letter - 'a';
        return (char) ('z' - intletter);
    }
    public static void main(String[] args) {
        String s1 = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
        System.out.println(Solution.solution(s1));

        String s2 = "Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!";
        System.out.println(Solution.solution(s2));
    }
}