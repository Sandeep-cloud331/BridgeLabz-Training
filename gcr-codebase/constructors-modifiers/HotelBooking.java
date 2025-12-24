class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    // Default Constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized Constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    // Method to display booking details
    void showBooking() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
        System.out.println("");
    }

    public static void main(String[] args) {

        // Using default constructor
        HotelBooking b1 = new HotelBooking();
        b1.showBooking();

        // Using parameterized constructor
        HotelBooking b2 = new HotelBooking("Ren", "Deluxe", 3);
        b2.showBooking();

        // Using copy constructor
        HotelBooking b3 = new HotelBooking(b2);
        b3.showBooking();
    }
}
