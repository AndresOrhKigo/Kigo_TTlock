package ttlock.demo.lock;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.reflect.TypeToken;
import com.ttlock.bl.sdk.util.GsonUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import ttlock.demo.BaseActivity;
import ttlock.demo.MyApplication;

import ttlock.demo.R;;

import ttlock.demo.databinding.ActivityUserLockBinding;
import ttlock.demo.lock.adapter.UserLockListAdapter;
import ttlock.demo.model.LockObj;
import ttlock.demo.retrofit.ApiService;
import ttlock.demo.retrofit.RetrofitAPIManager;

public class UserLockActivity extends BaseActivity {

    private int pageNo = 1;
    private int pageSize = 100;
    private UserLockListAdapter mListApapter;
    ActivityUserLockBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_lock);
        initList();
        lockList();
        binding.btnScan.setOnClickListener(v -> startTargetActivity(ScanLockActivity.class));
    }

    private void initList(){
        mListApapter = new UserLockListAdapter(this);
        binding.rvLockList.setAdapter(mListApapter);
        binding.rvLockList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void lockList() {
        ArrayList<LockObj> lockObjs2 = new ArrayList<>();
        lockObjs2.add(new LockObj());
        mListApapter.updateData(lockObjs2);
    }
}
