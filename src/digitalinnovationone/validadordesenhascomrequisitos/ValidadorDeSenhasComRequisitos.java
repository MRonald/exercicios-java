package digitalinnovationone.validadordesenhascomrequisitos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValidadorDeSenhasComRequisitos {
    public static void main(String[] args) throws IOException {
        // Pegando o arquivo
        File file = new File("ValidadorDeSenhasComRequisitos.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // Parte da resposta

        // Lendo as linhas do arquivo
        String currentLine = br.readLine();
        List<String> passwords = new ArrayList<>();
        do {
            if (currentLine.length() > 0) {
                passwords.add(currentLine);
            }
            currentLine = br.readLine();
        } while (currentLine != null);
        // Iterando todas as senhas
        for (String password : passwords) {
            boolean isUppercase = false;
            boolean isLowercase = false;
            boolean isNumber = false;
            boolean isCharacterInvalid = false;
            // Verificando tamanho da senha
            if (password.length() >= 6 && password.length() <= 32) {
                // Verifica letra por letra
                for (int i = 0; i < password.length(); i++) {
                    String character = password.substring(i, i + 1);
                    if (character.matches("[a-z]")) {
                        isLowercase = true;
                    } else if (character.matches("[A-Z]")) {
                        isUppercase = true;
                    } else if (character.matches("[0-9]")) {
                        isNumber = true;
                    } else {
                        isCharacterInvalid = true;
                        break;
                    }
                }
                // Resultado
                if ((isLowercase) &&
                        (isUppercase) &&
                        (isNumber) &&
                        (!isCharacterInvalid)) {
                    System.out.println("Senha valida.");
                } else {
                    System.out.println("Senha invalida.");
                }
            } else {
                System.out.println("Senha invalida.");
            }
        }
    }
}
