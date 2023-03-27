package com.liferay.rain.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.rain.rest.dto.v1_0.Doctor;
import com.liferay.rain.rest.dto.v1_0.Patient;
import com.liferay.rain.rest.resource.v1_0.DoctorResource;
import com.liferay.rain.rest.resource.v1_0.PatientResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Query {

	public static void setDoctorResourceComponentServiceObjects(
		ComponentServiceObjects<DoctorResource>
			doctorResourceComponentServiceObjects) {

		_doctorResourceComponentServiceObjects =
			doctorResourceComponentServiceObjects;
	}

	public static void setPatientResourceComponentServiceObjects(
		ComponentServiceObjects<PatientResource>
			patientResourceComponentServiceObjects) {

		_patientResourceComponentServiceObjects =
			patientResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {doctor(employeeId: ___){employeeId, groupId, surname, firstName, department, govtId, nationality, payGroup, email, contactNumber}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Doctor doctor(@GraphQLName("employeeId") Long employeeId)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.getDoctor(employeeId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {doctorsByDept(department: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public DoctorPage doctorsByDept(
			@GraphQLName("department") String department)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> new DoctorPage(
				doctorResource.getDoctorsByDept(department)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {doctorsBySurname(surname: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public DoctorPage doctorsBySurname(@GraphQLName("surname") String surname)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> new DoctorPage(
				doctorResource.getDoctorsBySurname(surname)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {patient(govtId: ___){govtId, groupId, surname, firstName, nationality, age, isAdult, email, contactNumber, insuranceId, primaryDoctor}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Patient patient(@GraphQLName("govtId") String govtId)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.getPatient(govtId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {patientsByAge(age: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public PatientPage patientsByAge(@GraphQLName("age") String age)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> new PatientPage(
				patientResource.getPatientsByAge(age)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {patientsBySurname(surname: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public PatientPage patientsBySurname(@GraphQLName("surname") String surname)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> new PatientPage(
				patientResource.getPatientsBySurname(surname)));
	}

	@GraphQLName("DoctorPage")
	public class DoctorPage {

		public DoctorPage(Page doctorPage) {
			actions = doctorPage.getActions();

			items = doctorPage.getItems();
			lastPage = doctorPage.getLastPage();
			page = doctorPage.getPage();
			pageSize = doctorPage.getPageSize();
			totalCount = doctorPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Doctor> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("PatientPage")
	public class PatientPage {

		public PatientPage(Page patientPage) {
			actions = patientPage.getActions();

			items = patientPage.getItems();
			lastPage = patientPage.getLastPage();
			page = patientPage.getPage();
			pageSize = patientPage.getPageSize();
			totalCount = patientPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Patient> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(DoctorResource doctorResource)
		throws Exception {

		doctorResource.setContextAcceptLanguage(_acceptLanguage);
		doctorResource.setContextCompany(_company);
		doctorResource.setContextHttpServletRequest(_httpServletRequest);
		doctorResource.setContextHttpServletResponse(_httpServletResponse);
		doctorResource.setContextUriInfo(_uriInfo);
		doctorResource.setContextUser(_user);
		doctorResource.setGroupLocalService(_groupLocalService);
		doctorResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(PatientResource patientResource)
		throws Exception {

		patientResource.setContextAcceptLanguage(_acceptLanguage);
		patientResource.setContextCompany(_company);
		patientResource.setContextHttpServletRequest(_httpServletRequest);
		patientResource.setContextHttpServletResponse(_httpServletResponse);
		patientResource.setContextUriInfo(_uriInfo);
		patientResource.setContextUser(_user);
		patientResource.setGroupLocalService(_groupLocalService);
		patientResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<DoctorResource>
		_doctorResourceComponentServiceObjects;
	private static ComponentServiceObjects<PatientResource>
		_patientResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}