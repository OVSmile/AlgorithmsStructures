
public class Main {
    public static  void sort(int[] array) {
        // Построение кучи (пергруппировка массива)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        //Один за другим извлечение элементов из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещение текущего корня в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызов процедуры heaoify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализация наиьольшего элемента как корня
        int leftChild = 2 * rootIndex + 1; // левый = 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2; // правый = 2 * rootindex + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // Если правый дочерний элемент больше, чем самый большой эдлемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивное преобращованте в двоичную кучу затронутого поддерева
            heapify(array, heapSize, largest);
        }
    }
}