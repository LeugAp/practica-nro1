
package model;

/**
 *
 * @author miguel
 */
public class Sale {

    private int id;
    private MonthEnum month;
    private double value;

    public Sale() {
    }

    public Sale(int id, MonthEnum month, double value) {
        this.id = id;
        this.month = month;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MonthEnum getMonth() {
        return month;
    }

    public void setMonth(MonthEnum month) {
        this.month = month;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", month=" + month + ", value=" + value + '}';
    }
}
