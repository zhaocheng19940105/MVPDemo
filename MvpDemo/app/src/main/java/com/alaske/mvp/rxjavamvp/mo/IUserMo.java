package com.alaske.mvp.rxjavamvp.mo;

import rx.Observable;

/**
 * Author: zhaocheng
 * Date: 2016-04-14
 * Time: 17:32
 * Name:IUserMo
 * Introduction:
 */
public interface IUserMo {
    Observable<UserMo> getUser();
}
