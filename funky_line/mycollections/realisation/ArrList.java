package com.funky_line.mycollections.realisation;

import com.funky_line.mycollections.myinterface.Ilist;
/**
 * Created by Rudniev Oleksandr on 10.11.2016.
 */
class ArrList<T> implements Ilist<T> {

    /**
     * Array for containing myArr
     */
    private Object myArr[];

    /**
     * Position to the current cell
     */
    private int position;

    /**
     * Default constructor. Initialized real size with
     * value 10.
     */
    ArrList() {
        this(10);
    }

    /**
     * Constructor with initial value for real size array
     *
     * @param capaity real size of the collection
     */
    private ArrList(int capaity) {
        position = 0;
        myArr = new Object[capaity];
    }

    /**
     * Extending containing array with saving data.
     */
    private void extendMyArr() {
        Object[] newMyArr = new Object[(int) (myArr.length * 2)];
        for (int i = 0; i < myArr.length; i++) {
            newMyArr[i] = myArr[i];
        }
        myArr = newMyArr;
    }

    /**
     * Add new object to the end of the collection.
     * @param o added object
     * @return true when object is successful added.
     */
    @Override
    public boolean add(Object o) {
        if (myArr.length == position) {
            extendMyArr();
        }
        myArr[position++] = o;
        return true;
    }

    /**
     * Add new object to the concrete position.
     * The object that held the position will be shifted by 1 position
     * @param value added object
     * @param o position for the added object
     * @return true when object is successful added.
     */
    @Override
    public boolean add(int o, Object value) {
        if (o > position) {
            throw new IndexOutOfBoundsException("size:" + position + " index:" + o);
        }
        if (position >= myArr.length - 1) {
            extendMyArr();
        }
        for (int i = position + 1; i > o; i--) {
            myArr[i] = myArr[i - 1];
        }
        myArr[o] = value;
        position++;

        return true;
    }

    /**
     * Remove object in collection from the concrete position
     * Objects which followed the deleted object will be moved to the 1 position
     * @param index position for the remove added object
     * @return true when object is successful remove.
     */
    @Override
    public boolean remove(int index) {
        if (index > position) {
            throw new IndexOutOfBoundsException("size:" + position + " index:" + index);
        }
        for (int i = index + 1; i < position; i++) {
            myArr[i - 1] = myArr[i];
        }
        position--;

        return true;
    }

    /**
     * Verification availability object in collection.
     * @param o object for search
     * @return true when object contained in collection
     */
    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (myArr[i].equals(o));{
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Get object from index.
     * @param index the index of returned object.
     * @return object at the specified position
     */
    @Override
    public Object get(int index) {
        if (index > position) {
            throw new IndexOutOfBoundsException("size:" + position + " index:" + index);
        }
        return myArr[index];
    }

    /**
     * Returned size of the collection.
     * @return size of the collection.
     */
    @Override
    public int size() {
        return position;
    }

    /**
     * Returns true if this collection contains no elements.
     * @return true only if length is 0.
     */
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] != null) return false;
        }
        return true;
    }

    /**
     *Set all elements of collection to null.
     *Also set position to 0 (first element collection).
     *Then try call garbage collector.
     */
    @Override
    public void  clear() {
        for (int i = 0; i < position ; i++) {
            myArr[i] = null;
        }
        position = 0;
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

//    @Override
//    public boolean set(int o, Object value) {
//        return false;
//    }

    /**
     * Add new object to the concrete position.
     * Previous object will be lost.
     * @param value added object
     * @param o position for added object/
     * @return true when object successful added.
     */
    @Override
    public boolean set(int o, Object value) {
        boolean result = false;
        if (o < position){
            myArr[o] = value;
            result = true;
        }
        return result;
    }
}
