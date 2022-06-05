package ru.geekbrains.shavshina2;

/*      1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
        вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово.
        2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
        добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
        учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
        лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
        через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
        справочника.*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> product = Arrays.asList(
                "Bounty", "Kit Kat", "Snikers", "Picnic", "Nuts",
                "Twix", "Bounty", "Milky Way", "Twix", "Mars",
                "Nuts", "Kit Kat", "Mars", "Snikers", "Picnic",
                "Milky Way", "M & M's", "Twix", "Mars"
        );
        System.out.println("Первоначальный список наименований");
        System.out.println(product.toString());

        Set<String> unique = new HashSet<String>(product);


        System.out.println("Уникальные слова");
        System.out.println(unique.toString());
        System.out.println("Как часто встречается конкретное наименование");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(product, key));
        }

        System.out.println("-----------------");
        System.out.println("Справочник номеров сотрудников");
        Phonebook phonebook = new Phonebook();

        System.out.println("Открываем справочник");
        phonebook.add("Мишур", "+375293654586");
        phonebook.add("Шамак", "+375448972122");
        phonebook.add("Процко", "+375259632541");
        phonebook.add("Евтушенко", "+375448972122");
        phonebook.add("Мишур", "+375291258974");
        phonebook.add("Шамак", "+375296985413");
        phonebook.add("Чугуев", "+375443571524");
        phonebook.add("Лизоблюдов", "+375254589218");

        System.out.println("-----------------");

        System.out.println("Выборка по фамилии");
        System.out.println("Мишур");
        System.out.println(phonebook.get("Мишур"));
        System.out.println("Шамак");
        System.out.println(phonebook.get("Шамак"));
        System.out.println("Процко");
        System.out.println(phonebook.get("Процко"));
        System.out.println("Евтушенко");
        System.out.println(phonebook.get("Евтушенко"));
        System.out.println("Чугуев");
        System.out.println(phonebook.get("Чугуев"));
        System.out.println("Лизоблюдов");
        System.out.println(phonebook.get("Лизоблюдов"));
        System.out.println("-----------------");

        System.out.println("Случай отсутствия записи");
        System.out.println("Архипенко");
        System.out.println(phonebook.get("Архипенко"));
        System.out.println("-----------------");

        System.out.println("Пробуем записать существующий номер");
        phonebook.add("Мишур", "+375291258974");
        System.out.println("Мишур");
        System.out.println(phonebook.get("Мишур"));
    }
}


