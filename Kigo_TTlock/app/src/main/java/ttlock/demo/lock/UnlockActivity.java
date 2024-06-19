package ttlock.demo.lock;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.ttlock.bl.sdk.api.TTLockClient;
import com.ttlock.bl.sdk.callback.ControlLockCallback;
import com.ttlock.bl.sdk.constant.ControlAction;
import com.ttlock.bl.sdk.entity.ControlLockResult;
import com.ttlock.bl.sdk.entity.LockError;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call; //Es utilizado para hacer el request
import ttlock.demo.BaseActivity; //La función más iportante es ensureBluetoothIsEnabled
import ttlock.demo.MyApplication;  //Obtiene la info de usuario y la info del candado generada con la clase LockObj, esta clase genera el objeto del candado seleccionado.
import ttlock.demo.R;
import ttlock.demo.databinding.ActivityUnlockBinding; //Este no es necesario, es una UI
import ttlock.demo.lock.model.KeyListObj; //No es necesario, genera una lista de todos los candados disponibles
import ttlock.demo.lock.model.KeyObj; //Esta clase encapsula propiedades relacionadas con la clave y el candado al que pertenece, junto con métodos para acceder a estas propiedades
import ttlock.demo.retrofit.ApiService; //Requests al API de ttlock
import ttlock.demo.retrofit.RetrofitAPIManager; //Clase que funciona como helper para generar los requests de TTlock


//IMPORTANTE
//Esta clase se encarga de la interfaz y la lógica para desbloquear y bloquear cerraduras utilizando la API de TTLock.

public class UnlockActivity extends BaseActivity {
    ActivityUnlockBinding binding;
    //demo only add one lock,so we just get key for one lock,and the key is admin key.
    KeyObj mMyTestLockEKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getUserKeyList();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_unlock);
        TTLockClient.getDefault().prepareBTService(getApplicationContext());
        initListener();
    }

    private void initListener(){
        binding.btnUnlock.setOnClickListener(v -> doUnlock());
        binding.btnLock.setOnClickListener(v -> doLockLock());
    }

    //user should get a key list and show them with a list.In demo,we just have one admin key.
//    private void getUserKeyList(){
////        ApiService apiService = RetrofitAPIManager.provideClientApi();
//        HashMap<String,String> param = new HashMap<>(6);
//        param.put("clientId","439063e312444f1f85050a52efcecd2e");
//        param.put("accessToken","615b898b5d0f47f108ed1665fd50f30f");
//        param.put("pageNo","1");
//        param.put("pageSize","1000");
//        param.put("date",String.valueOf(System.currentTimeMillis()));
//
////        Call<ResponseBody> call = apiService.getUserKeyList(param);
//
//        RetrofitAPIManager.enqueue(call, new TypeToken<KeyListObj>(){}, result -> {
//            if(!result.success){
//                makeToast("--get my key list fail-" + result.getMsg());
//                return;
//            }
//            Log.d("OMG","===result===" + result.getResult().toString() + "===" + result);
//            KeyListObj keyListObj = result.getResult();
//            ArrayList<KeyObj> myKeyList = keyListObj.getList();
//            if(!myKeyList.isEmpty()){
//                for(KeyObj keyObj : myKeyList){
//                    if(keyObj.getLockId() == mCurrentLock.getLockId()){
//                        mMyTestLockEKey = keyObj;
//                    }
//                }
//            }
//        }, requestError -> {
//            makeToast("--get key list fail-" + requestError.getMessage());
//        });
//    }

    /**
     * use eKey for controlLock interface
     */

    /**Intenta desbloquear la cerradura.
    Verifica que el Bluetooth esté habilitado.
    Llama a la API de TTLock para realizar la acción de desbloqueo.
    Maneja la respuesta de éxito o error mostrando mensajes Toast.
     */
    private void doUnlock(){
//        if(mMyTestLockEKey == null){
//            makeToast(" you should get your key list first ");
//            return;
//        }
        ensureBluetoothIsEnabled();
        showConnectLockToast();
        TTLockClient.getDefault().controlLock(ControlAction.UNLOCK, mCurrentLock.getLockData(), mCurrentLock.getLockMac(),new ControlLockCallback() {
            @Override
            public void onControlLockSuccess(ControlLockResult controlLockResult) {
                Toast.makeText(UnlockActivity.this,"Unlocked successfully!",Toast.LENGTH_LONG).show();
                Log.d("","===result===" + controlLockResult.getClass());
            }

            @Override
            public void onFail(LockError error) {
                Toast.makeText(UnlockActivity.this,"unLock fail!--" + error.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * use eKey for controlLock interface
     */
    private void doLockLock(){
//        if(mMyTestLockEKey == null){
//            makeToast(" you should get your key list first ");
//            return;
//        }
        ensureBluetoothIsEnabled();
        showConnectLockToast();
        TTLockClient.getDefault().controlLock(ControlAction.LOCK, mCurrentLock.getLockData(), mCurrentLock.getLockMac(),new ControlLockCallback() {
            @Override
            public void onControlLockSuccess(ControlLockResult controlLockResult) {
                Toast.makeText(UnlockActivity.this,"lock is locked!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFail(LockError error) {
                Toast.makeText(UnlockActivity.this,"lock lock fail!--" + error.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * stopBTService should be called when Activity is finishing to release Bluetooth resource.
     */
    @Override
    public void onDestroy(){
        super.onDestroy();
        TTLockClient.getDefault().stopBTService();
    }


}

