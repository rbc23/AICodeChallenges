import java.util.Arrays;

public class VectorMath {
    public static void main(String[] args) {
        int[] vector1 = {2, 3, 4};
        int[] vector2 = {5, 6, 7};

        int dotProduct = calculateDotProduct(vector1, vector2);
        int[] crossProduct = calculateCrossProduct(vector1, vector2);

        System.out.println("Dot Product: " + dotProduct);
        System.out.println("Cross Product: " + Arrays.toString(crossProduct));
    }

    public static int calculateDotProduct(int[] vector1, int[] vector2) {
        int dotProduct = 0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }
        return dotProduct;
    }

    public static int[] calculateCrossProduct(int[] vector1, int[] vector2) {
        int[] crossProduct = new int[3];
        crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        return crossProduct;
    }
}