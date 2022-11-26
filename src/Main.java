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
            System.out.println("Выберете номер операции или введите end: ");
            for (String o : operations) {
                System.out.println("\t" + (operations.indexOf(o) + 1) + ". " + o);
            }
            String line = scanner.nextLine();

          if ("end".equals(line)) {
              break;
          }

          int numberOperation = Integer.parseInt(line);
          if (numberOperation == 1) {

              System.out.println("Какую покупку хотите добавить? ");
              String title = scanner.nextLine();
              product.add(title);
              System.out.println("Итого покупок в списке: " + product.size());

          } else if (numberOperation == 2) {

              System.out.println("Список покупок: ");
              for (String p : product) {
                  System.out.println("\t" + (product.indexOf(p) + 1) + ". " + p);
              }
              System.out.println();

          } else if (numberOperation == 3) {

              System.out.println("Список покупок: ");
              for (String p : product) {
                  System.out.println("\t" + (product.indexOf(p) + 1) + ". " + p);
              }
              System.out.println();

              System.out.println("Какой товар хотите удалить? Введите номер или название ");
              String removedProduct = scanner.nextLine();

              if ("1".equals(removedProduct) || "2".equals(removedProduct) || "3".equals(removedProduct)) {
                  int numberProduct = Integer.parseInt(removedProduct) - 1;
                  String name = product.get(numberProduct);
                  product.remove(name);
                  System.out.println("Покупка " + name + " удалена, список покупок: ");

                  for (String p : product) {
                      System.out.println("\t" + (product.indexOf(p) + 1) + ". " + p);
                  }
                  System.out.println();

              } else {
                  product.remove(removedProduct);
                  System.out.println("Покупка " + removedProduct + " удалена, список покупок: ");
                  for (String p : product) {
                      System.out.println("\t" + (product.indexOf(p) + 1) + ". " + p);
                  }
                  System.out.println();
              }
          } else if (numberOperation == 4) {
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
        }
    }
}
