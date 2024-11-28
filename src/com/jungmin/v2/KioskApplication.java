package com.jungmin.v2;

public class KioskApplication {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.welcomeMessagePrint();

        int menuNumber = kiosk.selectMenu();

        int quantity = kiosk.selectMenuQuantity();

        int totalPrice = kiosk.calculateOrderPrice(menuNumber, quantity);
        kiosk.orderPriceMessagePrint(totalPrice);
    }
}
