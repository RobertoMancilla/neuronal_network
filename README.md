Neuronal Network Project
This project implements a simple neural network in Java, designed to predict outputs based on input features. The neural network consists of neurons that are interconnected, and it supports training using a dataset to minimize prediction errors. This implementation can be extended for various purposes such as classification, regression, and more.

Features
AbstractNeuron Class: Defines the blueprint for neurons, including methods for mutation, memory management, and computation.
Neuron Class: Extends AbstractNeuron to provide functionality for computing outputs, mutating weights, and bias.
Network Class: Represents the entire neural network, comprising multiple neurons. It includes methods for training the network and making predictions.
Utility Functions: Includes common functions like the sigmoid activation function and mean squared loss calculation.
Training with Dataset: Load a dataset, train the network over multiple epochs, and output predictions.
CSV Output: Saves predictions to a CSV file for further analysis or integration with other applications.

Usage
Training the Network:

The network can be trained using the train method in the Network class. The App class demonstrates this process by loading data, training the network, and generating predictions.
Customize the number of epochs and learning rate by passing them to the Network constructor.
Predicting Outputs:

After training, use the predict method to generate predictions based on new input data. The predictions are saved to a CSV file for easy access.
Customizing the Neuron Behavior:

The Neuron class can be modified to change how the neurons compute outputs, mutate, or remember weights and bias.
Implementation Details
AbstractNeuron Class:

Abstract class defining the structure for neurons. Contains methods like mutate, forget, remember, and compute.
Neuron Class:

Implements the methods defined in AbstractNeuron. It supports weight and bias mutations, remembers the best state, and computes outputs using a sigmoid activation function.
Network Class:

Contains multiple neurons connected in a specific architecture. Trains the network using a simple forward propagation approach and stores the best weights and biases based on the loss function.
Util Class:

Provides utility methods such as sigmoid for activation and meanSquareLoss for evaluating the network's performance.
App Class:

Serves as the entry point for the application. Loads the dataset, trains the network, and saves predictions to a CSV file.
