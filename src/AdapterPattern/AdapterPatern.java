package AdapterPattern;

interface MediaPlayer {
	public void play(String audioType, String fileName);
}

interface AdvanceMediaPlayer {
	public void playVlc(String fileName);

	public void playMp4(String fileName);
}

class VlcPlayer implements AdvanceMediaPlayer {
	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
	}

	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing Vlc file: " + fileName);
	}
}

class Mp4Player implements AdvanceMediaPlayer {
	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing MP4 file: " + fileName);
	}

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub

	}
}

class MediaAdapter implements MediaPlayer {
	AdvanceMediaPlayer advanceMediaPlayer = null;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advanceMediaPlayer = new VlcPlayer();
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advanceMediaPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advanceMediaPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advanceMediaPlayer.playMp4(fileName);
		}

	}

}

class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println(" playing mp3 file: " + fileName);
		}
		else if (audioType.equalsIgnoreCase("Vlc")
				|| audioType.equalsIgnoreCase("MP4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("not supported");
		}

	}
}

public class AdapterPatern {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "beyond horizon.mp3");
		audioPlayer.play("mp4", "beyond horizon.mp4");
		audioPlayer.play("vlc", "beyond horizon.vlc");
		audioPlayer.play("avi", "beyond horizon.avi");
	}

}
