package by.self.parser.united.airlines.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MixedExtraDataVO extends ExtraDataVO implements Serializable {

    @JsonIgnoreProperties
    public static final long serialVersionUID = 42L;

    @JsonProperty("field_sub_lvl")
    private String fieldSubLevel;

    public MixedExtraDataVO() {
    }

    public String getFieldSubLevel() {
        return fieldSubLevel;
    }

    public void setFieldSubLevel(String fieldSubLevel) {
        this.fieldSubLevel = fieldSubLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MixedExtraDataVO that = (MixedExtraDataVO) o;

        if (fieldSubLevel != null ? !fieldSubLevel.equals(that.fieldSubLevel) : that.fieldSubLevel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fieldSubLevel != null ? fieldSubLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MixedExtraDataVO{" +
                "fieldSubLevel='" + fieldSubLevel + '\'' +
                '}';
    }
}
