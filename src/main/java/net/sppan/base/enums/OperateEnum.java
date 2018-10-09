package net.sppan.base.enums;

/**
 * @author: yangzhigang
 * @Date: 2018/10/9 14:34
 * @Description:
 */
public enum OperateEnum {
    SELECT(1, "select"), DELETE(2, "delete");

    private int op;
    private String val;

    private OperateEnum(int op, String val) {
        this.op = op;
        this.val = val;
    }

    public int getOp() {
        return op;
    }

    public String getVal() {
        return val;
    }
}
