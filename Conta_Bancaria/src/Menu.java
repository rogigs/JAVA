
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public final class Menu {

    private final LinkedHashMap<String, Runnable> options = new LinkedHashMap<>();
    private boolean exit = false;

    public void addOption(String description, Runnable action) {
        options.put(description, action);
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("\nMenu:");
            int index = 1;
            for (String option : options.keySet()) {
                System.out.println(index++ + ". " + option);
            }
            System.out.print("Escolha uma opção: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= options.size()) {
                    new ArrayList<>(options.values()).get(choice - 1).run();
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    public void exit() {
        exit = true;
        System.out.println("Saindo do sistema. Até logo!");
    }
}