package com.wallethub.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by juanroman on 6/02/17.
 */
public class Palindrome {

    /**
     * Evaluates if a given string is a palindrome.
     *
     * @param text The text to eval
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String text) {

        if (text.length() == 1) {
            return true;
        }
        String firstChar = text.substring(0, 1);
        String lastChar = text.substring(text.length() - 1, text.length());

        if (!firstChar.equals(lastChar)) {
            return false;
        }

        if (text.length() > 2) {
            return isPalindrome(text.substring(1, text.length() - 1));
        }

        return true;
    }

    /**
     * Prepare a string for evaluate if it is a palindrome.
     *
     * @param text the text to evaluate.
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isStringPalindrome(String text) {

        //clean special chars elements and go lower case
        String str = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindrome(str);
    }

    /**
     * The main method
     *
     * @param args
     */
    public static void main(String args[]) {

        List<String> testCases = Arrays.asList("rotor", "1221", "anita lava la tina", "juan roman");

        for(String s : testCases) {

            System.out.printf("palindrome [%s] : %s%n", s, isStringPalindrome(s));
        }
    }
}
