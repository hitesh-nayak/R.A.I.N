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
import com.liferay.rain.service.exception.NoSuchDoctorException;
import com.liferay.rain.service.model.Doctor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the doctor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctorUtil
 * @generated
 */
@ProviderType
public interface DoctorPersistence extends BasePersistence<Doctor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoctorUtil} to access the doctor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the doctors where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the matching doctors
	 */
	public java.util.List<Doctor> findBySurname(String surname);

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
	public java.util.List<Doctor> findBySurname(
		String surname, int start, int end);

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
	public java.util.List<Doctor> findBySurname(
		String surname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

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
	public java.util.List<Doctor> findBySurname(
		String surname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findBySurname_First(
			String surname,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the first doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchBySurname_First(
		String surname,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the last doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findBySurname_Last(
			String surname,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the last doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchBySurname_Last(
		String surname,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where surname = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public Doctor[] findBySurname_PrevAndNext(
			long employeeId, String surname,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Removes all the doctors where surname = &#63; from the database.
	 *
	 * @param surname the surname
	 */
	public void removeBySurname(String surname);

	/**
	 * Returns the number of doctors where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the number of matching doctors
	 */
	public int countBySurname(String surname);

	/**
	 * Returns the doctor where employeeId = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByEmployeeId(long employeeId)
		throws NoSuchDoctorException;

	/**
	 * Returns the doctor where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByEmployeeId(long employeeId);

	/**
	 * Returns the doctor where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByEmployeeId(long employeeId, boolean useFinderCache);

	/**
	 * Removes the doctor where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the doctor that was removed
	 */
	public Doctor removeByEmployeeId(long employeeId)
		throws NoSuchDoctorException;

	/**
	 * Returns the number of doctors where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching doctors
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the doctors where department = &#63;.
	 *
	 * @param department the department
	 * @return the matching doctors
	 */
	public java.util.List<Doctor> findByDepartment(String department);

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
	public java.util.List<Doctor> findByDepartment(
		String department, int start, int end);

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
	public java.util.List<Doctor> findByDepartment(
		String department, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

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
	public java.util.List<Doctor> findByDepartment(
		String department, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByDepartment_First(
			String department,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the first doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByDepartment_First(
		String department,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the last doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByDepartment_Last(
			String department,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the last doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByDepartment_Last(
		String department,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where department = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public Doctor[] findByDepartment_PrevAndNext(
			long employeeId, String department,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Removes all the doctors where department = &#63; from the database.
	 *
	 * @param department the department
	 */
	public void removeByDepartment(String department);

	/**
	 * Returns the number of doctors where department = &#63;.
	 *
	 * @param department the department
	 * @return the number of matching doctors
	 */
	public int countByDepartment(String department);

	/**
	 * Returns all the doctors where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @return the matching doctors
	 */
	public java.util.List<Doctor> findByPayGroup(String payGroup);

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
	public java.util.List<Doctor> findByPayGroup(
		String payGroup, int start, int end);

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
	public java.util.List<Doctor> findByPayGroup(
		String payGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

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
	public java.util.List<Doctor> findByPayGroup(
		String payGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByPayGroup_First(
			String payGroup,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the first doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByPayGroup_First(
		String payGroup,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the last doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByPayGroup_Last(
			String payGroup,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the last doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByPayGroup_Last(
		String payGroup,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public Doctor[] findByPayGroup_PrevAndNext(
			long employeeId, String payGroup,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Removes all the doctors where payGroup = &#63; from the database.
	 *
	 * @param payGroup the pay group
	 */
	public void removeByPayGroup(String payGroup);

	/**
	 * Returns the number of doctors where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @return the number of matching doctors
	 */
	public int countByPayGroup(String payGroup);

	/**
	 * Returns all the doctors where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the matching doctors
	 */
	public java.util.List<Doctor> findByNationality(String nationality);

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
	public java.util.List<Doctor> findByNationality(
		String nationality, int start, int end);

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
	public java.util.List<Doctor> findByNationality(
		String nationality, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

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
	public java.util.List<Doctor> findByNationality(
		String nationality, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByNationality_First(
			String nationality,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the first doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByNationality_First(
		String nationality,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the last doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByNationality_Last(
			String nationality,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Returns the last doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByNationality_Last(
		String nationality,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

	/**
	 * Returns the doctors before and after the current doctor in the ordered set where nationality = &#63;.
	 *
	 * @param employeeId the primary key of the current doctor
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public Doctor[] findByNationality_PrevAndNext(
			long employeeId, String nationality,
			com.liferay.portal.kernel.util.OrderByComparator<Doctor>
				orderByComparator)
		throws NoSuchDoctorException;

	/**
	 * Removes all the doctors where nationality = &#63; from the database.
	 *
	 * @param nationality the nationality
	 */
	public void removeByNationality(String nationality);

	/**
	 * Returns the number of doctors where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the number of matching doctors
	 */
	public int countByNationality(String nationality);

	/**
	 * Returns the doctor where govtId = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param govtId the govt ID
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByGovtId(String govtId) throws NoSuchDoctorException;

	/**
	 * Returns the doctor where govtId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param govtId the govt ID
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByGovtId(String govtId);

	/**
	 * Returns the doctor where govtId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param govtId the govt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByGovtId(String govtId, boolean useFinderCache);

	/**
	 * Removes the doctor where govtId = &#63; from the database.
	 *
	 * @param govtId the govt ID
	 * @return the doctor that was removed
	 */
	public Doctor removeByGovtId(String govtId) throws NoSuchDoctorException;

	/**
	 * Returns the number of doctors where govtId = &#63;.
	 *
	 * @param govtId the govt ID
	 * @return the number of matching doctors
	 */
	public int countByGovtId(String govtId);

	/**
	 * Returns the doctor where email = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByEmail(String email) throws NoSuchDoctorException;

	/**
	 * Returns the doctor where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByEmail(String email);

	/**
	 * Returns the doctor where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByEmail(String email, boolean useFinderCache);

	/**
	 * Removes the doctor where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the doctor that was removed
	 */
	public Doctor removeByEmail(String email) throws NoSuchDoctorException;

	/**
	 * Returns the number of doctors where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching doctors
	 */
	public int countByEmail(String email);

	/**
	 * Returns the doctor where contactNumber = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param contactNumber the contact number
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	public Doctor findByContactNumber(String contactNumber)
		throws NoSuchDoctorException;

	/**
	 * Returns the doctor where contactNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByContactNumber(String contactNumber);

	/**
	 * Returns the doctor where contactNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	public Doctor fetchByContactNumber(
		String contactNumber, boolean useFinderCache);

	/**
	 * Removes the doctor where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 * @return the doctor that was removed
	 */
	public Doctor removeByContactNumber(String contactNumber)
		throws NoSuchDoctorException;

	/**
	 * Returns the number of doctors where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching doctors
	 */
	public int countByContactNumber(String contactNumber);

	/**
	 * Caches the doctor in the entity cache if it is enabled.
	 *
	 * @param doctor the doctor
	 */
	public void cacheResult(Doctor doctor);

	/**
	 * Caches the doctors in the entity cache if it is enabled.
	 *
	 * @param doctors the doctors
	 */
	public void cacheResult(java.util.List<Doctor> doctors);

	/**
	 * Creates a new doctor with the primary key. Does not add the doctor to the database.
	 *
	 * @param employeeId the primary key for the new doctor
	 * @return the new doctor
	 */
	public Doctor create(long employeeId);

	/**
	 * Removes the doctor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor that was removed
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public Doctor remove(long employeeId) throws NoSuchDoctorException;

	public Doctor updateImpl(Doctor doctor);

	/**
	 * Returns the doctor with the primary key or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	public Doctor findByPrimaryKey(long employeeId)
		throws NoSuchDoctorException;

	/**
	 * Returns the doctor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor, or <code>null</code> if a doctor with the primary key could not be found
	 */
	public Doctor fetchByPrimaryKey(long employeeId);

	/**
	 * Returns all the doctors.
	 *
	 * @return the doctors
	 */
	public java.util.List<Doctor> findAll();

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
	public java.util.List<Doctor> findAll(int start, int end);

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
	public java.util.List<Doctor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator);

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
	public java.util.List<Doctor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Doctor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the doctors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of doctors.
	 *
	 * @return the number of doctors
	 */
	public int countAll();

}