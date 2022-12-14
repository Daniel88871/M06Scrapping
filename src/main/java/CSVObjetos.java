import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVObjetos {

    File lolsFile3 = new File("src/lols3.csv");

    public CSVObjetos(List<Objetos> lols) {
        CSVWriter csvWriter;
        String[] head = {"popularidad","porcentajevictorias"};
        List<String[]> infolols = new ArrayList<>();
        for (Objetos l : lols){
            infolols.add(new String[] {l.popularidad,l.porcentajedevictoria});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(lolsFile3));
            csvWriter.writeNext(head);
            csvWriter.writeAll(infolols);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}