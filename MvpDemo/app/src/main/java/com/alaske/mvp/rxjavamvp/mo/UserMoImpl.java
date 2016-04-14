package com.alaske.mvp.rxjavamvp.mo;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Author: zhaocheng
 * Date: 2016-04-14
 * Time: 17:28
 * Name:UserMoImpl
 * Introduction:
 */
public class UserMoImpl implements IUserMo {

    @Override
    public Observable<UserMo> getUser() {
        return Observable.create(new Observable.OnSubscribe<UserMo>() {
            @Override
            public void call(Subscriber<? super UserMo> subscriber) {
                try {
                    subscriber.onStart();
                    Thread.sleep(2000);
                    UserMo userMo = new UserMo();
                    userMo.name="Alaske";
                    subscriber.onNext(userMo);
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
