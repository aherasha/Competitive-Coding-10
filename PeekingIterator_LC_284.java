/*
Approach :
Use a buffer (nextElement) to store the next item when peek() is called, so it doesn't advance the iterator.
Subsequent next() returns the buffered item if peek() was called earlier; otherwise, it fetches directly from the iterator.
Time Complexity - O(1) for all methods
Space Complexity - O(1) for buffer
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator_LC_284 implements Iterator<Integer> {
    Iterator<Integer> iterator;
    private Integer nextElement;
    private boolean hasPeeked;


    public PeekingIterator_LC_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.hasPeeked = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasPeeked){ //true
            if(iterator.hasNext()) {
                nextElement = iterator.next();
                hasPeeked = true;
            }
        }
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next(); // no peek happened before
        }
        Integer result = nextElement;
        hasPeeked = false; // we are consuming the peeked element
        nextElement = null;
        return result;

    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}