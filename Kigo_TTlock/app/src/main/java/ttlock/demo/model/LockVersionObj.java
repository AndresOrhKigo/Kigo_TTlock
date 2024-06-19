package ttlock.demo.model;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by TTLock on 2019/4/23.
 */

public class LockVersionObj implements Serializable {
    /**
     * showAdminKbpwdFlag : true
     * groupId : 1
     * protocolVersion : 3
     * protocolType : 5
     * orgId : 1
     * logoUrl :
     * scene : 2
     */

    private boolean showAdminKbpwdFlag = true;
    private int groupId = 1;
    private int protocolVersion = 3;
    private int protocolType = 5;
    private int orgId = 1;
    private String logoUrl = "";
    private int scene = 8;

    public boolean isShowAdminKbpwdFlag() {
        return showAdminKbpwdFlag;
    }

    public void setShowAdminKbpwdFlag(boolean showAdminKbpwdFlag) {
        this.showAdminKbpwdFlag = showAdminKbpwdFlag;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public int getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(int protocolType) {
        this.protocolType = protocolType;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public String lockVersionObjToString(){
        Log.d(
                "LockVersionObj",
                "showAdminKbpwdFlag:"+showAdminKbpwdFlag+" groupId:"+groupId+" protocolVersion:"+protocolVersion+" protocolType:"+protocolType+" orgId:"+orgId+" logoUrl:"+logoUrl+" scene:"+scene
        );
        return "showAdminKbpwdFlag:"+showAdminKbpwdFlag+" groupId:"+groupId+" protocolVersion:"+protocolVersion+" protocolType:"+protocolType+" orgId:"+orgId+" logoUrl:"+logoUrl+" scene:"+scene;
    }
}
