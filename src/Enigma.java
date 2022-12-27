import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

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
        int asciiNumFirst = 97;
        int asciiNumLast = 122;
        char cFirst;
        char c1Last;
        for (int i = 0; i < 26; i++) {
            cFirst = (char) asciiNumFirst;
            c1Last = (char) asciiNumLast;
            Reflector.put(cFirst, c1Last);
            asciiNumFirst++;
            asciiNumLast--;
        }
    }

    public void plugBoard(String plugBoardLine) {
        String plugBoardStr = plugBoardLine.substring(12, plugBoardLine.length() - 1);
        String plugBoardStrArray[] = plugBoardStr.split(", ");
        for (int i = 0; i < plugBoardStrArray.length; i++) {
            PlugBoard.put(plugBoardStrArray[i].charAt(0), plugBoardStrArray[i].charAt(1));
        }
//        for (int i = 0; i < plugBoardStrArray.length; i++) {
//            PlugBoard.put(plugBoardStrArray[i].charAt(1), plugBoardStrArray[i].charAt(0));
//        }
    }

    public void rotator1(String rotate1Line) {  //    ascii A to Z is 65 to  90
        String rotate1Str = rotate1Line.substring(9, rotate1Line.length() - 1);
        int asciiNum = 97;
        char c;
        for (int i = 0; i < rotate1Str.length(); i++) {
            c = (char) asciiNum;
            Rotator1.put(c, rotate1Str.charAt(i));
            asciiNum++;
        }
    }

    public void rotator2(String rotate2Line) {  //    ascii A to Z is 65 to  90
        String rotate2Str = rotate2Line.substring(9, rotate2Line.length() - 1);
        int asciiNum = 97;
        char c;
        for (int i = 0; i < rotate2Str.length(); i++) {
            c = (char) asciiNum;
            Rotator2.put(c, rotate2Str.charAt(i));
            asciiNum++;
        }
    }


    public void rotator3(String rotate3Line) {  //    ascii A to Z is 65 to  90
        String rotate3Str = rotate3Line.substring(9, rotate3Line.length() - 1);
        int asciiNum = 97;
        char c;
        for (int i = 0; i < rotate3Str.length(); i++) {
            c = (char) asciiNum;
            Rotator3.put(c, rotate3Str.charAt(i));
            asciiNum++;
        }
    }

    public char getPlugBoardValueByKey(char c) {
        if (PlugBoard.get(c) == null)
            return c;
        return PlugBoard.get(c);
    }

    public char getReflectorValueByKey(char c) {
        return Reflector.get(c);
    }

    public char getRotator1ValueByKey(char c) {
        return Rotator1.get(c);
    }

    public char getRotator2ValueByKey(char c) {
        return Rotator2.get(c);
    }

    public char getRotator3ValueByKey(char c) {
        return Rotator3.get(c);
    }


    public void changeRotator1() {
        int asciiNum = 122;
        char c, c2;
        char last = Rotator1.get('z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciiNum;
            c2 = (char) (asciiNum - 1);
            Rotator1.put(c, Rotator1.get(c2));
            asciiNum--;
        }
        Rotator1.put('a', last);
    }

    public void changeRotator2() {
        int asciiNum = 122;
        char c, c2;
        char last = Rotator2.get('z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciiNum;
            c2 = (char) (asciiNum - 1);
            Rotator2.put(c, Rotator2.get(c2));
            asciiNum--;
        }
        Rotator2.put('a', last);
    }


    public void changeRotator3() {
        int asciiNum = 122;
        char c, c2;
        char last = Rotator3.get('z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciiNum;
            c2 = (char) (asciiNum - 1);
            Rotator3.put(c, Rotator3.get(c2));
            asciiNum--;
        }
        Rotator3.put('a', last);
    }

    public char enigmaDecoding(char c) {

        char answer = getPlugBoardValueByKey(getRotator3ValueByKey(getRotator2ValueByKey(getRotator1ValueByKey(getReflectorValueByKey(getRotator1ValueByKey(getRotator2ValueByKey(getRotator3ValueByKey(getPlugBoardValueByKey(c)))))))));

        countRotate1++;
        if (countRotate1 == 26) {
            changeRotator1();
            countRotate2++;
            countRotate1 = 0;
        }
        if (countRotate2 == 26) {
            changeRotator2();
            countRotate3++;
            countRotate2 = 0;
        }
        if (countRotate3 == 26) {
            changeRotator3();
            countRotate1++;
            countRotate3 = 0;
        }
        return answer;
    }
}
