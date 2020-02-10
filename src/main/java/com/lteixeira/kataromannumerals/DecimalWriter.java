package com.lteixeira.kataromannumerals;

import java.util.HashMap;
import java.util.Map;

public class DecimalWriter {

    private Map<String, Integer> romanDigits = new HashMap<>();

    public DecimalWriter() {

        addUnitsToDigits();
        addTensToDigits();
        addHundredsToDigits();
        addThousandsToDigits();

    }

    private void addUnitsToDigits() {
        romanDigits.put("I", 1);
        romanDigits.put("II", 2);
        romanDigits.put("III", 3);
        romanDigits.put("IV", 4);
        romanDigits.put("V", 5);
        romanDigits.put("VI", 6);
        romanDigits.put("VII", 7);
        romanDigits.put("VIII", 8);
        romanDigits.put("IX", 9);
    }

    private void addTensToDigits() {
        romanDigits.put("X", 10);
        romanDigits.put("XX", 20);
        romanDigits.put("XXX", 30);
        romanDigits.put("XL", 40);
        romanDigits.put("L", 50);
        romanDigits.put("LX", 60);
        romanDigits.put("LXX", 70);
        romanDigits.put("LXXX", 80);
        romanDigits.put("XC", 90);
    }

    private void addHundredsToDigits() {
        romanDigits.put("C", 100);
        romanDigits.put("CC", 200);
        romanDigits.put("CCC", 300);
        romanDigits.put("CD", 400);
        romanDigits.put("D", 500);
        romanDigits.put("DC", 600);
        romanDigits.put("DCC", 700);
        romanDigits.put("DCCC", 800);
        romanDigits.put("CM", 900);
    }

    private void addThousandsToDigits() {
        romanDigits.put("M", 1000);
        romanDigits.put("MM", 2000);
        romanDigits.put("MMM", 3000);
    }

    public Integer writeDecimal(String romanNumeral) {
        return convertRomanDigits(romanNumeral);
    }

    private Integer convertRomanDigits(String romanNumeral) {
        Integer decimalNumber = 0;
        int beginIndex = 0;
        while (beginIndex < romanNumeral.length()) {
            int endIndex = beginIndex + 1;
            String subString = romanNumeral.substring(beginIndex, endIndex);
            int temporaryNumber = 0;
            while (romanDigits.containsKey(subString) && endIndex <= romanNumeral.length()) {
                temporaryNumber = romanDigits.get(subString);
                endIndex++;
                if(endIndex <= romanNumeral.length())
                    subString = romanNumeral.substring(beginIndex, endIndex);
            }
            decimalNumber += temporaryNumber;
            beginIndex = endIndex - 1;
        }
        return decimalNumber;
    }

}
