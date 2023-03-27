package com.liferay.rain.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;
import com.liferay.rain.rest.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.rain.rest.internal.graphql.query.v1_0.Query;
import com.liferay.rain.rest.internal.resource.v1_0.DoctorResourceImpl;
import com.liferay.rain.rest.internal.resource.v1_0.PatientResourceImpl;
import com.liferay.rain.rest.resource.v1_0.DoctorResource;
import com.liferay.rain.rest.resource.v1_0.PatientResource;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author me
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setDoctorResourceComponentServiceObjects(
			_doctorResourceComponentServiceObjects);
		Mutation.setPatientResourceComponentServiceObjects(
			_patientResourceComponentServiceObjects);

		Query.setDoctorResourceComponentServiceObjects(
			_doctorResourceComponentServiceObjects);
		Query.setPatientResourceComponentServiceObjects(
			_patientResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "RainRest";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/rain-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#deleteDoctor",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "deleteDoctor"));
					put(
						"mutation#deleteDoctorBatch",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "deleteDoctorBatch"));
					put(
						"mutation#patchDoctor",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "patchDoctor"));
					put(
						"mutation#updateDoctor",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "putDoctor"));
					put(
						"mutation#updateDoctorBatch",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "putDoctorBatch"));
					put(
						"mutation#createDoctor",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "postDoctor"));
					put(
						"mutation#createDoctorBatch",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "postDoctorBatch"));
					put(
						"mutation#deletePatient",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "deletePatient"));
					put(
						"mutation#deletePatientBatch",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "deletePatientBatch"));
					put(
						"mutation#patchPatient",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "patchPatient"));
					put(
						"mutation#updatePatient",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "putPatient"));
					put(
						"mutation#updatePatientBatch",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "putPatientBatch"));
					put(
						"mutation#createPatient",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "postPatient"));
					put(
						"mutation#createPatientBatch",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "postPatientBatch"));

					put(
						"query#doctor",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "getDoctor"));
					put(
						"query#doctorsByDept",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "getDoctorsByDept"));
					put(
						"query#doctorsBySurname",
						new ObjectValuePair<>(
							DoctorResourceImpl.class, "getDoctorsBySurname"));
					put(
						"query#patient",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "getPatient"));
					put(
						"query#patientsByAge",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "getPatientsByAge"));
					put(
						"query#patientsBySurname",
						new ObjectValuePair<>(
							PatientResourceImpl.class, "getPatientsBySurname"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DoctorResource>
		_doctorResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PatientResource>
		_patientResourceComponentServiceObjects;

}