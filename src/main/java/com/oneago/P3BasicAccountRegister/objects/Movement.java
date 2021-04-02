package com.oneago.P3BasicAccountRegister.objects;

public class Movement {
    private String date;
    private String type;
    private int quantity;
    private String detail;

    public Movement(String date, String type, int quantity, String detail) {
        this.date = date;
        this.type = type;
        this.quantity = quantity;
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDetail() {
        return detail;
    }
}
