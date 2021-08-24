package com.apm.coding_problems.book_appointments;

/*

Working day is from 10AM to 8PM.
Write a function that takes start time and end time,
and blocks that slot if available and return true,
or if the slot is occupied, returns false.
 */

import java.util.Scanner;
import java.util.TreeSet;

public class BookAppointments {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    AppointmentCalendar appointmentCalendar = new AppointmentCalendar(1000, 2000);

    boolean validInput = true;
    while (validInput) {
      System.out.println("Free Slots - " + appointmentCalendar.getAllFreeSlots());
      System.out.println("Enter start time (HHMM 24 hour clock, 0 to exit): ");
      int startTime = scanner.nextInt();
      System.out.println("Enter end time (HHMM 24 hour clock, 0 to exit): ");
      int endTime = scanner.nextInt();

      validInput = (startTime != 0 && endTime != 0);
      if (validInput) {
        boolean bookingStatus = appointmentCalendar.bookSlot(startTime, endTime);
        System.out.println(bookingStatus ? "Slot Booked" : "Slot Occupied");
      }
    }
  }

  static class AppointmentCalendar {
    private int dailyStartTime;
    private int dailyEndTime;
    private TreeSet<FreeSlot> freeSlots;

    AppointmentCalendar(int dailyStartTime, int dailyEndTime) {
      this.dailyStartTime = dailyStartTime;
      this.dailyEndTime = dailyEndTime;

      freeSlots = new TreeSet<>();
      freeSlots.add(new FreeSlot(this.dailyStartTime, this.dailyEndTime));
    }

    boolean bookSlot(int startTime, int endTime) {
      if (startTime < dailyStartTime || endTime > dailyEndTime) {
        System.out.println("Slot is outside the working times");
        return false;
      }

      FreeSlot proposedSlot = new FreeSlot(startTime, endTime);
      FreeSlot freeSlotBefore = freeSlots.floor(proposedSlot);
      if (freeSlotBefore == null) {
        System.out.println("All slots before start time are booked");
        return false;
      }

      if (freeSlotBefore.slotEnd >= endTime) {
        freeSlots.remove(freeSlotBefore);

        if (freeSlotBefore.slotStart < startTime)
          freeSlots.add(new FreeSlot(freeSlotBefore.slotStart, startTime));

        if (freeSlotBefore.slotEnd > endTime)
          freeSlots.add(new FreeSlot(endTime, freeSlotBefore.slotEnd));

        return true;
      }
      else {
        System.out.println("Slot end time goes beyond free time");
        return false;
      }
    }

    public String getAllFreeSlots() {
      return freeSlots.toString();
    }

    private class FreeSlot implements Comparable<FreeSlot> {
      public int slotStart;
      public int slotEnd;

      FreeSlot(int slotStart, int slotEnd) {
        this.slotStart = slotStart;
        this.slotEnd = slotEnd;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == null)
          return false;
        else if (obj instanceof FreeSlot) {
          return this.slotStart == ((FreeSlot) obj).slotStart;
        }
        else
          return false;
      }

      @Override
      public String toString() {
        return "[" + this.slotStart + "::" + this.slotEnd + "]";
      }

      @Override
      public int compareTo(FreeSlot o) {
        if (this.slotStart < o.slotStart)
          return -1;
        else if (this.slotStart > o.slotStart)
          return 1;
        else
          return 0;
      }
    }
  }
}
