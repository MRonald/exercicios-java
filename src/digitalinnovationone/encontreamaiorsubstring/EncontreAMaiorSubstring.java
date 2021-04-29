package digitalinnovationone.encontreamaiorsubstring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EncontreAMaiorSubstring {
    public static void main(String[] args) throws IOException {
        // Pegando o arquivo
        File file = new File("EncontreAMaiorSubstring.txt");
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
        int initialIndex = 0;
        // Pegando o par de palavras
        while (initialIndex != lines.size()) {
            String[] pair = new String[2];
            pair[0] = lines.get(initialIndex);
            pair[1] = lines.get(initialIndex + 1);
            int lastIndexWord = pair[0].length();
            int initialIndexWord = 0;
            int sizeMaxGroup = 0;
            while (initialIndexWord != lastIndexWord) {
                for (int i = lastIndexWord; i > initialIndexWord; i--) {
                    if (pair[1].contains(pair[0].substring(initialIndexWord, i))) {
                        int sizeCurrentGroup = pair[0].substring(initialIndexWord, i).length();
                        if (sizeCurrentGroup > sizeMaxGroup) {
                            sizeMaxGroup = sizeCurrentGroup;
                        }
                    }
                }
                initialIndexWord++;
            }
            System.out.println(sizeMaxGroup);
            // Índice do próximo par de palavras
            initialIndex += 2;
        }
    }
}
