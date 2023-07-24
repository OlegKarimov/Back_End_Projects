
import de.ait.config.ApplicationConfig;
import de.ait.services.ProductsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductsService productsService = context.getBean(ProductsService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить продукт");
            System.out.println("2. Показать все продукты");
            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    System.out.println("Введите id: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Введите название: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите кол-во: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите прошел ли срок годности y/n: ");
                    String validChar = scanner.nextLine();
                    boolean valid;
                    if (validChar.equalsIgnoreCase("y")) {
                        valid = true;
                    } else valid = false;
                    productsService.signUp(id, name, quantity, valid);
                }
                case 2 -> System.out.println(productsService.getAllProducts());
                case 0 -> System.exit(0);
            }
        }
    }
}
