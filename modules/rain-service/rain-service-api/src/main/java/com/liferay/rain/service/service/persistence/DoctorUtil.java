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
import com.liferay.rain.service.model.Doctor;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the doctor service. This utility wraps <code>com.liferay.rain.service.service.persistence.impl.DoctorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctorPersistence
 * @generated
 */
public class DoctorUtil {

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
	public static void clearCache(Doctor doctor) {
		getPersistence().clearCache(doctor);
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
	public static Map<Serializable, Doctor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Doctor> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Doctor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Doctor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Doctor update(Doctor doctor) {
		return getPersistence().update(doctor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Doctor update(Doctor doctor, ServiceContext serviceContext) {
		return getPersistence().update(doctor, serviceContext);
	}

	/**
	 * Returns all the doctors where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the matching doctors
	 */
	public static List<Doctor> findBySurname(String surname) {
		return getPersistence().findBySurname(surname);
	}

	/**
	 * Returns a range of all the doctors where surname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param surname the surname
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @return the range of matching doctors
	 */
	public static List<Doctor> findBySurname(
		String surname, int start, int end) {

		return getPersistence().findBySurname(surname, start, end);
	}

	/**
	 * Returns an ordered range of all the doctors where surname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param surname the surname
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().findBySurname(
			surname, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doctors where surname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param surname the surname
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySurname(
			surname, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findBySurname_First(
			String surname, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findBySurname_First(surname, orderByComparator);
	}

	/**
	 * Returns the first doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchBySurname_First(
		String surname, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchBySurname_First(
			surname, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findBySurname_Last(
			String surname, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findBySurname_Last(surname, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchBySurname_Last(
		String surname, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchBySurname_Last(surname, orderByComparator);
	}

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where surname = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public static Doctor[] findBySurname_PrevAndNext(
			long employeeId, String surname,
			OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findBySurname_PrevAndNext(
			employeeId, surname, orderByComparator);
	}

	/**
	 * Removes all the doctors where surname = &#63; from the database.
	 *
	 * @param surname the surname
	 */
	public static void removeBySurname(String surname) {
		getPersistence().removeBySurname(surname);
	}

	/**
	 * Returns the number of doctors where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the number of matching doctors
	 */
	public static int countBySurname(String surname) {
		return getPersistence().countBySurname(surname);
	}

	/**
	 * Returns the doctor where employeeId = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByEmployeeId(long employeeId)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the doctor where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the doctor where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the doctor where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the doctor that was removed
	 */
	public static Doctor removeByEmployeeId(long employeeId)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of doctors where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching doctors
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the doctors where department = &#63;.
	 *
	 * @param department the department
	 * @return the matching doctors
	 */
	public static List<Doctor> findByDepartment(String department) {
		return getPersistence().findByDepartment(department);
	}

	/**
	 * Returns a range of all the doctors where department = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param department the department
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @return the range of matching doctors
	 */
	public static List<Doctor> findByDepartment(
		String department, int start, int end) {

		return getPersistence().findByDepartment(department, start, end);
	}

	/**
	 * Returns an ordered range of all the doctors where department = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param department the department
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findByDepartment(
		String department, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().findByDepartment(
			department, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doctors where department = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param department the department
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findByDepartment(
		String department, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDepartment(
			department, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByDepartment_First(
			String department, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByDepartment_First(
			department, orderByComparator);
	}

	/**
	 * Returns the first doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByDepartment_First(
		String department, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchByDepartment_First(
			department, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByDepartment_Last(
			String department, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByDepartment_Last(
			department, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByDepartment_Last(
		String department, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchByDepartment_Last(
			department, orderByComparator);
	}

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where department = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public static Doctor[] findByDepartment_PrevAndNext(
			long employeeId, String department,
			OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByDepartment_PrevAndNext(
			employeeId, department, orderByComparator);
	}

	/**
	 * Removes all the doctors where department = &#63; from the database.
	 *
	 * @param department the department
	 */
	public static void removeByDepartment(String department) {
		getPersistence().removeByDepartment(department);
	}

	/**
	 * Returns the number of doctors where department = &#63;.
	 *
	 * @param department the department
	 * @return the number of matching doctors
	 */
	public static int countByDepartment(String department) {
		return getPersistence().countByDepartment(department);
	}

	/**
	 * Returns all the doctors where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @return the matching doctors
	 */
	public static List<Doctor> findByPayGroup(String payGroup) {
		return getPersistence().findByPayGroup(payGroup);
	}

	/**
	 * Returns a range of all the doctors where payGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param payGroup the pay group
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @return the range of matching doctors
	 */
	public static List<Doctor> findByPayGroup(
		String payGroup, int start, int end) {

		return getPersistence().findByPayGroup(payGroup, start, end);
	}

	/**
	 * Returns an ordered range of all the doctors where payGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param payGroup the pay group
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findByPayGroup(
		String payGroup, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().findByPayGroup(
			payGroup, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doctors where payGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param payGroup the pay group
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findByPayGroup(
		String payGroup, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPayGroup(
			payGroup, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByPayGroup_First(
			String payGroup, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByPayGroup_First(
			payGroup, orderByComparator);
	}

	/**
	 * Returns the first doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByPayGroup_First(
		String payGroup, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchByPayGroup_First(
			payGroup, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByPayGroup_Last(
			String payGroup, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByPayGroup_Last(
			payGroup, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByPayGroup_Last(
		String payGroup, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchByPayGroup_Last(
			payGroup, orderByComparator);
	}

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public static Doctor[] findByPayGroup_PrevAndNext(
			long employeeId, String payGroup,
			OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByPayGroup_PrevAndNext(
			employeeId, payGroup, orderByComparator);
	}

	/**
	 * Removes all the doctors where payGroup = &#63; from the database.
	 *
	 * @param payGroup the pay group
	 */
	public static void removeByPayGroup(String payGroup) {
		getPersistence().removeByPayGroup(payGroup);
	}

	/**
	 * Returns the number of doctors where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @return the number of matching doctors
	 */
	public static int countByPayGroup(String payGroup) {
		return getPersistence().countByPayGroup(payGroup);
	}

	/**
	 * Returns all the doctors where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the matching doctors
	 */
	public static List<Doctor> findByNationality(String nationality) {
		return getPersistence().findByNationality(nationality);
	}

	/**
	 * Returns a range of all the doctors where nationality = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param nationality the nationality
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @return the range of matching doctors
	 */
	public static List<Doctor> findByNationality(
		String nationality, int start, int end) {

		return getPersistence().findByNationality(nationality, start, end);
	}

	/**
	 * Returns an ordered range of all the doctors where nationality = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param nationality the nationality
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().findByNationality(
			nationality, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doctors where nationality = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param nationality the nationality
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctors
	 */
	public static List<Doctor> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNationality(
			nationality, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByNationality_First(
			String nationality, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByNationality_First(
			nationality, orderByComparator);
	}

	/**
	 * Returns the first doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByNationality_First(
		String nationality, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchByNationality_First(
			nationality, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByNationality_Last(
			String nationality, OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByNationality_Last(
			nationality, orderByComparator);
	}

	/**
	 * Returns the last doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByNationality_Last(
		String nationality, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().fetchByNationality_Last(
			nationality, orderByComparator);
	}

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where nationality = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public static Doctor[] findByNationality_PrevAndNext(
			long employeeId, String nationality,
			OrderByComparator<Doctor> orderByComparator)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByNationality_PrevAndNext(
			employeeId, nationality, orderByComparator);
	}

	/**
	 * Removes all the doctors where nationality = &#63; from the database.
	 *
	 * @param nationality the nationality
	 */
	public static void removeByNationality(String nationality) {
		getPersistence().removeByNationality(nationality);
	}

	/**
	 * Returns the number of doctors where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the number of matching doctors
	 */
	public static int countByNationality(String nationality) {
		return getPersistence().countByNationality(nationality);
	}

	/**
	 * Returns the doctor where govtId = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param govtId the govt ID
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByGovtId(String govtId)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByGovtId(govtId);
	}

	/**
	 * Returns the doctor where govtId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param govtId the govt ID
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByGovtId(String govtId) {
		return getPersistence().fetchByGovtId(govtId);
	}

	/**
	 * Returns the doctor where govtId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param govtId the govt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByGovtId(String govtId, boolean useFinderCache) {
		return getPersistence().fetchByGovtId(govtId, useFinderCache);
	}

	/**
	 * Removes the doctor where govtId = &#63; from the database.
	 *
	 * @param govtId the govt ID
	 * @return the doctor that was removed
	 */
	public static Doctor removeByGovtId(String govtId)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().removeByGovtId(govtId);
	}

	/**
	 * Returns the number of doctors where govtId = &#63;.
	 *
	 * @param govtId the govt ID
	 * @return the number of matching doctors
	 */
	public static int countByGovtId(String govtId) {
		return getPersistence().countByGovtId(govtId);
	}

	/**
	 * Returns the doctor where email = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByEmail(String email)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns the doctor where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByEmail(String email) {
		return getPersistence().fetchByEmail(email);
	}

	/**
	 * Returns the doctor where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByEmail(String email, boolean useFinderCache) {
		return getPersistence().fetchByEmail(email, useFinderCache);
	}

	/**
	 * Removes the doctor where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the doctor that was removed
	 */
	public static Doctor removeByEmail(String email)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of doctors where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching doctors
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns the doctor where contactNumber = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param contactNumber the contact number
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public static Doctor findByContactNumber(String contactNumber)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByContactNumber(contactNumber);
	}

	/**
	 * Returns the doctor where contactNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByContactNumber(String contactNumber) {
		return getPersistence().fetchByContactNumber(contactNumber);
	}

	/**
	 * Returns the doctor where contactNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public static Doctor fetchByContactNumber(
		String contactNumber, boolean useFinderCache) {

		return getPersistence().fetchByContactNumber(
			contactNumber, useFinderCache);
	}

	/**
	 * Removes the doctor where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 * @return the doctor that was removed
	 */
	public static Doctor removeByContactNumber(String contactNumber)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().removeByContactNumber(contactNumber);
	}

	/**
	 * Returns the number of doctors where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching doctors
	 */
	public static int countByContactNumber(String contactNumber) {
		return getPersistence().countByContactNumber(contactNumber);
	}

	/**
	 * Caches the doctor in the entity cache if it is enabled.
	 *
	 * @param doctor the doctor
	 */
	public static void cacheResult(Doctor doctor) {
		getPersistence().cacheResult(doctor);
	}

	/**
	 * Caches the doctors in the entity cache if it is enabled.
	 *
	 * @param doctors the doctors
	 */
	public static void cacheResult(List<Doctor> doctors) {
		getPersistence().cacheResult(doctors);
	}

	/**
	 * Creates a new doctor with the primary key. Does not add the doctor to the database.
	 *
	 * @param employeeId the primary key for the new doctor
	 * @return the new doctor
	 */
	public static Doctor create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the doctor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor that was removed
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public static Doctor remove(long employeeId)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().remove(employeeId);
	}

	public static Doctor updateImpl(Doctor doctor) {
		return getPersistence().updateImpl(doctor);
	}

	/**
	 * Returns the doctor with the primary key or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public static Doctor findByPrimaryKey(long employeeId)
		throws com.liferay.rain.service.exception.NoSuchDoctorException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the doctor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor, or <code>null</code> if a doctor with the primary key could not be found
	 */
	public static Doctor fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the doctors.
	 *
	 * @return the doctors
	 */
	public static List<Doctor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the doctors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @return the range of doctors
	 */
	public static List<Doctor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the doctors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doctors
	 */
	public static List<Doctor> findAll(
		int start, int end, OrderByComparator<Doctor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doctors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctors
	 * @param end the upper bound of the range of doctors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of doctors
	 */
	public static List<Doctor> findAll(
		int start, int end, OrderByComparator<Doctor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the doctors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of doctors.
	 *
	 * @return the number of doctors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DoctorPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DoctorPersistence _persistence;

}