//Problem Statement: Write a program to count the number of words in a given string.
class Solution {

    public static void main(String[] args) {
        System.out.println(count("Hello I am Mayank Gupta"));
    }

    public static int count(String s) {
        return s.split(" ").length;
    }
}
