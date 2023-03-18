// Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
// что 1 человек может иметь несколько телефонов.

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class HW_java_5{
//
//    // Метод, который добавляет номера в книгу
//    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
//        if (map.containsKey(key)) {
//            map.get(key).add(value);
//        } else {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(value);
//            map.put(key, list);
//        }
//
//    }
//    // Метод, который печатает список контактов
//    public static void printBook(Map<String, ArrayList<Integer>> map){
//        for (var item : map.entrySet()) {
//            String phones = "";
//            for(int el: item.getValue()){
//                phones = phones + el + ", ";
//            }
//            System.out.printf("%s: %s \n", item.getKey(), phones);
//        }
//    }
//    public static void main(String[] args) {
//        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
//        addNumber("Боярский", 456, bookPhone);
//        addNumber("Белоусов", 96969, bookPhone);
//        addNumber("Киркоров", 77777, bookPhone);
//        addNumber("Нагиев", 8787878, bookPhone);
//        addNumber("Боярский", 258369, bookPhone);
//        addNumber("Вицин", 88888888, bookPhone);
//        printBook(bookPhone);
//    }
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Пусть дан список сотрудников:Иван Иванов ( и остальные, полный текст дз будет на платформе)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
public class HW_java_5 {

    public static ArrayList<String> getName(String [] list){
        ArrayList<String> listName = new ArrayList<>();
        for (String el : list) {
            String [] elList = el.split(" ");
            listName.add(elList[0]);
        }
        return listName;
    }
    public static Map<String, Integer> getMap(ArrayList<String> name) {
        Map<String, Integer> mapName = new HashMap<>();
        for (int i = 0; i < name.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < name.size(); j++){
                if (name.get(i).equals(name.get(j))) count += 1;
            }
            if (mapName.containsKey(name.get(i)) == false) mapName.put(name.get(i), count);
        }
        return mapName;
    }
    public static void nameRepeat(Map<String, Integer> map){
        for(var item: map.entrySet()){
            if (item.getValue() > 1) System.out.printf("%s: %d \n", item.getKey(), item.getValue());
        }
    }
    public static void sortName(Map<String, Integer> map){
        Map<Integer, ArrayList<String>> sortMap = new HashMap<>();
        ArrayList<Integer> listCount = new ArrayList<>();
        for(var item: map.entrySet()) {
            if (listCount.contains(item.getValue()) == false) listCount.add(item.getValue());
        }
        listCount.sort(null);
        for (int i = listCount.size()-1; i > -1; i--){
            for (var item: map.entrySet()){
                if (listCount.get(i) == item.getValue()) System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }
    public static void main(String[] args) {
        String[] emploees = new String[] {"Иван Иванов", "Иван Петров", "Сергей Козлов", "Евгений Петров", "Сергей Васильев", "Иван Смирнов", "Андрей Петров"};
        ArrayList<String> emploeesName = getName(emploees);
        Map<String, Integer> mapName =  getMap(emploeesName);
        System.out.println("Повторяющиеся имена: ");
        nameRepeat(mapName);
        System.out.println("Имена, отсортированные по убыванию популярности: ");
        sortName(mapName);
    }

}