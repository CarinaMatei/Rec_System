package com.springboot.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.project.model.Preference;
import com.springboot.project.repository.PreferenceRepository;

@Service
public class PreferenceServiceImpl implements PreferenceService{
	
	private PreferenceRepository preferenceRepository;

	public PreferenceServiceImpl(PreferenceRepository preferenceRepository) {
		super();
		this.preferenceRepository = preferenceRepository;
	}

	@Override
	public List<Preference> getAllPreferences() {
		return preferenceRepository.findAll();
	}

	@Override
	public Preference savePreference(Preference preference) {
		return preferenceRepository.save(preference);
	}

	@Override
	public Preference getPreferenceById(Long id) {
		return preferenceRepository.findById(id).get();
	}
	
	@Override
	public List<Preference> getPreferencesByIds(List<Long> preferenceIds) {
		return preferenceRepository.findAllById(preferenceIds);
	}

	@Override
	public Preference updatePreference(Preference preference) {
		return preferenceRepository.save(preference);
	}
}
