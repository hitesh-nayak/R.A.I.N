package com.liferay.rain.rest.client.dto.v1_0;

import com.liferay.rain.rest.client.function.UnsafeSupplier;
import com.liferay.rain.rest.client.serdes.v1_0.PatientSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Patient implements Cloneable, Serializable {

	public static Patient toDTO(String json) {
		return PatientSerDes.toDTO(json);
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public void setAge(UnsafeSupplier<Long, Exception> ageUnsafeSupplier) {
		try {
			age = ageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long age;

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setContactNumber(
		UnsafeSupplier<String, Exception> contactNumberUnsafeSupplier) {

		try {
			contactNumber = contactNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String contactNumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(
		UnsafeSupplier<String, Exception> firstNameUnsafeSupplier) {

		try {
			firstName = firstNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String firstName;

	public String getGovtId() {
		return govtId;
	}

	public void setGovtId(String govtId) {
		this.govtId = govtId;
	}

	public void setGovtId(
		UnsafeSupplier<String, Exception> govtIdUnsafeSupplier) {

		try {
			govtId = govtIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String govtId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long groupId;

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public void setInsuranceId(
		UnsafeSupplier<String, Exception> insuranceIdUnsafeSupplier) {

		try {
			insuranceId = insuranceIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String insuranceId;

	public Boolean getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(Boolean isAdult) {
		this.isAdult = isAdult;
	}

	public void setIsAdult(
		UnsafeSupplier<Boolean, Exception> isAdultUnsafeSupplier) {

		try {
			isAdult = isAdultUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isAdult;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setNationality(
		UnsafeSupplier<String, Exception> nationalityUnsafeSupplier) {

		try {
			nationality = nationalityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String nationality;

	public Long getPrimaryDoctor() {
		return primaryDoctor;
	}

	public void setPrimaryDoctor(Long primaryDoctor) {
		this.primaryDoctor = primaryDoctor;
	}

	public void setPrimaryDoctor(
		UnsafeSupplier<Long, Exception> primaryDoctorUnsafeSupplier) {

		try {
			primaryDoctor = primaryDoctorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long primaryDoctor;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setSurname(
		UnsafeSupplier<String, Exception> surnameUnsafeSupplier) {

		try {
			surname = surnameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String surname;

	@Override
	public Patient clone() throws CloneNotSupportedException {
		return (Patient)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Patient)) {
			return false;
		}

		Patient patient = (Patient)object;

		return Objects.equals(toString(), patient.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PatientSerDes.toJSON(this);
	}

}