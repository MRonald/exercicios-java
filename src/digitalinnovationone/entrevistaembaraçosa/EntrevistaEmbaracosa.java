package digitalinnovationone.entrevistaembaraçosa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) throws IOException {
        // Pegando o arquivo
        File file = new File("EntrevistaEmbaracosa.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // Parte da resposta

        // Lendo as linhas do arquivo
        String currentLine = br.readLine();
        List<String> lines = new ArrayList<>();
        do {
            if (currentLine.length() > 0) {
                lines.add(currentLine);
            }
            currentLine = br.readLine();
        } while (currentLine != null);
        // Iterando as palavras
        for (String currentWord : lines) {
            boolean repetition = false;
            for (int i = 1; i < currentWord.length(); i++) {
                String initialPart = currentWord.substring(0, i);
                String finalPart = currentWord.substring(i);
                if (initialPart.endsWith(finalPart)) {
                    System.out.println(initialPart);
                    repetition = true;
                }
            }
            // Caso não haja repetição, imprime a palavra original
            if (!repetition) {
                System.out.println(currentWord);
            }
        }
    }
}
