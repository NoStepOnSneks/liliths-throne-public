package com.lilithsthrone.game.character.body.valueEnums;

import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.utils.Colour;

/**
 * @since 0.1.83
 * @version 0.1.83
 * @author Innoxia
 */
public enum Muscle {
	
	ZERO_SOFT("soft", 0, 20, Colour.MUSCLE_ZERO),
	ONE_LIGHTLY_MUSCLED("lightly muscled", 20, 40, Colour.MUSCLE_ONE),
	TWO_TONED("toned", 40, 60, Colour.MUSCLE_TWO),
	THREE_MUSCULAR("muscular", 60, 80, Colour.MUSCLE_THREE),
	FOUR_RIPPED("ripped", 80, 100, Colour.MUSCLE_FOUR);

	private String name;
	private int minimumMuscle, maximumMuscle;
	private Colour colour;

	private Muscle(String name, int minimumMuscle, int maximumMuscle, Colour colour) {
		this.name = name;
		this.minimumMuscle = minimumMuscle;
		this.maximumMuscle = maximumMuscle;
		this.colour = colour;
	}

	public int getMinimumValue() {
		return minimumMuscle;
	}

	public int getMaximumValue() {
		return maximumMuscle;
	}

	public int getMedianValue() {
		return minimumMuscle + (maximumMuscle - minimumMuscle) / 2;
	}

	public static Muscle valueOf(int muscle) {
		for(Muscle f : Muscle.values()) {
			if(muscle>=f.getMinimumValue() && muscle<f.getMaximumValue()) {
				return f;
			}
		}
		return FOUR_RIPPED;
	}
	
	public String getName(boolean withDeterminer) {
		if(withDeterminer) {
			return UtilText.generateSingularDeterminer(name) + " " + name;
		} else {
			return name;
		}
	}

	public Colour getColour() {
		return colour;
	}
}
