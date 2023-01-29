package lesson1;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        // Укажите название метода
//        System.out.println(isPalindrome());
        calculation();


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

//________________________________________________________________________

    // Семинар 2, задачи:

    // 1. Дано число N(>0) и символы c1 и c2.
//    Написать метод, который вернет строку длиной N,
//    которая состоит из чередующихся c1 и c2.
    public static void sequence(){

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите длину строки: ");
        int N = iScanner.nextInt();

        System.out.println("Введите первый символ: ");
        String c1 = iScanner.next();

        System.out.println("Введите второй символ: ");
        String c2 = iScanner.next();
// Добавляем 1 и 2 символ, потом проверяем на четность, и если нечетный, то удаляем последний символ
        StringBuilder builder = new StringBuilder();
        for (int i = 0; builder.length() < N; i++){
            builder.append(c1).append(c2);
        }
        if (N % 2 != 0){
            builder.delete(builder.length() - 1, builder.length());
        }
        System.out.println(builder);

// Добавляем символ по счетчику
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while (counter < N) {
            sb.append(c1);
            counter++;
            if (counter < N) {
                sb.append(c2);
                counter++;
            }
        }
        System.out.println(sb);
    }

//________________________________________________________________________

    // ДЗ 2 семинар
    // 1. Напишите метод, который принимает на вход строку (String)
    // и определяет является ли строка палиндромом (возвращает boolean значение).
    public static boolean isPalindrome() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String text = iScanner.next();

        StringBuilder sb = new StringBuilder(text);
        sb.reverse(); //переворачиваем строку
        String invertedText = sb.reverse().toString(); //присваиваем перевернутую строку
        return text.equalsIgnoreCase(invertedText); //возвращаем сравнение двух строк вне зависимости от регистра
    }


    //2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST
    // и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.
    public static void repeatText() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String text = iScanner.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(text);
            sb.append(' ');
        }
        System.out.println(sb);


        try(PrintWriter pw = new PrintWriter("file.txt")) {
            pw.print(sb);
        } catch (FileNotFoundException e) {         // Тут не понятно что происходит
            e.printStackTrace();
        }

// По поводу файлов я не все до конца поняла. Как будто файл создался. В общем сделала что-то наугад)
    }



    // ДЗ 3 семинар
//    1. Пусть дан произвольный список целых чисел,
//    удалить из него четные числа (в языке уже есть что-то готовое для этого)
    public static void deletedOddNumbs(){
        ArrayList<Integer> numList = new ArrayList<>();

        numList.add(51);
        numList.add(14);
        numList.add(11);
        numList.add(12);
        numList.add(31);
        numList.add(21);

        System.out.println("Оригинал: " + numList.toString());

        numList.removeIf(i -> (i %2 != 0));

        System.out.println("Новый список: " + numList.toString());


    }

//2. Задан целочисленный список ArrayList.
// Найти минимальное, максимальное и среднее арифметическое из этого списка.
public static void calculation(){
    ArrayList<Integer> numList = new ArrayList<>();

    numList.add(51);
    numList.add(14);
    numList.add(11);
    numList.add(12);
    numList.add(31);
    numList.add(21);

    double average = 0;
    double sum = 0;

    System.out.println("Список чисел: " + numList.toString());
    System.out.println("Максимальное число: " + Collections.max(numList));
    System.out.println("Минимальное число: " + Collections.min(numList));

    for (int i = 0; i < numList.size(); i++) {
        sum = sum + numList.get(i);
    }
    average = sum / numList.size();

    System.out.println("Среднее арифметическое: " + average);

}




}








