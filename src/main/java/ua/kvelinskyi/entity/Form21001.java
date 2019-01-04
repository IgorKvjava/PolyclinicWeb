package ua.kvelinskyi.entity;

/**
 * @author Igor Kvelinskyi (igorkvjava@gmail.com)
 *
 */
public class Form21001 {

    private String position;
    private int rowNumber;
    private Form39 form39;

    public Form21001() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Form39 getForm39() {
        return form39;
    }

    public void setForm39(Form39 form39) {
        this.form39 = form39;
    }
}
