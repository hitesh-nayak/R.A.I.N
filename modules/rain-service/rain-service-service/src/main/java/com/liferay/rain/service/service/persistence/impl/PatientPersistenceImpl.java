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
import com.liferay.rain.service.exception.NoSuchPatientException;
import com.liferay.rain.service.model.Patient;
import com.liferay.rain.service.model.PatientTable;
import com.liferay.rain.service.model.impl.PatientImpl;
import com.liferay.rain.service.model.impl.PatientModelImpl;
import com.liferay.rain.service.service.persistence.PatientPersistence;
import com.liferay.rain.service.service.persistence.PatientUtil;
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
 * The persistence implementation for the patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PatientPersistence.class)
public class PatientPersistenceImpl
	extends BasePersistenceImpl<Patient> implements PatientPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PatientUtil</code> to access the patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PatientImpl.class.getName();

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
	 * Returns all the patients where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findBySurname(String surname) {
		return findBySurname(
			surname, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findBySurname(String surname, int start, int end) {
		return findBySurname(surname, start, end, null);
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
	@Override
	public List<Patient> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findBySurname(surname, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findBySurname(
		String surname, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

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

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (!surname.equals(patient.getSurname())) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

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
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
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

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findBySurname_First(
			String surname, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchBySurname_First(surname, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surname=");
		sb.append(surname);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchBySurname_First(
		String surname, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findBySurname(surname, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findBySurname_Last(
			String surname, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchBySurname_Last(surname, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("surname=");
		sb.append(surname);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where surname = &#63;.
	 *
	 * @param surname the surname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchBySurname_Last(
		String surname, OrderByComparator<Patient> orderByComparator) {

		int count = countBySurname(surname);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findBySurname(
			surname, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findBySurname_PrevAndNext(
			long govtId, String surname,
			OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		surname = Objects.toString(surname, "");

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getBySurname_PrevAndNext(
				session, patient, surname, orderByComparator, true);

			array[1] = patient;

			array[2] = getBySurname_PrevAndNext(
				session, patient, surname, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getBySurname_PrevAndNext(
		Session session, Patient patient, String surname,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where surname = &#63; from the database.
	 *
	 * @param surname the surname
	 */
	@Override
	public void removeBySurname(String surname) {
		for (Patient patient :
				findBySurname(
					surname, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where surname = &#63;.
	 *
	 * @param surname the surname
	 * @return the number of matching patients
	 */
	@Override
	public int countBySurname(String surname) {
		surname = Objects.toString(surname, "");

		FinderPath finderPath = _finderPathCountBySurname;

		Object[] finderArgs = new Object[] {surname};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

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
		"patient.surname = ?";

	private static final String _FINDER_COLUMN_SURNAME_SURNAME_3 =
		"(patient.surname IS NULL OR patient.surname = '')";

	private FinderPath _finderPathFetchByGovtId;
	private FinderPath _finderPathCountByGovtId;

	/**
	 * Returns the patient where govtId = &#63; or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param govtId the govt ID
	 * @return the matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByGovtId(long govtId) throws NoSuchPatientException {
		Patient patient = fetchByGovtId(govtId);

		if (patient == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("govtId=");
			sb.append(govtId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPatientException(sb.toString());
		}

		return patient;
	}

	/**
	 * Returns the patient where govtId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param govtId the govt ID
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByGovtId(long govtId) {
		return fetchByGovtId(govtId, true);
	}

	/**
	 * Returns the patient where govtId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param govtId the govt ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByGovtId(long govtId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {govtId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGovtId, finderArgs, this);
		}

		if (result instanceof Patient) {
			Patient patient = (Patient)result;

			if (govtId != patient.getGovtId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PATIENT_WHERE);

			sb.append(_FINDER_COLUMN_GOVTID_GOVTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(govtId);

				List<Patient> list = query.list();

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
								"PatientPersistenceImpl.fetchByGovtId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Patient patient = list.get(0);

					result = patient;

					cacheResult(patient);
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
			return (Patient)result;
		}
	}

	/**
	 * Removes the patient where govtId = &#63; from the database.
	 *
	 * @param govtId the govt ID
	 * @return the patient that was removed
	 */
	@Override
	public Patient removeByGovtId(long govtId) throws NoSuchPatientException {
		Patient patient = findByGovtId(govtId);

		return remove(patient);
	}

	/**
	 * Returns the number of patients where govtId = &#63;.
	 *
	 * @param govtId the govt ID
	 * @return the number of matching patients
	 */
	@Override
	public int countByGovtId(long govtId) {
		FinderPath finderPath = _finderPathCountByGovtId;

		Object[] finderArgs = new Object[] {govtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

			sb.append(_FINDER_COLUMN_GOVTID_GOVTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(govtId);

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
		"patient.govtId = ?";

	private FinderPath _finderPathWithPaginationFindByNationality;
	private FinderPath _finderPathWithoutPaginationFindByNationality;
	private FinderPath _finderPathCountByNationality;

	/**
	 * Returns all the patients where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findByNationality(String nationality) {
		return findByNationality(
			nationality, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findByNationality(
		String nationality, int start, int end) {

		return findByNationality(nationality, start, end, null);
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
	@Override
	public List<Patient> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findByNationality(
			nationality, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findByNationality(
		String nationality, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

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

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (!nationality.equals(patient.getNationality())) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

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
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
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

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByNationality_First(
			String nationality, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByNationality_First(
			nationality, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationality=");
		sb.append(nationality);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByNationality_First(
		String nationality, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findByNationality(
			nationality, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByNationality_Last(
			String nationality, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByNationality_Last(
			nationality, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationality=");
		sb.append(nationality);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByNationality_Last(
		String nationality, OrderByComparator<Patient> orderByComparator) {

		int count = countByNationality(nationality);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findByNationality(
			nationality, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findByNationality_PrevAndNext(
			long govtId, String nationality,
			OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		nationality = Objects.toString(nationality, "");

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getByNationality_PrevAndNext(
				session, patient, nationality, orderByComparator, true);

			array[1] = patient;

			array[2] = getByNationality_PrevAndNext(
				session, patient, nationality, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getByNationality_PrevAndNext(
		Session session, Patient patient, String nationality,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where nationality = &#63; from the database.
	 *
	 * @param nationality the nationality
	 */
	@Override
	public void removeByNationality(String nationality) {
		for (Patient patient :
				findByNationality(
					nationality, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where nationality = &#63;.
	 *
	 * @param nationality the nationality
	 * @return the number of matching patients
	 */
	@Override
	public int countByNationality(String nationality) {
		nationality = Objects.toString(nationality, "");

		FinderPath finderPath = _finderPathCountByNationality;

		Object[] finderArgs = new Object[] {nationality};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

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
		"patient.nationality = ?";

	private static final String _FINDER_COLUMN_NATIONALITY_NATIONALITY_3 =
		"(patient.nationality IS NULL OR patient.nationality = '')";

	private FinderPath _finderPathWithPaginationFindByInsuranceId;
	private FinderPath _finderPathWithoutPaginationFindByInsuranceId;
	private FinderPath _finderPathCountByInsuranceId;

	/**
	 * Returns all the patients where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findByInsuranceId(String insuranceId) {
		return findByInsuranceId(
			insuranceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findByInsuranceId(
		String insuranceId, int start, int end) {

		return findByInsuranceId(insuranceId, start, end, null);
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
	@Override
	public List<Patient> findByInsuranceId(
		String insuranceId, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findByInsuranceId(
			insuranceId, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findByInsuranceId(
		String insuranceId, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		insuranceId = Objects.toString(insuranceId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInsuranceId;
				finderArgs = new Object[] {insuranceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInsuranceId;
			finderArgs = new Object[] {
				insuranceId, start, end, orderByComparator
			};
		}

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (!insuranceId.equals(patient.getInsuranceId())) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

			boolean bindInsuranceId = false;

			if (insuranceId.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSURANCEID_INSURANCEID_3);
			}
			else {
				bindInsuranceId = true;

				sb.append(_FINDER_COLUMN_INSURANCEID_INSURANCEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInsuranceId) {
					queryPos.add(insuranceId);
				}

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByInsuranceId_First(
			String insuranceId, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByInsuranceId_First(
			insuranceId, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuranceId=");
		sb.append(insuranceId);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByInsuranceId_First(
		String insuranceId, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findByInsuranceId(
			insuranceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByInsuranceId_Last(
			String insuranceId, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByInsuranceId_Last(
			insuranceId, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("insuranceId=");
		sb.append(insuranceId);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByInsuranceId_Last(
		String insuranceId, OrderByComparator<Patient> orderByComparator) {

		int count = countByInsuranceId(insuranceId);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findByInsuranceId(
			insuranceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findByInsuranceId_PrevAndNext(
			long govtId, String insuranceId,
			OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		insuranceId = Objects.toString(insuranceId, "");

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getByInsuranceId_PrevAndNext(
				session, patient, insuranceId, orderByComparator, true);

			array[1] = patient;

			array[2] = getByInsuranceId_PrevAndNext(
				session, patient, insuranceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getByInsuranceId_PrevAndNext(
		Session session, Patient patient, String insuranceId,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

		boolean bindInsuranceId = false;

		if (insuranceId.isEmpty()) {
			sb.append(_FINDER_COLUMN_INSURANCEID_INSURANCEID_3);
		}
		else {
			bindInsuranceId = true;

			sb.append(_FINDER_COLUMN_INSURANCEID_INSURANCEID_2);
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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindInsuranceId) {
			queryPos.add(insuranceId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where insuranceId = &#63; from the database.
	 *
	 * @param insuranceId the insurance ID
	 */
	@Override
	public void removeByInsuranceId(String insuranceId) {
		for (Patient patient :
				findByInsuranceId(
					insuranceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where insuranceId = &#63;.
	 *
	 * @param insuranceId the insurance ID
	 * @return the number of matching patients
	 */
	@Override
	public int countByInsuranceId(String insuranceId) {
		insuranceId = Objects.toString(insuranceId, "");

		FinderPath finderPath = _finderPathCountByInsuranceId;

		Object[] finderArgs = new Object[] {insuranceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

			boolean bindInsuranceId = false;

			if (insuranceId.isEmpty()) {
				sb.append(_FINDER_COLUMN_INSURANCEID_INSURANCEID_3);
			}
			else {
				bindInsuranceId = true;

				sb.append(_FINDER_COLUMN_INSURANCEID_INSURANCEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInsuranceId) {
					queryPos.add(insuranceId);
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

	private static final String _FINDER_COLUMN_INSURANCEID_INSURANCEID_2 =
		"patient.insuranceId = ?";

	private static final String _FINDER_COLUMN_INSURANCEID_INSURANCEID_3 =
		"(patient.insuranceId IS NULL OR patient.insuranceId = '')";

	private FinderPath _finderPathWithPaginationFindByContactNumber;
	private FinderPath _finderPathWithoutPaginationFindByContactNumber;
	private FinderPath _finderPathCountByContactNumber;

	/**
	 * Returns all the patients where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findByContactNumber(String contactNumber) {
		return findByContactNumber(
			contactNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findByContactNumber(
		String contactNumber, int start, int end) {

		return findByContactNumber(contactNumber, start, end, null);
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
	@Override
	public List<Patient> findByContactNumber(
		String contactNumber, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findByContactNumber(
			contactNumber, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findByContactNumber(
		String contactNumber, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		contactNumber = Objects.toString(contactNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContactNumber;
				finderArgs = new Object[] {contactNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContactNumber;
			finderArgs = new Object[] {
				contactNumber, start, end, orderByComparator
			};
		}

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (!contactNumber.equals(patient.getContactNumber())) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

			boolean bindContactNumber = false;

			if (contactNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3);
			}
			else {
				bindContactNumber = true;

				sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
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

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByContactNumber_First(
			String contactNumber, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByContactNumber_First(
			contactNumber, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contactNumber=");
		sb.append(contactNumber);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByContactNumber_First(
		String contactNumber, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findByContactNumber(
			contactNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByContactNumber_Last(
			String contactNumber, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByContactNumber_Last(
			contactNumber, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("contactNumber=");
		sb.append(contactNumber);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByContactNumber_Last(
		String contactNumber, OrderByComparator<Patient> orderByComparator) {

		int count = countByContactNumber(contactNumber);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findByContactNumber(
			contactNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findByContactNumber_PrevAndNext(
			long govtId, String contactNumber,
			OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		contactNumber = Objects.toString(contactNumber, "");

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getByContactNumber_PrevAndNext(
				session, patient, contactNumber, orderByComparator, true);

			array[1] = patient;

			array[2] = getByContactNumber_PrevAndNext(
				session, patient, contactNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getByContactNumber_PrevAndNext(
		Session session, Patient patient, String contactNumber,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

		boolean bindContactNumber = false;

		if (contactNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3);
		}
		else {
			bindContactNumber = true;

			sb.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2);
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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindContactNumber) {
			queryPos.add(contactNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 */
	@Override
	public void removeByContactNumber(String contactNumber) {
		for (Patient patient :
				findByContactNumber(
					contactNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching patients
	 */
	@Override
	public int countByContactNumber(String contactNumber) {
		contactNumber = Objects.toString(contactNumber, "");

		FinderPath finderPath = _finderPathCountByContactNumber;

		Object[] finderArgs = new Object[] {contactNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

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
		"patient.contactNumber = ?";

	private static final String _FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3 =
		"(patient.contactNumber IS NULL OR patient.contactNumber = '')";

	private FinderPath _finderPathWithPaginationFindByEmail;
	private FinderPath _finderPathWithoutPaginationFindByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns all the patients where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findByEmail(String email) {
		return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findByEmail(String email, int start, int end) {
		return findByEmail(email, start, end, null);
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
	@Override
	public List<Patient> findByEmail(
		String email, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findByEmail(email, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findByEmail(
		String email, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		email = Objects.toString(email, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmail;
				finderArgs = new Object[] {email};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmail;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (!email.equals(patient.getEmail())) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
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

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByEmail_First(
			String email, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByEmail_First(email, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByEmail_First(
		String email, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findByEmail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByEmail_Last(
			String email, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByEmail_Last(email, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByEmail_Last(
		String email, OrderByComparator<Patient> orderByComparator) {

		int count = countByEmail(email);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findByEmail(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findByEmail_PrevAndNext(
			long govtId, String email,
			OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		email = Objects.toString(email, "");

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getByEmail_PrevAndNext(
				session, patient, email, orderByComparator, true);

			array[1] = patient;

			array[2] = getByEmail_PrevAndNext(
				session, patient, email, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getByEmail_PrevAndNext(
		Session session, Patient patient, String email,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmail) {
			queryPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByEmail(String email) {
		for (Patient patient :
				findByEmail(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching patients
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

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
		"patient.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(patient.email IS NULL OR patient.email = '')";

	private FinderPath _finderPathWithPaginationFindByAge;
	private FinderPath _finderPathWithoutPaginationFindByAge;
	private FinderPath _finderPathCountByAge;

	/**
	 * Returns all the patients where age = &#63;.
	 *
	 * @param age the age
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findByAge(long age) {
		return findByAge(age, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findByAge(long age, int start, int end) {
		return findByAge(age, start, end, null);
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
	@Override
	public List<Patient> findByAge(
		long age, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findByAge(age, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findByAge(
		long age, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAge;
				finderArgs = new Object[] {age};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAge;
			finderArgs = new Object[] {age, start, end, orderByComparator};
		}

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (age != patient.getAge()) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

			sb.append(_FINDER_COLUMN_AGE_AGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(age);

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByAge_First(
			long age, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByAge_First(age, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("age=");
		sb.append(age);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByAge_First(
		long age, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findByAge(age, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByAge_Last(
			long age, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByAge_Last(age, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("age=");
		sb.append(age);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where age = &#63;.
	 *
	 * @param age the age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByAge_Last(
		long age, OrderByComparator<Patient> orderByComparator) {

		int count = countByAge(age);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findByAge(
			age, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findByAge_PrevAndNext(
			long govtId, long age, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getByAge_PrevAndNext(
				session, patient, age, orderByComparator, true);

			array[1] = patient;

			array[2] = getByAge_PrevAndNext(
				session, patient, age, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getByAge_PrevAndNext(
		Session session, Patient patient, long age,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

		sb.append(_FINDER_COLUMN_AGE_AGE_2);

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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(age);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where age = &#63; from the database.
	 *
	 * @param age the age
	 */
	@Override
	public void removeByAge(long age) {
		for (Patient patient :
				findByAge(age, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where age = &#63;.
	 *
	 * @param age the age
	 * @return the number of matching patients
	 */
	@Override
	public int countByAge(long age) {
		FinderPath finderPath = _finderPathCountByAge;

		Object[] finderArgs = new Object[] {age};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

			sb.append(_FINDER_COLUMN_AGE_AGE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(age);

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

	private static final String _FINDER_COLUMN_AGE_AGE_2 = "patient.age = ?";

	private FinderPath _finderPathWithPaginationFindByPrimaryDoctor;
	private FinderPath _finderPathWithoutPaginationFindByPrimaryDoctor;
	private FinderPath _finderPathCountByPrimaryDoctor;

	/**
	 * Returns all the patients where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @return the matching patients
	 */
	@Override
	public List<Patient> findByPrimaryDoctor(long primaryDoctor) {
		return findByPrimaryDoctor(
			primaryDoctor, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end) {

		return findByPrimaryDoctor(primaryDoctor, start, end, null);
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
	@Override
	public List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end,
		OrderByComparator<Patient> orderByComparator) {

		return findByPrimaryDoctor(
			primaryDoctor, start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findByPrimaryDoctor(
		long primaryDoctor, int start, int end,
		OrderByComparator<Patient> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPrimaryDoctor;
				finderArgs = new Object[] {primaryDoctor};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPrimaryDoctor;
			finderArgs = new Object[] {
				primaryDoctor, start, end, orderByComparator
			};
		}

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Patient patient : list) {
					if (primaryDoctor != patient.getPrimaryDoctor()) {
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

			sb.append(_SQL_SELECT_PATIENT_WHERE);

			sb.append(_FINDER_COLUMN_PRIMARYDOCTOR_PRIMARYDOCTOR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PatientModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(primaryDoctor);

				list = (List<Patient>)QueryUtil.list(
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
	 * Returns the first patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByPrimaryDoctor_First(
			long primaryDoctor, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByPrimaryDoctor_First(
			primaryDoctor, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("primaryDoctor=");
		sb.append(primaryDoctor);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the first patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByPrimaryDoctor_First(
		long primaryDoctor, OrderByComparator<Patient> orderByComparator) {

		List<Patient> list = findByPrimaryDoctor(
			primaryDoctor, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient
	 * @throws NoSuchPatientException if a matching patient could not be found
	 */
	@Override
	public Patient findByPrimaryDoctor_Last(
			long primaryDoctor, OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = fetchByPrimaryDoctor_Last(
			primaryDoctor, orderByComparator);

		if (patient != null) {
			return patient;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("primaryDoctor=");
		sb.append(primaryDoctor);

		sb.append("}");

		throw new NoSuchPatientException(sb.toString());
	}

	/**
	 * Returns the last patient in the ordered set where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient, or <code>null</code> if a matching patient could not be found
	 */
	@Override
	public Patient fetchByPrimaryDoctor_Last(
		long primaryDoctor, OrderByComparator<Patient> orderByComparator) {

		int count = countByPrimaryDoctor(primaryDoctor);

		if (count == 0) {
			return null;
		}

		List<Patient> list = findByPrimaryDoctor(
			primaryDoctor, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Patient[] findByPrimaryDoctor_PrevAndNext(
			long govtId, long primaryDoctor,
			OrderByComparator<Patient> orderByComparator)
		throws NoSuchPatientException {

		Patient patient = findByPrimaryKey(govtId);

		Session session = null;

		try {
			session = openSession();

			Patient[] array = new PatientImpl[3];

			array[0] = getByPrimaryDoctor_PrevAndNext(
				session, patient, primaryDoctor, orderByComparator, true);

			array[1] = patient;

			array[2] = getByPrimaryDoctor_PrevAndNext(
				session, patient, primaryDoctor, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Patient getByPrimaryDoctor_PrevAndNext(
		Session session, Patient patient, long primaryDoctor,
		OrderByComparator<Patient> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PATIENT_WHERE);

		sb.append(_FINDER_COLUMN_PRIMARYDOCTOR_PRIMARYDOCTOR_2);

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
			sb.append(PatientModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(primaryDoctor);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(patient)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Patient> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patients where primaryDoctor = &#63; from the database.
	 *
	 * @param primaryDoctor the primary doctor
	 */
	@Override
	public void removeByPrimaryDoctor(long primaryDoctor) {
		for (Patient patient :
				findByPrimaryDoctor(
					primaryDoctor, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patient);
		}
	}

	/**
	 * Returns the number of patients where primaryDoctor = &#63;.
	 *
	 * @param primaryDoctor the primary doctor
	 * @return the number of matching patients
	 */
	@Override
	public int countByPrimaryDoctor(long primaryDoctor) {
		FinderPath finderPath = _finderPathCountByPrimaryDoctor;

		Object[] finderArgs = new Object[] {primaryDoctor};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENT_WHERE);

			sb.append(_FINDER_COLUMN_PRIMARYDOCTOR_PRIMARYDOCTOR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(primaryDoctor);

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

	private static final String _FINDER_COLUMN_PRIMARYDOCTOR_PRIMARYDOCTOR_2 =
		"patient.primaryDoctor = ?";

	public PatientPersistenceImpl() {
		setModelClass(Patient.class);

		setModelImplClass(PatientImpl.class);
		setModelPKClass(long.class);

		setTable(PatientTable.INSTANCE);
	}

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	@Override
	public void cacheResult(Patient patient) {
		entityCache.putResult(
			PatientImpl.class, patient.getPrimaryKey(), patient);

		finderCache.putResult(
			_finderPathFetchByGovtId, new Object[] {patient.getGovtId()},
			patient);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	@Override
	public void cacheResult(List<Patient> patients) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (patients.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Patient patient : patients) {
			if (entityCache.getResult(
					PatientImpl.class, patient.getPrimaryKey()) == null) {

				cacheResult(patient);
			}
		}
	}

	/**
	 * Clears the cache for all patients.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PatientImpl.class);

		finderCache.clearCache(PatientImpl.class);
	}

	/**
	 * Clears the cache for the patient.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Patient patient) {
		entityCache.removeResult(PatientImpl.class, patient);
	}

	@Override
	public void clearCache(List<Patient> patients) {
		for (Patient patient : patients) {
			entityCache.removeResult(PatientImpl.class, patient);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PatientImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PatientImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PatientModelImpl patientModelImpl) {
		Object[] args = new Object[] {patientModelImpl.getGovtId()};

		finderCache.putResult(_finderPathCountByGovtId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByGovtId, args, patientModelImpl);
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param govtId the primary key for the new patient
	 * @return the new patient
	 */
	@Override
	public Patient create(long govtId) {
		Patient patient = new PatientImpl();

		patient.setNew(true);
		patient.setPrimaryKey(govtId);

		return patient;
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient that was removed
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	@Override
	public Patient remove(long govtId) throws NoSuchPatientException {
		return remove((Serializable)govtId);
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient that was removed
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	@Override
	public Patient remove(Serializable primaryKey)
		throws NoSuchPatientException {

		Session session = null;

		try {
			session = openSession();

			Patient patient = (Patient)session.get(
				PatientImpl.class, primaryKey);

			if (patient == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatientException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(patient);
		}
		catch (NoSuchPatientException noSuchEntityException) {
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
	protected Patient removeImpl(Patient patient) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patient)) {
				patient = (Patient)session.get(
					PatientImpl.class, patient.getPrimaryKeyObj());
			}

			if (patient != null) {
				session.delete(patient);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (patient != null) {
			clearCache(patient);
		}

		return patient;
	}

	@Override
	public Patient updateImpl(Patient patient) {
		boolean isNew = patient.isNew();

		if (!(patient instanceof PatientModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(patient.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(patient);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in patient proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Patient implementation " +
					patient.getClass());
		}

		PatientModelImpl patientModelImpl = (PatientModelImpl)patient;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(patient);
			}
			else {
				patient = (Patient)session.merge(patient);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PatientImpl.class, patientModelImpl, false, true);

		cacheUniqueFindersCache(patientModelImpl);

		if (isNew) {
			patient.setNew(false);
		}

		patient.resetOriginalValues();

		return patient;
	}

	/**
	 * Returns the patient with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	@Override
	public Patient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatientException {

		Patient patient = fetchByPrimaryKey(primaryKey);

		if (patient == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatientException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return patient;
	}

	/**
	 * Returns the patient with the primary key or throws a <code>NoSuchPatientException</code> if it could not be found.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient
	 * @throws NoSuchPatientException if a patient with the primary key could not be found
	 */
	@Override
	public Patient findByPrimaryKey(long govtId) throws NoSuchPatientException {
		return findByPrimaryKey((Serializable)govtId);
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param govtId the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 */
	@Override
	public Patient fetchByPrimaryKey(long govtId) {
		return fetchByPrimaryKey((Serializable)govtId);
	}

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 */
	@Override
	public List<Patient> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Patient> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Patient> findAll(
		int start, int end, OrderByComparator<Patient> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Patient> findAll(
		int start, int end, OrderByComparator<Patient> orderByComparator,
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

		List<Patient> list = null;

		if (useFinderCache) {
			list = (List<Patient>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PATIENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENT;

				sql = sql.concat(PatientModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Patient>)QueryUtil.list(
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
	 * Removes all the patients from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Patient patient : findAll()) {
			remove(patient);
		}
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PATIENT);

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
		return "govtId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PATIENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PatientModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the patient persistence.
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

		_finderPathFetchByGovtId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGovtId",
			new String[] {Long.class.getName()}, new String[] {"govtId"}, true);

		_finderPathCountByGovtId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGovtId",
			new String[] {Long.class.getName()}, new String[] {"govtId"},
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

		_finderPathWithPaginationFindByInsuranceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInsuranceId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"insuranceId"}, true);

		_finderPathWithoutPaginationFindByInsuranceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInsuranceId",
			new String[] {String.class.getName()}, new String[] {"insuranceId"},
			true);

		_finderPathCountByInsuranceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInsuranceId",
			new String[] {String.class.getName()}, new String[] {"insuranceId"},
			false);

		_finderPathWithPaginationFindByContactNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"contactNumber"}, true);

		_finderPathWithoutPaginationFindByContactNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactNumber",
			new String[] {String.class.getName()},
			new String[] {"contactNumber"}, true);

		_finderPathCountByContactNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactNumber",
			new String[] {String.class.getName()},
			new String[] {"contactNumber"}, false);

		_finderPathWithPaginationFindByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"email"}, true);

		_finderPathWithoutPaginationFindByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathWithPaginationFindByAge = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAge",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"age"}, true);

		_finderPathWithoutPaginationFindByAge = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAge",
			new String[] {Long.class.getName()}, new String[] {"age"}, true);

		_finderPathCountByAge = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAge",
			new String[] {Long.class.getName()}, new String[] {"age"}, false);

		_finderPathWithPaginationFindByPrimaryDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrimaryDoctor",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"primaryDoctor"}, true);

		_finderPathWithoutPaginationFindByPrimaryDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrimaryDoctor",
			new String[] {Long.class.getName()}, new String[] {"primaryDoctor"},
			true);

		_finderPathCountByPrimaryDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrimaryDoctor",
			new String[] {Long.class.getName()}, new String[] {"primaryDoctor"},
			false);

		_setPatientUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPatientUtilPersistence(null);

		entityCache.removeCache(PatientImpl.class.getName());
	}

	private void _setPatientUtilPersistence(
		PatientPersistence patientPersistence) {

		try {
			Field field = PatientUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, patientPersistence);
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

	private static final String _SQL_SELECT_PATIENT =
		"SELECT patient FROM Patient patient";

	private static final String _SQL_SELECT_PATIENT_WHERE =
		"SELECT patient FROM Patient patient WHERE ";

	private static final String _SQL_COUNT_PATIENT =
		"SELECT COUNT(patient) FROM Patient patient";

	private static final String _SQL_COUNT_PATIENT_WHERE =
		"SELECT COUNT(patient) FROM Patient patient WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "patient.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Patient exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Patient exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PatientPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}