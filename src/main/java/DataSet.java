import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */

public class DataSet {

//    static void create(String csvFileName, List<Musica> musicas) {
//        createCsv(csvFileName, musicas);
//        converterCsvToArff(csvFileName, );
//    }

    static void create(String csvFileName, List<Music> musicList) {

        ICsvBeanWriter beanWriter = null;

        CellProcessor[] processors = new CellProcessor[]{
                new NotNull(),//                "name",
                new NotNull(),//                "acousticness",
                new NotNull(),//                "danceability",
                new NotNull(),//                "durationMs",
                new NotNull(),//                "energy",
                new NotNull(),//                "instrumentalness",
                new NotNull(),//                "key",
                new NotNull(),//                "liveness",
                new NotNull(),//                "loudness",
                new NotNull(),//                "speechiness",
//                new NotNull(),//                "tempo",
                new NotNull(),//                "timeSignature",
                new NotNull(),//                "valence",
                new NotNull() //                "preferencia"
        };

        try {
            beanWriter = new CsvBeanWriter(new FileWriter(csvFileName), CsvPreference.STANDARD_PREFERENCE);

            String[] header = {
                    "name",
                    "acousticness",
                    "danceability",
                    "durationMs",
                    "energy",
                    "instrumentalness",
                    "key",
                    "liveness",
                    "loudness",
                    "speechiness",
//                    "tempo",
                    "timeSignature",
                    "valence",
                    "preferencia"
            };

            beanWriter.writeHeader(header);

            for (Music music : musicList) {
                beanWriter.write(music, header, processors);
            }

        } catch (IOException ex) {
            System.err.println("Error create CSV: " + ex);
        } finally {
            if (beanWriter != null) {
                try {
                    beanWriter.close();
                } catch (IOException ex) {
                    System.err.println("Error close to file csv " + ex);
                }
            }
        }
    }

    public static void converterCsvToArff(String path, String name) {
        try {
            // carregar CSV
            CSVLoader loader = new CSVLoader();

            File file = new File(path);
            loader.setSource(file);

            Instances data = loader.getDataSet();

            // save ARFF
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(name));
            saver.writeBatch();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
