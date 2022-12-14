import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHechizos {

    File lolsFile2 = new File("src/lols2.csv");

    public CSVHechizos(List<Hechizos> lols) {
        CSVWriter csvWriter;
        String[] head = {"nombre","popularidad","porcentajevictorias"};
        List<String[]> infolols = new ArrayList<>();
        for (Hechizos l : lols){
            infolols.add(new String[] {l.nombre,l.popularidad,l.porcentajevictorias});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(lolsFile2));
            csvWriter.writeNext(head);
            csvWriter.writeAll(infolols);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}