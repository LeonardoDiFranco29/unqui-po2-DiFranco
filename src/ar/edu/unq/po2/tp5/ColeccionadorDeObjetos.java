package ar.edu.unq.po2.tp5;

import java.util.Collection;
import java.util.List;

public class ColeccionadorDeObjetos {

    // Usa List porque get(0) es un método de List
    public Object getFirstFrom(List<?> collection) {
        return collection.get(0);
    }

    // Usa Collection porque add() es parte de Collection
    public void addLast(Object element, Collection<Object> collection) {
        collection.add(element);
    }

    // Usa List porque subList es un método de List
    public List<?> getSubCollection(List<?> collection, int from, int to) {
        return collection.subList(from, to);
    }

    // Usa Collection porque contains() está en Collection
    public boolean containsElement(Collection<?> collection, Object element) {
        return collection.contains(element);
    }
}