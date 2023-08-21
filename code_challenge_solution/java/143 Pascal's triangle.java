
class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5; // Specify the number of rows in Pascal's triangle

        for (int i = 0; i < numRows; i++) {
            int value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(value + " ");
                value = value * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
