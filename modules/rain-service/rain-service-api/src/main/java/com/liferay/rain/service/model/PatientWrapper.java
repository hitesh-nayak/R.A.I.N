/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.rain.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Patient}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
public class PatientWrapper
	extends BaseModelWrapper<Patient>
	implements ModelWrapper<Patient>, Patient {

	public PatientWrapper(Patient patient) {
		super(patient);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("govtId", getGovtId());
		attributes.put("groupId", getGroupId());
		attributes.put("surname", getSurname());
		attributes.put("firstName", getFirstName());
		attributes.put("nationality", getNationality());
		attributes.put("age", getAge());
		attributes.put("isAdult", isIsAdult());
		attributes.put("email", getEmail());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("insuranceId", getInsuranceId());
		attributes.put("primaryDoctor", getPrimaryDoctor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long govtId = (Long)attributes.get("govtId");

		if (govtId != null) {
			setGovtId(govtId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		Long age = (Long)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Boolean isAdult = (Boolean)attributes.get("isAdult");

		if (isAdult != null) {
			setIsAdult(isAdult);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String insuranceId = (String)attributes.get("insuranceId");

		if (insuranceId != null) {
			setInsuranceId(insuranceId);
		}

		Long primaryDoctor = (Long)attributes.get("primaryDoctor");

		if (primaryDoctor != null) {
			setPrimaryDoctor(primaryDoctor);
		}
	}

	@Override
	public Patient cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the age of this patient.
	 *
	 * @return the age of this patient
	 */
	@Override
	public long getAge() {
		return model.getAge();
	}

	/**
	 * Returns the contact number of this patient.
	 *
	 * @return the contact number of this patient
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the email of this patient.
	 *
	 * @return the email of this patient
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this patient.
	 *
	 * @return the first name of this patient
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the govt ID of this patient.
	 *
	 * @return the govt ID of this patient
	 */
	@Override
	public long getGovtId() {
		return model.getGovtId();
	}

	/**
	 * Returns the group ID of this patient.
	 *
	 * @return the group ID of this patient
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the insurance ID of this patient.
	 *
	 * @return the insurance ID of this patient
	 */
	@Override
	public String getInsuranceId() {
		return model.getInsuranceId();
	}

	/**
	 * Returns the is adult of this patient.
	 *
	 * @return the is adult of this patient
	 */
	@Override
	public boolean getIsAdult() {
		return model.getIsAdult();
	}

	/**
	 * Returns the nationality of this patient.
	 *
	 * @return the nationality of this patient
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the primary doctor of this patient.
	 *
	 * @return the primary doctor of this patient
	 */
	@Override
	public long getPrimaryDoctor() {
		return model.getPrimaryDoctor();
	}

	/**
	 * Returns the primary key of this patient.
	 *
	 * @return the primary key of this patient
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the surname of this patient.
	 *
	 * @return the surname of this patient
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	/**
	 * Returns <code>true</code> if this patient is is adult.
	 *
	 * @return <code>true</code> if this patient is is adult; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsAdult() {
		return model.isIsAdult();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the age of this patient.
	 *
	 * @param age the age of this patient
	 */
	@Override
	public void setAge(long age) {
		model.setAge(age);
	}

	/**
	 * Sets the contact number of this patient.
	 *
	 * @param contactNumber the contact number of this patient
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the email of this patient.
	 *
	 * @param email the email of this patient
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this patient.
	 *
	 * @param firstName the first name of this patient
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the govt ID of this patient.
	 *
	 * @param govtId the govt ID of this patient
	 */
	@Override
	public void setGovtId(long govtId) {
		model.setGovtId(govtId);
	}

	/**
	 * Sets the group ID of this patient.
	 *
	 * @param groupId the group ID of this patient
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the insurance ID of this patient.
	 *
	 * @param insuranceId the insurance ID of this patient
	 */
	@Override
	public void setInsuranceId(String insuranceId) {
		model.setInsuranceId(insuranceId);
	}

	/**
	 * Sets whether this patient is is adult.
	 *
	 * @param isAdult the is adult of this patient
	 */
	@Override
	public void setIsAdult(boolean isAdult) {
		model.setIsAdult(isAdult);
	}

	/**
	 * Sets the nationality of this patient.
	 *
	 * @param nationality the nationality of this patient
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the primary doctor of this patient.
	 *
	 * @param primaryDoctor the primary doctor of this patient
	 */
	@Override
	public void setPrimaryDoctor(long primaryDoctor) {
		model.setPrimaryDoctor(primaryDoctor);
	}

	/**
	 * Sets the primary key of this patient.
	 *
	 * @param primaryKey the primary key of this patient
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the surname of this patient.
	 *
	 * @param surname the surname of this patient
	 */
	@Override
	public void setSurname(String surname) {
		model.setSurname(surname);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PatientWrapper wrap(Patient patient) {
		return new PatientWrapper(patient);
	}

}