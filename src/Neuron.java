import java.util.Random;

public class Neuron {
    private final Random r = new Random();
    public double w1;
    public double w2;
    private double[] x1s;
    private double[] x2s;
    private double[] targetArray;
    private double lambda;
    private double mse;

    public void load(double[] x1s, double[] x2s, double[] target) { //loading data to the neuron
        this.x1s = x1s;
        this.x2s = x2s;
        this.targetArray = target;
        this.w1 = r.nextDouble(0, 1);
        this.w2 = r.nextDouble(0, 1);
    }

    public double guess(double x1, double x2) { // makes guesses using the formula given
        double actualGuess = ((x1 / 15 * w1) + (x2 / 10 * w2));
        // I actually added this part because if I give the neuron values like 50, 60; it was returning guesses
        // over 100. so I set up the max and minimum grade.
        if (actualGuess > 1) {
            return 1;
        }
        if (actualGuess < 0) {
            return 0;
        }
        return actualGuess;
    }

    public void train(int epoch) { // trains the neuron from the loaded set (epoch x sample number) times.
        for (int i = 0; i < epoch; i++) {
            for (int j = 0; j < x1s.length; j++) {
                double target = targetArray[j] / 100;
                double guess = guess(x1s[j], x2s[j]);
                this.w1 = w1 + lambda * (target - guess) * x1s[j]/10;
                this.w2 = w2 + lambda * (target - guess) * x2s[j]/15;
            }
        }
    }

    public void printGuesses() { // makes guesses and prints the inputs, the output and the expected values
        double sumOfSquares = 0; // mse is the average of sum of squares.
        System.out.printf("| %6s | %6s | %6s | %6s |\n", "X1", "X2", "TARGET", "GUESS");
        System.out.println("-------------------------------------");
        for (int i = 0; i < x1s.length; i++) {
            double target = targetArray[i] / 100;
            double guess = guess(x1s[i], x2s[i]);
            System.out.printf("| %6s | %6s | %6s | %6.2f |\n", x1s[i], x2s[i], targetArray[i], guess * 100);
            sumOfSquares += Math.pow(target - guess, 2);
        }
        this.mse = sumOfSquares/x1s.length;
        System.out.printf("MSE= %,.5f", mse);
        System.out.println();
    }

    public double getMse() { // mse getter
        return mse;
    }

    public void setLambda(double lambda) { //lambda setter
        this.lambda = lambda;
    }
}
