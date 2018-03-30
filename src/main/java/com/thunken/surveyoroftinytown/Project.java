package com.thunken.surveyoroftinytown;

import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.thunken.terroroftinytown.ProjectSettings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

/**
 * Immutable representation of a project surveyed in Surveyor of Tiny Town.
 *
 * @see Projects
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(SnakeCaseStrategy.class)
@JsonPropertyOrder(alphabetic = true)
@Value
public final class Project implements Comparable<Project> {

	@NonNull
	private Set<String> aliases;

	@NonNull
	private String host;

	private String warriorProjectName;

	/**
	 * Return the settings for this project on Terror of Tiny Town, or null if this project is not a Warrior project.
	 *
	 * @return the settings for this project on Terror of Tiny Town, or null if this project is not a Warrior project
	 * @throws IOException
	 *             if a low-level I/O problem occurs
	 */
	public ProjectSettings getSettings() throws IOException {
		return isWarriorProject() ? ProjectSettings.of(getWarriorProjectName()) : null;
	}

	public boolean isWarriorProject() {
		return getWarriorProjectName() != null;
	}

	@Override
	public int compareTo(@NonNull final Project o) {
		return getHost().compareToIgnoreCase(o.getHost());
	}

}