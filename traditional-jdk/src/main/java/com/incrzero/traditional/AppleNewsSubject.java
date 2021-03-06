package com.incrzero.traditional;

import java.util.Observable;

/**
 * 新闻主题
 *
 * @author jiangdongzhao
 */
public class AppleNewsSubject extends Observable {

    public AppleNewsSubject() {
    }

    public static void main(String[] args) {
        AppleNewsSubject subject = new AppleNewsSubject();
        subject.addObserver(new Father());
        subject.addObserver(new Mother());
        subject.addObserver((x, y) -> System.out.println("妹妹收到信息：" + y));
        subject.setChanged();
        subject.notifyObservers("今天天气很好！");
    }
}
