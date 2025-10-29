// Problem statement -> Given a string remove all characters from the string which are not alphabets
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(filterAlphabets("take12% *&u ^$#forward"));
    }

    public static String filterAlphabets(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (isAlpha(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
