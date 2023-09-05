public class FizzBuzz {
    public static void main(String[] args) {
//        implementasi fizzBuzz
        fizzBuzz(5,5);

//        implementasi bubbleSort
        int[] array = {5,7,3,2,1,4,6};
        bubbleSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

//    fizzBuzz
    private static void fizzBuzz(int i, int n) {
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("Fizz Buzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
            ++i;
        }
    }

//    algoritma pengurutan (bubble sort)
    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}