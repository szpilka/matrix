package matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MatrixSerializerService.printMatrix(System.out, MatrixSerializerService.readMatrix(scanner).multiply(2));
        }
    }
}
