package com.sokolov.hw04;

public class Main {

	private static int size = 7_500_000;

    public static void main(String[] args) {
        Object[] array = new Object[size];
//        int i = 0;
        try {
            while (true) {
                Sled.startSled();
                for (int i = 0; i < size; i++) {
                    array[i] = new String("Element " + i);
                    if (i % 100 == 0) {
                        array[i] = null;
                        Thread.sleep(1);
                    }
                }

                System.out.println("Array with " + array.length + " elements was created.");
                Sled.stopSled();
            }
        } catch (IndexOutOfBoundsException e){
            e.getStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}