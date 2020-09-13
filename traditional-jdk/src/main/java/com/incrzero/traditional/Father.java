package com.incrzero.traditional;

import java.util.Observable;
import java.util.Observer;

/**
 * Father对象
 *
 * @author jiangdongzhao
 */
public class Father implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println("Father获取新闻");
        System.out.println(arg);
    }
}
