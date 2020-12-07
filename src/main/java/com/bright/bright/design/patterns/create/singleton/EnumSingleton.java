package com.bright.bright.design.patterns.create.singleton;

/**
 * 枚举。
 * 这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 *
 * @author zhengyuan
 * @since 2020/12/07
 */
public enum EnumSingleton {
    INSTANCE;

    public void whateverMethod() {
    }
}
