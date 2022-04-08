package maps.Task01;

import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("123", "John Smith");
        map.put("111", "George Smith");
        map.put("123", "Steve Yao");
        map.put("222", "Steve Yao");
        System.out.println("(1) " + map);
        System.out.println("(2) " + new TreeMap<String, String>(map));

        for(Map.Entry<String, String> entry: map.entrySet())
            if (entry.getKey().equals("123"))
                System.out.println(entry.getValue());
    }
}

