package load_data;

// DataLoader.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private List<List<Integer>> data;
    private List<Double> labels;

    //Constructor
    public DataLoader() {
        //Lista de listas porque en un arreglo se guardan los pesos y las alturas [[190,60],[]]...
        data = new ArrayList<List<Integer>>();
        labels = new ArrayList<>();
    }

    public void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.trim().split("\\s*,\\s*");
                List<Integer> features = new ArrayList<>();
                labels.add("Male".equals(values[2]) ? 0.0 : 1.0); // Género: Male = 0.0, Female = 1.0, es decir cambia los males y females por 0 y 1
                features.add(Integer.parseInt(values[0])); // Altura
                features.add(Integer.parseInt(values[1])); // Peso
                data.add(features);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<Integer>> getData() {
        return data;
    }

    public List<Double> getLabels() {
        return labels;
    }
}