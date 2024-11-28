package com.jungmin.v3;

public class KioskApplication {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.welcomeMessagePrint();
        MenuItem menu = kiosk.selectMenu();
        int quantity = kiosk.selectMenuQuantity();
        kiosk.orderPriceMessagePrint(menu, quantity);
    }
}
