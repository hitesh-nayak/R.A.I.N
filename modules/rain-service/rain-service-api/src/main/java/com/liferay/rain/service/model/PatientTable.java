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
 * The table class for the &quot;Rain_Patient&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
public class PatientTable extends BaseTable<PatientTable> {

	public static final PatientTable INSTANCE = new PatientTable();

	public final Column<PatientTable, Long> govtId = createColumn(
		"govtId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PatientTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PatientTable, String> surname = createColumn(
		"surname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientTable, String> nationality = createColumn(
		"nationality", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientTable, Long> age = createColumn(
		"age", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PatientTable, Boolean> isAdult = createColumn(
		"isAdult", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PatientTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientTable, String> contactNumber = createColumn(
		"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientTable, String> insuranceId = createColumn(
		"insuranceId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientTable, Long> primaryDoctor = createColumn(
		"primaryDoctor", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PatientTable() {
		super("Rain_Patient", PatientTable::new);
	}

}