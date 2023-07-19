public class LetterGrouping {

    public String group(String str) {
        int count = 0;
        int i = 0;
        String newString = "";
        char[] charArray = str.toCharArray();

        while (i <= str.length()-1) {
            count = 1;
            i++;

            while (i <=str.length()-1 && charArray[i - 1] == charArray[i]) {
                count++;
                i++;
            }
            newString = newString + String.valueOf(count) + charArray[i-1] + " ";
        }
        return newString;
    }

    public static void main(String[] args) {
        LetterGrouping lg = new LetterGrouping();
        String result = lg.group("AAAAARRRRRPPPPPOOOORRR");
        System.out.println(result);
    }
}
