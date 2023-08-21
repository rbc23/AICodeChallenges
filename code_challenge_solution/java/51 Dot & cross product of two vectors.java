import java.util.Arrays;

public class VectorMath {
    
    public static int dotProduct(int[] vector1, int[] vector2) {
        int dotProduct = 0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }
        return dotProduct;
    }
    
    public static int[] crossProduct(int[] vector1, int[] vector2) {
        int[] crossProduct = new int[3];
        crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        return crossProduct;
    }
    
    public static void main(String[] args) {
        int[] vector1 = {1, 2, 3};
        int[] vector2 = {4, 5, 6};
        
        int dotProduct = dotProduct(vector1, vector2);
        int[] crossProduct = crossProduct(vector1, vector2);
        
        System.out.println("Dot Product: " + dotProduct);
        System.out.println("Cross Product: " + Arrays.toString(crossProduct));
    }
}