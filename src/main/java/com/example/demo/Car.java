package com.example.demo;

public class Car {
    private int cardId;
    private String mark;
    private String model;
    private String color;

    public Car(int cardId, String mark, String model, String color) {
        this.cardId = cardId;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
