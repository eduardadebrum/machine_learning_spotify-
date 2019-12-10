import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

/**
 * @author Eduarda de Brum Lucena
 */
public class WekaService {


    public Instance create(Instances instancias, Music music) {
        Instance novo = new DenseInstance(instancias.numAttributes());
        novo.setDataset(instancias);

//        novo.setValue(0, musica.getNome());
//        novo.setValue(1, musica.getAcousticness());
//        novo.setValue(2, musica.getDanceability());
//        novo.setValue(3, musica.getDurationMs());
//        novo.setValue(4, musica.getEnergy());
//        novo.setValue(5, musica.getInstrumentalness());
//        novo.setValue(6, musica.getKey());
//        novo.setValue(7, musica.getLiveness());
//        novo.setValue(8, musica.getLoudness());
//        novo.setValue(9, musica.getMode());
//        novo.setValue(10, musica.getSpeechiness());
//        novo.setValue(11, musica.getTempo());
//        novo.setValue(12, musica.getTimeSignature());
//        novo.setValue(13, musica.getValence());


//        Attribute messageAtt = instancias.attribute("name");
//        novo.setValue(0, messageAtt.addStringValue(music.getName()));
//        novo.setValue(1, music.getAcousticness());
//        novo.setValue(2, music.getDanceability());
//        novo.setValue(3, music.getDurationMs());
//        novo.setValue(4, music.getEnergy());
//        novo.setValue(5, music.getInstrumentalness());
//        novo.setValue(6, music.getKey());
//        novo.setValue(7, music.getLiveness());
//        novo.setValue(8, music.getLoudness());
//        novo.setValue(9, music.getSpeechiness());
////        novo.setValue(10, music.getTempo());
//        novo.setValue(10, music.getTimeSignature());
//        novo.setValue(11, music.getValence());

        //        Attribute messageAtt = instancias.attribute("name");
//        novo.setValue(0, messageAtt.addStringValue(music.getName()));
        novo.setValue(0, music.getAcousticness());
        novo.setValue(1, music.getDanceability());
        novo.setValue(2, music.getDurationMs());
        novo.setValue(3, music.getEnergy());
        novo.setValue(4, music.getInstrumentalness());
        novo.setValue(5, music.getKey());
        novo.setValue(6, music.getLiveness());
        novo.setValue(7, music.getLoudness());
        novo.setValue(8, music.getSpeechiness());
//        novo.setValue(10, music.getTempo());
        novo.setValue(9, music.getTimeSignature());
        novo.setValue(10, music.getValence());

        return novo;
    }


    public Instances loadDataSet(String nameFile) {
        try {
            ConverterUtils.DataSource ds = null;
            ds = new ConverterUtils.DataSource(nameFile);

            Instances instancias = ds.getDataSet();
            instancias.setClassIndex(instancias.numAttributes() - 1);

            return instancias;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

