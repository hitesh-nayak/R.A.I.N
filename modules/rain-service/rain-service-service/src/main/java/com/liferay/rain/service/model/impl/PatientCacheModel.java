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

package com.liferay.rain.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.rain.service.model.Patient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Patient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientCacheModel implements CacheModel<Patient>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PatientCacheModel)) {
			return false;
		}

		PatientCacheModel patientCacheModel = (PatientCacheModel)object;

		if (govtId == patientCacheModel.govtId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, govtId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{govtId=");
		sb.append(govtId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", age=");
		sb.append(age);
		sb.append(", isAdult=");
		sb.append(isAdult);
		sb.append(", email=");
		sb.append(email);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", insuranceId=");
		sb.append(insuranceId);
		sb.append(", primaryDoctor=");
		sb.append(primaryDoctor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Patient toEntityModel() {
		PatientImpl patientImpl = new PatientImpl();

		patientImpl.setGovtId(govtId);
		patientImpl.setGroupId(groupId);

		if (surname == null) {
			patientImpl.setSurname("");
		}
		else {
			patientImpl.setSurname(surname);
		}

		if (firstName == null) {
			patientImpl.setFirstName("");
		}
		else {
			patientImpl.setFirstName(firstName);
		}

		if (nationality == null) {
			patientImpl.setNationality("");
		}
		else {
			patientImpl.setNationality(nationality);
		}

		patientImpl.setAge(age);
		patientImpl.setIsAdult(isAdult);

		if (email == null) {
			patientImpl.setEmail("");
		}
		else {
			patientImpl.setEmail(email);
		}

		if (contactNumber == null) {
			patientImpl.setContactNumber("");
		}
		else {
			patientImpl.setContactNumber(contactNumber);
		}

		if (insuranceId == null) {
			patientImpl.setInsuranceId("");
		}
		else {
			patientImpl.setInsuranceId(insuranceId);
		}

		patientImpl.setPrimaryDoctor(primaryDoctor);

		patientImpl.resetOriginalValues();

		return patientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		govtId = objectInput.readLong();

		groupId = objectInput.readLong();
		surname = objectInput.readUTF();
		firstName = objectInput.readUTF();
		nationality = objectInput.readUTF();

		age = objectInput.readLong();

		isAdult = objectInput.readBoolean();
		email = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		insuranceId = objectInput.readUTF();

		primaryDoctor = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(govtId);

		objectOutput.writeLong(groupId);

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		objectOutput.writeLong(age);

		objectOutput.writeBoolean(isAdult);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (insuranceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuranceId);
		}

		objectOutput.writeLong(primaryDoctor);
	}

	public long govtId;
	public long groupId;
	public String surname;
	public String firstName;
	public String nationality;
	public long age;
	public boolean isAdult;
	public String email;
	public String contactNumber;
	public String insuranceId;
	public long primaryDoctor;

}