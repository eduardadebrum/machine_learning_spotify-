import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.text.DecimalFormat;

/**
 * @author Eduarda de Brum Lucena
 */
public class NaiveBayesService {


    public void procces(Music music) {
        try {



            WekaService wekaService = new WekaService();

            Instances dataSet = wekaService.loadDataSet("musicaConverter.arff");

            Instances removeData = teste(new int[] {0}, dataSet);
            Instance novo = wekaService.create(removeData, music);



//            StringToWordVector filter = new StringToWordVector();
//            FilteredClassifier classifier = new FilteredClassifier();
//            classifier.setFilter(filter);
//            classifier.setClassifier(new NaiveBayes());
//            classifier.buildClassifier(dataSet);

            NaiveBayes naiveBayes = new NaiveBayes();
            naiveBayes.buildClassifier(removeData);
//            NaiveBayes naiveBayes = new NaiveBayes();
//            naiveBayes.buildClassifier(dataSet);

            double[] resultado = naiveBayes.distributionForInstance(novo);

            DecimalFormat df = new DecimalFormat("##.##%");


            System.out.println("Algoritmo Naive Bayes");
            System.out.println("Gosto: " + df.format(resultado[0]));
            System.out.println("Não Gosto: " + df.format(resultado[1]));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private Instances teste(int[] columns, Instances instances) {
        Remove removeFilter = new Remove();
        try {

            removeFilter.setAttributeIndicesArray(columns);

            removeFilter.setInputFormat(instances);

            return Filter.useFilter(instances, removeFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
