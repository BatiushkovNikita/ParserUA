package by.self.parser.united.airlines;

import java.util.List;

public class RequestData {

    private String startDate;
    private String endDate;
    private String origin;
    private String destination;
    private int seats;
    private String classes;
    private Long requestId;
    private Long userId;
    private String type;

    public RequestData() {
    }

    public RequestData(String startDate, String endDate, String origin, String destination, int seats, String classes, Long requestId, Long userId, String type) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
        this.classes = classes;
        this.requestId = requestId;
        this.userId = userId;
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestData that = (RequestData) o;

        if (seats != that.seats) return false;
        if (classes != null ? !classes.equals(that.classes) : that.classes != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (requestId != null ? !requestId.equals(that.requestId) : that.requestId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + seats;
        result = 31 * result + (classes != null ? classes.hashCode() : 0);
        result = 31 * result + (requestId != null ? requestId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", classes='" + classes + '\'' +
                ", requestId=" + requestId +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                '}';
    }
}
