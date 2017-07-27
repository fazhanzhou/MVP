package zhoufazhan.com.mvp.Login;

import io.reactivex.Observable;
import zhoufazhan.com.mvp.MVPListener;
import zhoufazhan.com.mvp.User;
import zhoufazhan.com.mvp.util.ResponseData;
import zhoufazhan.com.mvp.util.TestData;

/**
 * Created by zhoufazhan on 2017/7/26.
 */

public class LoginPresenter extends LoginContract.LoginPresenter {


    @Override
    void getUser(String name,String password) {
        final LoginContract.LoginView view = getView();
        view.showLoading();
        model.getUser(name, password, new MVPListener() {
            @Override
            public void onSuccess(Object login) {
                if(login instanceof  TestData){
                    view.setUser((TestData<User>) login);
                }

            }

            @Override
            public void onError() {
                 view.showError();
            }
        });
    }
}
