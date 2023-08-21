using System;

class Program
{
    static void Main(string[] args)
    {
        double[] vector1 = { 2, 3, 4 };
        double[] vector2 = { 5, 6, 7 };

        double dotProduct = DotProduct(vector1, vector2);
        double[] crossProduct = CrossProduct(vector1, vector2);

        Console.WriteLine("Dot Product: " + dotProduct);
        Console.WriteLine("Cross Product: " + string.Join(", ", crossProduct));
    }

    static double DotProduct(double[] vector1, double[] vector2)
    {
        double dotProduct = 0;
        for (int i = 0; i < vector1.Length; i++)
        {
            dotProduct += vector1[i] * vector2[i];
        }
        return dotProduct;
    }

    static double[] CrossProduct(double[] vector1, double[] vector2)
    {
        if (vector1.Length != 3 || vector2.Length != 3)
        {
            throw new ArgumentException("Both vectors must have 3 dimensions for cross product calculation");
        }

        double[] crossProduct = new double[3];
        crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];

        return crossProduct;
    }
}