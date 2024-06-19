package ttlock.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


public class LockObj implements Serializable{
    /**
     * date : 1534470870000
     * specialValue : 21729
     * lockAlias : AS1003_84e13c
     * modelNum : SN139-M101-T1_PV53
     * lockMac : D3:58:7F:58:DE:B9
     * lockId : 24409
     * electricQuantity : 75
     * lockData : Djksy80snK7hKn9QdPutr6QI9YsRHDy+id/vo3o330AeQjMd4vgjWh/9ydA6b5H4e1+eVOyMgFlUjI2f8sfw8jkm/3RrPYeZ8wuSGN9yDiwYibmPx7QJGF/Pw7vQTyT7zSKgisAjOxWIk+AnDbNajZ3bhBH+AzP+APWl4FywDykIFLigO/8rCO7//o4Ziz932ynSOWiX15mirIjOz3tghwZMi6nl6m/cLxQWv1flKVt8MJdLr4G3ezdizHk8wEvOuNSK+F75ToJ+esUTK6tL50++8qNb6FBsB4Y3cmuLI1sTTZ6swtnmUALc7V2oijznmX89qG7I4y7SFDUEhVlkhy1zkHrq53ZMUgqutRCDdad7GAkTqtSL9eNYl3lfdSe5mAzz2cZ4l6CiE+yJo5GGcFkv9n31/sf//eNecJ7G0ulmH9+H5vaJ7SvMYuLUkw/FigQ9++0p5SiibEx1ZMTPC32mr8UoN0ZiAvhWQ3qeGj4MyoxEm1lw0I5o7VU/xuUA1p6+EDaGCyaYbU3GyemvH/sZsJj331zvImykLVCX9GB5Js7pzHSkAD/QcBgE49GsYlelBnC+4ZZj68eArtaIm0eT91F2FqeD/r+odA8VHiXTWH9Y3rk=
     * keyboardPwdVersion : 4
     * hardwareRevision : 1.1
     * lockVersion : {
     *      "showAdminKbpwdFlag":true,
     *      "groupId":1,
     *      "protocolVersion":3,
     *      "protocolType":5,
     *      "orgId":1,
     *      "logoUrl":"",
     *      "scene":2
     *      }
     * userType : 110301
     * lockName : M101T_b9de58
     * firmwareRevision : 4.1.18.0131
     */

//    featureValue=C2F44754CF5F7,
//    modelNum='SN9161-TCL-T12-INT_PV53',
//    hardwareRevision='2.1',
//    firmwareRevision='6.4.14.220701',
//    nbNodeId='null',
//    nbOperator='null',
//    nbCardNumber='null',
//    nbRssi=0,
//    factoryDate='2bb61d13',
//    lockClock='2406111222'
    private long date = System.currentTimeMillis();
    private int specialValue = 553702628;
    private String lockAlias = "Candado Grande";
    private String modelNum = "1178636";
    private String lockMac = "8D:56:F2:6B:5F:7A";
    private int lockId = 13661974;
    private int electricQuantity = 55;
    private String lockData = "0IWe4IhSee2csF0J+oDhypq0GCGVyFkY0rZ+yx4K5stVsdHcQgEBcLmVDWuh2S2V6kiJNW4On4AJryQIt0P6rD4VhGJQRhdupRCa78FzcQkWRigVCKOg6mU7EPMjugxJiBbOYBBmK/vVhfcqj/KKTP8wpBuato8wTNE982XesaRN5Bf5SuAlq3EuSzdzPeRulY3TGYuOJR1e6WbQyIIoFBUtiWzfUJWG2NueQzlyYvFtHK96Jrw8lHtNFUHE8hk9n4YBWaadZHXMZA2a4ai0pZXkwp+fecyhTNmvnIp4/VApkpVEinppM8+52zx2ghd0qu4WyEsaT2xvceDAt7SNtSQEIU8vJKBV0bbmo8oLDu+2/YXg6bW3qiuDqimWUBQ/nFDC+xvn9IrOHMMv974jPF7nq/O9e18xgVjVfMQoRUwU+XSOwy6oKzexK4sQMfx9l5qppSUihqCqX22Ge/vPw0drQHmCmjB0fRBhwUxkbKOaxFXbXrJgVAz9urINfZdv5blSPsO7eJtokoExaeN0PXS2KLsbx17dn2mqyAdYRgbue+GWzgaKLwPHveNOG6dYSplYWJ8i5AcWSIBe44rNO0EGBOp3FvEqwyRwtiYIjPZHOpmsn22bAVu+JqBcrOD+oMXacieA4aQ2eLNVliVTQOY0LtL9Lzq9KpFks8H5LwLp3PqsnwpoepfPZ27Quhp5nX98FazVpyeHq5uOp5LqBpzJfaarVceR+n8fsN/jHdu/P1apoInn8beft3QJXAQTcnYtNl2GgJ9gxref8ao2s41W8mtfeg==";
    private int keyboardPwdVersion = 4;
    private String hardwareRevision;
    private LockVersionObj lockVersion = getLockVersion();
    private String userType;
    private String lockName = "P3_7a5f6b";
    private String firmwareRevision ;
    private String featureValue = "7442100D4E4";

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getSpecialValue() {
        return specialValue;
    }

    public void setSpecialValue(int specialValue) {
        this.specialValue = specialValue;
    }

    public String getLockAlias() {
        return lockAlias;
    }

    public void setLockAlias(String lockAlias) {
        this.lockAlias = lockAlias;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getLockMac() {
        return lockMac;
    }

    public void setLockMac(String lockMac) {
        this.lockMac = lockMac;
    }

    public int getLockId() {
        return lockId;
    }

    public void setLockId(int lockId) {
        this.lockId = lockId;
    }

    public int getElectricQuantity() {
        return electricQuantity;
    }

    public void setElectricQuantity(int electricQuantity) {
        this.electricQuantity = electricQuantity;
    }

    public String getLockData() {
        return lockData;
    }

    public void setLockData(String lockData) {
        this.lockData = lockData;
    }

    public int getKeyboardPwdVersion() {
        return keyboardPwdVersion;
    }

    public void setKeyboardPwdVersion(int keyboardPwdVersion) {
        this.keyboardPwdVersion = keyboardPwdVersion;
    }

    public String getHardwareRevision() {
        return hardwareRevision;
    }

    public void setHardwareRevision(String hardwareRevision) {
        this.hardwareRevision = hardwareRevision;
    }

    public LockVersionObj getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(LockVersionObj lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public String getFirmwareRevision() {
        return firmwareRevision;
    }

    public void setFirmwareRevision(String firmwareRevision) {
        this.firmwareRevision = firmwareRevision;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
}
