public class WordCount {
    public static void main(String[] args) {
        //Name: Wang Yihan;
        //Email: Y.Wang437@lse.ac.uk;
        int count = 0;
        for (String text : args) {
            for (int i = 0; i < text.length(); i++) {
                if (((i > 0) && (Character.isWhitespace(text.charAt(i)) == false) && (
                        Character.isWhitespace(text.charAt(i - 1)) == true)) || (
                        (Character.isWhitespace(text.charAt(0)) == false) && (i
                                == 0))) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
