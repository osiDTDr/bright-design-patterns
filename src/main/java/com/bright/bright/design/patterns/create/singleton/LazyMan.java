package com.bright.bright.design.patterns.create.singleton;

import org.jetbrains.annotations.Contract;

/**
 * 懒汉式
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public class LazyMan {
    private static LazyMan instance;

    /**
     * 私有构造函数
     */
    @Contract(pure = true)
    private LazyMan() {
        // do nothing
    }

    public static synchronized LazyMan getInstance() {
        if (null == instance) {
            instance = new LazyMan();
        }
        return instance;
    }
}
