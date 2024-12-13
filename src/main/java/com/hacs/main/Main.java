package com.hacs.main;

import com.hacs.service.AffectedService;
import com.hacs.service.DonorService;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AffectedService affectedService = new AffectedService();
    private static final DonorService donorService = new DonorService();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    createNeed();
                    break;
                case 2:
                    updateNeed();
                    break;
                case 3:
                    deleteNeed();
                    break;
                case 4:
                    viewNeedStatus();
                    break;
                case 5:
                    createDonation();
                    break;
                case 6:
                    updateDonation();
                    break;
                case 7:
                    deleteDonation();
                    break;
                case 8:
                    viewDonationHistory();
                    break;
                case 9:
                    generateDonationConfirmation();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Create Need");
        System.out.println("2. Update Need");
        System.out.println("3. Delete Need");
        System.out.println("4. View Need Status");
        System.out.println("5. Create Donation");
        System.out.println("6. Update Donation");
        System.out.println("7. Delete Donation");
        System.out.println("8. View Donation History");
        System.out.println("9. Generate Donation Confirmation");
        System.out.println("0. Exit");
    }

    private static void createNeed() {
        System.out.println("Enter request details:");
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Urgency (low, medium, high): ");
        String urgency = scanner.nextLine();

        affectedService.createNeed(type, description, urgency);
    }

    private static void updateNeed() {
        System.out.print("Enter the ID of the need to update: ");
        String needId = scanner.nextLine();
        System.out.print("Updated description: ");
        String updatedDescription = scanner.nextLine();
        System.out.print("Updated urgency: ");
        String updatedUrgency = scanner.nextLine();

        affectedService.updateNeed(needId, updatedDescription, updatedUrgency);
    }

    private static void deleteNeed() {
        System.out.print("Enter the ID of the need to delete: ");
        String needId = scanner.nextLine();

        affectedService.deleteNeed(needId);
    }

    private static void viewNeedStatus() {
        System.out.print("Enter the ID of the need to view status: ");
        String needId = scanner.nextLine();

        affectedService.viewNeedStatus(needId);
    }

    private static void createDonation() {
        System.out.println("Enter donation details:");
        System.out.print("Type (money, goods, services): ");
        String type = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // consume the newline character
        System.out.print("Description: ");
        String description = scanner.nextLine();

        donorService.createDonation(type, amount, description);
    }

    private static void updateDonation() {
        System.out.print("Enter the ID of the donation to update: ");
        String donationId = scanner.nextLine();
        System.out.print("Updated description: ");
        String updatedDescription = scanner.nextLine();
        System.out.print("Updated amount: ");
        double updatedAmount = scanner.nextDouble();
        scanner.nextLine();  // consume the newline character

        donorService.updateDonation(donationId, updatedDescription, updatedAmount);
    }

    private static void deleteDonation() {
        System.out.print("Enter the ID of the donation to delete: ");
        String donationId = scanner.nextLine();

        donorService.deleteDonation(donationId);
    }

    private static void viewDonationHistory() {
        System.out.print("Enter donor ID to view donation history: ");
        String donorId = scanner.nextLine();

        donorService.viewDonationHistory(donorId);
    }

    private static void generateDonationConfirmation() {
        System.out.print("Enter donation ID to generate confirmation: ");
        String donationId = scanner.nextLine();

        donorService.generateDonationConfirmation(donationId);
    }
}
