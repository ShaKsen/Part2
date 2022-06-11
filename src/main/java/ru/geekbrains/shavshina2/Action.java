package ru.geekbrains.shavshina2;

public class Action {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void firstThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - a) + " мс");
    }

    public void secondThread() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        new Thread(() -> {
            float[] b = calculate(arr1);
            System.arraycopy(b, 0, arr1, 0, b.length);
        }).start();

        new Thread(() -> {
            float[] c = calculate(arr2);
            System.arraycopy(c, 0, arr2, 0, c.length);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - a)+ " мс");
    }
}
