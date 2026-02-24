package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class FileManager {

    public static final String VENDAS1 = "vendas.csv";

    public static List<String[]> ReadCSV(String csvName) {
        List<String[]> dataList = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(csvName));
            String line;

            bf.readLine();

            while ((line = bf.readLine()) != null) {
                String[] data = line.split(",");
                dataList.add(data);
            }

            bf.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
            System.out.println(e);
            return dataList;
        }

        return dataList;
    }
}
