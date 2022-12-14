import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVCampeones {

    File lolsFile1 = new File("src/lols.csv");

    public CSVCampeones(List<Campeones> lols) {
        CSVWriter csvWriter;
        String[] head = {"nombre","popularidad","porcentajevictorias","porcentajebaneos","kda","pentasporpartida"};
        List<String[]> infolols = new ArrayList<>();
        for (Campeones l : lols){
            infolols.add(new String[] {l.nombre,l.popularidad,l.porcentajevictorias,l.porcentajebaneos,l.kda,l.pentasporpartida});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(lolsFile1));
            csvWriter.writeNext(head);
            csvWriter.writeAll(infolols);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}