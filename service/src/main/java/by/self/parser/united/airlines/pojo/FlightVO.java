package by.self.parser.united.airlines.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class FlightVO implements Serializable {

    @JsonIgnoreProperties
    public static final long serialVersionUID = 42L;

    @JsonProperty("depart_time")
    private String departTime;

    @JsonProperty("depart_date")
    private String departDate;

    @JsonProperty("depart_place")
    private String departPlace;

    @JsonProperty("depart_code")
    private String departCode;

    @JsonProperty("arrive_time")
    private String arriveTime;

    @JsonProperty("arrive_date")
    private String arriveDate;

    @JsonProperty("arrive_place")
    private String arrivePlace;

    @JsonProperty("arrive_code")
    private String arriveCode;

    @JsonProperty("travel_time")
    private String travelTime;

    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("airline_company")
    private String airlineCompany;

    @JsonProperty("aircraft")
    private String aircraft;

    @JsonProperty("meal")
    private String meal;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("layover_time")
    private String layoverTime;

    public FlightVO() {
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getArrivePlace() {
        return arrivePlace;
    }

    public void setArrivePlace(String arrivePlace) {
        this.arrivePlace = arrivePlace;
    }

    public String getArriveCode() {
        return arriveCode;
    }

    public void setArriveCode(String arriveCode) {
        this.arriveCode = arriveCode;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLayoverTime() {
        return layoverTime;
    }

    public void setLayoverTime(String layoverTime) {
        this.layoverTime = layoverTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightVO flightVO = (FlightVO) o;

        if (aircraft != null ? !aircraft.equals(flightVO.aircraft) : flightVO.aircraft != null) return false;
        if (airlineCompany != null ? !airlineCompany.equals(flightVO.airlineCompany) : flightVO.airlineCompany != null)
            return false;
        if (arriveCode != null ? !arriveCode.equals(flightVO.arriveCode) : flightVO.arriveCode != null) return false;
        if (arriveDate != null ? !arriveDate.equals(flightVO.arriveDate) : flightVO.arriveDate != null) return false;
        if (arrivePlace != null ? !arrivePlace.equals(flightVO.arrivePlace) : flightVO.arrivePlace != null)
            return false;
        if (arriveTime != null ? !arriveTime.equals(flightVO.arriveTime) : flightVO.arriveTime != null) return false;
        if (departCode != null ? !departCode.equals(flightVO.departCode) : flightVO.departCode != null) return false;
        if (departDate != null ? !departDate.equals(flightVO.departDate) : flightVO.departDate != null) return false;
        if (departPlace != null ? !departPlace.equals(flightVO.departPlace) : flightVO.departPlace != null)
            return false;
        if (departTime != null ? !departTime.equals(flightVO.departTime) : flightVO.departTime != null) return false;
        if (flightNumber != null ? !flightNumber.equals(flightVO.flightNumber) : flightVO.flightNumber != null)
            return false;
        if (id != null ? !id.equals(flightVO.id) : flightVO.id != null) return false;
        if (layoverTime != null ? !layoverTime.equals(flightVO.layoverTime) : flightVO.layoverTime != null)
            return false;
        if (meal != null ? !meal.equals(flightVO.meal) : flightVO.meal != null) return false;
        if (travelTime != null ? !travelTime.equals(flightVO.travelTime) : flightVO.travelTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departTime != null ? departTime.hashCode() : 0;
        result = 31 * result + (departDate != null ? departDate.hashCode() : 0);
        result = 31 * result + (departPlace != null ? departPlace.hashCode() : 0);
        result = 31 * result + (departCode != null ? departCode.hashCode() : 0);
        result = 31 * result + (arriveTime != null ? arriveTime.hashCode() : 0);
        result = 31 * result + (arriveDate != null ? arriveDate.hashCode() : 0);
        result = 31 * result + (arrivePlace != null ? arrivePlace.hashCode() : 0);
        result = 31 * result + (arriveCode != null ? arriveCode.hashCode() : 0);
        result = 31 * result + (travelTime != null ? travelTime.hashCode() : 0);
        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        result = 31 * result + (airlineCompany != null ? airlineCompany.hashCode() : 0);
        result = 31 * result + (aircraft != null ? aircraft.hashCode() : 0);
        result = 31 * result + (meal != null ? meal.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (layoverTime != null ? layoverTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightVO{" +
                "departTime='" + departTime + '\'' +
                ", departDate='" + departDate + '\'' +
                ", departPlace='" + departPlace + '\'' +
                ", departCode='" + departCode + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", arriveDate='" + arriveDate + '\'' +
                ", arrivePlace='" + arrivePlace + '\'' +
                ", arriveCode='" + arriveCode + '\'' +
                ", travelTime='" + travelTime + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", airlineCompany='" + airlineCompany + '\'' +
                ", aircraft='" + aircraft + '\'' +
                ", meal='" + meal + '\'' +
                ", id=" + id +
                ", layoverTime='" + layoverTime + '\'' +
                '}';
    }
}
