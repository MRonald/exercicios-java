import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileTests {
    public static void main(String[] args) throws IOException {
        // Insira o nome do arquivo
        String nameFile = "Divisores.txt";
        // ------------------------
        File file = new File(nameFile);
        FileWriter fw = new FileWriter(file);
        fw.close();
        System.out.println("Criei o arquivo \"" + nameFile + "\"");
    }
}
