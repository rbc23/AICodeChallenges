public class VectorMath {
    public static void main(String[] args) {
        double[] vector1 = {2, 3, 4};
        double[] vector2 = {5, 6, 7};

        double dotProduct = calculateDotProduct(vector1, vector2);
        double[] crossProduct = calculateCrossProduct(vector1, vector2);

        System.out.println("Dot Product: " + dotProduct);
        System.out.println("Cross Product: [" + crossProduct[0] + ", " + crossProduct[1] + ", " + crossProduct[2] + "]");
    }

    public static double calculateDotProduct(double[] vector1, double[] vector2) {
        if(vector1.length != vector2.length){
            throw new IllegalArgumentException("Vector dimensions are not the same.");
        }

        double dotProduct = 0;

        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }

        return dotProduct;
    }

    public static double[] calculateCrossProduct(double[] vector1, double[] vector2) {
        if(vector1.length != 3 || vector2.length != 3){
            throw new IllegalArgumentException("Vector dimensions are not 3.");
        }

        double[] crossProduct = new double[3];

        crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];

        return crossProduct;
    }
}

