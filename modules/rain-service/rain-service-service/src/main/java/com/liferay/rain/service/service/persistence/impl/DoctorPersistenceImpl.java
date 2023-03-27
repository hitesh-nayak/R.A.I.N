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

package com.liferay.rain.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.rain.service.exception.NoSuchDoctorException;
import com.liferay.rain.service.model.Doctor;
import com.liferay.rain.service.model.DoctorTable;
import com.liferay.rain.service.model.impl.DoctorImpl;
import com.liferay.rain.service.model.impl.DoctorModelImpl;
import com.liferay.rain.service.service.persistence.DoctorPersistence;
import com.liferay.rain.service.service.persistence.DoctorUtil;
import com.liferay.rain.service.service.persistence.impl.constants.RainPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the doctor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DoctorPersistence.class)
public class DoctorPersistenceImpl
	extends BasePersistenceImpl<Doctor> implements DoctorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DoctorUtil</code> to access the doctor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DoctorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySurname;
	private FinderPath _finderPathWithoutPaginationFindBySurname;
	private FinderPath _finderPathCountBySurname;

	/**
	 * Returns all the doctors where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the matching doctors
	 */
	@Override
	public List<Doctor> findBySurname(String surname) {
		return findBySurname(
			surname, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Doctor> findBySurname(String surname, int start, int end) {
		return findBySurname(surname, start, end, null);
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
	@Override
	public List<Doctor> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return findBySurname(surname, start, end, orderByComparator, true);
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
	@Override
	public List<Doctor> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		surname = Objects.toString(surname, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySurname;
				finderArgs = new Object[] {surname};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySurname;
			finderArgs = new Object[] {surname, start, end, orderByComparator};
		}

		List<Doctor> list = null;

		if (useFinderCache) {
			list = (List<Doctor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Doctor doctor : list) {
					if (!surname.equals(doctor.getSurname())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindSurname = false;

			if (surname.isEmpty()) {
				sb.append(_FINDER_COLUMN_SURNAME_SURNAME_3);
			}
			else {
				bindSurname = true;

				sb.append(_FINDER_COLUMN_SURNAME_SURNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DoctorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSurname) {
					queryPos.add(surname);
				}

				list = (List<Doctor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findBySurname_First(
			String surname, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchBySurname_First(surname, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surname=");
		sb.append(surname);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the first doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchBySurname_First(
		String surname, OrderByComparator<Doctor> orderByComparator) {

		List<Doctor> list = findBySurname(surname, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findBySurname_Last(
			String surname, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchBySurname_Last(surname, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surname=");
		sb.append(surname);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the last doctor in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchBySurname_Last(
		String surname, OrderByComparator<Doctor> orderByComparator) {

		int count = countBySurname(surname);

		if (count == 0) {
			return null;
		}

		List<Doctor> list = findBySurname(
			surname, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Doctor[] findBySurname_PrevAndNext(
			long employeeId, String surname,
			OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		surname = Objects.toString(surname, "");

		Doctor doctor = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Doctor[] array = new DoctorImpl[3];

			array[0] = getBySurname_PrevAndNext(
				session, doctor, surname, orderByComparator, true);

			array[1] = doctor;

			array[2] = getBySurname_PrevAndNext(
				session, doctor, surname, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Doctor getBySurname_PrevAndNext(
		Session session, Doctor doctor, String surname,
		OrderByComparator<Doctor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCTOR_WHERE);

		boolean bindSurname = false;

		if (surname.isEmpty()) {
			sb.append(_FINDER_COLUMN_SURNAME_SURNAME_3);
		}
		else {
			bindSurname = true;

			sb.append(_FINDER_COLUMN_SURNAME_SURNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DoctorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSurname) {
			queryPos.add(surname);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(doctor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Doctor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctors where surname = &#63; from the database.
	 *
	 * @param surname the surname
	 */
	@Override
	public void removeBySurname(String surname) {
		for (Doctor doctor :
				findBySurname(
					surname, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(doctor);
		}
	}

	/**
	 * Returns the number of doctors where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the number of matching doctors
	 */
	@Override
	public int countBySurname(String surname) {
		surname = Objects.toString(surname, "");

		FinderPath finderPath = _finderPathCountBySurname;

		Object[] finderArgs = new Object[] {surname};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindSurname = false;

			if (surname.isEmpty()) {
				sb.append(_FINDER_COLUMN_SURNAME_SURNAME_3);
			}
			else {
				bindSurname = true;

				sb.append(_FINDER_COLUMN_SURNAME_SURNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSurname) {
					queryPos.add(surname);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURNAME_SURNAME_2 =
		"doctor.surname = ?";

	private static final String _FINDER_COLUMN_SURNAME_SURNAME_3 =
		"(doctor.surname IS NULL OR doctor.surname = '')";

	private FinderPath _finderPathFetchByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns the doctor where employeeId = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByEmployeeId(long employeeId)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByEmployeeId(employeeId);

		if (doctor == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDoctorException(sb.toString());
		}

		return doctor;
	}

	/**
	 * Returns the doctor where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByEmployeeId(long employeeId) {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the doctor where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByEmployeeId(long employeeId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeId, finderArgs, this);
		}

		if (result instanceof Doctor) {
			Doctor doctor = (Doctor)result;

			if (employeeId != doctor.getEmployeeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				List<Doctor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {employeeId};
							}

							_log.warn(
								"DoctorPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Doctor doctor = list.get(0);

					result = doctor;

					cacheResult(doctor);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Doctor)result;
		}
	}

	/**
	 * Removes the doctor where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the doctor that was removed
	 */
	@Override
	public Doctor removeByEmployeeId(long employeeId)
		throws NoSuchDoctorException {

		Doctor doctor = findByEmployeeId(employeeId);

		return remove(doctor);
	}

	/**
	 * Returns the number of doctors where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching doctors
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"doctor.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByDepartment;
	private FinderPath _finderPathWithoutPaginationFindByDepartment;
	private FinderPath _finderPathCountByDepartment;

	/**
	 * Returns all the doctors where department = &#63;.
	 *
	 * @param department the department
	 * @return the matching doctors
	 */
	@Override
	public List<Doctor> findByDepartment(String department) {
		return findByDepartment(
			department, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Doctor> findByDepartment(
		String department, int start, int end) {

		return findByDepartment(department, start, end, null);
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
	@Override
	public List<Doctor> findByDepartment(
		String department, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return findByDepartment(
			department, start, end, orderByComparator, true);
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
	@Override
	public List<Doctor> findByDepartment(
		String department, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		department = Objects.toString(department, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDepartment;
				finderArgs = new Object[] {department};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDepartment;
			finderArgs = new Object[] {
				department, start, end, orderByComparator
			};
		}

		List<Doctor> list = null;

		if (useFinderCache) {
			list = (List<Doctor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Doctor doctor : list) {
					if (!department.equals(doctor.getDepartment())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindDepartment = false;

			if (department.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3);
			}
			else {
				bindDepartment = true;

				sb.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DoctorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDepartment) {
					queryPos.add(department);
				}

				list = (List<Doctor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByDepartment_First(
			String department, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByDepartment_First(department, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("department=");
		sb.append(department);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the first doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByDepartment_First(
		String department, OrderByComparator<Doctor> orderByComparator) {

		List<Doctor> list = findByDepartment(
			department, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByDepartment_Last(
			String department, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByDepartment_Last(department, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("department=");
		sb.append(department);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the last doctor in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByDepartment_Last(
		String department, OrderByComparator<Doctor> orderByComparator) {

		int count = countByDepartment(department);

		if (count == 0) {
			return null;
		}

		List<Doctor> list = findByDepartment(
			department, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Doctor[] findByDepartment_PrevAndNext(
			long employeeId, String department,
			OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		department = Objects.toString(department, "");

		Doctor doctor = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Doctor[] array = new DoctorImpl[3];

			array[0] = getByDepartment_PrevAndNext(
				session, doctor, department, orderByComparator, true);

			array[1] = doctor;

			array[2] = getByDepartment_PrevAndNext(
				session, doctor, department, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Doctor getByDepartment_PrevAndNext(
		Session session, Doctor doctor, String department,
		OrderByComparator<Doctor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCTOR_WHERE);

		boolean bindDepartment = false;

		if (department.isEmpty()) {
			sb.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3);
		}
		else {
			bindDepartment = true;

			sb.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DoctorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDepartment) {
			queryPos.add(department);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(doctor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Doctor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctors where department = &#63; from the database.
	 *
	 * @param department the department
	 */
	@Override
	public void removeByDepartment(String department) {
		for (Doctor doctor :
				findByDepartment(
					department, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(doctor);
		}
	}

	/**
	 * Returns the number of doctors where department = &#63;.
	 *
	 * @param department the department
	 * @return the number of matching doctors
	 */
	@Override
	public int countByDepartment(String department) {
		department = Objects.toString(department, "");

		FinderPath finderPath = _finderPathCountByDepartment;

		Object[] finderArgs = new Object[] {department};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindDepartment = false;

			if (department.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3);
			}
			else {
				bindDepartment = true;

				sb.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDepartment) {
					queryPos.add(department);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2 =
		"doctor.department = ?";

	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3 =
		"(doctor.department IS NULL OR doctor.department = '')";

	private FinderPath _finderPathWithPaginationFindByPayGroup;
	private FinderPath _finderPathWithoutPaginationFindByPayGroup;
	private FinderPath _finderPathCountByPayGroup;

	/**
	 * Returns all the doctors where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @return the matching doctors
	 */
	@Override
	public List<Doctor> findByPayGroup(String payGroup) {
		return findByPayGroup(
			payGroup, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Doctor> findByPayGroup(String payGroup, int start, int end) {
		return findByPayGroup(payGroup, start, end, null);
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
	@Override
	public List<Doctor> findByPayGroup(
		String payGroup, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return findByPayGroup(payGroup, start, end, orderByComparator, true);
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
	@Override
	public List<Doctor> findByPayGroup(
		String payGroup, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		payGroup = Objects.toString(payGroup, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPayGroup;
				finderArgs = new Object[] {payGroup};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPayGroup;
			finderArgs = new Object[] {payGroup, start, end, orderByComparator};
		}

		List<Doctor> list = null;

		if (useFinderCache) {
			list = (List<Doctor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Doctor doctor : list) {
					if (!payGroup.equals(doctor.getPayGroup())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindPayGroup = false;

			if (payGroup.isEmpty()) {
				sb.append(_FINDER_COLUMN_PAYGROUP_PAYGROUP_3);
			}
			else {
				bindPayGroup = true;

				sb.append(_FINDER_COLUMN_PAYGROUP_PAYGROUP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DoctorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPayGroup) {
					queryPos.add(payGroup);
				}

				list = (List<Doctor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByPayGroup_First(
			String payGroup, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByPayGroup_First(payGroup, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("payGroup=");
		sb.append(payGroup);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the first doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByPayGroup_First(
		String payGroup, OrderByComparator<Doctor> orderByComparator) {

		List<Doctor> list = findByPayGroup(payGroup, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByPayGroup_Last(
			String payGroup, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByPayGroup_Last(payGroup, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("payGroup=");
		sb.append(payGroup);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the last doctor in the ordered set where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByPayGroup_Last(
		String payGroup, OrderByComparator<Doctor> orderByComparator) {

		int count = countByPayGroup(payGroup);

		if (count == 0) {
			return null;
		}

		List<Doctor> list = findByPayGroup(
			payGroup, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Doctor[] findByPayGroup_PrevAndNext(
			long employeeId, String payGroup,
			OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		payGroup = Objects.toString(payGroup, "");

		Doctor doctor = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Doctor[] array = new DoctorImpl[3];

			array[0] = getByPayGroup_PrevAndNext(
				session, doctor, payGroup, orderByComparator, true);

			array[1] = doctor;

			array[2] = getByPayGroup_PrevAndNext(
				session, doctor, payGroup, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Doctor getByPayGroup_PrevAndNext(
		Session session, Doctor doctor, String payGroup,
		OrderByComparator<Doctor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCTOR_WHERE);

		boolean bindPayGroup = false;

		if (payGroup.isEmpty()) {
			sb.append(_FINDER_COLUMN_PAYGROUP_PAYGROUP_3);
		}
		else {
			bindPayGroup = true;

			sb.append(_FINDER_COLUMN_PAYGROUP_PAYGROUP_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DoctorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPayGroup) {
			queryPos.add(payGroup);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(doctor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Doctor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctors where payGroup = &#63; from the database.
	 *
	 * @param payGroup the pay group
	 */
	@Override
	public void removeByPayGroup(String payGroup) {
		for (Doctor doctor :
				findByPayGroup(
					payGroup, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(doctor);
		}
	}

	/**
	 * Returns the number of doctors where payGroup = &#63;.
	 *
	 * @param payGroup the pay group
	 * @return the number of matching doctors
	 */
	@Override
	public int countByPayGroup(String payGroup) {
		payGroup = Objects.toString(payGroup, "");

		FinderPath finderPath = _finderPathCountByPayGroup;

		Object[] finderArgs = new Object[] {payGroup};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindPayGroup = false;

			if (payGroup.isEmpty()) {
				sb.append(_FINDER_COLUMN_PAYGROUP_PAYGROUP_3);
			}
			else {
				bindPayGroup = true;

				sb.append(_FINDER_COLUMN_PAYGROUP_PAYGROUP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPayGroup) {
					queryPos.add(payGroup);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PAYGROUP_PAYGROUP_2 =
		"doctor.payGroup = ?";

	private static final String _FINDER_COLUMN_PAYGROUP_PAYGROUP_3 =
		"(doctor.payGroup IS NULL OR doctor.payGroup = '')";

	private FinderPath _finderPathWithPaginationFindByNationality;
	private FinderPath _finderPathWithoutPaginationFindByNationality;
	private FinderPath _finderPathCountByNationality;

	/**
	 * Returns all the doctors where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the matching doctors
	 */
	@Override
	public List<Doctor> findByNationality(String nationality) {
		return findByNationality(
			nationality, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Doctor> findByNationality(
		String nationality, int start, int end) {

		return findByNationality(nationality, start, end, null);
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
	@Override
	public List<Doctor> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Doctor> orderByComparator) {

		return findByNationality(
			nationality, start, end, orderByComparator, true);
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
	@Override
	public List<Doctor> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Doctor> orderByComparator, boolean useFinderCache) {

		nationality = Objects.toString(nationality, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNationality;
				finderArgs = new Object[] {nationality};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNationality;
			finderArgs = new Object[] {
				nationality, start, end, orderByComparator
			};
		}

		List<Doctor> list = null;

		if (useFinderCache) {
			list = (List<Doctor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Doctor doctor : list) {
					if (!nationality.equals(doctor.getNationality())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindNationality = false;

			if (nationality.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALITY_NATIONALITY_3);
			}
			else {
				bindNationality = true;

				sb.append(_FINDER_COLUMN_NATIONALITY_NATIONALITY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DoctorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationality) {
					queryPos.add(nationality);
				}

				list = (List<Doctor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByNationality_First(
			String nationality, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByNationality_First(
			nationality, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationality=");
		sb.append(nationality);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the first doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByNationality_First(
		String nationality, OrderByComparator<Doctor> orderByComparator) {

		List<Doctor> list = findByNationality(
			nationality, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByNationality_Last(
			String nationality, OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByNationality_Last(nationality, orderByComparator);

		if (doctor != null) {
			return doctor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationality=");
		sb.append(nationality);

		sb.append("}");

		throw new NoSuchDoctorException(sb.toString());
	}

	/**
	 * Returns the last doctor in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByNationality_Last(
		String nationality, OrderByComparator<Doctor> orderByComparator) {

		int count = countByNationality(nationality);

		if (count == 0) {
			return null;
		}

		List<Doctor> list = findByNationality(
			nationality, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Doctor[] findByNationality_PrevAndNext(
			long employeeId, String nationality,
			OrderByComparator<Doctor> orderByComparator)
		throws NoSuchDoctorException {

		nationality = Objects.toString(nationality, "");

		Doctor doctor = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Doctor[] array = new DoctorImpl[3];

			array[0] = getByNationality_PrevAndNext(
				session, doctor, nationality, orderByComparator, true);

			array[1] = doctor;

			array[2] = getByNationality_PrevAndNext(
				session, doctor, nationality, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Doctor getByNationality_PrevAndNext(
		Session session, Doctor doctor, String nationality,
		OrderByComparator<Doctor> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCTOR_WHERE);

		boolean bindNationality = false;

		if (nationality.isEmpty()) {
			sb.append(_FINDER_COLUMN_NATIONALITY_NATIONALITY_3);
		}
		else {
			bindNationality = true;

			sb.append(_FINDER_COLUMN_NATIONALITY_NATIONALITY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DoctorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNationality) {
			queryPos.add(nationality);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(doctor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Doctor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctors where nationality = &#63; from the database.
	 *
	 * @param nationality the nationality
	 */
	@Override
	public void removeByNationality(String nationality) {
		for (Doctor doctor :
				findByNationality(
					nationality, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(doctor);
		}
	}

	/**
	 * Returns the number of doctors where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the number of matching doctors
	 */
	@Override
	public int countByNationality(String nationality) {
		nationality = Objects.toString(nationality, "");

		FinderPath finderPath = _finderPathCountByNationality;

		Object[] finderArgs = new Object[] {nationality};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindNationality = false;

			if (nationality.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALITY_NATIONALITY_3);
			}
			else {
				bindNationality = true;

				sb.append(_FINDER_COLUMN_NATIONALITY_NATIONALITY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationality) {
					queryPos.add(nationality);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NATIONALITY_NATIONALITY_2 =
		"doctor.nationality = ?";

	private static final String _FINDER_COLUMN_NATIONALITY_NATIONALITY_3 =
		"(doctor.nationality IS NULL OR doctor.nationality = '')";

	private FinderPath _finderPathFetchByGovtId;
	private FinderPath _finderPathCountByGovtId;

	/**
	 * Returns the doctor where govtId = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param govtId the govt ID
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByGovtId(String govtId) throws NoSuchDoctorException {
		Doctor doctor = fetchByGovtId(govtId);

		if (doctor == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("govtId=");
			sb.append(govtId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDoctorException(sb.toString());
		}

		return doctor;
	}

	/**
	 * Returns the doctor where govtId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param govtId the govt ID
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByGovtId(String govtId) {
		return fetchByGovtId(govtId, true);
	}

	/**
	 * Returns the doctor where govtId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param govtId the govt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByGovtId(String govtId, boolean useFinderCache) {
		govtId = Objects.toString(govtId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {govtId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGovtId, finderArgs, this);
		}

		if (result instanceof Doctor) {
			Doctor doctor = (Doctor)result;

			if (!Objects.equals(govtId, doctor.getGovtId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindGovtId = false;

			if (govtId.isEmpty()) {
				sb.append(_FINDER_COLUMN_GOVTID_GOVTID_3);
			}
			else {
				bindGovtId = true;

				sb.append(_FINDER_COLUMN_GOVTID_GOVTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGovtId) {
					queryPos.add(govtId);
				}

				List<Doctor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGovtId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {govtId};
							}

							_log.warn(
								"DoctorPersistenceImpl.fetchByGovtId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Doctor doctor = list.get(0);

					result = doctor;

					cacheResult(doctor);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Doctor)result;
		}
	}

	/**
	 * Removes the doctor where govtId = &#63; from the database.
	 *
	 * @param govtId the govt ID
	 * @return the doctor that was removed
	 */
	@Override
	public Doctor removeByGovtId(String govtId) throws NoSuchDoctorException {
		Doctor doctor = findByGovtId(govtId);

		return remove(doctor);
	}

	/**
	 * Returns the number of doctors where govtId = &#63;.
	 *
	 * @param govtId the govt ID
	 * @return the number of matching doctors
	 */
	@Override
	public int countByGovtId(String govtId) {
		govtId = Objects.toString(govtId, "");

		FinderPath finderPath = _finderPathCountByGovtId;

		Object[] finderArgs = new Object[] {govtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindGovtId = false;

			if (govtId.isEmpty()) {
				sb.append(_FINDER_COLUMN_GOVTID_GOVTID_3);
			}
			else {
				bindGovtId = true;

				sb.append(_FINDER_COLUMN_GOVTID_GOVTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGovtId) {
					queryPos.add(govtId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GOVTID_GOVTID_2 =
		"doctor.govtId = ?";

	private static final String _FINDER_COLUMN_GOVTID_GOVTID_3 =
		"(doctor.govtId IS NULL OR doctor.govtId = '')";

	private FinderPath _finderPathFetchByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns the doctor where email = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByEmail(String email) throws NoSuchDoctorException {
		Doctor doctor = fetchByEmail(email);

		if (doctor == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDoctorException(sb.toString());
		}

		return doctor;
	}

	/**
	 * Returns the doctor where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the doctor where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByEmail(String email, boolean useFinderCache) {
		email = Objects.toString(email, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmail, finderArgs, this);
		}

		if (result instanceof Doctor) {
			Doctor doctor = (Doctor)result;

			if (!Objects.equals(email, doctor.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				List<Doctor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmail, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email};
							}

							_log.warn(
								"DoctorPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Doctor doctor = list.get(0);

					result = doctor;

					cacheResult(doctor);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Doctor)result;
		}
	}

	/**
	 * Removes the doctor where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the doctor that was removed
	 */
	@Override
	public Doctor removeByEmail(String email) throws NoSuchDoctorException {
		Doctor doctor = findByEmail(email);

		return remove(doctor);
	}

	/**
	 * Returns the number of doctors where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching doctors
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"doctor.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(doctor.email IS NULL OR doctor.email = '')";

	private FinderPath _finderPathFetchByContactNumber;
	private FinderPath _finderPathCountByContactNumber;

	/**
	 * Returns the doctor where contactNumber = &#63; or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param contactNumber the contact number
	 * @return the matching doctor
	 * @throws NoSuchDoctorException if a matching doctor could not be found
	 */
	@Override
	public Doctor findByContactNumber(String contactNumber)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByContactNumber(contactNumber);

		if (doctor == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("contactNumber=");
			sb.append(contactNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDoctorException(sb.toString());
		}

		return doctor;
	}

	/**
	 * Returns the doctor where contactNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByContactNumber(String contactNumber) {
		return fetchByContactNumber(contactNumber, true);
	}

	/**
	 * Returns the doctor where contactNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor, or <code>null</code> if a matching doctor could not be found
	 */
	@Override
	public Doctor fetchByContactNumber(
		String contactNumber, boolean useFinderCache) {

		contactNumber = Objects.toString(contactNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {contactNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByContactNumber, finderArgs, this);
		}

		if (result instanceof Doctor) {
			Doctor doctor = (Doctor)result;

			if (!Objects.equals(contactNumber, doctor.getContactNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCTOR_WHERE);

			boolean bindContactNumber = false;

			if (contactNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3);
			}
			else {
				bindContactNumber = true;

				sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindContactNumber) {
					queryPos.add(contactNumber);
				}

				List<Doctor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByContactNumber, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {contactNumber};
							}

							_log.warn(
								"DoctorPersistenceImpl.fetchByContactNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Doctor doctor = list.get(0);

					result = doctor;

					cacheResult(doctor);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Doctor)result;
		}
	}

	/**
	 * Removes the doctor where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 * @return the doctor that was removed
	 */
	@Override
	public Doctor removeByContactNumber(String contactNumber)
		throws NoSuchDoctorException {

		Doctor doctor = findByContactNumber(contactNumber);

		return remove(doctor);
	}

	/**
	 * Returns the number of doctors where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching doctors
	 */
	@Override
	public int countByContactNumber(String contactNumber) {
		contactNumber = Objects.toString(contactNumber, "");

		FinderPath finderPath = _finderPathCountByContactNumber;

		Object[] finderArgs = new Object[] {contactNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTOR_WHERE);

			boolean bindContactNumber = false;

			if (contactNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3);
			}
			else {
				bindContactNumber = true;

				sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindContactNumber) {
					queryPos.add(contactNumber);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2 =
		"doctor.contactNumber = ?";

	private static final String _FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3 =
		"(doctor.contactNumber IS NULL OR doctor.contactNumber = '')";

	public DoctorPersistenceImpl() {
		setModelClass(Doctor.class);

		setModelImplClass(DoctorImpl.class);
		setModelPKClass(long.class);

		setTable(DoctorTable.INSTANCE);
	}

	/**
	 * Caches the doctor in the entity cache if it is enabled.
	 *
	 * @param doctor the doctor
	 */
	@Override
	public void cacheResult(Doctor doctor) {
		entityCache.putResult(DoctorImpl.class, doctor.getPrimaryKey(), doctor);

		finderCache.putResult(
			_finderPathFetchByEmployeeId, new Object[] {doctor.getEmployeeId()},
			doctor);

		finderCache.putResult(
			_finderPathFetchByGovtId, new Object[] {doctor.getGovtId()},
			doctor);

		finderCache.putResult(
			_finderPathFetchByEmail, new Object[] {doctor.getEmail()}, doctor);

		finderCache.putResult(
			_finderPathFetchByContactNumber,
			new Object[] {doctor.getContactNumber()}, doctor);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the doctors in the entity cache if it is enabled.
	 *
	 * @param doctors the doctors
	 */
	@Override
	public void cacheResult(List<Doctor> doctors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (doctors.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Doctor doctor : doctors) {
			if (entityCache.getResult(
					DoctorImpl.class, doctor.getPrimaryKey()) == null) {

				cacheResult(doctor);
			}
		}
	}

	/**
	 * Clears the cache for all doctors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DoctorImpl.class);

		finderCache.clearCache(DoctorImpl.class);
	}

	/**
	 * Clears the cache for the doctor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Doctor doctor) {
		entityCache.removeResult(DoctorImpl.class, doctor);
	}

	@Override
	public void clearCache(List<Doctor> doctors) {
		for (Doctor doctor : doctors) {
			entityCache.removeResult(DoctorImpl.class, doctor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DoctorImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DoctorImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(DoctorModelImpl doctorModelImpl) {
		Object[] args = new Object[] {doctorModelImpl.getEmployeeId()};

		finderCache.putResult(
			_finderPathCountByEmployeeId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEmployeeId, args, doctorModelImpl);

		args = new Object[] {doctorModelImpl.getGovtId()};

		finderCache.putResult(_finderPathCountByGovtId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByGovtId, args, doctorModelImpl);

		args = new Object[] {doctorModelImpl.getEmail()};

		finderCache.putResult(_finderPathCountByEmail, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByEmail, args, doctorModelImpl);

		args = new Object[] {doctorModelImpl.getContactNumber()};

		finderCache.putResult(
			_finderPathCountByContactNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByContactNumber, args, doctorModelImpl);
	}

	/**
	 * Creates a new doctor with the primary key. Does not add the doctor to the database.
	 *
	 * @param employeeId the primary key for the new doctor
	 * @return the new doctor
	 */
	@Override
	public Doctor create(long employeeId) {
		Doctor doctor = new DoctorImpl();

		doctor.setNew(true);
		doctor.setPrimaryKey(employeeId);

		return doctor;
	}

	/**
	 * Removes the doctor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor that was removed
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	@Override
	public Doctor remove(long employeeId) throws NoSuchDoctorException {
		return remove((Serializable)employeeId);
	}

	/**
	 * Removes the doctor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doctor
	 * @return the doctor that was removed
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	@Override
	public Doctor remove(Serializable primaryKey) throws NoSuchDoctorException {
		Session session = null;

		try {
			session = openSession();

			Doctor doctor = (Doctor)session.get(DoctorImpl.class, primaryKey);

			if (doctor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDoctorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(doctor);
		}
		catch (NoSuchDoctorException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Doctor removeImpl(Doctor doctor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(doctor)) {
				doctor = (Doctor)session.get(
					DoctorImpl.class, doctor.getPrimaryKeyObj());
			}

			if (doctor != null) {
				session.delete(doctor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (doctor != null) {
			clearCache(doctor);
		}

		return doctor;
	}

	@Override
	public Doctor updateImpl(Doctor doctor) {
		boolean isNew = doctor.isNew();

		if (!(doctor instanceof DoctorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(doctor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(doctor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in doctor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Doctor implementation " +
					doctor.getClass());
		}

		DoctorModelImpl doctorModelImpl = (DoctorModelImpl)doctor;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(doctor);
			}
			else {
				doctor = (Doctor)session.merge(doctor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DoctorImpl.class, doctorModelImpl, false, true);

		cacheUniqueFindersCache(doctorModelImpl);

		if (isNew) {
			doctor.setNew(false);
		}

		doctor.resetOriginalValues();

		return doctor;
	}

	/**
	 * Returns the doctor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doctor
	 * @return the doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	@Override
	public Doctor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDoctorException {

		Doctor doctor = fetchByPrimaryKey(primaryKey);

		if (doctor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDoctorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return doctor;
	}

	/**
	 * Returns the doctor with the primary key or throws a <code>NoSuchDoctorException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor
	 * @throws NoSuchDoctorException if a doctor with the primary key could not be found
	 */
	@Override
	public Doctor findByPrimaryKey(long employeeId)
		throws NoSuchDoctorException {

		return findByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns the doctor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the doctor
	 * @return the doctor, or <code>null</code> if a doctor with the primary key could not be found
	 */
	@Override
	public Doctor fetchByPrimaryKey(long employeeId) {
		return fetchByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns all the doctors.
	 *
	 * @return the doctors
	 */
	@Override
	public List<Doctor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Doctor> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Doctor> findAll(
		int start, int end, OrderByComparator<Doctor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Doctor> findAll(
		int start, int end, OrderByComparator<Doctor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Doctor> list = null;

		if (useFinderCache) {
			list = (List<Doctor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCTOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCTOR;

				sql = sql.concat(DoctorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Doctor>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the doctors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Doctor doctor : findAll()) {
			remove(doctor);
		}
	}

	/**
	 * Returns the number of doctors.
	 *
	 * @return the number of doctors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCTOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCTOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DoctorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the doctor persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBySurname = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurname",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"surname"}, true);

		_finderPathWithoutPaginationFindBySurname = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurname",
			new String[] {String.class.getName()}, new String[] {"surname"},
			true);

		_finderPathCountBySurname = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurname",
			new String[] {String.class.getName()}, new String[] {"surname"},
			false);

		_finderPathFetchByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathWithPaginationFindByDepartment = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartment",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"department"}, true);

		_finderPathWithoutPaginationFindByDepartment = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartment",
			new String[] {String.class.getName()}, new String[] {"department"},
			true);

		_finderPathCountByDepartment = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartment",
			new String[] {String.class.getName()}, new String[] {"department"},
			false);

		_finderPathWithPaginationFindByPayGroup = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPayGroup",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"payGroup"}, true);

		_finderPathWithoutPaginationFindByPayGroup = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPayGroup",
			new String[] {String.class.getName()}, new String[] {"payGroup"},
			true);

		_finderPathCountByPayGroup = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPayGroup",
			new String[] {String.class.getName()}, new String[] {"payGroup"},
			false);

		_finderPathWithPaginationFindByNationality = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNationality",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nationality"}, true);

		_finderPathWithoutPaginationFindByNationality = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNationality",
			new String[] {String.class.getName()}, new String[] {"nationality"},
			true);

		_finderPathCountByNationality = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNationality",
			new String[] {String.class.getName()}, new String[] {"nationality"},
			false);

		_finderPathFetchByGovtId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGovtId",
			new String[] {String.class.getName()}, new String[] {"govtId"},
			true);

		_finderPathCountByGovtId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGovtId",
			new String[] {String.class.getName()}, new String[] {"govtId"},
			false);

		_finderPathFetchByEmail = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathFetchByContactNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByContactNumber",
			new String[] {String.class.getName()},
			new String[] {"contactNumber"}, true);

		_finderPathCountByContactNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactNumber",
			new String[] {String.class.getName()},
			new String[] {"contactNumber"}, false);

		_setDoctorUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDoctorUtilPersistence(null);

		entityCache.removeCache(DoctorImpl.class.getName());
	}

	private void _setDoctorUtilPersistence(
		DoctorPersistence doctorPersistence) {

		try {
			Field field = DoctorUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, doctorPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = RainPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = RainPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = RainPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DOCTOR =
		"SELECT doctor FROM Doctor doctor";

	private static final String _SQL_SELECT_DOCTOR_WHERE =
		"SELECT doctor FROM Doctor doctor WHERE ";

	private static final String _SQL_COUNT_DOCTOR =
		"SELECT COUNT(doctor) FROM Doctor doctor";

	private static final String _SQL_COUNT_DOCTOR_WHERE =
		"SELECT COUNT(doctor) FROM Doctor doctor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "doctor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Doctor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Doctor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DoctorPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}