
import java.util.Scanner;

public class ArrowCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ПРОГРАММА ПОДСЧЁТА СТРЕЛ В СТРОКЕ");
        System.out.println();
        System.out.println("Добро пожаловать!");
        System.out.println("Эта программа находит количество стрел в последовательности.");
        System.out.println();
        System.out.println("Типы стрел:");
        System.out.println("• Стрела вправо: >>-->");
        System.out.println("• Стрела влево:  <--<<");
        System.out.println();
        System.out.println();

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("─────────────────────────────────────────");
            System.out.print("Введите строку из символов '>', '<' и '-': ");
            String input = scanner.nextLine();

            boolean isValid = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch != '>' && ch != '<' && ch != '-') {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Ошибка: Строка должна содержать только символы '>', '<' и '-'!");
                System.out.println();
                continue;
            }

            if (input.length() == 0) {
                System.out.println("Ошибка: Введите непустую строку!");
                System.out.println();
                continue;
            }

            int arrowCount = countArrows(input);

            System.out.println();
            System.out.println("   РЕЗУЛЬТАТ:");
            System.out.println("   Исходная строка: " + input);
            System.out.println("   Длина строки: " + input.length() + " символов");
            System.out.println("   Найдено стрел: " + arrowCount);

            System.out.println();
            System.out.print("Хотите проверить другую строку? (да/нет): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("нет") || answer.equals("н") || answer.equals("no") || answer.equals("n")) {
                continueProgram = false;
            }
            System.out.println();
        }

        System.out.println("Спасибо за использование программы!");
        System.out.println("До свидания!");

        scanner.close();
    }

    private static int countArrows(String str) {
        int count = 0;
        String rightArrow = ">>-->";
        String leftArrow = "<--<<";

        for (int i = 0; i <= str.length() - 5; i++) {
            if (i + 5 <= str.length() && str.substring(i, i + 5).equals(rightArrow)) {
                count++;
            }
            if (i + 5 <= str.length() && str.substring(i, i + 5).equals(leftArrow)) {
                count++;
            }
        }

        return count;
    }
}