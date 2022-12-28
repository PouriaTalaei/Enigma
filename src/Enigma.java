import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Enigma {
    Map<Character, Character> PlugBoard = new HashMap<>();
    Map<Character, Character> Rotor1 = new HashMap<>();
    Map<Character, Character> Rotor2 = new HashMap<>();
    Map<Character, Character> Rotor3 = new HashMap<>();
    Map<Character, Character> Rotor1Rev = new HashMap<>();
    Map<Character, Character> Rotor2Rev = new HashMap<>();
    Map<Character, Character> Rotor3Rev = new HashMap<>();
    Map<Character, Character> Reflector = new HashMap<>();

    int countRotor1 = 0; // (nRotate1+1)%26
    int countRotor2 = 0;
    int countRotor3 = 0;

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
        for (int i = 0; i < plugBoardStrArray.length; i++) {
            PlugBoard.put(plugBoardStrArray[i].charAt(1), plugBoardStrArray[i].charAt(0));
        }
    }

    public void rotor1(String rotor1Line) {  //    ascii A to Z is 65 to  90
        String rotor1Str = rotor1Line.substring(9, rotor1Line.length() - 1);
        int asciiNum = 97;
        char c;
        for (int i = 0; i < rotor1Str.length(); i++) {
            c = (char) asciiNum;
            Rotor1.put(c, rotor1Str.charAt(i));
            Rotor1Rev.put(rotor1Str.charAt(i), c);
            asciiNum++;
        }
    }

    public void rotor2(String rotor2Line) {  //    ascii A to Z is 65 to  90
        String rotor2Str = rotor2Line.substring(9, rotor2Line.length() - 1);
        int asciiNum = 97;
        char c;
        for (int i = 0; i < rotor2Str.length(); i++) {
            c = (char) asciiNum;
            Rotor2.put(c, rotor2Str.charAt(i));
            Rotor2Rev.put(rotor2Str.charAt(i), c);
            asciiNum++;
        }
    }


    public void rotor3(String rotor3Line) {  //    ascii A to Z is 65 to  90
        String rotor3Str = rotor3Line.substring(9, rotor3Line.length() - 1);
        int asciiNum = 97;
        char c;
        for (int i = 0; i < rotor3Str.length(); i++) {
            c = (char) asciiNum;
            Rotor3.put(c, rotor3Str.charAt(i));
            Rotor3Rev.put(rotor3Str.charAt(i), c);
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

    public char getRotor1ValueByKey(char c) {
        return Rotor1.get(c);
    }

    public char getRotor2ValueByKey(char c) {
        return Rotor2.get(c);
    }

    public char getRotor3ValueByKey(char c) {
        return Rotor3.get(c);
    }

    public char getRotor1KeyByValue(char c) {
        return Rotor1Rev.get(c);
    }

    public char getRotor2KeyByValue(char c) {
        return Rotor2Rev.get(c);
    }

    public char getRotor3KeyByValue(char c) {
        return Rotor3Rev.get(c);
    }


    public void changeRotor1() {
        int asciiNum = 122;
        char c, c2;
        char last = Rotor1.get('z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciiNum;
            c2 = (char) (asciiNum - 1);
            Rotor1.put(c, Rotor1.get(c2));
            asciiNum--;
        }
        Rotor1.put('a', last);
    }

    public void changeRotor2() {
        int asciiNum = 122;
        char c, c2;
        char last = Rotor2.get('z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciiNum;
            c2 = (char) (asciiNum - 1);
            Rotor2.put(c, Rotor2.get(c2));
            asciiNum--;
        }
        Rotor2.put('a', last);
    }


    public void changeRotor3() {
        int asciiNum = 122;
        char c, c2;
        char last = Rotor3.get('z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciiNum;
            c2 = (char) (asciiNum - 1);
            Rotor3.put(c, Rotor3.get(c2));
            asciiNum--;
        }
        Rotor3.put('a', last);
    }

    public Map<Character, Character> reversRotor(Map<Character, Character> rotor) {
        Map<Character, Character> revRotor = new HashMap<>();
        char first = 97;
        for (int i = 0; i < 26; i++) {
            revRotor.put(rotor.get(first), first);
            first++;
        }
        return revRotor;
    }


    public char enigmaDecoding(char c) {

        char answer = getPlugBoardValueByKey(getRotor3KeyByValue(getRotor2KeyByValue(getRotor1KeyByValue(getReflectorValueByKey(getRotor1ValueByKey(getRotor2ValueByKey(getRotor3ValueByKey(getPlugBoardValueByKey(c)))))))));

        changeRotor3();
        Rotor3Rev = reversRotor(Rotor3);
        countRotor3++;

        if (countRotor3 == 26) {
            changeRotor2();
            Rotor2Rev = reversRotor(Rotor2);
            countRotor2++;
            countRotor3 = 0;
        }
        if (countRotor2 == 26) {
            changeRotor1();
            Rotor1Rev = reversRotor(Rotor1);
            countRotor1++;
            countRotor2 = 0;
        }
        return answer;
    }
}
