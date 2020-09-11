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
        subject.setChanged();
        subject.notifyObservers("今天天气很好！");
    }
}
