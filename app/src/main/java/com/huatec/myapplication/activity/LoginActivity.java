package com.huatec.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.huatec.myapplication.R;
import com.huatec.myapplication.utils.Constants;
import com.huatec.myapplication.utils.SharedPreferencesUtil;
import com.huatec.myapplication.utils.ValidatorUtils;

import org.w3c.dom.Text;

import javax.xml.validation.Validator;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果校验成功，保存登录状态，跳转到列表界面
                if (ValidareSucc()){
                 // 保存登录状态
                    SharedPreferencesUtil.getInstance(LoginActivity.this).setLogin(true);

                 //跳转列表界面
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 校验用户输入
     * @return
     */
    private boolean ValidareSucc() {
        TextInputEditText tiptetEmail = findViewById(R.id.tiptet_email);
        TextInputEditText tiptetPassword = findViewById(R.id.tiptet_password);
        String email = tiptetEmail.getText().toString();
        String password = tiptetPassword.getText().toString();
        //校验邮箱非空
        if(TextUtils.isEmpty(email)){
            tiptetEmail.setError("邮箱不能为空,请重新输入");
            return false;
        }
        //校验邮箱合规
        if (!ValidatorUtils.isEmail(email)){
            tiptetEmail.setError("请输入正确的邮箱格式");
            return false;
        }
        //校验密码非空
        if (TextUtils.isEmpty(password)){
            tiptetPassword.setError("密码不能为空");
            return false;
        }
        //校验密码合规
        if (!ValidatorUtils.isPassword(password)){
            tiptetPassword.setError("请输入正确的密码形式");
            return false;
        }
        //校验用户名密码正确
        if(!Constants.LOGIN_USER_NAME.equals(email) || !Constants.LOGIN_USER_PASSWORD.equals(password)){
            Toast.makeText(this, "用户名密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
            return false;
        }
        //全部都正确
        return true;
    }
}
