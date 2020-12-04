package com.bright.bright.design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;


public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.print("聚合的内容有：");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}

/**
 * 抽象迭代器
 */
interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}

/**
 * 抽象聚合
 */
interface Aggregate {
    void add(Object obj);

    void remove(Object obj);

    Iterator getIterator();
}

/**
 * 具体聚合
 */
class ConcreteAggregate implements Aggregate {
    private final List<Object> list = new ArrayList<>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}


/**
 * 具体迭代器
 */
class ConcreteIterator implements Iterator {
    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }

    public Object first() {
        index = 0;
        return list.get(index);
    }

    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }
}
