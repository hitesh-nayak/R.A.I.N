package com.liferay.rain.rest.internal.resource.v1_0;

import com.liferay.rain.rest.resource.v1_0.PatientResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/patient.properties",
	scope = ServiceScope.PROTOTYPE, service = PatientResource.class
)
public class PatientResourceImpl extends BasePatientResourceImpl {
}