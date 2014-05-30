package com.hackbulgaria.corejava;

public class FaultyProblem4 {
    public static boolean areEqual(Integer e, Integer k) {
        k++;
        k--;
        return e == k;
    }

    public static boolean areEqual(float a, float b) {
        return a == b;
    }

    public static boolean haveEqualSubstrings(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String substringA = a.substring(i, a.length() - 1);
            String substringB = b.substring(i, a.length() - 1);
            if (substringA.equals(substringB)){
                return true;
            }
        }
        return false;
    }
}
