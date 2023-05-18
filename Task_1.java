/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
что 1 человек может иметь несколько телефонов. Нужны методы добавления
новой записи в книгу и метод поиска записей в телефонной книге
*/

import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class Task_1 {  
    // public static HashMap<String, List<String>> phoneBook = new HashMap<>();
    
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Maria", List.of("+79329049790", "+79755425998"));
        phoneBook.put("Ivan", List.of("+79051236548"));
        phoneBook.put("Semen",List.of("+7997894562"));
        phoneBook.put("Alex",List.of("+79984563214", "+79974573247"));
        phoneBook.put("Olga",List.of("+7905818384", "+79329754992"));
        
        Scanner sc = new Scanner(System.in);
        System.out.print("введите d(добавить) или f(поиск), любой символ - печать всего списка: ");
        String str = sc.nextLine();
        switch (str) {
            case ("d"):
                addPerson(phoneBook);  
                break;
            case ("f"):            
            System.out.print("введите Имя: ");
            String strName = sc.nextLine();
            findPerson(strName, phoneBook);
                break;
            default:
            System.out.print(phoneBook);
        }     
        
        sc.close();
    }
    public static void addPerson(HashMap<String, List<String>> phoneBook) {        
        Scanner scAdd = new Scanner(System.in);
        System.out.print("Добавте имя: ");
        String name = scAdd.nextLine();
        System.out.print("Добавте телефон: ");
        String tel = scAdd.nextLine();
        phoneBook.put(name, List.of(tel));        
        scAdd.close();
        System.out.print(phoneBook);
    }
    public static void findPerson(String name, HashMap<String, List<String>> phoneBook) {
        System.out.printf("%s: %s", name, phoneBook.get(name));
    }
}
