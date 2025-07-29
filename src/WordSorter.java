import java.util.Scanner;
import java.util.Arrays;

public class WordSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ПРОГРАММА СОРТИРОВКИ БУКВ В СЛОВАХ");
        System.out.println();
        System.out.println("Эта программа сортирует буквы в каждом слове по алфавиту");
        System.out.println("и выводит результат в нижнем регистре.");
        System.out.println();
        System.out.println("Пример: 'Hello World' → 'ehllo dlorw'");
        System.out.println();

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("─────────────────────────────────────────");
            System.out.print("Введите строку (слова через пробел): ");
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Ошибка: Введите непустую строку!");
                System.out.println();
                continue;
            }

            boolean isValid = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (!Character.isLetter(ch) && ch != ' ') {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Ошибка: Строка должна содержать только буквы и пробелы!");
                System.out.println();
                continue;
            }

            String result = sortWordsLetters(input);

            System.out.println();
            System.out.println("✅ РЕЗУЛЬТАТ:");
            System.out.println("   Исходная строка: " + input);
            System.out.println("   Результат: " + result);

            System.out.println();
            System.out.print("Хотите обработать другую строку? (да/нет): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("нет") || answer.equals("н") || answer.equals("no") || answer.equals("n")) {
                continueProgram = false;
            }
            System.out.println();
        }

        System.out.println("Спасибо за использование программы!");
        System.out.println("До свидания! 👋");

        scanner.close();
    }

    private static String sortWordsLetters(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                String sortedWord = sortLetters(words[i].toLowerCase());
                result.append(sortedWord);

                if (i < words.length - 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }

    private static String sortLetters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
