using System;

public class Program
{
    public static void Main()
    {
        // Vector 1
        double[] vector1 = { 2, 3, 4 };

        // Vector 2
        double[] vector2 = { 5, 6, 7 };

        // Calculate dot product
        double dotProduct = CalculateDotProduct(vector1, vector2);

        // Calculate cross product
        double[] crossProduct = CalculateCrossProduct(vector1, vector2);

        // Display the dot product and cross product
        Console.WriteLine("Dot Product: " + dotProduct);
        Console.WriteLine("Cross Product: [" + string.Join(", ", crossProduct) + "]");
    }

    public static double CalculateDotProduct(double[] vector1, double[] vector2)
    {
        if (vector1.Length != vector2.Length)
        {
            throw new ArgumentException("Vector lengths do not match.");
        }

        double dotProduct = 0;

        for (int i = 0; i < vector1.Length; i++)
        {
            dotProduct += vector1[i] * vector2[i];
        }

        return dotProduct;
    }

    public static double[] CalculateCrossProduct(double[] vector1, double[] vector2)
    {
        if (vector1.Length != 3 || vector2.Length != 3)
        {
            throw new ArgumentException("Both vectors must have length 3 for calculating cross product.");
        }

        double[] crossProduct = new double[3];

        crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];

        return crossProduct;
    }
}