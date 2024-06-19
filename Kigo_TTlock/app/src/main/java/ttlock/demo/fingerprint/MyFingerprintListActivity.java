package ttlock.demo.fingerprint;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.ttlock.bl.sdk.api.TTLockClient;
import com.ttlock.bl.sdk.callback.ClearAllFingerprintCallback;
import com.ttlock.bl.sdk.callback.GetAllValidFingerprintCallback;
import com.ttlock.bl.sdk.entity.LockError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import ttlock.demo.BaseActivity;
import ttlock.demo.MyApplication;

import ttlock.demo.R;

import ttlock.demo.databinding.ActivityMyFingerprintListBinding;
import ttlock.demo.fingerprint.model.FingerpintListObj;
import ttlock.demo.fingerprint.model.FingerprintObj;
import ttlock.demo.retrofit.ApiService;
import ttlock.demo.retrofit.RetrofitAPIManager;

public class MyFingerprintListActivity extends BaseActivity implements FinggerprintAdapter.onListItemClick{

    FinggerprintAdapter mListAdapter;
    ActivityMyFingerprintListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_my_fingerprint_list);
        initView();
    }

    @Override
    public void onResume(){
        super.onResume();
        getFingerprintList();
    }

    private void initView(){
        mListAdapter = new FinggerprintAdapter(this);
        binding.rvFingerprintList.setAdapter(mListAdapter);
        binding.rvFingerprintList.setLayoutManager(new LinearLayoutManager(this));
        binding.btnClearFingerprints.setOnClickListener(v -> clearAllFingerprints());
        mListAdapter.setOnListItemClick(this);
    }

    private void getFingerprintList() {
        ApiService apiService = RetrofitAPIManager.provideClientApi();
        HashMap<String, String> param = new HashMap<>(6);
        param.put("clientId", ApiService.CLIENT_ID);
        param.put("accessToken", MyApplication.getmInstance().getAccountInfo().getAccess_token());
        param.put("lockId", String.valueOf(mCurrentLock.getLockId()));
        param.put("pageNo", "1");
        param.put("pageSize", "1000");
        param.put("date", String.valueOf(System.currentTimeMillis()));

        Call<ResponseBody> call = apiService.getUserFingerprintList(param);
        RetrofitAPIManager.enqueue(call, new TypeToken<FingerpintListObj>() {
        }, result -> {
            if (!result.success) {
                makeToast("--get my fingerprint list fail-" + result.getMsg());
                return;
            }
            Log.d("Fingerprint", "===result===" + result.getResult() + "===" + result.getMsgJson());
            FingerpintListObj fingerpintListObj = result.getResult();
            ArrayList<FingerprintObj> myFingerprintList = fingerpintListObj.getList();
            if (myFingerprintList.isEmpty()) {
                makeToast("- please add fingerprint first --");
            }
            mListAdapter.updateData(myFingerprintList);

        }, requestError -> {
            makeToast("--get my fingerprint list fail-" + requestError.getMessage());
        });


    }


//        private void getAllFingerprints(){
//            TTLockClient.getDefault().getAllValidFingerprints(mCurrentLock.getLockData(), mCurrentLock.getLockMac(), new GetAllValidFingerprintCallback() {
//
//                @Override
//                public void onGetAllFingerprintsSuccess(String fingerprintsStr) {
//                    makeToast("==Getting All Fingerprints Success==" + fingerprintsStr);
//
//                }
//
//
//                @Override
//                public void onFail(LockError lockError) {
//
//                }
//            });
//        }


    @Override
    public void onItemClick(FingerprintObj fingerprintObj) {
        if(fingerprintObj != null){
            FingerprintModifyActivity.launch(MyFingerprintListActivity.this,fingerprintObj);
        }
    }
    private void clearAllFingerprints(){
        showConnectLockToast();
        TTLockClient.getDefault().clearAllFingerprints( mCurrentLock.getLockData(), mCurrentLock.getLockMac(), new ClearAllFingerprintCallback() {

            @Override
            public void onClearAllFingerprintSuccess() {
                makeToast("--Authorized Fingerprints Cleared Successfully--");
                //this must be done
//                uploadClear2Server();
            }

            @Override
            public void onFail(LockError error) {
                makeErrorToast(error);
            }
        });
    }
}
