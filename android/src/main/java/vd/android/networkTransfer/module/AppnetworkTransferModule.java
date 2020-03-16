package vd.android.networkTransfer.module;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

import app.vd.framework.extend.module.vdParse;
import vd.android.networkTransfer.module.transfer.ModuleResultListener;
import vd.android.networkTransfer.module.transfer.TransferModule;

public class AppnetworkTransferModule extends WXModule {

    @JSMethod
    public void upload(String str, final JSCallback jsCallback){
        TransferModule.getInstance().upload(str, new ModuleResultListener() {
            @Override
            public void onResult(HashMap<String, Object> o) {
                if (vdParse.parseInt(o.get("status")) == -1 || vdParse.parseInt(o.get("status")) == 200) {
                    jsCallback.invoke(o);
                }else{
                    jsCallback.invokeAndKeepAlive(o);
                }
            }
        });
    }

    @JSMethod
    public void download(String str, final JSCallback jsCallback){
        TransferModule.getInstance().download(str, new ModuleResultListener() {
            @Override
            public void onResult(HashMap<String, Object> o) {
                if (vdParse.parseInt(o.get("status")) == -1 || vdParse.parseInt(o.get("status")) == 200) {
                    jsCallback.invoke(o);
                }else{
                    jsCallback.invokeAndKeepAlive(o);
                }
            }
        });
    }
}
