package org.example.calendartest;

import java.time.ZonedDateTime;

public class CalendarActivity {
    private ZonedDateTime date;
    private String clientName;
    private Integer serviceNo;

    public CalendarActivity(ZonedDateTime date, String clientName, Integer serviceNo) {
        this.date = date;
        this.clientName = clientName;
        this.serviceNo = serviceNo;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Integer serviceNo) {
        this.serviceNo = serviceNo;
    }

    @Override
    public String toString() {
        return clientName + " " + date.getMonth().getValue() + "/" + date.getDayOfMonth();
    }
}