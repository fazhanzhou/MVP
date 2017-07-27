package zhoufazhan.com.mvp.Login;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import zhoufazhan.com.mvp.R;
import zhoufazhan.com.mvp.User;
import zhoufazhan.com.mvp.base.BaseActivity;
import zhoufazhan.com.mvp.util.ResponseData;
import zhoufazhan.com.mvp.util.TestData;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.LoginView {
    AutoCompleteTextView name;
    EditText password;
    Button mButton;

    @Override
    public void showLoading() {
        Toast.makeText(this, "showLoading", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setUser(TestData<User> user) {
        if (user != null) {
            Toast.makeText(this, user.getUser().getTel()+"", Toast.LENGTH_LONG).show();
        }
    }

    //由父类调用
    @Override
    public void initView() {
        name = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        mButton = (Button) findViewById(R.id.email_sign_in_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getUser(name.getText().toString(), password.getText().toString());
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
}

