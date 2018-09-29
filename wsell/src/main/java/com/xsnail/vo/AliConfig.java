package com.xsnail.vo;



public class AliConfig {
    private boolean isCanUse;
    private String message;
    private boolean isNeedUpdate;
    private int version;

    public boolean isCanUse() {
        return isCanUse;
    }

    public void setCanUse(boolean canUse) {
        isCanUse = canUse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isNeedUpdate() {
        return isNeedUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        isNeedUpdate = needUpdate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AliConfig{" +
                "isCanUse=" + isCanUse +
                ", message='" + message + '\'' +
                ", isNeedUpdate=" + isNeedUpdate +
                ", version=" + version +
                '}';
    }
}
