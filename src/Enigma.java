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
    }


    public char getPlugBoardValueByKey(char c){
        if (PlugBoard.get(c)==null) {
            exit(0);
        }
        return PlugBoard.get(c);
    }

    public char getReflectorValueByKey(char c){
        return Reflector.get(c);
    }

    public char getRotator1ValueByKey(char c){
        return Rotator1.get(c);
    }

    public char getRotator2ValueByKey(char c){
        return Rotator2.get(c);
    }

    public char getRotator3ValueByKey(char c){
        return Rotator3.get(c);
    }



    public void changeRotator1(){
        int asciNum = 90;
        char c,c2;
        char last = Rotator1.get('Z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciNum;
            c2 = (char) (asciNum-1) ;
            Rotator1.put(c, Rotator1.get(c2));
            asciNum--;
        }
        Rotator1.put('A' ,last);
    }

    public void changeRotator2(){
        int asciNum = 90;
        char c,c2;
        char last = Rotator2.get('Z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciNum;
            c2 = (char) (asciNum-1) ;
            Rotator2.put(c, Rotator2.get(c2));
            asciNum--;
        }
        Rotator2.put('A' ,last);
    }


    public void changeRotator3(){
        int asciNum = 90;
        char c,c2;
        char last = Rotator3.get('Z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciNum;
            c2 = (char) (asciNum-1) ;
            Rotator3.put(c, Rotator3.get(c2));
            asciNum--;
        }
        Rotator3.put('A' ,last);
    }

}
