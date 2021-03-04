package AliTest;

public class ConsultResult {

    // Type类型
    private String requestType;

    // 咨询结果是否可用
    private boolean isEnable;

    // 错误码
    private String errorCode;

    public ConsultResult(String requestType,boolean isEnable, String errorCode) {
        this.requestType = requestType;
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    public boolean getIsEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
