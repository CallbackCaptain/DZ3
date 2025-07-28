import java.util.Scanner;

public class KeyboardLeftLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Определяем порядок букв на замкнутой клавиатуре
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";

        // Приветствие и описание программы
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("      ПРОГРАММА ПОИСКА ЛЕВОЙ БУКВЫ НА КЛАВИАТУРЕ        ");
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println();
        System.out.println("Добро пожаловать!");
        System.out.println("Эта программа показывает букву, расположенную слева");
        System.out.println("от введённой буквы на стандартной QWERTY-клавиатуре.");
        System.out.println();
        System.out.println("Особенности замкнутой клавиатуры:");
        System.out.println("• Слева от 'a' находится 'p'");
        System.out.println("• Слева от 'q' находится 'm'");
        System.out.println("• Слева от 'z' находится 'l'");
        System.out.println();
        System.out.println("Раскладка клавиатуры:");
        System.out.println("──────────────────────");
        System.out.println(" q w e r t y u i o p  ");
        System.out.println("  a s d f g h j k l   ");
        System.out.println("   z x c v b n m      ");
        System.out.println("──────────────────────");
        System.out.println();

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("Введите букву английского алфавита (маленькую): ");
            String input = scanner.next().toLowerCase();

            if (input.length() != 1) {
                System.out.println("Ошибка: Пожалуйста, введите только одну букву!");
                System.out.println();
                continue;
            }

            char inputChar = input.charAt(0);

            // Проверка, что введена английская буква
            if (inputChar < 'a' || inputChar > 'z') {
                System.out.println("Ошибка: Пожалуйста, введите маленькую букву английского алфавита!");
                System.out.println();
                continue;
            }

            // Находим позицию введенной буквы
            int position = keyboard.indexOf(inputChar);

            // Находим букву слева
            int leftPosition;
            if (position == 0) {
                leftPosition = keyboard.length() - 1;
            } else {
                leftPosition = position - 1;
            }

            char leftChar = keyboard.charAt(leftPosition);

            // Выводим результат
            System.out.println();
            System.out.println("═══════════════════════════════");
            System.out.println("   Результат:");
            System.out.println("   Введённая буква: '" + inputChar + "'");
            System.out.println("   Буква слева: '" + leftChar + "'");
            System.out.println("═══════════════════════════════");
            System.out.println();

            // Спрашиваем, хочет ли пользователь продолжить
            System.out.print("Хотите проверить другую букву? (да/нет): ");
            String answer = scanner.next().toLowerCase();

            if (answer.equals("нет") || answer.equals("н") || answer.equals("no") || answer.equals("n") || answer.equals("-")) {
                continueProgram = false;
            }
            System.out.println();
        }

        // Прощание
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("           Спасибо за проверку работы!                  ");
        System.out.println("                    До свидания! 👋                     ");
        System.out.println("════════════════════════════════════════════════════════");

        scanner.close();
    }
}