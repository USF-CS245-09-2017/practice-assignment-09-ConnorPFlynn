import java.util.Arrays;

public class BinaryHeap {

    int[] heap;
    int size;

    BinaryHeap(){
        heap = new int[10];
        size = 0;
    }

    void add(int value){

        if(size == heap.length){
            heap = Arrays.copyOf(heap, heap.length * 2);
        }

        heap[size++] = value;
        int current = size-1;
        int parent = (current - 1) / 2;
        while(current != 0 && heap[current] < heap[parent]){
            swap(heap, current, parent);
            current = parent;
            parent = (parent-1)/2;
        }

    }

    private void swap(int[] arr, int i, int j){

        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void siftDown(int value){

        int parent = value;
        int l = 2 * parent + 1;
        int r = 2 * parent + 2;


        if (l >= size || r >= size) {
            return;
        }

        if (heap[l] > heap[r] && heap[r] < heap[parent]) {
            swap(heap, parent, r);
            siftDown(r);
        }
        else if(heap[r] > heap[l] && heap[l] < heap[parent]) {
            swap(heap, parent, l);
            siftDown(l);
        }
    }

    int remove() {

        swap(heap, 0, size-1);
        size--;
        if(size > 0){
            siftDown(0);
        }
        return heap[size];
    }
}