package by.self.parser.united.airlines.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ClassVO implements Serializable {

    @JsonIgnoreProperties
    public static final long serialVersionUID = 42L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("mileage")
    private int mileage;

    @JsonProperty("tax")
    private BigDecimal tax;

    @JsonProperty("id")
    private int id;

    public ClassVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassVO classVO = (ClassVO) o;

        if (id != classVO.id) return false;
        if (mileage != classVO.mileage) return false;
        if (name != null ? !name.equals(classVO.name) : classVO.name != null) return false;
        if (status != null ? !status.equals(classVO.status) : classVO.status != null) return false;
        if (tax != null ? !tax.equals(classVO.tax) : classVO.tax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + mileage;
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "ClassVO{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", mileage=" + mileage +
                ", tax=" + tax +
                ", id=" + id +
                '}';
    }
}
