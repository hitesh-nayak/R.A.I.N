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

package com.liferay.rain.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Rain_Doctor&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Doctor
 * @generated
 */
public class DoctorTable extends BaseTable<DoctorTable> {

	public static final DoctorTable INSTANCE = new DoctorTable();

	public final Column<DoctorTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DoctorTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> surname = createColumn(
		"surname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> department = createColumn(
		"department", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> govtId = createColumn(
		"govtId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> nationality = createColumn(
		"nationality", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> payGroup = createColumn(
		"payGroup", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorTable, String> contactNumber = createColumn(
		"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DoctorTable() {
		super("Rain_Doctor", DoctorTable::new);
	}

}