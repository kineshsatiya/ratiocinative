package com.ratiocinative.solutions.design;

import java.util.Iterator;
import java.util.List;

/**
 * better than iterator is use two pointers - inner and outer, be careful in remove()
 */
public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> parentIterator;
    Iterator<Integer> current;

    public Vector2D(List<List<Integer>> vec2d) {
        parentIterator = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return current.next();
    }

    @Override
    public boolean hasNext() {
        if (current == null) {
            if (parentIterator.hasNext()) {
                current = parentIterator.next().iterator();
            } else {
                return false;
            }

        }
        if (current.hasNext()) {
            return true;
        } else {
            while (parentIterator.hasNext() && !current.hasNext()) {
                current = parentIterator.next().iterator();
                if (current.hasNext()) {
                    return true;
                }
            }
            return false;
        }
    }
}
