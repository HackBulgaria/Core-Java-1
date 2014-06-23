package com.hackbulgaria.corejava.exam1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static List<Integer> reverse(List<Integer> list) {
        ArrayList<Integer> arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static List<Integer> sort(List<Integer> list) {
        ArrayList<Integer> arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        return arrayList;
    }

    public static boolean isMonotonic(List<Integer> list) {
        return list.equals(sort(list)) || list.equals(reverse(sort(list)));
    }
}
