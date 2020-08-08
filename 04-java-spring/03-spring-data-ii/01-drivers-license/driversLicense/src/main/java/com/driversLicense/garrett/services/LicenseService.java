package com.driversLicense.garrett.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.driversLicense.garrett.models.License;
import com.driversLicense.garrett.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return licenseRepository.save(license);
	}
	
	public int generateLicenseNumber() {
		License l = licenseRepository.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return(largestNumber);
	}

}
