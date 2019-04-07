package lesson3;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson_3 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {
//        randomNumbers();
        whatFruit();
    }

    public static void randomNumbers() {
        System.out.println("Введи число от 1 до 9");


        int randomNumber = rd.nextInt(10);
        int count = 0;

        do {
            count++;
            System.out.println("Поытка № " + count);
            int x = sc.nextInt();
            if (x < randomNumber && count != 3) {
                System.out.println("Загаданное число больше");
            }
            if (x > randomNumber && count != 3) {
                System.out.println("Загаданное число меньше");
            }
            if (randomNumber == x) {
                System.out.println("BINGO!");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).");
                int restart = sc.nextInt();
                if (restart == 1) {
                    System.out.println("Давай попробуем еще раз");
                    System.out.println("Введи число от 1 до 9");
                    randomNumber = rd.nextInt(10);
                    count = 0;
                }
                if (restart == 0) {
                    count = 4;
                }
            }
            if (count == 3) {
                System.out.println("Ваши попытки кончились, Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет");
                int restart = sc.nextInt();
                if (restart == 1) {
                    System.out.println("Давай попробуем еще раз");
                    randomNumber = rd.nextInt(10);
                    count = 0;
                }
                if (restart == 0) {
                    count = 4;
                }
            }
        } while (count != 4);
        System.out.println("Пока!");
    }

    public static void whatFruit() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Я загадал слово, попробуй его угадать");
        System.out.println(Arrays.toString(words));
        System.out.println("Для выхода из игры, просто нажмите Enter");
        int randomFruit = rd.nextInt(words.length);
        String compWords = words[randomFruit];


        do{
            String humanWord = sc.next();
            if (humanWord.equals("")) break;
            else if (compWords.equals(humanWord)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            char[] answer = humanWord.toCharArray();
            for (int i = 0; i < compWords.length(); i++) {
                if(i >= answer.length)
                    break;
                if(compWords.charAt(i) != humanWord.charAt(i))
                    answer[i] = '#';
            }
            StringBuilder comment = new StringBuilder(String.valueOf(answer));
            for (int i = comment.length(); i < 15; i++) {
                comment.append("#");
            }
            System.out.println(comment);

        }while (true);
    }
}

