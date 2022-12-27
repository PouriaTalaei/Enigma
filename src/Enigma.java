import java.util.HashMap;
import java.util.Map;

public class Enigma {
    Map<Character, Character> PlugBoard = new HashMap<>();
    Map<Character, Character> Rotator1 = new HashMap<>();
    Map<Character, Character> Rotator2 = new HashMap<>();
    Map<Character, Character> Rotator3 = new HashMap<>();
    Map<Character, Character> Reflector = new HashMap<>();

    int countRotate1 = 0; // (nRotate1+1)%26
    int countRotate2 = 0;
    int countRotate3 = 0;

    Enigma() {
        setReflector();
    }

    public void setReflector() {
        int asciNumFirst = 65;
        int asciNumLast = 90;
        char cFirst;
        char c1Last;
        for (int i = 0; i < 26; i++) {
            cFirst = (char) asciNumFirst;
            c1Last = (char) asciNumLast;
            Reflector.put(cFirst, c1Last);
            asciNumFirst++;
            asciNumLast--;
        }
    }
}
