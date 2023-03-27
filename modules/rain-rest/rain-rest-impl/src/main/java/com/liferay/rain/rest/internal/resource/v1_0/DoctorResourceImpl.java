package com.liferay.rain.rest.internal.resource.v1_0;



import com.liferay.rain.rest.resource.v1_0.DoctorResource;
import com.liferay.rain.service.model.Doctor;
import com.liferay.rain.service.service.DoctorService;
import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/doctor.properties",
	scope = ServiceScope.PROTOTYPE, service = DoctorResource.class
)
public class DoctorResourceImpl extends BaseDoctorResourceImpl {

	@Reference
	private DoctorService doctorService;

	@Override
	public com.liferay.rain.rest.dto.v1_0.Doctor postDoctor(com.liferay.rain.rest.dto.v1_0.Doctor doctor) throws  Exception{

		com.liferay.rain.service.model.Doctor serviceDoctor = doctorService.post(doctor.getGroupId());

		com.liferay.rain.rest.dto.v1_0.Doctor returnDoctor = new com.liferay.rain.rest.dto.v1_0.Doctor();
		returnDoctor.setGroupId(serviceDoctor.getGroupId());
		return returnDoctor;
	}


//	public static void main(String[] args) throws Exception {
//
//		DoctorResource.Builder docBuilder = DoctorResource.builder();
//		DoctorResource doctorResource = docBuilder.authentication("test@liferay.com", "learn")
//				.build();
//		long empId = (int)(Math.random()*10e5);
//		Doctor doctor = new Doctor();
//		doctor.setGroupId(20120L);
//		doctor.setEmployeeId(empId);

//		System.out.println(doctorResource.postDoctor(doctor));

	}


