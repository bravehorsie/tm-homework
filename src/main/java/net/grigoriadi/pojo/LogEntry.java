package net.grigoriadi.pojo;

import java.time.LocalDateTime;

/**
 * Represents a single entry in the log (input.txt).
 */
public class LogEntry {

    private String customer;

    private String phoneNumber;

    private String item;

    private LocalDateTime dateTime;

    private Integer order;

    public LogEntry() {
    }

    public LogEntry(String customer, String phoneNumber, String item, LocalDateTime dateTime) {
        this.customer = customer;
        this.phoneNumber = phoneNumber;
        this.item = item;
        this.dateTime = dateTime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
