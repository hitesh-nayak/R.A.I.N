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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Patient service. Represents a row in the &quot;Rain_Patient&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.rain.service.model.impl.PatientModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.rain.service.model.impl.PatientImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
@ProviderType
public interface PatientModel extends BaseModel<Patient> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a patient model instance should use the {@link Patient} interface instead.
	 */

	/**
	 * Returns the primary key of this patient.
	 *
	 * @return the primary key of this patient
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this patient.
	 *
	 * @param primaryKey the primary key of this patient
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the govt ID of this patient.
	 *
	 * @return the govt ID of this patient
	 */
	public long getGovtId();

	/**
	 * Sets the govt ID of this patient.
	 *
	 * @param govtId the govt ID of this patient
	 */
	public void setGovtId(long govtId);

	/**
	 * Returns the group ID of this patient.
	 *
	 * @return the group ID of this patient
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this patient.
	 *
	 * @param groupId the group ID of this patient
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the surname of this patient.
	 *
	 * @return the surname of this patient
	 */
	@AutoEscape
	public String getSurname();

	/**
	 * Sets the surname of this patient.
	 *
	 * @param surname the surname of this patient
	 */
	public void setSurname(String surname);

	/**
	 * Returns the first name of this patient.
	 *
	 * @return the first name of this patient
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this patient.
	 *
	 * @param firstName the first name of this patient
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the nationality of this patient.
	 *
	 * @return the nationality of this patient
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this patient.
	 *
	 * @param nationality the nationality of this patient
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the age of this patient.
	 *
	 * @return the age of this patient
	 */
	public long getAge();

	/**
	 * Sets the age of this patient.
	 *
	 * @param age the age of this patient
	 */
	public void setAge(long age);

	/**
	 * Returns the is adult of this patient.
	 *
	 * @return the is adult of this patient
	 */
	public boolean getIsAdult();

	/**
	 * Returns <code>true</code> if this patient is is adult.
	 *
	 * @return <code>true</code> if this patient is is adult; <code>false</code> otherwise
	 */
	public boolean isIsAdult();

	/**
	 * Sets whether this patient is is adult.
	 *
	 * @param isAdult the is adult of this patient
	 */
	public void setIsAdult(boolean isAdult);

	/**
	 * Returns the email of this patient.
	 *
	 * @return the email of this patient
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this patient.
	 *
	 * @param email the email of this patient
	 */
	public void setEmail(String email);

	/**
	 * Returns the contact number of this patient.
	 *
	 * @return the contact number of this patient
	 */
	@AutoEscape
	public String getContactNumber();

	/**
	 * Sets the contact number of this patient.
	 *
	 * @param contactNumber the contact number of this patient
	 */
	public void setContactNumber(String contactNumber);

	/**
	 * Returns the insurance ID of this patient.
	 *
	 * @return the insurance ID of this patient
	 */
	@AutoEscape
	public String getInsuranceId();

	/**
	 * Sets the insurance ID of this patient.
	 *
	 * @param insuranceId the insurance ID of this patient
	 */
	public void setInsuranceId(String insuranceId);

	/**
	 * Returns the primary doctor of this patient.
	 *
	 * @return the primary doctor of this patient
	 */
	public long getPrimaryDoctor();

	/**
	 * Sets the primary doctor of this patient.
	 *
	 * @param primaryDoctor the primary doctor of this patient
	 */
	public void setPrimaryDoctor(long primaryDoctor);

	@Override
	public Patient cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}