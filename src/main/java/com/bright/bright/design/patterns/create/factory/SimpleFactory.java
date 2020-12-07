package com.bright.bright.design.patterns.create.factory;

/**
 * 简单工厂模式
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product productA = makeProduct(Const.PRODUCT_A);
        Product productB = makeProduct(Const.PRODUCT_B);
        assert productA != null;
        productA.show();
        assert productB != null;
        productB.show();
    }

    public static Product makeProduct(int kind) {
        switch (kind) {
            case Const.PRODUCT_A:
                return new ConcreteProduct1();
            case Const.PRODUCT_B:
                return new ConcreteProduct2();
        }
        return null;
    }
}

/**
 * 抽象产品
 */
interface Product {
    void show();
}

/**
 * 具体产品：ProductA
 */
class ConcreteProduct1 implements Product {
    public void show() {
        System.out.println("具体产品1显示...");
    }
}

/**
 * 具体产品：ProductB
 */
class ConcreteProduct2 implements Product {
    public void show() {
        System.out.println("具体产品2显示...");
    }
}

final class Const {
    static final int PRODUCT_A = 0;
    static final int PRODUCT_B = 1;
}
