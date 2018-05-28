package trbparte2;
import java.util.Scanner;

public class TRBParte2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Insercao AVL");
        System.out.println("2 - Insercao B");
        System.out.println("3 - Insercao Splay");
        System.out.println("4 - Insercao VP");
        System.out.println("5 - Remocao AVL");
        System.out.println("6 - Remocao B");
        System.out.println("7 - Remocao VP");
        System.out.println("Qual operacao voce deseja realizar?");
        int op = scanner.nextInt();
        InsereRemove T = new InsereRemove(10000, op);  
    }
}
