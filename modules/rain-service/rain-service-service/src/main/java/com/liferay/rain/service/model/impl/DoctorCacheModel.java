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
import com.liferay.rain.service.model.Doctor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Doctor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DoctorCacheModel implements CacheModel<Doctor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DoctorCacheModel)) {
			return false;
		}

		DoctorCacheModel doctorCacheModel = (DoctorCacheModel)object;

		if (employeeId == doctorCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", department=");
		sb.append(department);
		sb.append(", govtId=");
		sb.append(govtId);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", payGroup=");
		sb.append(payGroup);
		sb.append(", email=");
		sb.append(email);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Doctor toEntityModel() {
		DoctorImpl doctorImpl = new DoctorImpl();

		doctorImpl.setEmployeeId(employeeId);
		doctorImpl.setGroupId(groupId);

		if (surname == null) {
			doctorImpl.setSurname("");
		}
		else {
			doctorImpl.setSurname(surname);
		}

		if (firstName == null) {
			doctorImpl.setFirstName("");
		}
		else {
			doctorImpl.setFirstName(firstName);
		}

		if (department == null) {
			doctorImpl.setDepartment("");
		}
		else {
			doctorImpl.setDepartment(department);
		}

		if (govtId == null) {
			doctorImpl.setGovtId("");
		}
		else {
			doctorImpl.setGovtId(govtId);
		}

		if (nationality == null) {
			doctorImpl.setNationality("");
		}
		else {
			doctorImpl.setNationality(nationality);
		}

		if (payGroup == null) {
			doctorImpl.setPayGroup("");
		}
		else {
			doctorImpl.setPayGroup(payGroup);
		}

		if (email == null) {
			doctorImpl.setEmail("");
		}
		else {
			doctorImpl.setEmail(email);
		}

		if (contactNumber == null) {
			doctorImpl.setContactNumber("");
		}
		else {
			doctorImpl.setContactNumber(contactNumber);
		}

		doctorImpl.resetOriginalValues();

		return doctorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();

		groupId = objectInput.readLong();
		surname = objectInput.readUTF();
		firstName = objectInput.readUTF();
		department = objectInput.readUTF();
		govtId = objectInput.readUTF();
		nationality = objectInput.readUTF();
		payGroup = objectInput.readUTF();
		email = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeId);

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

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (govtId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(govtId);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (payGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(payGroup);
		}

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
	}

	public long employeeId;
	public long groupId;
	public String surname;
	public String firstName;
	public String department;
	public String govtId;
	public String nationality;
	public String payGroup;
	public String email;
	public String contactNumber;

}