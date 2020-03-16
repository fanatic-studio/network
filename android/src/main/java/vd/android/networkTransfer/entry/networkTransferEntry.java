package vd.android.networkTransfer.entry;

import android.content.Context;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import app.vd.framework.extend.annotation.ModuleEntry;
import vd.android.networkTransfer.module.AppnetworkTransferModule;

@ModuleEntry
public class networkTransferEntry {

    /**
     * APP启动会运行此函数方法
     * @param content Application
     */
    public void init(Context content) {

        //1、注册weex模块
        try {
            WXSDKEngine.registerModule("vdNetwork", AppnetworkTransferModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }

}
