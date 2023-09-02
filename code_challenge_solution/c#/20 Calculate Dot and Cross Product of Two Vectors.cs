```csharp

using System;

namespace VectorMath
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] vector1 = { 1, 2, 3 }; // vector 1
            int[] vector2 = { 4, 5, 6 }; // vector 2

            // Calculate dot product of the two vectors
            int dotProduct = CalculateDotProduct(vector1, vector2);
            Console.WriteLine("Dot product: " + dotProduct);

            // Calculate cross product of the two vectors
            int[] crossProduct = CalculateCrossProduct(vector1, vector2);
            Console.WriteLine("Cross product: (" + crossProduct[0] + ", " + crossProduct[1] + ", " + crossProduct[2] + ")");
        }

        static int CalculateDotProduct(int[] vector1, int[] vector2)
        {
            int dotProduct = 0;

            for (int i = 0; i < vector1.Length; i++)
            {
                dotProduct += vector1[i] * vector2[i];
            }

            return dotProduct;
        }

        static int[] CalculateCrossProduct(int[] vector1, int[] vector2)
        {
            int[] crossProduct = new int[3];

            crossProduct[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
            crossProduct[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
            crossProduct[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];

            return crossProduct;
        }
    }
}

```