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

package com.liferay.rain.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.rain.service.exception.NoSuchPatientException;
import com.liferay.rain.service.model.Patient;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientUtil
 * @generated
 */
@ProviderType
public interface PatientPersistence extends BasePersistence<Patient> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatientUtil} to access the patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the patients where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the matching patients
	 */
	public java.util.List<Patient> findBySurname(String surname);

	/**
	 * Returns a range of all the patients where surname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param surname the surname
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findBySurname(
		String surname, int start, int end);

	/**
	 * Returns an ordered range of all the patients where surname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param surname the surname
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findBySurname(
		String surname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where surname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param surname the surname
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findBySurname(
		String surname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findBySurname_First(
			String surname,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchBySurname_First(
		String surname,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findBySurname_Last(
			String surname,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchBySurname_Last(
		String surname,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where surname = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findBySurname_PrevAndNext(
			long govtId, String surname,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where surname = &#63; from the database.
	 *
	 * @param surname the surname
	 */
	public void removeBySurname(String surname);

	/**
	 * Returns the number of patients where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the number of matching patients
	 */
	public int countBySurname(String surname);

	/**
	 * Returns the patient where govtId = &#63; or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param govtId the govt ID
	 * @return the matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByGovtId(long govtId) throws NoSuchPatientException;

	/**
	 * Returns the patient where govtId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param govtId the govt ID
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByGovtId(long govtId);

	/**
	 * Returns the patient where govtId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param govtId the govt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByGovtId(long govtId, boolean useFinderCache);

	/**
	 * Removes the patient where govtId = &#63; from the database.
	 *
	 * @param govtId the govt ID
	 * @return the patient that was removed
	 */
	public Patient removeByGovtId(long govtId) throws NoSuchPatientException;

	/**
	 * Returns the number of patients where govtId = &#63;.
	 *
	 * @param govtId the govt ID
	 * @return the number of matching patients
	 */
	public int countByGovtId(long govtId);

	/**
	 * Returns all the patients where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByNationality(String nationality);

	/**
	 * Returns a range of all the patients where nationality = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param nationality the nationality
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findByNationality(
		String nationality, int start, int end);

	/**
	 * Returns an ordered range of all the patients where nationality = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param nationality the nationality
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByNationality(
		String nationality, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where nationality = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param nationality the nationality
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByNationality(
		String nationality, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByNationality_First(
			String nationality,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByNationality_First(
		String nationality,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByNationality_Last(
			String nationality,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByNationality_Last(
		String nationality,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where nationality = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByNationality_PrevAndNext(
			long govtId, String nationality,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where nationality = &#63; from the database.
	 *
	 * @param nationality the nationality
	 */
	public void removeByNationality(String nationality);

	/**
	 * Returns the number of patients where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the number of matching patients
	 */
	public int countByNationality(String nationality);

	/**
	 * Returns all the patients where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByInsuranceId(String insuranceId);

	/**
	 * Returns a range of all the patients where insuranceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param insuranceId the insurance ID
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findByInsuranceId(
		String insuranceId, int start, int end);

	/**
	 * Returns an ordered range of all the patients where insuranceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param insuranceId the insurance ID
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByInsuranceId(
		String insuranceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where insuranceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param insuranceId the insurance ID
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByInsuranceId(
		String insuranceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByInsuranceId_First(
			String insuranceId,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByInsuranceId_First(
		String insuranceId,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByInsuranceId_Last(
			String insuranceId,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByInsuranceId_Last(
		String insuranceId,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByInsuranceId_PrevAndNext(
			long govtId, String insuranceId,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where insuranceId = &#63; from the database.
	 *
	 * @param insuranceId the insurance ID
	 */
	public void removeByInsuranceId(String insuranceId);

	/**
	 * Returns the number of patients where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @return the number of matching patients
	 */
	public int countByInsuranceId(String insuranceId);

	/**
	 * Returns all the patients where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByContactNumber(String contactNumber);

	/**
	 * Returns a range of all the patients where contactNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param contactNumber the contact number
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findByContactNumber(
		String contactNumber, int start, int end);

	/**
	 * Returns an ordered range of all the patients where contactNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param contactNumber the contact number
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByContactNumber(
		String contactNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where contactNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param contactNumber the contact number
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByContactNumber(
		String contactNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByContactNumber_First(
			String contactNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByContactNumber_First(
		String contactNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByContactNumber_Last(
			String contactNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByContactNumber_Last(
		String contactNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByContactNumber_PrevAndNext(
			long govtId, String contactNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 */
	public void removeByContactNumber(String contactNumber);

	/**
	 * Returns the number of patients where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching patients
	 */
	public int countByContactNumber(String contactNumber);

	/**
	 * Returns all the patients where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByEmail(String email);

	/**
	 * Returns a range of all the patients where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findByEmail(
		String email, int start, int end);

	/**
	 * Returns an ordered range of all the patients where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByEmail(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByEmail_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByEmail_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByEmail_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByEmail_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where email = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByEmail_PrevAndNext(
			long govtId, String email,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByEmail(String email);

	/**
	 * Returns the number of patients where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching patients
	 */
	public int countByEmail(String email);

	/**
	 * Returns all the patients where age = &#63;.
	 *
	 * @param age the age
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByAge(long age);

	/**
	 * Returns a range of all the patients where age = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param age the age
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findByAge(long age, int start, int end);

	/**
	 * Returns an ordered range of all the patients where age = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param age the age
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByAge(
		long age, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where age = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param age the age
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByAge(
		long age, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByAge_First(
			long age,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByAge_First(
		long age,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByAge_Last(
			long age,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByAge_Last(
		long age,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where age = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByAge_PrevAndNext(
			long govtId, long age,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where age = &#63; from the database.
	 *
	 * @param age the age
	 */
	public void removeByAge(long age);

	/**
	 * Returns the number of patients where age = &#63;.
	 *
	 * @param age the age
	 * @return the number of matching patients
	 */
	public int countByAge(long age);

	/**
	 * Returns all the patients where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @return the matching patients
	 */
	public java.util.List<Patient> findByPrimaryDoctor(long primaryDoctor);

	/**
	 * Returns a range of all the patients where primaryDoctor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param primaryDoctor the primary doctor
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of matching patients
	 */
	public java.util.List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end);

	/**
	 * Returns an ordered range of all the patients where primaryDoctor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param primaryDoctor the primary doctor
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients where primaryDoctor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param primaryDoctor the primary doctor
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patients
	 */
	public java.util.List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByPrimaryDoctor_First(
			long primaryDoctor,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the first patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByPrimaryDoctor_First(
		long primaryDoctor,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the last patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public Patient findByPrimaryDoctor_Last(
			long primaryDoctor,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Returns the last patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public Patient fetchByPrimaryDoctor_Last(
		long primaryDoctor,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns the patients before and after the current patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient[] findByPrimaryDoctor_PrevAndNext(
			long govtId, long primaryDoctor,
			com.liferay.portal.kernel.util.OrderByComparator<Patient>
				orderByComparator)
		throws NoSuchPatientException;

	/**
	 * Removes all the patients where primaryDoctor = &#63; from the database.
	 *
	 * @param primaryDoctor the primary doctor
	 */
	public void removeByPrimaryDoctor(long primaryDoctor);

	/**
	 * Returns the number of patients where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @return the number of matching patients
	 */
	public int countByPrimaryDoctor(long primaryDoctor);

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	public void cacheResult(Patient patient);

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	public void cacheResult(java.util.List<Patient> patients);

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param govtId the primary key for the new patient
	 * @return the new patient
	 */
	public Patient create(long govtId);

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient that was removed
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient remove(long govtId) throws NoSuchPatientException;

	public Patient updateImpl(Patient patient);

	/**
	 * Returns the patient with the primary key or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public Patient findByPrimaryKey(long govtId) throws NoSuchPatientException;

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 */
	public Patient fetchByPrimaryKey(long govtId);

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 */
	public java.util.List<Patient> findAll();

	/**
	 * Returns a range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of patients
	 */
	public java.util.List<Patient> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patients
	 */
	public java.util.List<Patient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator);

	/**
	 * Returns an ordered range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patients
	 */
	public java.util.List<Patient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Patient>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the patients from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	public int countAll();

}