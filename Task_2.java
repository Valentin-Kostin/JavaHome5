/*Пусть дан список сотрудников: 
Иван Иванов, 
Светлана Петрова, 
Кристина Белова, 
Анна Мусина, 
Анна Крутова, 
Иван Юрин, 
Петр Лыков, 
Павел Чернов, 
Петр Чернышов, 
Мария Федорова, 
Марина Светлова, 
Мария Савина, 
Мария Рыкова, 
Марина Лугова, 
Анна Владимирова, 
Иван Мечников, 
Петр Петин, 
Иван Ежов. 
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности. Для сортировки использовать TreeMap. 
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task_2 {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, List<String>> nameMapSort = new TreeMap<>(Comparator.reverseOrder());
        String persons = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";
        String[] listPersons = persons.split(" ");
        
        for (int i = 0; i < listPersons.length; i += 2) {
            if (nameMap.containsKey(listPersons[i])) {
                nameMap.put(listPersons[i], nameMap.get(listPersons[i]) + 1);
            } else {
                nameMap.put(listPersons[i], 1);
            }
        }

        System.out.println(nameMap);

        for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
            String keyHash = entry.getKey();
            Integer valueHash = entry.getValue();
            if (nameMapSort.keySet().contains(valueHash)) {
                List<String> list = nameMapSort.get(valueHash);
                list.add(keyHash);
                nameMapSort.put(valueHash, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(keyHash);
                nameMapSort.put(valueHash, list);
            }
        }
        System.out.println(nameMapSort);
    }
}