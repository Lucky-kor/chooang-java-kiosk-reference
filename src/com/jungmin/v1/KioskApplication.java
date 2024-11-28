package com.jungmin.v1;

public class KioskApplication {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.welcomeMessagePrint();

        kiosk.menuSelectMessagePrint();
        int menuNumber = kiosk.selectMenu();

        kiosk.menuCountMessagePrint();
        int quantity = kiosk.inputMenuCount();

        int totalPrice = kiosk.calculateOrderPrice(menuNumber, quantity);
        kiosk.orderPriceMessagePrint(totalPrice);
    }
}
