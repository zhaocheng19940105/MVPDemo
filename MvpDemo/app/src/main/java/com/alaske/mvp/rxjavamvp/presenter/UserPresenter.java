package com.alaske.mvp.rxjavamvp.presenter;

import com.alaske.mvp.rxjavamvp.mo.IUserMo;
import com.alaske.mvp.rxjavamvp.mo.UserMo;
import com.alaske.mvp.rxjavamvp.mo.UserMoImpl;
import com.alaske.mvp.rxjavamvp.ui.IUserView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: zhaocheng
 * Date: 2016-04-14
 * Time: 17:35
 * Name:UserPresenter
 * Introduction:
 */
public class UserPresenter implements IUserPresenter {

    private IUserView mUserView;
    private IUserMo mUserModel;

    public UserPresenter(IUserView userView) {
        mUserView = userView;
        mUserModel = new UserMoImpl();
    }

    @Override
    public void getUser() {
        mUserView.showProgressDialog();
        mUserModel.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserMo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mUserView.hideProgressDialog();
                        mUserView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(UserMo userMo) {
                        mUserView.hideProgressDialog();
                        mUserView.updateView(userMo);
                    }
                });
    }
}
