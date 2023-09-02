import java.util.Arrays;

public class VectorMath {
    public static void main(String[] args) {
        // First vector
        int[] vector1 = {2, 3, 4};
        
        // Second vector
        int[] vector2 = {5, 6, 7};
        
        // Calculate dot product
        int dotProduct = calculateDotProduct(vector1, vector2);
        System.out.println("Dot Product: " + dotProduct);
        
        // Calculate cross product
        int[] crossProduct = calculateCrossProduct(vector1, vector2);
        System.out.println("Cross Product: " + Arrays.toString(crossProduct));
    }
    
    public static int calculateDotProduct(int[] vector1, int[] vector2) {
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        
        int dotProduct = 0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }
        
        return dotProduct;
    }
    
    public static int[] calculateCrossProduct(int[] vector1, int[] vector2) {
        if (vector1.length != 3 || vector2.length != 3) {
            throw new IllegalArgumentException("Vectors must have size 3 for cross product calculation");
        }
        
        int x = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        int y = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        int z = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        
        int[] crossProduct = {x, y, z};
        return crossProduct;
    }
}