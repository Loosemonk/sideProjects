import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.lang.model.type.IntersectionType;

public class IntervalFinder {

	public static void main(String[] args) {

		int lowNoteInt = 0;
		int highNoteInt = 0;

		Map<Integer, String> interval = new TreeMap<>();

		interval.put(0, "Octave");
		interval.put(1, "Minor 2nd");
		interval.put(2, "Major 2nd");
		interval.put(3, "Minor 3rd");
		interval.put(4, "Major 3rd");
		interval.put(5, "Perfect 4th");
		interval.put(6, "Tritone");
		interval.put(7, "Perfect 5th");
		interval.put(8, "Minor 6th");
		interval.put(9, "Major 6th");
		interval.put(10, "Minor 7th");
		interval.put(11, "Major 7th");

		String[] chromaticScale = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
		System.out.println(
				"Enter your low note. If the note is flat, provide it's harmonic equivalent in a sharp(#) please");
		Scanner userInput = new Scanner(System.in);
		String lowNote = userInput.nextLine();

		for (int i = 0; i < chromaticScale.length; i++) {
			if (lowNote.equalsIgnoreCase(chromaticScale[i])) {
				lowNoteInt = i++;
			}

		}

		System.out.println(
				"Enter your high note. If the note is flat, provide it's harmonic equivalent in a sharp(#) please");
		String highNote = userInput.nextLine();

		for (int i = 0; i < chromaticScale.length; i++) {
			if (highNote.equalsIgnoreCase(chromaticScale[i])) {
				highNoteInt = i++;
			}
		}

		if (lowNoteInt < highNoteInt) {
			int scaleHigh = highNoteInt - lowNoteInt;
			System.out.println(interval.get(scaleHigh));
		} else if (lowNoteInt > highNoteInt) {
			int scaleLow = (12 - lowNoteInt) + highNoteInt;
			System.out.println(interval.get(scaleLow));
		} else
			System.out.println("Octave");
		{

		}
	}
}
