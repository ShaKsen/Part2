package ru.geekbrains.shavshina2;

class MyArraySizeException extends CustomException {

    MyArraySizeException() {
        super("Размер массива должен быть [4 x 4]\n");
    }
}