package zhoufazhan.com.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zhoufazhan.com.mvp.util.CreatUtil;

/**
 * Created by zhoufazhan on 2017/7/27.
 */

public abstract class BaseActivity<T extends BasePresenter, M extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = CreatUtil.getT(this, 0);
        mModel = CreatUtil.getT(this,1);
        mPresenter.attachModelView(mModel,this);
        initView();
    }

    public abstract void initView();

    public abstract int getLayoutId();
}
