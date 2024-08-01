package tester_app;

//Clases csv file
import java.io.FileWriter;
import java.io.PrintWriter;
//Exception
import java.io.IOException;
//Clase contenedor
import java.util.List;

import load_data.DataLoader;
import neuronal_network.Network;

public class App {
    public static void main(String[] args) throws IOException{
        App app = new App();
        app.trainAndGetResults();
    }

    public void trainAndGetResults() throws IOException{

        DataLoader dataLoader = new DataLoader();
        //Poner el path en donde guardaste el archivo csv del data set.
        dataLoader.loadData("C:/Users/Roberto Man/Java/POO/Proyecto/ProyectoIntelIj/src/tester_app/training_set.csv");
        List<List<Integer>> data = dataLoader.getData();
        List<Double> answers = dataLoader.getLabels();

        Network network1 = new Network(100000);
        network1.train(data, answers);

        //Imprimir data en un csv
        //Crear el file
        FileWriter csvFileSaveData = new FileWriter("my_data.csv");

        //Escribir en el CSV
        PrintWriter writer = new PrintWriter(csvFileSaveData);

        //Escribir en el archivo
        writer.print("Prediction,\n");
        //Male tiende a 0, Female tiende a 1
        writer.print(network1.predict(146,59) + ",\n"); //Female    2
        writer.print(network1.predict(175,77) + ",\n"); //Male      3
        writer.print(network1.predict(183,59) + ",\n"); //Male      4
        writer.print(network1.predict(184,77) + ",\n"); //Male      5
        writer.print(network1.predict(132,55) + ",\n"); //Female    6
        writer.print(network1.predict(149,66) + ",\n"); //Female    7
        writer.print(network1.predict(191,83) + ",\n"); //Male      8
        writer.print(network1.predict(135,46) + ",\n"); //Female    9
        writer.print(network1.predict(184,71) + ",\n"); //Male      10
        writer.print(network1.predict(179,65));         //Male      11

        // Cerrar archivo
        writer.close();
    }
}








