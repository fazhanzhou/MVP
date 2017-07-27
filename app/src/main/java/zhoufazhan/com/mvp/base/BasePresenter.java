package zhoufazhan.com.mvp.base;

import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by zhoufazhan on 2017/7/26.
 * presenter同时持有Model和View
 */

public abstract class BasePresenter<M, V> {
    public M model;
    V view;
    public WeakReference<V> mViewRef;

    public void attachModelView(M pModel, V pView) {
        this.model = pModel;
        mViewRef = new WeakReference<>(pView);
    }

    public boolean isAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public void onDettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
