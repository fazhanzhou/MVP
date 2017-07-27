package zhoufazhan.com.mvp.Login;

import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zhoufazhan.com.mvp.MVPListener;
import zhoufazhan.com.mvp.User;
import zhoufazhan.com.mvp.util.ApiService;
import zhoufazhan.com.mvp.util.ResponseData;
import zhoufazhan.com.mvp.util.TestData;

/**
 * Created by zhoufazhan on 2017/7/26.
 * 获取数据使用
 */

public class LoginModel implements LoginContract.LoginModel {
    Retrofit retrofit;

    @Override
    public void getUser(String name, String password, final MVPListener mvpListener) {
        //做一些网络请求
        initHttp();
        retrofit.create(ApiService.class).reLogin(name, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TestData<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TestData<User> value) {
                        //回调给presenter
                        mvpListener.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mvpListener.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void initHttp() {
        retrofit = new Retrofit.Builder().baseUrl("http://wnd.agri114.cn/wndms/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd").create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
