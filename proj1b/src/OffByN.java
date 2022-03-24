import static java.lang.Math.abs;

public class OffByN implements CharacterComparator{
    public int N;
    OffByN(int No) {
        N = No;
    }
    public boolean equalChars(char x, char y) {
        if (abs(x - y) == N) {
            return true;
        } else {
            return false;
        }
    }
}
