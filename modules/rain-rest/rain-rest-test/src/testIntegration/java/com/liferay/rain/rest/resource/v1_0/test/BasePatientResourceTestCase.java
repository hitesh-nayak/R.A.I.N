package com.liferay.rain.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.rain.rest.client.dto.v1_0.Patient;
import com.liferay.rain.rest.client.http.HttpInvoker;
import com.liferay.rain.rest.client.pagination.Page;
import com.liferay.rain.rest.client.resource.v1_0.PatientResource;
import com.liferay.rain.rest.client.serdes.v1_0.PatientSerDes;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author me
 * @generated
 */
@Generated("")
public abstract class BasePatientResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_patientResource.setContextCompany(testCompany);

		PatientResource.Builder builder = PatientResource.builder();

		patientResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Patient patient1 = randomPatient();

		String json = objectMapper.writeValueAsString(patient1);

		Patient patient2 = PatientSerDes.toDTO(json);

		Assert.assertTrue(equals(patient1, patient2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Patient patient = randomPatient();

		String json1 = objectMapper.writeValueAsString(patient);
		String json2 = PatientSerDes.toJSON(patient);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Patient patient = randomPatient();

		patient.setContactNumber(regex);
		patient.setEmail(regex);
		patient.setFirstName(regex);
		patient.setGovtId(regex);
		patient.setInsuranceId(regex);
		patient.setNationality(regex);
		patient.setSurname(regex);

		String json = PatientSerDes.toJSON(patient);

		Assert.assertFalse(json.contains(regex));

		patient = PatientSerDes.toDTO(json);

		Assert.assertEquals(regex, patient.getContactNumber());
		Assert.assertEquals(regex, patient.getEmail());
		Assert.assertEquals(regex, patient.getFirstName());
		Assert.assertEquals(regex, patient.getGovtId());
		Assert.assertEquals(regex, patient.getInsuranceId());
		Assert.assertEquals(regex, patient.getNationality());
		Assert.assertEquals(regex, patient.getSurname());
	}

	@Test
	public void testDeletePatient() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeletePatient() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetPatient() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetPatient() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetPatientNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPatchPatient() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPutPatient() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetPatientsByAge() throws Exception {
		String age = testGetPatientsByAge_getAge();
		String irrelevantAge = testGetPatientsByAge_getIrrelevantAge();

		Page<Patient> page = patientResource.getPatientsByAge(age);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantAge != null) {
			Patient irrelevantPatient = testGetPatientsByAge_addPatient(
				irrelevantAge, randomIrrelevantPatient());

			page = patientResource.getPatientsByAge(irrelevantAge);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantPatient),
				(List<Patient>)page.getItems());
			assertValid(page);
		}

		Patient patient1 = testGetPatientsByAge_addPatient(
			age, randomPatient());

		Patient patient2 = testGetPatientsByAge_addPatient(
			age, randomPatient());

		page = patientResource.getPatientsByAge(age);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(patient1, patient2), (List<Patient>)page.getItems());
		assertValid(page);
	}

	protected Patient testGetPatientsByAge_addPatient(
			String age, Patient patient)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetPatientsByAge_getAge() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetPatientsByAge_getIrrelevantAge() throws Exception {
		return null;
	}

	@Test
	public void testGetPatientsBySurname() throws Exception {
		String surname = testGetPatientsBySurname_getSurname();
		String irrelevantSurname =
			testGetPatientsBySurname_getIrrelevantSurname();

		Page<Patient> page = patientResource.getPatientsBySurname(surname);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantSurname != null) {
			Patient irrelevantPatient = testGetPatientsBySurname_addPatient(
				irrelevantSurname, randomIrrelevantPatient());

			page = patientResource.getPatientsBySurname(irrelevantSurname);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantPatient),
				(List<Patient>)page.getItems());
			assertValid(page);
		}

		Patient patient1 = testGetPatientsBySurname_addPatient(
			surname, randomPatient());

		Patient patient2 = testGetPatientsBySurname_addPatient(
			surname, randomPatient());

		page = patientResource.getPatientsBySurname(surname);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(patient1, patient2), (List<Patient>)page.getItems());
		assertValid(page);
	}

	protected Patient testGetPatientsBySurname_addPatient(
			String surname, Patient patient)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetPatientsBySurname_getSurname() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetPatientsBySurname_getIrrelevantSurname()
		throws Exception {

		return null;
	}

	@Test
	public void testPostPatient() throws Exception {
		Patient randomPatient = randomPatient();

		Patient postPatient = testPostPatient_addPatient(randomPatient);

		assertEquals(randomPatient, postPatient);
		assertValid(postPatient);
	}

	protected Patient testPostPatient_addPatient(Patient patient)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Patient patient, List<Patient> patients) {
		boolean contains = false;

		for (Patient item : patients) {
			if (equals(patient, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(patients + " does not contain " + patient, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Patient patient1, Patient patient2) {
		Assert.assertTrue(
			patient1 + " does not equal " + patient2,
			equals(patient1, patient2));
	}

	protected void assertEquals(
		List<Patient> patients1, List<Patient> patients2) {

		Assert.assertEquals(patients1.size(), patients2.size());

		for (int i = 0; i < patients1.size(); i++) {
			Patient patient1 = patients1.get(i);
			Patient patient2 = patients2.get(i);

			assertEquals(patient1, patient2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Patient> patients1, List<Patient> patients2) {

		Assert.assertEquals(patients1.size(), patients2.size());

		for (Patient patient1 : patients1) {
			boolean contains = false;

			for (Patient patient2 : patients2) {
				if (equals(patient1, patient2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				patients2 + " does not contain " + patient1, contains);
		}
	}

	protected void assertValid(Patient patient) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("age", additionalAssertFieldName)) {
				if (patient.getAge() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("contactNumber", additionalAssertFieldName)) {
				if (patient.getContactNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (patient.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (patient.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("govtId", additionalAssertFieldName)) {
				if (patient.getGovtId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (patient.getGroupId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("insuranceId", additionalAssertFieldName)) {
				if (patient.getInsuranceId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("isAdult", additionalAssertFieldName)) {
				if (patient.getIsAdult() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nationality", additionalAssertFieldName)) {
				if (patient.getNationality() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("primaryDoctor", additionalAssertFieldName)) {
				if (patient.getPrimaryDoctor() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("surname", additionalAssertFieldName)) {
				if (patient.getSurname() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Patient> page) {
		boolean valid = false;

		java.util.Collection<Patient> patients = page.getItems();

		int size = patients.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.rain.rest.dto.v1_0.Patient.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Patient patient1, Patient patient2) {
		if (patient1 == patient2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("age", additionalAssertFieldName)) {
				if (!Objects.deepEquals(patient1.getAge(), patient2.getAge())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("contactNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getContactNumber(),
						patient2.getContactNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getEmail(), patient2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getFirstName(), patient2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("govtId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getGovtId(), patient2.getGovtId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getGroupId(), patient2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("insuranceId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getInsuranceId(), patient2.getInsuranceId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("isAdult", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getIsAdult(), patient2.getIsAdult())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nationality", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getNationality(), patient2.getNationality())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("primaryDoctor", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getPrimaryDoctor(),
						patient2.getPrimaryDoctor())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("surname", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						patient1.getSurname(), patient2.getSurname())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_patientResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_patientResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Patient patient) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("age")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("contactNumber")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getContactNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("firstName")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getFirstName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("govtId")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getGovtId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("groupId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("insuranceId")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getInsuranceId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("isAdult")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("nationality")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getNationality()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("primaryDoctor")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("surname")) {
			sb.append("'");
			sb.append(String.valueOf(patient.getSurname()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Patient randomPatient() throws Exception {
		return new Patient() {
			{
				age = RandomTestUtil.randomLong();
				contactNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				firstName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				govtId = StringUtil.toLowerCase(RandomTestUtil.randomString());
				groupId = RandomTestUtil.randomLong();
				insuranceId = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				isAdult = RandomTestUtil.randomBoolean();
				nationality = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				primaryDoctor = RandomTestUtil.randomLong();
				surname = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Patient randomIrrelevantPatient() throws Exception {
		Patient randomIrrelevantPatient = randomPatient();

		return randomIrrelevantPatient;
	}

	protected Patient randomPatchPatient() throws Exception {
		return randomPatient();
	}

	protected PatientResource patientResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BasePatientResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.rain.rest.resource.v1_0.PatientResource
		_patientResource;

}