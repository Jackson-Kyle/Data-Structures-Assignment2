public class MinHeap{

    private Job[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new Job[capacity + 1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void insert(Job job) {
        heap[++size] = job;
        swim(size);
    }public void timeInsert(Job job) {
        heap[++size] = job;
        timeSwim(size);
    }
    public int delMin(){
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        Job min = heap[1];
        exch(1, size--);
        sink(1);
        heap[size+1] = null;
        return min.getId();
    }
    private void swim(int k) {
        while (k > 1 && less(k,k/2)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private void timeSwim(int k) {
        while (k > 1 && timeLess(k,k/2)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if(j < size && less(j+1, j)) j++;
            if(!less(j,k)) break;
            exch(k,j);
            k = j;
        }
    }
    private void timeSink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if(j < size && timeLess(j+1, j)) j++;
            if(!timeLess(j,k)) break;
            exch(k,j);
            k = j;
        }
    }
    public Job returnFirst(){
        return heap[1];
    }
    private void exch(int i, int j) {
        Job temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;

    }
    private boolean timeLess(int i, int j) {
        return heap[i].timeCompareTo(heap[j]) < 0;

    }

}
