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

package com.liferay.rain.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DoctorService}.
 *
 * @author Brian Wing Shun Chan
 * @see DoctorService
 * @generated
 */
public class DoctorServiceWrapper
	implements DoctorService, ServiceWrapper<DoctorService> {

	public DoctorServiceWrapper() {
		this(null);
	}

	public DoctorServiceWrapper(DoctorService doctorService) {
		_doctorService = doctorService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _doctorService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.rain.service.model.Doctor post(long groupId) {
		return _doctorService.post(groupId);
	}

	@Override
	public DoctorService getWrappedService() {
		return _doctorService;
	}

	@Override
	public void setWrappedService(DoctorService doctorService) {
		_doctorService = doctorService;
	}

	private DoctorService _doctorService;

}