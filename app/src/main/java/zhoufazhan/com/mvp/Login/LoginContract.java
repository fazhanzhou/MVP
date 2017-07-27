package zhoufazhan.com.mvp.Login;

import io.reactivex.Observable;
import zhoufazhan.com.mvp.MVPListener;
import zhoufazhan.com.mvp.User;
import zhoufazhan.com.mvp.base.BaseModel;
import zhoufazhan.com.mvp.base.BasePresenter;
import zhoufazhan.com.mvp.base.BaseView;
import zhoufazhan.com.mvp.util.ResponseData;
import zhoufazhan.com.mvp.util.TestData;

/**
 * Created by zhoufazhan on 2017/7/26.
 * 将M,V,P接口合并到一起
 */

public interface LoginContract {
    interface LoginView extends BaseView{
        //在LoginPresenter中调用这个方法显示数据
        void setUser(TestData<User> user);
    }
    interface LoginModel extends BaseModel{
        //获取数据库的数据
        void getUser(String name , String password, MVPListener listener);
    }
    abstract class LoginPresenter extends BasePresenter<LoginModel,LoginView>{
        //调用LoginModel的getUser方法获取数据，传递给LoginView显示，起到中间人的作用
       abstract void getUser(String name,String password);
    }
}
