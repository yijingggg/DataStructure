/**
 * A class that implements the BagInterface using an array.
 */
public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        boolean result = true;
        if (isFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    //remove the last element
    public T remove() {
        T result = null;
        if (!isEmpty()) {
            numberOfEntries--;
            result = bag[numberOfEntries];
            bag[numberOfEntries] = null;
        }
        return result;
    }

    //replace the entry with the last element
    public boolean remove(T anEntry) {
        boolean result = false;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                numberOfEntries--;
                bag[i] = bag[numberOfEntries];
                bag[numberOfEntries] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < numberOfEntries; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                freq++;
            }
        }
        return freq;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    //Q2
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        T[] thisBagArr = this.toArray();
        T[] anotherBagArr = anotherBag.toArray();

        ArrayBag<T> unionBag = new ArrayBag<>();

        for (int i = 0; i < thisBagArr.length; i++) {
            unionBag.add(thisBagArr[i]);
        }

        for (int i = 0; i < anotherBagArr.length; i++) {
            unionBag.add(anotherBagArr[i]);
        }
        return unionBag;
    }

    //Q3
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        T[] thisBagArr = this.toArray();
        T[] anotherBagArr = anotherBag.toArray();

        ArrayBag<T> intersectionBag = new ArrayBag<>();

        for (int i = 0; i < thisBagArr.length; i++) {
            for (int j = 0; j < anotherBagArr.length; j++) {
                if (thisBagArr[i].equals(anotherBagArr[j])) {
                    intersectionBag.add(anotherBagArr[j]);
                    anotherBagArr[j] = null;
                    break;
                }
            }
        }
        return intersectionBag;
    }

    //Q4
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        T[] thisBagArr = this.toArray();
        T[] anotherBagArr = anotherBag.toArray();

        ArrayBag<T> differenceBag = new ArrayBag<>();

        // set duplicate items to null
        for (int i = 0; i < thisBagArr.length; i++) {
            for (int j = 0; j < anotherBagArr.length; j++) {
                if (thisBagArr[i].equals(anotherBagArr[j])) {
                    thisBagArr[i] = null;
                    anotherBagArr[j] = null;
                    break;
                }
            }
        }

        for (int i = 0; i < thisBagArr.length; i++) {
            if (thisBagArr[i] != null) {
                differenceBag.add(thisBagArr[i]);
            }

        }
        return differenceBag;
    }
}
