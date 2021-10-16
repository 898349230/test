package com.ab.mypatern.single;


/**
 * @classname: EnumSingleton
 * @description: 枚举方式实现单例
 * @author: sunxinbo
 * @time: 2020/2/20、10:54
 */
public enum EnumSingleton {
    INSTANCE;
    private SingleInstance single = new SingleInstance();

    public SingleInstance getInstance() {
        return single;
    }

}
