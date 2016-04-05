package by.self.parser.united.airlines.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ExtraDataVO implements Serializable {

    @JsonIgnoreProperties
    public static final long serialVersionUID = 42L;

    @JsonProperty("field_name")
    private String fieldName;

    @JsonProperty("field_type")
    private String fieldType;

    @JsonProperty("field_value")
    private String fieldValue;

    @JsonProperty("field_level")
    private String fieldLevel;

    @JsonProperty("field_id")
    private String fieldId;

    public ExtraDataVO() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldLevel() {
        return fieldLevel;
    }

    public void setFieldLevel(String fieldLevel) {
        this.fieldLevel = fieldLevel;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtraDataVO that = (ExtraDataVO) o;

        if (fieldId != null ? !fieldId.equals(that.fieldId) : that.fieldId != null) return false;
        if (fieldLevel != null ? !fieldLevel.equals(that.fieldLevel) : that.fieldLevel != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (fieldType != null ? !fieldType.equals(that.fieldType) : that.fieldType != null) return false;
        if (fieldValue != null ? !fieldValue.equals(that.fieldValue) : that.fieldValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldName != null ? fieldName.hashCode() : 0;
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        result = 31 * result + (fieldValue != null ? fieldValue.hashCode() : 0);
        result = 31 * result + (fieldLevel != null ? fieldLevel.hashCode() : 0);
        result = 31 * result + (fieldId != null ? fieldId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExtraDataVO{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                ", fieldLevel='" + fieldLevel + '\'' +
                ", fieldId='" + fieldId + '\'' +
                '}';
    }
}
