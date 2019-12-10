import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.text.DecimalFormat;

/**
 * @author Eduarda de Brum Lucena
 */
public class KnnService {

    private WekaService wekaService;

    public KnnService() {
        this.wekaService = new WekaService();
    }

    public void procces(Music music) {
        try {

            Instances dataSet = wekaService.loadDataSet("musicaConverter.arff");
            Instance novo = wekaService.create(dataSet, music);

            int metade = dataSet.size() / 2;
            int k = metade % 2 == 0 ? metade - 1 : metade;

            StringToWordVector filter = new StringToWordVector();
            FilteredClassifier classifier = new FilteredClassifier();
            classifier.setFilter(filter);
            classifier.setClassifier(new IBk(k));
            classifier.buildClassifier(dataSet);

//            IBk iBk = new IBk(45);
//            iBk.buildClassifier(dataSet);


            double[] resultado = classifier.distributionForInstance(novo);

            DecimalFormat df = new DecimalFormat("##.##%");

            System.out.println("-------------------------------");
            System.out.println("Algoritmo K-NN");
            System.out.println("Total dto.Musica: " + dataSet.size());
            System.out.println("Valor de K Vizinhos: " + k);
            System.out.println("Gosto: " + df.format(resultado[0]));
            System.out.println("Não Gosto: " + df.format(resultado[1]));
            System.out.println("-------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
