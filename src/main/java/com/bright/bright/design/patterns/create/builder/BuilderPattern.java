package com.bright.bright.design.patterns.create.builder;

/**
 * 建造者模式
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public class BuilderPattern {
    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Product build = concreteBuilder
                .bulidA("牛肉煲")
                .bulidC("全家桶")
                .bulidD("冰淇淋")
                .build();
        System.out.println(build.toString());
    }
}

/**
 * 产品角色：包含多个组成部件的复杂对象。
 */
class Product {
    private String buildA = "汉堡";
    private String buildB = "饮料";
    private String buildC = "薯条";
    private String buildD = "甜品";

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @Override
    public String toString() {
        return buildA + "\n" + buildB + "\n" + buildC + "\n" + buildD + "\n" + "组成套餐";
    }
}

/**
 * 抽象建造者：包含创建产品各个子部件的抽象方法。
 */
abstract class Builder {
    //汉堡
    abstract Builder bulidA(String mes);

    //饮料
    abstract Builder bulidB(String mes);

    //薯条
    abstract Builder bulidC(String mes);

    //甜品
    abstract Builder bulidD(String mes);

    //获取套餐
    abstract Product build();
}

/**
 * 具体建造者：实现了抽象建造者接口。
 */
class ConcreteBuilder extends Builder {
    private final Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    Product build() {
        return product;
    }

    @Override
    Builder bulidA(String mes) {
        product.setBuildA(mes);
        return this;
    }

    @Override
    Builder bulidB(String mes) {
        product.setBuildB(mes);
        return this;
    }

    @Override
    Builder bulidC(String mes) {
        product.setBuildC(mes);
        return this;
    }

    @Override
    Builder bulidD(String mes) {
        product.setBuildD(mes);
        return this;
    }
}


