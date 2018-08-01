package com.abouzidi.domain;

import lombok.Getter;

/**
 * @author Afif Bouzidi
 *
 */
@Getter
public enum Mark {

	NO_RATING(0), DID_NOT_LIKED_IT(1), IT_WAS_OK(2), LIKED_IT(3), REALLY_LIKED_IT(4), IT_WAS_AMAZING(5);

	private int mark;

	Mark(int mark) {
		this.mark = mark;
	}

	public static Mark getMark(Integer index) {
		for (Mark mark : values()) {
			Integer indexL = Integer.valueOf(mark.mark);
			if (index.equals(indexL)) {
				return mark;
			}
		}
		return NO_RATING;
	}

}
