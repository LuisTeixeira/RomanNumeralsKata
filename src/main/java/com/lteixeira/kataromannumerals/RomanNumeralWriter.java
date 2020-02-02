package com.lteixeira.kataromannumerals;

import java.util.List;

public class RomanNumeralWriter {

    private final String[] UNITS = new String[] {"I", "X", "C", "M"};
    private final String[] HALF_UNITS = new String[] {"V", "L", "D"};

    private StringBuilder romanNumeralBuilder = new StringBuilder();

    protected String writeRomanNumeral(List<Integer> digits) {
        this.romanNumeralBuilder = new StringBuilder();
        for(int i = digits.size() - 1; i >= 0; i--) {
            Integer digit = digits.get(i);
            if((digit / 5) > 0) {
                writeDigitLatgerThanHalfAUnit(i, digit);
            } else {
                writeDigitSmallerThanHalfAUnit(i, digit);
            }
        }
        return romanNumeralBuilder.toString();
    }

    private void writeDigitSmallerThanHalfAUnit(int digitIndex, Integer digit) {
        // Check if digit is one less than halfunit
        if (digit == 4) {
            romanNumeralBuilder.append(UNITS[digitIndex]);
            romanNumeralBuilder.append(HALF_UNITS[digitIndex]);
            return;
        }
        int numberOfRemainingUnits = digit;
        while (numberOfRemainingUnits >  0) {
            romanNumeralBuilder.append(UNITS[digitIndex]);
            numberOfRemainingUnits--;
        }
    }

    private void writeDigitLatgerThanHalfAUnit(int digitIndex, Integer digit) {
        // Check if digits is 1 less than next unit
        if (digit == 9) {
            romanNumeralBuilder.append(UNITS[digitIndex]);
            romanNumeralBuilder.append(UNITS[digitIndex+1]);
            return;
        }
        // check if digit is exactly half a unit
        romanNumeralBuilder.append(HALF_UNITS[digitIndex]);
        int numberOfRemainingUnits = digit - 5;
        while (numberOfRemainingUnits > 0) {
            romanNumeralBuilder.append(UNITS[digitIndex]);
            numberOfRemainingUnits--;
        }
    }

}
