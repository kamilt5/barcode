package com.main.checkbar;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;


/**
 * function check(String Barcode) will get a Barcode in String format and output
 * 0 if incorrent; else Character according to ISO/IES 7064 mod. 37/36 standard
 */
public class CheckBar {

    public CheckBar() {
        makeMapping();
    }

    //alphabet for mapping
    private String alph = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //2 dictionares, normal for char -> int convertion, inverted for int -> char
    public static Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
    public static Map<Integer, Character> invertedDictionary = new HashMap<Integer, Character>();

    /**
     * 
     * @param Barcode Barcode in String format
     * @return 0 if Barcode incorrent;
     *         else Character according to ISO/IES 7064 mod. 37/36 standard
     */
    public static Character check(String Barcode) {
        
        Integer mod = 36;
        Integer cd = mod;
        Integer val;

        for (int i = 0; i < Barcode.length(); i++) {
            val = dictionary.get(Barcode.charAt(i));
            cd = cd + val;
            if (cd > mod)
                cd = cd - mod;
            cd = cd * 2;
            if (cd > mod)
                cd = cd - mod - 1;
        }

        cd = mod + 1 - cd;
        if (cd == mod)
            cd = 0;

        System.out.println(invertedDictionary.get(cd));
        return invertedDictionary.get(cd);
    }

    /**
     * make 2 dictionaries from alphabet variable
     */
    private void makeMapping() {
        for (int i = 0; i < 36; i++) {
            dictionary.put(alph.charAt(i), i);
            invertedDictionary.put(i, alph.charAt(i));
        }
    }
}