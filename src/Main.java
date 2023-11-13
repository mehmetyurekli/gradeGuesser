public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        double[] x1 = {7.6, 8, 6.6, 8.4, 8.8, 7.2, 8.1, 9.5, 7.3, 8.9, 7.5, 7.6, 7.9, 8, 7.2, 8.8, 7.6, 7.5, 9, 7.7, 8.1};
        double[] x2 = {11, 10, 8, 10, 12, 10, 11, 9, 9, 11, 11, 9, 10, 10, 9, 10, 11, 10, 10, 9, 11};
        double[] target = {77, 70, 55, 78, 95, 67, 80, 87, 60, 88, 72, 58, 70, 76, 58, 81, 74, 67, 82, 62, 82};

        Neuron neuronOne = new Neuron();
        neuronOne.load(x1, x2, target);
        neuronOne.setLambda(0.05);
        neuronOne.train(10);

        Neuron neuronTwo = new Neuron();
        neuronTwo.load(x1, x2, target);
        neuronTwo.setLambda(0.01);
        neuronTwo.train(50);

        Neuron neuronThree = new Neuron();
        neuronThree.load(x1, x2, target);
        neuronThree.setLambda(0.025);
        neuronThree.train(100);

        System.out.println(neuronOne.getMse());
        System.out.println(neuronTwo.getMse());
        System.out.println(neuronThree.getMse());

        System.out.printf("RESULTS OF NEURON - 1 | MSE = %,.5f\n", neuronOne.getMse());
        neuronOne.printResults();

        System.out.printf("RESULTS OF NEURON - 2 | MSE = %,.5f\n", neuronTwo.getMse());
        neuronTwo.printResults();

        System.out.printf("RESULTS OF NEURON - 3 | MSE = %,.5f\n", neuronThree.getMse());
        neuronThree.printResults();


        System.out.println("GUESSES FROM UNTRAINED DATA:");
        System.out.printf("X1: %.1f | X2: %.1f -> Guess: %.0f\n", 10.1, 12.2, neuronTwo.guess(10, 12.2)*100);
        System.out.printf("X1: %.1f | X2: %.1f -> Guess: %.0f\n", 2.1, 3.5, neuronTwo.guess(2.1, 3.5)*100);
        System.out.printf("X1: %.1f | X2: %.1f -> Guess: %.0f\n", 6.5, 7.3, neuronTwo.guess(6.5, 7.3)*100);
        System.out.printf("X1: %.1f | X2: %.1f -> Guess: %.0f\n", 14.4, 9.2, neuronTwo.guess(14.4, 9.2)*100);
        System.out.printf("X1: %.1f | X2: %.1f -> Guess: %.0f\n", 1.5, 9.9, neuronTwo.guess(1.5, 9.9)*100);

    }
}
