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

    public Enigma() {
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

    public void plugBoard(String plugBoardLine) {
        String plugBoardStr = plugBoardLine.substring(12, plugBoardLine.length() - 1);
        String plugBoardStrArray[] = plugBoardStr.split(", ");
        for (int i = 0; i < plugBoardStrArray.length; i++) {
            PlugBoard.put(plugBoardStrArray[i].charAt(0), plugBoardStrArray[i].charAt(1));
        }
        for (int i = 0; i < plugBoardStrArray.length; i++) {
            PlugBoard.put(plugBoardStrArray[i].charAt(1), plugBoardStrArray[i].charAt(0));
        }
    }

    public void rotator1(String rotate1Str){  //    ascii A to Z is 65 to  90
        int asciiNum = 65;
        char c;
        for (int i = 0; i < rotate1Str.length(); i++) {
            c = (char) asciiNum;
            Rotator1.put(c, rotate1Str.charAt(i));
            asciiNum++;
        }
    }

    public void rotator2(String rotate2Str){  //    ascii A to Z is 65 to  90
        int asciiNum = 65;
        char c;
        for (int i = 0; i < rotate2Str.length(); i++) {
            c = (char) asciiNum;
            Rotator2.put(c, rotate2Str.charAt(i));
            asciiNum++;
        }

    }


    public void rotator3(String rotate3Str){  //    ascii A to Z is 65 to  90
        int asciiNum = 65;
        char c;
        for (int i = 0; i < rotate3Str.length(); i++) {
            c = (char) asciiNum;
            Rotator3.put(c, rotate3Str.charAt(i));
            asciiNum++;
        }
        System.out.println(Rotator3);

    }


}
