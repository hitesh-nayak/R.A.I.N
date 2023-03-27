package com.liferay.rain.rest.client.serdes.v1_0;

import com.liferay.rain.rest.client.dto.v1_0.Doctor;
import com.liferay.rain.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class DoctorSerDes {

	public static Doctor toDTO(String json) {
		DoctorJSONParser doctorJSONParser = new DoctorJSONParser();

		return doctorJSONParser.parseToDTO(json);
	}

	public static Doctor[] toDTOs(String json) {
		DoctorJSONParser doctorJSONParser = new DoctorJSONParser();

		return doctorJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Doctor doctor) {
		if (doctor == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (doctor.getContactNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactNumber\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getContactNumber()));

			sb.append("\"");
		}

		if (doctor.getDepartment() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"department\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getDepartment()));

			sb.append("\"");
		}

		if (doctor.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getEmail()));

			sb.append("\"");
		}

		if (doctor.getEmployeeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"employeeId\": ");

			sb.append(doctor.getEmployeeId());
		}

		if (doctor.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getFirstName()));

			sb.append("\"");
		}

		if (doctor.getGovtId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"govtId\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getGovtId()));

			sb.append("\"");
		}

		if (doctor.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(doctor.getGroupId());
		}

		if (doctor.getNationality() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nationality\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getNationality()));

			sb.append("\"");
		}

		if (doctor.getPayGroup() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"payGroup\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getPayGroup()));

			sb.append("\"");
		}

		if (doctor.getSurname() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"surname\": ");

			sb.append("\"");

			sb.append(_escape(doctor.getSurname()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DoctorJSONParser doctorJSONParser = new DoctorJSONParser();

		return doctorJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Doctor doctor) {
		if (doctor == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (doctor.getContactNumber() == null) {
			map.put("contactNumber", null);
		}
		else {
			map.put("contactNumber", String.valueOf(doctor.getContactNumber()));
		}

		if (doctor.getDepartment() == null) {
			map.put("department", null);
		}
		else {
			map.put("department", String.valueOf(doctor.getDepartment()));
		}

		if (doctor.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(doctor.getEmail()));
		}

		if (doctor.getEmployeeId() == null) {
			map.put("employeeId", null);
		}
		else {
			map.put("employeeId", String.valueOf(doctor.getEmployeeId()));
		}

		if (doctor.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(doctor.getFirstName()));
		}

		if (doctor.getGovtId() == null) {
			map.put("govtId", null);
		}
		else {
			map.put("govtId", String.valueOf(doctor.getGovtId()));
		}

		if (doctor.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(doctor.getGroupId()));
		}

		if (doctor.getNationality() == null) {
			map.put("nationality", null);
		}
		else {
			map.put("nationality", String.valueOf(doctor.getNationality()));
		}

		if (doctor.getPayGroup() == null) {
			map.put("payGroup", null);
		}
		else {
			map.put("payGroup", String.valueOf(doctor.getPayGroup()));
		}

		if (doctor.getSurname() == null) {
			map.put("surname", null);
		}
		else {
			map.put("surname", String.valueOf(doctor.getSurname()));
		}

		return map;
	}

	public static class DoctorJSONParser extends BaseJSONParser<Doctor> {

		@Override
		protected Doctor createDTO() {
			return new Doctor();
		}

		@Override
		protected Doctor[] createDTOArray(int size) {
			return new Doctor[size];
		}

		@Override
		protected void setField(
			Doctor doctor, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "contactNumber")) {
				if (jsonParserFieldValue != null) {
					doctor.setContactNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "department")) {
				if (jsonParserFieldValue != null) {
					doctor.setDepartment((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					doctor.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "employeeId")) {
				if (jsonParserFieldValue != null) {
					doctor.setEmployeeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					doctor.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "govtId")) {
				if (jsonParserFieldValue != null) {
					doctor.setGovtId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					doctor.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nationality")) {
				if (jsonParserFieldValue != null) {
					doctor.setNationality((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "payGroup")) {
				if (jsonParserFieldValue != null) {
					doctor.setPayGroup((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "surname")) {
				if (jsonParserFieldValue != null) {
					doctor.setSurname((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}