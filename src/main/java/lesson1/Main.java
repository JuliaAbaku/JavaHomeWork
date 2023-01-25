package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Укажите название метода
        changeArray();

    }

    // 1. Задать одномерный массив и найти в нем минимальный и максимальный элементы

    public static void minMaxElements() {

        int[] arr = {1, 2, 0, 4, 6, 33, 65, 5, 346, 5, 22};

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }


    // 2. Написать метод, который определяет,
    // является ли введенный пользователем год високосным,
    // и возвращает в консоль boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный.

    public static void leapYear() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите год : ");
        int year = iScanner.nextInt();

//        if (year < 1584){
//            System.out.print("Високосный год ввели в 1584 году.");
//        } else if (year%100 == 0 & year%400 != 0 & year%4 != 0) {
//            System.out.print("Год не високосный.");
//        } else {
//            System.out.print("Год високосный.");
//        }

        boolean leapYear = year > 1584 &&
                year % 400 == 0 ||
                year % 4 == 0 &&
                        year % 100 != 0;

        if (leapYear) {
            System.out.print("Год " + year + " високосный.");
        } else {
            System.out.print("Год " + year + " не високосный.");
        }
    }


    //3. Дан массив nums = [3,2,2,3] и число val = 3.
    //   Если в массиве есть числа, равные заданному,
    //   нужно перенести эти элементы в конец массива.
    //   Таким образом, первые несколько (или все) элементов массива
    //   должны быть отличны от заданного, а остальные - равны ему.

    public static void changeArray() {

        int[] arr = {3, 1, 6, 3, 8, 3, 9, 3, 5, 7, 3, 3};
        int val = 3;

        int left = 0;
        int right = arr.length - 1;
        int temp = 0;
        System.out.println(Arrays.toString(arr));


        while(left < right){

            if(arr[left] == val & arr[right] != val){
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }

            if(arr[left] != val){
                left++;
            }

            if(arr[right] == val){
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }


}








