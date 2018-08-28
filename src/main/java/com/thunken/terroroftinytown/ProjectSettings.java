package com.thunken.terroroftinytown;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Simple representation of a response from the API for Terror of Tiny Town projects on
 * <a href="https://tracker.archiveteam.org:1338/status">https://tracker.archiveteam.org:1338/status</a>.
 */
@AllArgsConstructor
@Data
@JsonNaming(SnakeCaseStrategy.class)
@JsonPropertyOrder(alphabetic = true)
@NoArgsConstructor
public final class ProjectSettings implements Comparable<ProjectSettings> {

	@NonNull
	private String alphabet, bodyRegex, method, name, urlTemplate;

	private String locationAntiRegex;

	private boolean autoqueue, enabled;

	private int autoreleaseTime, maxNumItems, minClientVersion, minVersion, numCountPerItem;

	@NonNull
	private int[] bannedCodes, noRedirectCodes, redirectCodes, unavailableCodes;

	private long lowerSequenceNum;

	private double requestDelay;

	@Override
	public int compareTo(@NonNull final ProjectSettings o) {
		return getName().compareTo(o.getName());
	}

	/**
	 * Load the settings for the given project on Terror of Tiny Town.
	 *
	 * @param name
	 *            the name of the project
	 * @return the settings for the given project on Terror of Tiny Town
	 * @throws IOException
	 *             if a low-level I/O problem occurs
	 * @throws NullPointerException
	 *             if {@code name} is null
	 */
	public static ProjectSettings of(@NonNull final String name) throws IOException {
		return of(new URL("https://tracker.archiveteam.org:1338/api/project_settings?name=" + name));
	}

	/**
	 * Load the settings for the given project on Terror of Tiny Town.
	 *
	 * @param url
	 *            the URL of the project
	 * @return the settings for the given project on Terror of Tiny Town
	 * @throws IOException
	 *             if a low-level I/O problem occurs
	 * @throws NullPointerException
	 *             if {@code url} is null
	 */
	static ProjectSettings of(@NonNull final URL url) throws IOException {
		return new ObjectMapper().readValue(url, ProjectSettings.class);
	}

}
