package palindrom;

public class PalindromTest {
    public static void main(String[] args) {


        String myString = "ala wzorcowo owoc rozwala".trim();
        System.out.println(isPalindrom(myString));
    }

    static boolean isPalindrom(String myString){
        for (int i = 0, j = myString.length() - 1; j - i == 1; i++, j--) {
            if (myString.charAt(i) != myString.charAt(j)) return false;
        }
        return true;
    }
}
