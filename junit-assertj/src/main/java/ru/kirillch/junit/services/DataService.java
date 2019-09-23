package ru.kirillch.junit.services;

import java.util.Comparator;
import java.util.List;

public class DataService {

    public static int findMax(List<Integer> numbers) throws Exception {

        if (numbers == null || numbers.size() == 0) {
            throw new Exception("List of numbers is empty");
        }

        int max = numbers.get(0);

        for (int i = 0; i < numbers.size(); i++) {

            int current = numbers.get(i);
            if(max<current){
                max = current;
            }
        }

        return max;

    }

    public static int findMaxByStreams(List<Integer> numbers) throws Exception {

        if (numbers == null || numbers.size() == 0) {
            throw new Exception("List of numbers is empty");
        }

        Integer max = numbers.stream().max(Comparator.naturalOrder())
                .orElseThrow(() -> new Exception("List of numbers is empty"));

        return max;

    }
}
