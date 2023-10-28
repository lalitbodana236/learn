package study.array;

import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Element already exists
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Element doesn't exist
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Swap the element to remove with the last element
        System.out.println("list "+list);
        System.out.println("map "+map);
        
        list.set(index, lastElement);
        map.put(lastElement, index);
        
        System.out.println("list "+list);
        System.out.println("map "+map);
        list.remove(list.size() - 1);
        map.remove(val);
        
        System.out.println("list after "+list);
        System.out.println("map after "+map);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}


