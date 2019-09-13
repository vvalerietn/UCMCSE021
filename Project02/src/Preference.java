
public class Preference {
	private int quietTime;
	private int music;
	private int reading;
	private int chatting;
	private int difference;
	
	private int qTimeDiff;
	private int musicDiff;
	private int readingDiff;
	private int chattingDiff;
	
	public Preference(int quietTime, int music, int reading, int chatting) {
		if (quietTime >= 0 && quietTime <= 10) {
			this.quietTime = quietTime;
		}
		if (music >= 0 && music <= 10) {
			this.music = music;
		}
		if (reading >= 0 && reading <= 10) {
			this.reading = reading;
		}
		if (chatting >= 0 && chatting <= 10) {
			this.chatting = chatting;
		}
	}
	
	//accessor method for quiet time
	public int getQuietTime() {
		return quietTime;
	}
	
	//accessor method for music
	public int getMusic() {
		return music;
	}
	
	//accessor method for reading
	public int getReading() {
		return reading;
	}
	
	//accessor method for chatting 
	public int getChatting() {
		return chatting;
	}
	
	//method for comparing preferences
	public int compare(Preference pref) {
		qTimeDiff = Math.abs(this.getQuietTime() - pref.getQuietTime());
		musicDiff = Math.abs(this.getMusic() - pref.getMusic());
		readingDiff = Math.abs(this.getReading() - pref.getReading());
		chattingDiff = Math.abs(this.getChatting() - pref.getChatting());
		
		difference = qTimeDiff + musicDiff + readingDiff + chattingDiff;
		return difference;
	}
	
}
