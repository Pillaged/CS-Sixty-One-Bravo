public class OffByOne implements CharacterComparator{
    public boolean equalChars(char x, char y) {
        int x1 = (int) x;
        int y1 = (int) y;
        if (x - y == 1 || x-y == -1) {
            return true;
        } else {
            return false;
        }
    }
}
