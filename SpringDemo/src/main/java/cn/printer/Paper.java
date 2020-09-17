package cn.printer;

/**
 * 纸张接口。
 * 
 * @author wlg
 */
public interface Paper {
    public static final String newline = "\r\n";

    /**
     * 输出一个字符到纸张。
     */
    public void putInChar(char c);

    /**
     * 得到输出到纸张上的内容。
     */
    public String getContent();
}
