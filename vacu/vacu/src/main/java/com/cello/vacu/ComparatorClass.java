package com.cello.vacu;

import java.util.*;

public class ComparatorClass {
    public static void main(String args[])
    {
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        List<String> list = new ArrayList<String>();
        list.add("Hello You");
        list.add("Hello from here");
        list.add("Hello here");
        list.add("Hello D here");
        Collections.sort(list, com);
        System.out.println(list);
    }
}
