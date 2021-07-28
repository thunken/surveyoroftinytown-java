package com.thunken.surveyoroftinytown;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.thunken.terroroftinytown.ProjectSettings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Simple representation of a project surveyed in Surveyor of Tiny Town.
 *
 * @see Projects
 */
@AllArgsConstructor
@Data
@JsonNaming(SnakeCaseStrategy.class)
@JsonPropertyOrder(alphabetic = true)
@NoArgsConstructor
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

	/**
	 * Return the URL of the given project's settings on the URLTeam's tracker, or null if this project is not a Warrior
	 * project.
	 *
	 * @return the URL of the given project's settings on the URLTeam's tracker, or null if this project is not a
	 *         Warrior project
	 * @throws MalformedURLException
	 *             if a malformed URL occurs
	 */
	public URL getSettingsURL() throws MalformedURLException {
		return isWarriorProject() ? ProjectSettings.getUrl(getWarriorProjectName()) : null;
	}

	public boolean isWarriorProject() {
		return getWarriorProjectName() != null;
	}

	@Override
	public int compareTo(@NonNull final Project o) {
		return getHost().compareToIgnoreCase(o.getHost());
	}

}