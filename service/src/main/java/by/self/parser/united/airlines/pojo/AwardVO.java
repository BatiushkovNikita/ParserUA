package by.self.parser.united.airlines.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AwardVO implements Serializable {

    @JsonIgnoreProperties
    public static final long serialVersionUID = 42L;

    @JsonProperty("class_list")
    private List<ClassVO> classVOList;

    @JsonProperty("flight_list")
    private List<FlightVO> flightVOList;

    @JsonProperty("total_duration")
    private String totalDuration;

    @JsonProperty("extra_data")
    private List<ExtraDataVO> extraDataVOList;

    @JsonProperty("split")
    private Boolean split;

    public AwardVO() {
    }

    public List<ClassVO> getClassVOList() {
        return classVOList;
    }

    public void setClassVOList(List<ClassVO> classVOList) {
        this.classVOList = classVOList;
    }

    public void addClassVO(ClassVO classVO) {
        if (this.classVOList == null) {
            this.classVOList = new ArrayList<>();
        }
        this.classVOList.add(classVO);
    }

    public List<FlightVO> getFlightVOList() {
        return flightVOList;
    }

    public void setFlightVOList(List<FlightVO> flightVOList) {
        this.flightVOList = flightVOList;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public List<ExtraDataVO> getExtraDataVOList() {
        return extraDataVOList;
    }

    public void setExtraDataVOList(List<ExtraDataVO> extraDataVOList) {
        this.extraDataVOList = extraDataVOList;
    }

    public Boolean getSplit() {
        return split;
    }

    public void setSplit(Boolean split) {
        this.split = split;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AwardVO awardVO = (AwardVO) o;

        if (classVOList != null ? !classVOList.equals(awardVO.classVOList) : awardVO.classVOList != null) return false;
        if (extraDataVOList != null ? !extraDataVOList.equals(awardVO.extraDataVOList) : awardVO.extraDataVOList != null)
            return false;
        if (flightVOList != null ? !flightVOList.equals(awardVO.flightVOList) : awardVO.flightVOList != null)
            return false;
        if (split != null ? !split.equals(awardVO.split) : awardVO.split != null) return false;
        if (totalDuration != null ? !totalDuration.equals(awardVO.totalDuration) : awardVO.totalDuration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classVOList != null ? classVOList.hashCode() : 0;
        result = 31 * result + (flightVOList != null ? flightVOList.hashCode() : 0);
        result = 31 * result + (totalDuration != null ? totalDuration.hashCode() : 0);
        result = 31 * result + (extraDataVOList != null ? extraDataVOList.hashCode() : 0);
        result = 31 * result + (split != null ? split.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AwardVO{" +
                "classVOList=" + classVOList +
                ", flightVOList=" + flightVOList +
                ", totalDuration='" + totalDuration + '\'' +
                ", extraDataVOList=" + extraDataVOList +
                ", split=" + split +
                '}';
    }
}
