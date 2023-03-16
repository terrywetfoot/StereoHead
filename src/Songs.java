import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Songs {


	
	private String groovy90Path = "sounds/bands/groove-crew/groovy90/Groovy90-";
	private Sounds groovy90Bass;
	private Sounds groovy90Drums;
	private Sounds groovy90Guitar;
	private Sounds groovy90Piano;
	private Sounds groovy90Tambourine;
	private Sounds groovy90Vibes;
	private Sounds groovy90Vocal;


	private String groovy95Path = "sounds/bands/groove-crew/groovy95/Groovy95-";
	private Sounds groovy95Bass;
	private Sounds groovy95Drums;
	private Sounds groovy95Guitar;
	private Sounds groovy95Piano;
	private Sounds groovy95Tambourine;
	private Sounds groovy95Vibes;
	private Sounds groovy95Vocal;
	
	private String groovy100Path = "sounds/bands/groove-crew/groovy100/Groovy100-";
	private Sounds groovy100Bass;
	private Sounds groovy100Drums;
	private Sounds groovy100Guitar;
	private Sounds groovy100Piano;
	private Sounds groovy100Tambourine;
	private Sounds groovy100Vibes;
	private Sounds groovy100Vocal;
	
	private String groovy130Path = "sounds/bands/groove-crew/groovy130/Groovy130-";
	private Sounds groovy130Bass;
	private Sounds groovy130Drums;
	private Sounds groovy130Guitar;
	private Sounds groovy130Piano;
	private Sounds groovy130Tambourine;
	private Sounds groovy130Vibes;
	private Sounds groovy130Vocal;
	
	
	

	public Sounds[][] songs;
	

	
	///////////////////////////////////////////////////////
	///CONSTRUCTOR
	public Songs() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		groovy90Bass = new Sounds("Bass", (groovy90Path + "Bass.wav"));
		groovy90Drums = new Sounds("Drums", (groovy90Path + "Drums.wav"));
		groovy90Guitar = new Sounds("Guitar", (groovy90Path + "Guitar.wav"));
		groovy90Piano = new Sounds("Piano",(groovy90Path + "Piano.wav"));
		groovy90Tambourine = new Sounds("Tambourine",(groovy90Path + "Tambourine.wav"));
		groovy90Vibes = new Sounds("Vibraphone", (groovy90Path + "Vibes.wav"));
		groovy90Vocal = new Sounds("Vocal", (groovy90Path + "Vocal.wav"));

		Sounds[] groovy90 = new Sounds[] {
				groovy90Bass,
				groovy90Drums,
				groovy90Guitar,
				groovy90Piano,
				groovy90Tambourine,
				groovy90Vibes,
				groovy90Vocal
		};


		groovy95Bass = new Sounds("Bass", (groovy95Path + "Bass.wav") );
		groovy95Drums = new Sounds("Drums", (groovy95Path + "Drums.wav"));
		groovy95Guitar = new Sounds("Guitar", (groovy95Path + "Guitar.wav"));
		groovy95Piano = new Sounds("Piano",(groovy95Path + "Piano.wav"));
		groovy95Tambourine = new Sounds("Tambourine",(groovy95Path + "Tambourine.wav"));
		groovy95Vibes = new Sounds("Vibraphone", (groovy95Path + "Vibes.wav"));
		groovy95Vocal = new Sounds("Vocal", (groovy95Path + "Vocal.wav"));

		Sounds[] groovy95 = new Sounds[] {
				groovy95Bass,
				groovy95Drums,
				groovy95Guitar,
				groovy95Piano,
				groovy95Tambourine,
				groovy95Vibes,
				groovy95Vocal
		};
		
		groovy100Bass = new Sounds("Bass", (groovy100Path + "Bass.wav") );
		groovy100Drums = new Sounds("Drums", (groovy100Path + "Drums.wav"));
		groovy100Guitar = new Sounds("Guitar", (groovy100Path + "Guitar.wav"));
		groovy100Piano = new Sounds("Piano",(groovy100Path + "Piano.wav"));
		groovy100Tambourine = new Sounds("Tambourine",(groovy100Path + "Tambourine.wav"));
		groovy100Vibes = new Sounds("Vibraphone", (groovy100Path + "Vibes.wav"));
		groovy100Vocal = new Sounds("Vocal", (groovy100Path + "Vocal.wav"));
		
		
		Sounds[] groovy100 = new Sounds[] {
				groovy100Bass,
				groovy100Drums,
				groovy100Guitar,
				groovy100Piano,
				groovy100Tambourine,
				groovy100Vibes,
				groovy100Vocal
		};
		
		groovy130Bass = new Sounds("Bass", (groovy130Path + "Bass.wav") );
		groovy130Drums = new Sounds("Drums", (groovy130Path + "Drums.wav"));
		groovy130Guitar = new Sounds("Guitar", (groovy130Path + "Guitar.wav"));
		groovy130Piano = new Sounds("Piano",(groovy130Path + "Piano.wav"));
		groovy130Tambourine = new Sounds("Tambourine",(groovy130Path + "Tambourine.wav"));
		groovy130Vibes = new Sounds("Vibraphone", (groovy130Path + "Vibes.wav"));
		groovy130Vocal = new Sounds("Vocal", (groovy130Path + "Vocal.wav"));
		
		Sounds[] groovy130 = new Sounds[] {
				groovy130Bass,
				groovy130Drums,
				groovy130Guitar,
				groovy130Piano,
				groovy130Tambourine,
				groovy130Vibes,
				groovy130Vocal
		};
		

		songs = new Sounds[4][];
		songs[0] = groovy90;
		songs[1] = groovy95;
		songs[2] = groovy100;
		songs[3] = groovy130;

	}




	
	
	

}









