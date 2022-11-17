import java.util.Scanner;

public class Main {
    public static Sections sections = new Sections();
    public static Products products = new Products();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1) Sections\n" + "2) Products\n" + "0) EXIT");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //таблица отделов
                    do {
                        System.out.println("1) Add section\n" +
                                "2) Remove section\n" +
                                "3) Edit section\n" +
                                "4) Add a product to the section\n" +
                                "5) Remove a product in the section\n" +
                                "6) Show all sections\n" +
                                "7) Show all sections and their products\n" +
                                "0) EXIT");

                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                //добавление нового отдела в массив
                                System.out.print("Enter section name: ");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                System.out.print("Enter work time: ");
                                String workTime = scanner.nextLine();
                                sections.addSection(name, workTime);
                                break;
                            case 2:
                                //удаление отдела из массива
                                if (!sections.getSections().isEmpty()) {
                                    System.out.print("Choose a section (id): ");
                                    sections.removeSection(sections.findSectionById(scanner.nextInt()));
                                } else {
                                    System.out.println("There are no sections..");
                                }
                                break;
                            case 3:
                                //изменение одного из отделов
                                if (!sections.getSections().isEmpty()) {
                                    System.out.print("Choose a section (id): ");
                                    Section updatedSection = sections.findSectionById(scanner.nextInt());

                                    System.out.println("(Nothing - void)");

                                    System.out.print("Edit section name: ");
                                    scanner.nextLine();
                                    String updatedName = scanner.nextLine();

                                    System.out.print("Edit work time: ");
                                    String updatedWorkTime = scanner.nextLine();

                                    sections.updateSection(updatedSection, updatedName, updatedWorkTime);
                                } else {
                                    System.out.println("There are no sections..");
                                }
                                break;
                            case 4:
                                //добавление товара в отдел
                                if (!sections.getSections().isEmpty()) {
                                    System.out.println("Choose a section (id)");
                                    Section section = sections.findSectionById(scanner.nextInt());                      //Ввод отдела
                                    System.out.println("Choose a product (id)");
                                    Product product = products.findProductById(scanner.nextInt());                         //Ввод товара

                                    section.addProductToSection(product);                                        //Добавление товара в отдел
                                } else {
                                    System.out.print("There are no sections..");
                                }
                                break;
                            case 5:
                                //удаление товара из отдела
                                if (!sections.getSections().isEmpty()) {
                                    System.out.println("Choose a section (id)");
                                    Section section = sections.findSectionById(scanner.nextInt());                      //Ввод отдела

                                    if (!section.getProducts().isEmpty()) {
                                        System.out.println("Choose a product (id)");
                                        Product product = products.findProductById(scanner.nextInt());                     //Ввод товара
                                        section.removeProductInSection(product);                                 //Удаление товара из отдела
                                    } else {
                                        System.out.println("There are no products in this section..");
                                    }
                                } else {
                                    System.out.print("There are no sections..");
                                }
                                break;
                            case 6:
                                ////////////////////////////////////////////////////////////////////////////////////////////////
                                //вывод всех товаров в отделе
                                if (!sections.getSections().isEmpty()) {
                                    System.out.println("Choose a section (id)");
                                    Section section = sections.findSectionById(scanner.nextInt());                    //Ввод отдела
                                    sections.showSections();                                 //Удаление товара из отдела
                                } else {
                                    System.out.print("There are no sections..");
                                }
                                break;
                            case 7:
                                //вывод всех отделов без товаров
                                sections.showSectionsWithoutProducts();
                                break;
                        }

                        System.out.println();
                    } while (choice != 0);
                    choice = -1;
                    break;
                case 2:
                    //товары
                    do {
                        System.out.println("1) Add a product\n" +
                                "2) Remove product\n" +
                                "3) Edit product\n" +
                                "4) Show all products\n" +
                                "0) EXIT");

                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                //добавление нового товара в массив
                                System.out.print("Enter product name: ");
                                scanner.nextLine();
                                String nameProduct = scanner.nextLine();
                                System.out.print("Enter product price: ");
                                int price = scanner.nextInt();
                                products.addProduct(nameProduct, price);
                                break;
                            case 2:
                                //удаление товара из массива
                                if (!products.getProducts().isEmpty()) {
                                    System.out.print("Choose a product (по id): ");
                                    products.removeProduct(products.findProductById(scanner.nextInt()));
                                } else {
                                    System.out.println("There are no products.. ");
                                }
                                break;
                            case 3:
                                //изменение одного из товаров
                                if (!products.getProducts().isEmpty()) {
                                    System.out.print("Choose a product (по id): ");
                                    Product updatedProduct = products.findProductById(scanner.nextInt());

                                    System.out.println("Nothing - void");

                                    System.out.print("Edit product name: ");
                                    scanner.nextLine();
                                    String updatedNameProduct = scanner.nextLine();

                                    System.out.print("Edit product price: ");
                                    String updatedPrice = scanner.nextLine();

                                    products.updateProduct(updatedProduct, updatedNameProduct, updatedPrice);
                                } else {
                                    System.out.println("There are no products..");
                                }
                                break;
                            case 4:
                                //вывод всех товаров
                                products.showProducts();
                                break;
                        }

                        System.out.println();
                    } while (choice != 0);
                    choice = -1;
                    break;
            }

            System.out.println();
        } while (choice != 0);
    }

}
