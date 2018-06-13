package matrix;

import java.util.Scanner;

import static matrix.MatrixSerializerService.printMatrix;
import static matrix.MatrixSerializerService.readMatrix;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            printMatrix(System.out, readMatrix(scanner).inverse());
        }
    }
}
