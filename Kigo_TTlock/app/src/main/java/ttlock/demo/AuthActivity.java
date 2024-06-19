package ttlock.demo;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ttlock.bl.sdk.util.DigitUtil;
import com.ttlock.bl.sdk.util.GsonUtil;

import retrofit2.Call;
import retrofit2.Callback;
import ttlock.demo.databinding.ActivityAuthBinding;
import ttlock.demo.lock.UserLockActivity;
import ttlock.demo.model.AccountInfo;
import ttlock.demo.retrofit.ApiService;
import ttlock.demo.retrofit.RetrofitAPIManager;

public class AuthActivity extends BaseActivity {

    ActivityAuthBinding binding;
    public AccountInfo accountInfo;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        ApiService apiService = RetrofitAPIManager.provideClientApi();
        String account = "diego.altamirano@cargomovil.com";
        password = "Valsequillo54";
        password = DigitUtil.getMD5(password);
        Call<String> call = apiService.auth(ApiService.CLIENT_ID, ApiService.CLIENT_SECRET, account, password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                String json = response.body();
                accountInfo = GsonUtil.toObject(json, AccountInfo.class);
                if (accountInfo != null) {
                    if (accountInfo.errcode == 0) {
                        accountInfo.setMd5Pwd(password);
                        MyApplication.getmInstance().setAccountInfo(accountInfo);
                        makeToast(accountInfo.toString());
                        startTargetActivity(UserLockActivity.class);
                        Log.d("AuthActivity", "Autenticación exitosa: " + accountInfo.toString());
                    } else {
                        makeToast(accountInfo.errmsg);
                    }
                } else {
                    makeToast(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                makeToast(t.getMessage());
            }
        });
    }

//    private void initListener() {
//        binding.btnAuth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                auth();
//            }
//        });
//    }
//
//    private void auth() {
//        ApiService apiService = RetrofitAPIManager.provideClientApi();
//        String account = "diego.altamirano@cargomovil.com";
//        password = "Valsequillo54";
//        password = DigitUtil.getMD5(password);
//        Call<String> call = apiService.auth(ApiService.CLIENT_ID, ApiService.CLIENT_SECRET, account, password);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
//                String json = response.body();
//                accountInfo = GsonUtil.toObject(json, AccountInfo.class);
//                if (accountInfo != null) {
//                    if (accountInfo.errcode == 0) {
//                        accountInfo.setMd5Pwd(password);
//                        MyApplication.getmInstance().setAccountInfo(accountInfo);
//                        makeToast(accountInfo.toString());
//                        startTargetActivity(IndexActivity.class);
//                        Log.d("AuthActivity", "Autenticación exitosa: " + accountInfo.toString());
//                    } else {
//                        makeToast(accountInfo.errmsg);
//                    }
//                } else {
//                    makeToast(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                makeToast(t.getMessage());
//            }
//        });
//    }
}


/*
AccountInfo{
    access_token='615b898b5d0f47f108ed1665fd50f30f',
    refresh_token='f7c111ac2bb702960f5c27afc6a1c561',
    uid=16779152,
    openid=1887397854,
    scope='user,key,room',
    token_type='Bearer',
    expires_in=7484978
}
 */