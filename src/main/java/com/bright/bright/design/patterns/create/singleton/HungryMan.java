package com.bright.bright.design.patterns.create.singleton;

import org.jetbrains.annotations.Contract;

/**
 * 饿汉式
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public class HungryMan {
    private static final HungryMan instance = new HungryMan();

    /**
     * 私有构造函数
     */
    @Contract(pure = true)
    private HungryMan() {
        // do nothing
    }

    public static HungryMan getInstance() {
        return instance;
    }
}
