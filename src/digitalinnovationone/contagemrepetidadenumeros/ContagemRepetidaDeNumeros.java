package digitalinnovationone.contagemrepetidadenumeros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContagemRepetidaDeNumeros {
    public static void main(String[] args) throws IOException {
        // Pegando o arquivo
        File file = new File("ContagemRepetidaDeNumeros.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // Parte da resposta

        // Lendo as linhas do arquivo
        int sizeIn = Integer.parseInt(br.readLine());
        String currentLine = br.readLine();
        Map<Integer, Integer> relatorioNumeros = new HashMap<>();
        for (int i = 0; i < sizeIn; i++) {
            if (!relatorioNumeros.containsKey(Integer.parseInt(currentLine))) {
                relatorioNumeros.put(Integer.parseInt(currentLine), 1);
            } else {
                relatorioNumeros.put(
                    Integer.parseInt(currentLine),
                    relatorioNumeros.get(Integer.parseInt(currentLine)) + 1
                );
            }
            currentLine = br.readLine();
        }

        // Iterando e mostrando resultado
        List<Map.Entry<Integer, Integer>> listaOrdenada = new ArrayList<>(relatorioNumeros.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, Integer> entry : listaOrdenada) {
            System.out.println(entry.getKey() + " aparece " + entry.getValue() + " vez(es)");
        }
    }
}
