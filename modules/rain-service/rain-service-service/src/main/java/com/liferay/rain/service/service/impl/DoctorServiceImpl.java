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

package com.liferay.rain.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.rain.service.model.Doctor;
import com.liferay.rain.service.service.base.DoctorServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=rain",
		"json.web.service.context.path=Doctor"
	},
	service = AopService.class
)
public class DoctorServiceImpl extends DoctorServiceBaseImpl {

	public Doctor post (long groupId) {




		Doctor doctor = doctorLocalService.createDoctor((int)(Math.random()*100000));
		doctor.setGroupId(groupId);
		return doctorLocalService.addDoctor(doctor);

	}
}