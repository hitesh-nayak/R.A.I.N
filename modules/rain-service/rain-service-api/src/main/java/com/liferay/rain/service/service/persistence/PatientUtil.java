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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.rain.service.model.Patient;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the patient service. This utility wraps <code>com.liferay.rain.service.service.persistence.impl.PatientPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientPersistence
 * @generated
 */
public class PatientUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Patient patient) {
		getPersistence().clearCache(patient);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Patient> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Patient update(Patient patient) {
		return getPersistence().update(patient);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Patient update(
		Patient patient, ServiceContext serviceContext) {

		return getPersistence().update(patient, serviceContext);
	}

	/**
	 * Returns all the patients where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the matching patients
	 */
	public static List<Patient> findBySurname(String surname) {
		return getPersistence().findBySurname(surname);
	}

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
	public static List<Patient> findBySurname(
		String surname, int start, int end) {

		return getPersistence().findBySurname(surname, start, end);
	}

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
	public static List<Patient> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findBySurname(
			surname, start, end, orderByComparator);
	}

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
	public static List<Patient> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySurname(
			surname, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findBySurname_First(
			String surname, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findBySurname_First(surname, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchBySurname_First(
		String surname, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchBySurname_First(
			surname, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findBySurname_Last(
			String surname, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findBySurname_Last(surname, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchBySurname_Last(
		String surname, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchBySurname_Last(surname, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where surname = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findBySurname_PrevAndNext(
			long govtId, String surname,
			OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findBySurname_PrevAndNext(
			govtId, surname, orderByComparator);
	}

	/**
	 * Removes all the patients where surname = &#63; from the database.
	 *
	 * @param surname the surname
	 */
	public static void removeBySurname(String surname) {
		getPersistence().removeBySurname(surname);
	}

	/**
	 * Returns the number of patients where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the number of matching patients
	 */
	public static int countBySurname(String surname) {
		return getPersistence().countBySurname(surname);
	}

	/**
	 * Returns the patient where govtId = &#63; or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param govtId the govt ID
	 * @return the matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByGovtId(long govtId)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByGovtId(govtId);
	}

	/**
	 * Returns the patient where govtId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param govtId the govt ID
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByGovtId(long govtId) {
		return getPersistence().fetchByGovtId(govtId);
	}

	/**
	 * Returns the patient where govtId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param govtId the govt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByGovtId(long govtId, boolean useFinderCache) {
		return getPersistence().fetchByGovtId(govtId, useFinderCache);
	}

	/**
	 * Removes the patient where govtId = &#63; from the database.
	 *
	 * @param govtId the govt ID
	 * @return the patient that was removed
	 */
	public static Patient removeByGovtId(long govtId)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().removeByGovtId(govtId);
	}

	/**
	 * Returns the number of patients where govtId = &#63;.
	 *
	 * @param govtId the govt ID
	 * @return the number of matching patients
	 */
	public static int countByGovtId(long govtId) {
		return getPersistence().countByGovtId(govtId);
	}

	/**
	 * Returns all the patients where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the matching patients
	 */
	public static List<Patient> findByNationality(String nationality) {
		return getPersistence().findByNationality(nationality);
	}

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
	public static List<Patient> findByNationality(
		String nationality, int start, int end) {

		return getPersistence().findByNationality(nationality, start, end);
	}

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
	public static List<Patient> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByNationality(
			nationality, start, end, orderByComparator);
	}

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
	public static List<Patient> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNationality(
			nationality, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByNationality_First(
			String nationality, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByNationality_First(
			nationality, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByNationality_First(
		String nationality, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByNationality_First(
			nationality, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByNationality_Last(
			String nationality, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByNationality_Last(
			nationality, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByNationality_Last(
		String nationality, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByNationality_Last(
			nationality, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where nationality = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByNationality_PrevAndNext(
			long govtId, String nationality,
			OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByNationality_PrevAndNext(
			govtId, nationality, orderByComparator);
	}

	/**
	 * Removes all the patients where nationality = &#63; from the database.
	 *
	 * @param nationality the nationality
	 */
	public static void removeByNationality(String nationality) {
		getPersistence().removeByNationality(nationality);
	}

	/**
	 * Returns the number of patients where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the number of matching patients
	 */
	public static int countByNationality(String nationality) {
		return getPersistence().countByNationality(nationality);
	}

	/**
	 * Returns all the patients where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @return the matching patients
	 */
	public static List<Patient> findByInsuranceId(String insuranceId) {
		return getPersistence().findByInsuranceId(insuranceId);
	}

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
	public static List<Patient> findByInsuranceId(
		String insuranceId, int start, int end) {

		return getPersistence().findByInsuranceId(insuranceId, start, end);
	}

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
	public static List<Patient> findByInsuranceId(
		String insuranceId, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByInsuranceId(
			insuranceId, start, end, orderByComparator);
	}

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
	public static List<Patient> findByInsuranceId(
		String insuranceId, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByInsuranceId(
			insuranceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByInsuranceId_First(
			String insuranceId, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByInsuranceId_First(
			insuranceId, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByInsuranceId_First(
		String insuranceId, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByInsuranceId_First(
			insuranceId, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByInsuranceId_Last(
			String insuranceId, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByInsuranceId_Last(
			insuranceId, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByInsuranceId_Last(
		String insuranceId, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByInsuranceId_Last(
			insuranceId, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByInsuranceId_PrevAndNext(
			long govtId, String insuranceId,
			OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByInsuranceId_PrevAndNext(
			govtId, insuranceId, orderByComparator);
	}

	/**
	 * Removes all the patients where insuranceId = &#63; from the database.
	 *
	 * @param insuranceId the insurance ID
	 */
	public static void removeByInsuranceId(String insuranceId) {
		getPersistence().removeByInsuranceId(insuranceId);
	}

	/**
	 * Returns the number of patients where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @return the number of matching patients
	 */
	public static int countByInsuranceId(String insuranceId) {
		return getPersistence().countByInsuranceId(insuranceId);
	}

	/**
	 * Returns all the patients where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the matching patients
	 */
	public static List<Patient> findByContactNumber(String contactNumber) {
		return getPersistence().findByContactNumber(contactNumber);
	}

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
	public static List<Patient> findByContactNumber(
		String contactNumber, int start, int end) {

		return getPersistence().findByContactNumber(contactNumber, start, end);
	}

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
	public static List<Patient> findByContactNumber(
		String contactNumber, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByContactNumber(
			contactNumber, start, end, orderByComparator);
	}

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
	public static List<Patient> findByContactNumber(
		String contactNumber, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByContactNumber(
			contactNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByContactNumber_First(
			String contactNumber, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByContactNumber_First(
			contactNumber, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByContactNumber_First(
		String contactNumber, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByContactNumber_First(
			contactNumber, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByContactNumber_Last(
			String contactNumber, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByContactNumber_Last(
			contactNumber, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByContactNumber_Last(
		String contactNumber, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByContactNumber_Last(
			contactNumber, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByContactNumber_PrevAndNext(
			long govtId, String contactNumber,
			OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByContactNumber_PrevAndNext(
			govtId, contactNumber, orderByComparator);
	}

	/**
	 * Removes all the patients where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 */
	public static void removeByContactNumber(String contactNumber) {
		getPersistence().removeByContactNumber(contactNumber);
	}

	/**
	 * Returns the number of patients where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching patients
	 */
	public static int countByContactNumber(String contactNumber) {
		return getPersistence().countByContactNumber(contactNumber);
	}

	/**
	 * Returns all the patients where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching patients
	 */
	public static List<Patient> findByEmail(String email) {
		return getPersistence().findByEmail(email);
	}

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
	public static List<Patient> findByEmail(String email, int start, int end) {
		return getPersistence().findByEmail(email, start, end);
	}

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
	public static List<Patient> findByEmail(
		String email, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator);
	}

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
	public static List<Patient> findByEmail(
		String email, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmail(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByEmail_First(
			String email, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByEmail_First(
		String email, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByEmail_First(email, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByEmail_Last(
			String email, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByEmail_Last(
		String email, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByEmail_Last(email, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where email = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByEmail_PrevAndNext(
			long govtId, String email,
			OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByEmail_PrevAndNext(
			govtId, email, orderByComparator);
	}

	/**
	 * Removes all the patients where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByEmail(String email) {
		getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of patients where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching patients
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns all the patients where age = &#63;.
	 *
	 * @param age the age
	 * @return the matching patients
	 */
	public static List<Patient> findByAge(long age) {
		return getPersistence().findByAge(age);
	}

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
	public static List<Patient> findByAge(long age, int start, int end) {
		return getPersistence().findByAge(age, start, end);
	}

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
	public static List<Patient> findByAge(
		long age, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByAge(age, start, end, orderByComparator);
	}

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
	public static List<Patient> findByAge(
		long age, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAge(
			age, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByAge_First(
			long age, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByAge_First(age, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByAge_First(
		long age, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByAge_First(age, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByAge_Last(
			long age, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByAge_Last(age, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByAge_Last(
		long age, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByAge_Last(age, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where age = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByAge_PrevAndNext(
			long govtId, long age, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByAge_PrevAndNext(
			govtId, age, orderByComparator);
	}

	/**
	 * Removes all the patients where age = &#63; from the database.
	 *
	 * @param age the age
	 */
	public static void removeByAge(long age) {
		getPersistence().removeByAge(age);
	}

	/**
	 * Returns the number of patients where age = &#63;.
	 *
	 * @param age the age
	 * @return the number of matching patients
	 */
	public static int countByAge(long age) {
		return getPersistence().countByAge(age);
	}

	/**
	 * Returns all the patients where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @return the matching patients
	 */
	public static List<Patient> findByPrimaryDoctor(long primaryDoctor) {
		return getPersistence().findByPrimaryDoctor(primaryDoctor);
	}

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
	public static List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end) {

		return getPersistence().findByPrimaryDoctor(primaryDoctor, start, end);
	}

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
	public static List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findByPrimaryDoctor(
			primaryDoctor, start, end, orderByComparator);
	}

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
	public static List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPrimaryDoctor(
			primaryDoctor, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByPrimaryDoctor_First(
			long primaryDoctor, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByPrimaryDoctor_First(
			primaryDoctor, orderByComparator);
	}

	/**
	 * Returns the first patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByPrimaryDoctor_First(
		long primaryDoctor, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByPrimaryDoctor_First(
			primaryDoctor, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	public static Patient findByPrimaryDoctor_Last(
			long primaryDoctor, OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByPrimaryDoctor_Last(
			primaryDoctor, orderByComparator);
	}

	/**
	 * Returns the last patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	public static Patient fetchByPrimaryDoctor_Last(
		long primaryDoctor, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().fetchByPrimaryDoctor_Last(
			primaryDoctor, orderByComparator);
	}

	/**
	 * Returns the patients before and after the current patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param govtId the primary key of the current patient
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient[] findByPrimaryDoctor_PrevAndNext(
			long govtId, long primaryDoctor,
			OrderByComparator<Patient> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByPrimaryDoctor_PrevAndNext(
			govtId, primaryDoctor, orderByComparator);
	}

	/**
	 * Removes all the patients where primaryDoctor = &#63; from the database.
	 *
	 * @param primaryDoctor the primary doctor
	 */
	public static void removeByPrimaryDoctor(long primaryDoctor) {
		getPersistence().removeByPrimaryDoctor(primaryDoctor);
	}

	/**
	 * Returns the number of patients where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @return the number of matching patients
	 */
	public static int countByPrimaryDoctor(long primaryDoctor) {
		return getPersistence().countByPrimaryDoctor(primaryDoctor);
	}

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	public static void cacheResult(Patient patient) {
		getPersistence().cacheResult(patient);
	}

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	public static void cacheResult(List<Patient> patients) {
		getPersistence().cacheResult(patients);
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param govtId the primary key for the new patient
	 * @return the new patient
	 */
	public static Patient create(long govtId) {
		return getPersistence().create(govtId);
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient that was removed
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient remove(long govtId)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().remove(govtId);
	}

	public static Patient updateImpl(Patient patient) {
		return getPersistence().updateImpl(patient);
	}

	/**
	 * Returns the patient with the primary key or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	public static Patient findByPrimaryKey(long govtId)
		throws com.liferay.rain.service.exception.NoSuchPatientException {

		return getPersistence().findByPrimaryKey(govtId);
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 */
	public static Patient fetchByPrimaryKey(long govtId) {
		return getPersistence().fetchByPrimaryKey(govtId);
	}

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 */
	public static List<Patient> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Patient> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Patient> findAll(
		int start, int end, OrderByComparator<Patient> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Patient> findAll(
		int start, int end, OrderByComparator<Patient> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the patients from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PatientPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PatientPersistence _persistence;

}