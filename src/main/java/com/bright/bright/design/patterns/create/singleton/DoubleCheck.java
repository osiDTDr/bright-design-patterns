package com.bright.bright.design.patterns.create.singleton;

import org.jetbrains.annotations.Contract;

/**
 * 双重检测
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public class DoubleCheck {
    private static volatile DoubleCheck instance;

    /**
     * 私有构造函数
     */
    @Contract(pure = true)
    private DoubleCheck() {
        // do nothing
    }

    public static DoubleCheck getInstance() {
        if (null == instance) {
            synchronized (DoubleCheck.class) {
                if (null == instance) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
