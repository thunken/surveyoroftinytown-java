package com.thunken.surveyoroftinytown;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * Utility methods to deserialize multiple {@link Project} objects from URLs.
 *
 * @see Project
 */
@UtilityClass
public class Projects {

	@NonNull
	public static final URL DEFAULT_URL;

	static {
		try {
			DEFAULT_URL = new URL("https://raw.githubusercontent.com/thunken/surveyoroftinytown/master/projects.json");
		} catch (final MalformedURLException e) {
			throw new UncheckedIOException(e);
		}
	}

	private static final TypeReference<List<Project>> PROJECT_LIST_TYPE = new TypeReference<List<Project>>() {
	};

	/**
	 * Load all projects surveyed in the latest version of Surveyor of Tiny Town, using {@link #DEFAULT_URL}.
	 *
	 * @return all projects surveyed in the latest version of Surveyor of Tiny Town
	 * @throws IOException
	 *             if a low-level I/O problem occurs
	 */
	public List<Project> load() throws IOException {
		return load(DEFAULT_URL);
	}

	/**
	 * Load all projects surveyed at the given URL.
	 *
	 * @return all projects surveyed at the given URL
	 * @throws IOException
	 *             if a low-level I/O problem occurs
	 * @throws NullPointerException
	 *             if {@code url} is null
	 */
	List<Project> load(@NonNull final URL url) throws IOException {
		return new ObjectMapper().readValue(url, PROJECT_LIST_TYPE);
	}

}
