package digitalinnovationone.divisores;

import java.io.*;
import java.util.Arrays;

public class Divisores {
    public static void main(String[] args) throws IOException {
        // Pegando o arquivo
        File file = new File("Divisores.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // Parte da resposta

        // Declarando variáveis
        String[] valueIn = br.readLine().split(" ");
        int a = Integer.parseInt(valueIn[0]);
        int b = Integer.parseInt(valueIn[1]);
        int c = Integer.parseInt(valueIn[2]);
        int d = Integer.parseInt(valueIn[3]);
        int n = 0;

        // Buscando N
        for (int i = 1; i <= 109; i++) {
            if ((i % a == 0) &&
                    (i % b != 0) &&
                    (c % i == 0) &&
                    (d % i != 0)) {
                n = i;
                break;
            }
        }

        // Mostrando o resultado
        if (n == 0) {
            System.out.println("-1");
        } else {
            System.out.println(n);
        }
    }
}
