package com.alaske.mvp.rxjavamvp.ui;

import com.alaske.mvp.rxjavamvp.mo.UserMo;

/**
 * Author: zhaocheng
 * Date: 2016-04-14
 * Time: 17:36
 * Name:IUserView
 * Introduction:
 */
public interface IUserView {

    void updateView(UserMo user);

    void showProgressDialog();

    void hideProgressDialog();

    void showError(String msg);
}
