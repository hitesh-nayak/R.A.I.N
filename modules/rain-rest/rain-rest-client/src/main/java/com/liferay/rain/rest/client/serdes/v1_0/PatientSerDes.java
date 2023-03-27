package com.liferay.rain.rest.client.serdes.v1_0;

import com.liferay.rain.rest.client.dto.v1_0.Patient;
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
public class PatientSerDes {

	public static Patient toDTO(String json) {
		PatientJSONParser patientJSONParser = new PatientJSONParser();

		return patientJSONParser.parseToDTO(json);
	}

	public static Patient[] toDTOs(String json) {
		PatientJSONParser patientJSONParser = new PatientJSONParser();

		return patientJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Patient patient) {
		if (patient == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (patient.getAge() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"age\": ");

			sb.append(patient.getAge());
		}

		if (patient.getContactNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactNumber\": ");

			sb.append("\"");

			sb.append(_escape(patient.getContactNumber()));

			sb.append("\"");
		}

		if (patient.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(patient.getEmail()));

			sb.append("\"");
		}

		if (patient.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(patient.getFirstName()));

			sb.append("\"");
		}

		if (patient.getGovtId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"govtId\": ");

			sb.append("\"");

			sb.append(_escape(patient.getGovtId()));

			sb.append("\"");
		}

		if (patient.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(patient.getGroupId());
		}

		if (patient.getInsuranceId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"insuranceId\": ");

			sb.append("\"");

			sb.append(_escape(patient.getInsuranceId()));

			sb.append("\"");
		}

		if (patient.getIsAdult() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isAdult\": ");

			sb.append(patient.getIsAdult());
		}

		if (patient.getNationality() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nationality\": ");

			sb.append("\"");

			sb.append(_escape(patient.getNationality()));

			sb.append("\"");
		}

		if (patient.getPrimaryDoctor() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"primaryDoctor\": ");

			sb.append(patient.getPrimaryDoctor());
		}

		if (patient.getSurname() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"surname\": ");

			sb.append("\"");

			sb.append(_escape(patient.getSurname()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PatientJSONParser patientJSONParser = new PatientJSONParser();

		return patientJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Patient patient) {
		if (patient == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (patient.getAge() == null) {
			map.put("age", null);
		}
		else {
			map.put("age", String.valueOf(patient.getAge()));
		}

		if (patient.getContactNumber() == null) {
			map.put("contactNumber", null);
		}
		else {
			map.put(
				"contactNumber", String.valueOf(patient.getContactNumber()));
		}

		if (patient.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(patient.getEmail()));
		}

		if (patient.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(patient.getFirstName()));
		}

		if (patient.getGovtId() == null) {
			map.put("govtId", null);
		}
		else {
			map.put("govtId", String.valueOf(patient.getGovtId()));
		}

		if (patient.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(patient.getGroupId()));
		}

		if (patient.getInsuranceId() == null) {
			map.put("insuranceId", null);
		}
		else {
			map.put("insuranceId", String.valueOf(patient.getInsuranceId()));
		}

		if (patient.getIsAdult() == null) {
			map.put("isAdult", null);
		}
		else {
			map.put("isAdult", String.valueOf(patient.getIsAdult()));
		}

		if (patient.getNationality() == null) {
			map.put("nationality", null);
		}
		else {
			map.put("nationality", String.valueOf(patient.getNationality()));
		}

		if (patient.getPrimaryDoctor() == null) {
			map.put("primaryDoctor", null);
		}
		else {
			map.put(
				"primaryDoctor", String.valueOf(patient.getPrimaryDoctor()));
		}

		if (patient.getSurname() == null) {
			map.put("surname", null);
		}
		else {
			map.put("surname", String.valueOf(patient.getSurname()));
		}

		return map;
	}

	public static class PatientJSONParser extends BaseJSONParser<Patient> {

		@Override
		protected Patient createDTO() {
			return new Patient();
		}

		@Override
		protected Patient[] createDTOArray(int size) {
			return new Patient[size];
		}

		@Override
		protected void setField(
			Patient patient, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "age")) {
				if (jsonParserFieldValue != null) {
					patient.setAge(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contactNumber")) {
				if (jsonParserFieldValue != null) {
					patient.setContactNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					patient.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					patient.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "govtId")) {
				if (jsonParserFieldValue != null) {
					patient.setGovtId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					patient.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "insuranceId")) {
				if (jsonParserFieldValue != null) {
					patient.setInsuranceId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "isAdult")) {
				if (jsonParserFieldValue != null) {
					patient.setIsAdult((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "nationality")) {
				if (jsonParserFieldValue != null) {
					patient.setNationality((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "primaryDoctor")) {
				if (jsonParserFieldValue != null) {
					patient.setPrimaryDoctor(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "surname")) {
				if (jsonParserFieldValue != null) {
					patient.setSurname((String)jsonParserFieldValue);
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