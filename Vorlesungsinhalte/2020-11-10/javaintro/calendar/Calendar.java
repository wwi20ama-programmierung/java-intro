package javaintro.calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
  private List<Meeting> meetings = new ArrayList<>();

  public void addMeeting(Meeting meeting) {
    this.meetings.add(meeting);
  }

  // Methode
  public void listMeetings() {
    for(int i = 0; i < this.meetings.size(); i++) {
      Meeting meeting = this.meetings.get(i);

      meeting.listMeetingParticipants();

      System.out.println(); // leere Zeile als Abstandshalter
    }
  }
}