class DynamicArray {
    int[] array;
    int size;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            this.array = new int[capacity];
        }

        this.size = 0;
    }

    private boolean isValidIndex(int index) {
        return index < size && index >= 0;
    }

    public int get(int i) {
        if (isValidIndex(i)) {
            return array[i];
        }

        return -1;
    }

    public void set(int i, int n) {
        if (isValidIndex(i)) {
            this.array[i] = n;
        }
    }

    public void pushback(int n) {
        // add element at the back of the array

        if (this.size == this.array.length) {
            resize();
        }

        this.array[size] = n;
        this.size++;


    }

    public int popback() {
        int result = - 1;

        if (this.size > 0) {
            result = this.array[this.size - 1];
        }

        this.size--;

        return result;
        

    }

    private void resize() {
        int[] resized = new int[this.array.length * 2];

        for (int i = 0; i < this.array.length; i++) {
            resized[i] = this.array[i];
        }

        this.array = resized;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.array.length;
    }
}
