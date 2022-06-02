package ru.geekbrains.shavshina2;
/*1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
при условии что подали на вход корректный массив).
Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
Integer.parseInt(сюда_подать_строку);*/

public class Main {
    public static void main(String[] args) {
        String[][] correctMatrix = {
                {"6", "0", "2", "1"},
                {"7", "6", "0", "4"},
                {"1", "3", "9", "0"},
                {"2", "1", "4", "2"}
        };
        String[][] wrongSizeMatrix = {
                {"0", "4", "1", "2"},
                {"5", "3", "2", "6"},
                {"1", "4", "5", "2"},
                {"1", "5"}
        };
        String[][] wrongCharMatrix = {
                {"6", "9", "3", "2"},
                {"l", "0", "3", "2"},
                {"3", "4", "1", "7"},
                {"2", "8", "3", "6"}
        };

        try {
            System.out.println("Вариант 1:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(correctMatrix) + ".\n");
        } catch (CustomException e) {
            e.getMessage();
        }

        try {
            System.out.println("Вариант 2:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(wrongSizeMatrix) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Вариант 3:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(wrongCharMatrix) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

    }
}


