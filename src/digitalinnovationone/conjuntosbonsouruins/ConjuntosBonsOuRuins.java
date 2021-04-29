package digitalinnovationone.conjuntosbonsouruins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConjuntosBonsOuRuins {
    public static void main(String[] args) throws IOException {
        // Pegando o arquivo
        File file = new File("ConjuntosBonsOuRuinsTest.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // Parte da resposta

        // Lendo as linhas do arquivo
        String currentLine = br.readLine();
        List<String> lines = new ArrayList<>();
        do {
            lines.add(currentLine);
            currentLine = br.readLine();
        } while (currentLine != null);
        // Iterando os dados
        if (lines.size() > 1) {
            int indexNumber = 0;
            do {
                // Tratando o conjunto
                int numberOfWords = Integer.parseInt(lines.get(indexNumber));
                String[] words = new String[numberOfWords];
                boolean goodGroup = true;
                // Preenchendo o vetor com as palavras a analisar
                int countArray = 0;
                for (int i = indexNumber; i < indexNumber + numberOfWords; i++) {
                    words[countArray] = lines.get(i + 1);
                    countArray++;
                }
                // Testando cada palavra do conjunto
                for (int i = 0; i < words.length; i++) {
                    String currentWord = words[i];
                    for (int j = 0; j < words.length; j++) {
                        // Verifica se o índice da palavra atual é diferente da palavra testada
                        // E se a palavra atual é prefixo da palavra testada
                        if (i != j && words[j].indexOf(currentWord) == 0) {
                            goodGroup = false;
                            break;
                        }
                    }
                }
                // Mostrando resultado
                if (goodGroup) {
                    System.out.println("Conjunto Bom");
                } else {
                    System.out.println("Conjunto Ruim");
                }
                // Buscando o próximo início do próximo grupo
                indexNumber += numberOfWords + 1;
            } while (!lines.get(indexNumber).equals("0"));
        }
    }
}
