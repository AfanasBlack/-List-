import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> product = new ArrayList<>();

        List<String> operations = Arrays.asList("Добавить товар", "Показать список покупок", "Удалить товар из списка", "Поиск товара");

        System.out.println("Добро пожаловать в наш магазин!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            listOperation(operations);
            String line = scanner.nextLine();

          if ("end".equals(line)) {
              break;
          }

          int numberOperation = Integer.parseInt(line);
          if (numberOperation == 1) {
              addProduct(product, scanner);

          } else if (numberOperation == 2) {
              listProduct(product);

          } else if (numberOperation == 3) {
              listProduct(product);
              removeProduct(product, scanner);

          } else if (numberOperation == 4) {
              searchProduct(product, scanner);
          }
        }
    }

    private static void searchProduct(ArrayList<String> product, Scanner scanner) {
        System.out.println("Введите текст для поиска: ");
        String searchProduct = scanner.nextLine();
        String queryLower = searchProduct.toLowerCase();
        System.out.println("Найдено: ");
        for (String p : product) {
            String itemLower = p.toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((product.indexOf(p) + 1) + ". " + p);
            }
        }
    }

    private static void removeProduct(ArrayList<String> product, Scanner scanner) {
        System.out.println("Какой товар хотите удалить? Введите номер или название ");
        String removedProduct = scanner.nextLine();
        try {
            int numberRemove = Integer.parseInt(removedProduct);
            if (numberRemove > 0) {
                int numberProduct = Integer.parseInt(removedProduct) - 1;
                String name = product.get(numberProduct);
                product.remove(name);
                System.out.println("Покупка " + name + " удалена, список покупок: ");
                listProduct(product);
            } else {
                product.remove(removedProduct);
                System.out.println("Покупка " + removedProduct + " удалена, список покупок: ");
                listProduct(product);
            }
        } catch (NumberFormatException e) {
            product.remove(removedProduct);
            System.out.println("Покупка " + removedProduct + " удалена, список покупок: ");
            listProduct(product);
        }
    }

    private static void addProduct(ArrayList<String> product, Scanner scanner) {
        System.out.println("Какую покупку хотите добавить? ");
        String title = scanner.nextLine();
        product.add(title);
        System.out.println("Итого покупок в списке: " + product.size());
    }

    private static void listOperation(List<String> operations) {
        System.out.println("Выберете номер операции или введите end: ");
        for (String o : operations) {
            System.out.println("\t" + (operations.indexOf(o) + 1) + ". " + o);
        }
    }

    private static void listProduct(ArrayList<String> product) {
        System.out.println("Список покупок: ");
        for (String p : product) {
            System.out.println("\t" + (product.indexOf(p) + 1) + ". " + p);
        }
        System.out.println();
    }
}
