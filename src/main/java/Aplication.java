import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
public class Aplication {

    public static void main(String[] args) {

        List<Cd> cds = new ArrayList<>();

        cds.add(new Cd("3JYT9f8X9LOfpTzbKDWN4a", Preferencia.GOSTO)); // The Ultimate Collection by Sade
        cds.add(new Cd("78f57KI9AnDAVHXG10yXvp", Preferencia.GOSTO)); // Eu, Tu e o Mundo by Esteban Tavares
        cds.add(new Cd("3YohnRYDCZvoDy8KueGutU", Preferencia.GOSTO)); // Esteban Tavares no Estúdio Showlivre (Ao Vivo)
        cds.add(new Cd("2gTwQq9qxwsU3mlJ9AL2dx", Preferencia.GOSTO)); // BRAZA Tijolo por Tijolo


        cds.add(new Cd("0DEFUklS9qGhffnp0zziso", Preferencia.NAO_GOSTO));
        cds.add(new Cd("1n4L6uxvbs8n1hnXI2WOTR", Preferencia.NAO_GOSTO));
        cds.add(new Cd("15FTDHzndnAulXT01aCNQb", Preferencia.NAO_GOSTO));
        cds.add(new Cd("754RY5WpZ2LTUZsk8kDBju", Preferencia.NAO_GOSTO));


        UserServiceImpl userServiceImpl = new UserServiceImpl();
        List<Music> listMusics = userServiceImpl.getListMusicas(cds);


//        DataSet.create("musicas.csv", listMusics);
//        DataSet.converterCsvToArff("musicas.csv", "musicaConverter.arff");

        try {

            Music music = userServiceImpl.findMusic("6oWaIuuSSUN1CveLzxcanX");

            System.out.println("Musica" + music.toString());

//            KnnService knnService = new KnnService();
//            knnService.procces(music);

            NaiveBayesService naiveBayesService = new NaiveBayesService();
            naiveBayesService.procces(music);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

