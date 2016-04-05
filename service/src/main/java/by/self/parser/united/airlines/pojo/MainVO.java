package by.self.parser.united.airlines.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class MainVO implements Serializable {

    @JsonIgnoreProperties
    public static final long serialVersionUID = 42L;

    @JsonProperty("award_list")
    private List<AwardVO> awardVOs;

    public MainVO() {
    }

    public MainVO(List<AwardVO> awardVOs) {
        this.awardVOs = awardVOs;
    }

    public List<AwardVO> getAwardVOs() {
        return awardVOs;
    }

    public void setAwardVOs(List<AwardVO> awardVOs) {
        this.awardVOs = awardVOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainVO mainVO = (MainVO) o;

        if (awardVOs != null ? !awardVOs.equals(mainVO.awardVOs) : mainVO.awardVOs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return awardVOs != null ? awardVOs.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MainVO{" +
                "awardVOs=" + awardVOs +
                '}';
    }
}
