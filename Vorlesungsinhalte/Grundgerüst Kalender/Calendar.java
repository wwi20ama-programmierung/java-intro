import java.util.ArrayList;

public class Calendar {
  private List<Meeting> meetings = new ArrayList<>();

  // Methode
  public void listMeetings() {
    for(int i = 0; i < this.meetings.size(); i++) {
      Meeting meeting = this.meetings[i];
      meeting.getDate();
      meeting.getTime();
      meeting.getTitle();
      // ...
      meeting.listParticipants();
    }
  }
}