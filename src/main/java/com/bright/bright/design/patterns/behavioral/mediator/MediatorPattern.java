package com.bright.bright.design.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Colleague c1, c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        c1.send();
        System.out.println("-----------------");
        c2.send();
    }
}

/**
 * 抽象同事类
 * 定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能
 */
interface Colleague {
    void receive();

    void send();
}

/**
 * 单例中介者
 */
class Mediator {
    private static final Mediator smd = new Mediator();
    private final List<Colleague> colleagues = new ArrayList<>();

    private Mediator() {
    }

    public static Mediator getMedium() {
        return (smd);
    }

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
        }
    }

    public void relay(Colleague scl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(scl)) {
                ob.receive();
            }
        }
    }
}


/**
 * 具体同事类1
 */
class ConcreteColleague1 implements Colleague {
    ConcreteColleague1() {
        Mediator smd = Mediator.getMedium();
        smd.register(this);
    }

    public void receive() {
        System.out.println("具体同事类1：收到请求。");
    }

    public void send() {
        Mediator smd = Mediator.getMedium();
        System.out.println("具体同事类1：发出请求...");
        smd.relay(this); //请中介者转发
    }
}

/**
 * 具体同事类2
 */
class ConcreteColleague2 implements Colleague {
    ConcreteColleague2() {
        Mediator smd = Mediator.getMedium();
        smd.register(this);
    }

    public void receive() {
        System.out.println("具体同事类2：收到请求。");
    }

    public void send() {
        Mediator smd = Mediator.getMedium();
        System.out.println("具体同事类2：发出请求...");
        smd.relay(this); //请中介者转发
    }
}
