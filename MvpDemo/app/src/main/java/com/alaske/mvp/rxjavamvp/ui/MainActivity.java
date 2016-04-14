package com.alaske.mvp.rxjavamvp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alaske.mvp.R;
import com.alaske.mvp.rxjavamvp.mo.UserMo;
import com.alaske.mvp.rxjavamvp.presenter.IUserPresenter;
import com.alaske.mvp.rxjavamvp.presenter.UserPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IUserView,View.OnClickListener {

    @Bind(R.id.btn_get_user)
    Button mBtnGetUser;
    @Bind(R.id.tv_user)
    TextView mTvUser;

    private ProgressDialog mLoadingPB;
    private IUserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        // view init
        mLoadingPB = new ProgressDialog(this);
        mLoadingPB.setMessage("loading.......");
        mBtnGetUser.setOnClickListener(this);
        //data init
        mUserPresenter = new UserPresenter(this);
    }


    @Override
    public void updateView(UserMo user) {
        mTvUser.setText(user.name);
    }

    @Override
    public void showProgressDialog() {
        mLoadingPB.show();
    }

    @Override
    public void hideProgressDialog() {
        mLoadingPB.hide();
    }

    @Override
    public void showError(String msg) {
        /**
         * do error
         */
    }

    @Override
    public void onClick(View v) {
        mUserPresenter.getUser();
    }
}
