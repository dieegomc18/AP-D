package com.hacs;

import com.hacs.models.*;
import com.hacs.services.*;

public class Main {
    public static void main(String[] args) {
        // Example usage
        DonationService donationService = new DonationService();
        NeedService needService = new NeedService();

        // Create and manage donations
        Donation donation = new Donation("1", "Funds", 100.0, "For food supplies");
        donationService.createDonation(donation);

        // Create and manage needs
        Need need = new Need("1", "Food", "Request for food assistance");
        needService.createNeed(need);
    }
}
