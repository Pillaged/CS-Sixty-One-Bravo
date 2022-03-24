public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }
    public boolean isPalindrome(String word){
        int len = word.length();
        if (len == 0 || len == 1) {
            return true;
        }
        String hehp = "";
        String behp = "";
        boolean goop = false;
        int x = 0;
        while (len/2 > hehp.length()) {
            hehp = hehp + word.charAt(x);
            behp = behp + word.charAt((len-1)-x);
            goop = hehp.equals(behp);
            System.out.println(hehp + " - " + behp);
            x++;
        }
        return goop;
    }
}
