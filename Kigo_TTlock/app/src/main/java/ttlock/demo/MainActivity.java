package ttlock.demo;

import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.os.Bundle;

import ttlock.demo.databinding.ActivityMainBinding;
import ttlock.demo.fingerprint.FingerprintActivity;
import ttlock.demo.iccard.ICCardActivity;
import ttlock.demo.lock.UnlockActivity;
import ttlock.demo.passcode.PasscodeActivity;
import ttlock.demo.utils.AppUtil;


public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initListener();
        if (AppUtil.isAndroid12OrOver()) {
            AppUtil.checkPermission(this, Manifest.permission.BLUETOOTH_CONNECT);
        }
    }

    private void initListener(){
        binding.btnLock.setOnClickListener(v -> startTargetActivity(UnlockActivity.class));
        binding.btnPasscode.setOnClickListener(v -> startTargetActivity(PasscodeActivity.class));
        binding.btnFingerprint.setOnClickListener(v -> startTargetActivity(FingerprintActivity.class));
        binding.btnIc.setOnClickListener(v -> startTargetActivity(ICCardActivity.class));
    }
}
