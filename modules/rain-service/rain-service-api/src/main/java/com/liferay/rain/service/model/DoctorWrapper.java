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
 * This class is a wrapper for {@link Doctor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Doctor
 * @generated
 */
public class DoctorWrapper
	extends BaseModelWrapper<Doctor> implements Doctor, ModelWrapper<Doctor> {

	public DoctorWrapper(Doctor doctor) {
		super(doctor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("surname", getSurname());
		attributes.put("firstName", getFirstName());
		attributes.put("department", getDepartment());
		attributes.put("govtId", getGovtId());
		attributes.put("nationality", getNationality());
		attributes.put("payGroup", getPayGroup());
		attributes.put("email", getEmail());
		attributes.put("contactNumber", getContactNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String govtId = (String)attributes.get("govtId");

		if (govtId != null) {
			setGovtId(govtId);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String payGroup = (String)attributes.get("payGroup");

		if (payGroup != null) {
			setPayGroup(payGroup);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}
	}

	@Override
	public Doctor cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the contact number of this doctor.
	 *
	 * @return the contact number of this doctor
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the department of this doctor.
	 *
	 * @return the department of this doctor
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the email of this doctor.
	 *
	 * @return the email of this doctor
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the employee ID of this doctor.
	 *
	 * @return the employee ID of this doctor
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the first name of this doctor.
	 *
	 * @return the first name of this doctor
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the govt ID of this doctor.
	 *
	 * @return the govt ID of this doctor
	 */
	@Override
	public String getGovtId() {
		return model.getGovtId();
	}

	/**
	 * Returns the group ID of this doctor.
	 *
	 * @return the group ID of this doctor
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the nationality of this doctor.
	 *
	 * @return the nationality of this doctor
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the pay group of this doctor.
	 *
	 * @return the pay group of this doctor
	 */
	@Override
	public String getPayGroup() {
		return model.getPayGroup();
	}

	/**
	 * Returns the primary key of this doctor.
	 *
	 * @return the primary key of this doctor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the surname of this doctor.
	 *
	 * @return the surname of this doctor
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the contact number of this doctor.
	 *
	 * @param contactNumber the contact number of this doctor
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the department of this doctor.
	 *
	 * @param department the department of this doctor
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the email of this doctor.
	 *
	 * @param email the email of this doctor
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the employee ID of this doctor.
	 *
	 * @param employeeId the employee ID of this doctor
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the first name of this doctor.
	 *
	 * @param firstName the first name of this doctor
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the govt ID of this doctor.
	 *
	 * @param govtId the govt ID of this doctor
	 */
	@Override
	public void setGovtId(String govtId) {
		model.setGovtId(govtId);
	}

	/**
	 * Sets the group ID of this doctor.
	 *
	 * @param groupId the group ID of this doctor
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the nationality of this doctor.
	 *
	 * @param nationality the nationality of this doctor
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the pay group of this doctor.
	 *
	 * @param payGroup the pay group of this doctor
	 */
	@Override
	public void setPayGroup(String payGroup) {
		model.setPayGroup(payGroup);
	}

	/**
	 * Sets the primary key of this doctor.
	 *
	 * @param primaryKey the primary key of this doctor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the surname of this doctor.
	 *
	 * @param surname the surname of this doctor
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
	protected DoctorWrapper wrap(Doctor doctor) {
		return new DoctorWrapper(doctor);
	}

}