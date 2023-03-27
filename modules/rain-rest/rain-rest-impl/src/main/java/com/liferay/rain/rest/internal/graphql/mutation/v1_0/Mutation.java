package com.liferay.rain.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.rain.rest.dto.v1_0.Doctor;
import com.liferay.rain.rest.dto.v1_0.Patient;
import com.liferay.rain.rest.resource.v1_0.DoctorResource;
import com.liferay.rain.rest.resource.v1_0.PatientResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Mutation {

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

	@GraphQLField
	public boolean deleteDoctor(@GraphQLName("employeeId") Long employeeId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.deleteDoctor(employeeId));

		return true;
	}

	@GraphQLField
	public Response deleteDoctorBatch(
			@GraphQLName("employeeId") Long employeeId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.deleteDoctorBatch(
				employeeId, callbackURL, object));
	}

	@GraphQLField
	public Doctor patchDoctor(
			@GraphQLName("employeeId") Long employeeId,
			@GraphQLName("doctor") Doctor doctor)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.patchDoctor(employeeId, doctor));
	}

	@GraphQLField
	public Doctor updateDoctor(
			@GraphQLName("employeeId") Long employeeId,
			@GraphQLName("doctor") Doctor doctor)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.putDoctor(employeeId, doctor));
	}

	@GraphQLField
	public Response updateDoctorBatch(
			@GraphQLName("employeeId") Long employeeId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.putDoctorBatch(
				employeeId, callbackURL, object));
	}

	@GraphQLField
	public Doctor createDoctor(@GraphQLName("doctor") Doctor doctor)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.postDoctor(doctor));
	}

	@GraphQLField
	public Response createDoctorBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_doctorResourceComponentServiceObjects,
			this::_populateResourceContext,
			doctorResource -> doctorResource.postDoctorBatch(
				callbackURL, object));
	}

	@GraphQLField
	public boolean deletePatient(@GraphQLName("govtId") String govtId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.deletePatient(govtId));

		return true;
	}

	@GraphQLField
	public Response deletePatientBatch(
			@GraphQLName("govtId") String govtId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.deletePatientBatch(
				govtId, callbackURL, object));
	}

	@GraphQLField
	public Patient patchPatient(
			@GraphQLName("govtId") String govtId,
			@GraphQLName("patient") Patient patient)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.patchPatient(govtId, patient));
	}

	@GraphQLField
	public Patient updatePatient(
			@GraphQLName("govtId") String govtId,
			@GraphQLName("patient") Patient patient)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.putPatient(govtId, patient));
	}

	@GraphQLField
	public Response updatePatientBatch(
			@GraphQLName("govtId") String govtId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.putPatientBatch(
				govtId, callbackURL, object));
	}

	@GraphQLField
	public Patient createPatient(@GraphQLName("patient") Patient patient)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.postPatient(patient));
	}

	@GraphQLField
	public Response createPatientBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_patientResourceComponentServiceObjects,
			this::_populateResourceContext,
			patientResource -> patientResource.postPatientBatch(
				callbackURL, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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

		doctorResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
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

		patientResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<DoctorResource>
		_doctorResourceComponentServiceObjects;
	private static ComponentServiceObjects<PatientResource>
		_patientResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}