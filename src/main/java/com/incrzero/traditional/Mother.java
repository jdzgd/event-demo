package com.incrzero.traditional;

import java.util.Observable;
import java.util.Observer;

/**
 * Mother对象
 *
 * @author jiangdongzhao
 */
public class Mother implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println("Mother获取新闻");
        System.out.println(arg);
    }
}
