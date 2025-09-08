package com.inventory.cli;

import com.inventory.adapters.controller.ProductController;
import com.inventory.adapters.persistence.ProductRepositoryImpl;
import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import com.inventory.usecases.*;

import java.util.Scanner;

/**
 * CLI de la aplicación.
 * Aquí podrías simular un login sencillo para manejar roles.
 */
public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepositoryImpl();

        AddProductUseCase addProductUseCase = new AddProductUseCase(productRepository);
        UpdateProductUseCase updateProductUseCase = new UpdateProductUseCase(productRepository);
        DeleteProductUseCase deleteProductUseCase = new DeleteProductUseCase(productRepository);
        ListAllProductsUseCase listAllProductsUseCase = new ListAllProductsUseCase(productRepository);

        ProductController controller = new ProductController(
                addProductUseCase,
                updateProductUseCase,
                deleteProductUseCase,
                listAllProductsUseCase
        );

        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese su rol (ADMIN o USER): ");
        String userRole = scanner.nextLine().trim().toUpperCase();

        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());

                    Product product = new Product(id, name, price, stock);
                    controller.addProduct(product, userRole);
                    break;
                case 2:
                    System.out.print("Ingrese ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Nuevo nombre (enter para omitir): ");
                    String updateName = scanner.nextLine();
                    updateName = updateName.isEmpty() ? null : updateName;
                    System.out.print("Nuevo precio (enter para omitir): ");
                    String priceStr = scanner.nextLine();
                    Double updatePrice = priceStr.isEmpty() ? null : Double.parseDouble(priceStr);
                    System.out.print("Nuevo stock (enter para omitir): ");
                    String stockStr = scanner.nextLine();
                    Integer updateStock = stockStr.isEmpty() ? null : Integer.parseInt(stockStr);

                    controller.updateProduct(updateId, updateName, updatePrice, updateStock);
                    break;
                case 3:
                    System.out.print("Ingrese ID: ");
                    String deleteId = scanner.nextLine();
                    controller.deleteProduct(deleteId);
                    break;
                case 4:
                    controller.listAllProducts();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("⚠Opción inválida.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Menú Inventario ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Actualizar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Listar Productos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
