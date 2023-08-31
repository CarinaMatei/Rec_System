package com.springboot.project.service;

import java.util.List;

import com.springboot.project.model.Preference;

public interface PreferenceService {
	List<Preference> getAllPreferences();
	
	Preference savePreference(Preference preference);

	Preference getPreferenceById(Long id);
	
	List<Preference> getPreferencesByIds(List<Long> preferenceIds);
	
	Preference updatePreference(Preference preference);
}
