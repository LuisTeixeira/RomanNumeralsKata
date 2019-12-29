package com.lteixeira.kataromannumerals;

import java.util.*;

public class Converter {

    private List<String> units = new ArrayList<>();
    private List<String> halfUnits = new ArrayList<>();

    public Converter() {
        // Instantiate Units
        units.add("I");
        units.add("X");
        units.add("C");
        units.add("M");

        // Instantiate Half Units
        halfUnits.add("V");
        halfUnits.add("L");
        halfUnits.add("D");
    }

    public String toRomanNumeral(int number) {
        if (number > 0 && number < 4000) {
            List<Integer> digits = getDigits(number);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = digits.size() - 1; i >= 0; i--) {
                Integer digit = digits.get(i);
                // Check if it's more or less than half a unit
                if((digit / 5) > 0) {
                    // Check if digits is 1 less than next unit
                    if (digit == 9) {
                        stringBuilder.append(units.get(i));
                        stringBuilder.append(units.get(i+1));
                        continue;
                    }
                    // check if digit is exactly half a unit
                    stringBuilder.append(halfUnits.get(i));
                    int numberOfRemainingUnits = digit - 5;
                    while (numberOfRemainingUnits > 0) {
                        stringBuilder.append(units.get(i));
                        numberOfRemainingUnits--;
                    }
                } else {
                    // Check if digit is one less than halfunit
                    if (digit == 4) {
                        stringBuilder.append(units.get(i));
                        stringBuilder.append(halfUnits.get(i));
                        continue;
                    }
                    int numberOfRemainingUnits = digit;
                    while (numberOfRemainingUnits > 0) {
                        stringBuilder.append(units.get(i));
                        numberOfRemainingUnits--;
                    }
                }
            }
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Not possible to convert " + number);
    }

    private List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }
        return digits;
    }

}
