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
import com.liferay.rain.rest.client.dto.v1_0.Doctor;
import com.liferay.rain.rest.client.http.HttpInvoker;
import com.liferay.rain.rest.client.pagination.Page;
import com.liferay.rain.rest.client.resource.v1_0.DoctorResource;
import com.liferay.rain.rest.client.serdes.v1_0.DoctorSerDes;

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
public abstract class BaseDoctorResourceTestCase {

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

		_doctorResource.setContextCompany(testCompany);

		DoctorResource.Builder builder = DoctorResource.builder();

		doctorResource = builder.authentication(
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

		Doctor doctor1 = randomDoctor();

		String json = objectMapper.writeValueAsString(doctor1);

		Doctor doctor2 = DoctorSerDes.toDTO(json);

		Assert.assertTrue(equals(doctor1, doctor2));
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

		Doctor doctor = randomDoctor();

		String json1 = objectMapper.writeValueAsString(doctor);
		String json2 = DoctorSerDes.toJSON(doctor);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Doctor doctor = randomDoctor();

		doctor.setContactNumber(regex);
		doctor.setDepartment(regex);
		doctor.setEmail(regex);
		doctor.setFirstName(regex);
		doctor.setGovtId(regex);
		doctor.setNationality(regex);
		doctor.setPayGroup(regex);
		doctor.setSurname(regex);

		String json = DoctorSerDes.toJSON(doctor);

		Assert.assertFalse(json.contains(regex));

		doctor = DoctorSerDes.toDTO(json);

		Assert.assertEquals(regex, doctor.getContactNumber());
		Assert.assertEquals(regex, doctor.getDepartment());
		Assert.assertEquals(regex, doctor.getEmail());
		Assert.assertEquals(regex, doctor.getFirstName());
		Assert.assertEquals(regex, doctor.getGovtId());
		Assert.assertEquals(regex, doctor.getNationality());
		Assert.assertEquals(regex, doctor.getPayGroup());
		Assert.assertEquals(regex, doctor.getSurname());
	}

	@Test
	public void testDeleteDoctor() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteDoctor() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetDoctor() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetDoctor() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetDoctorNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPatchDoctor() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPutDoctor() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetDoctorsByDept() throws Exception {
		String department = testGetDoctorsByDept_getDepartment();
		String irrelevantDepartment =
			testGetDoctorsByDept_getIrrelevantDepartment();

		Page<Doctor> page = doctorResource.getDoctorsByDept(department);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantDepartment != null) {
			Doctor irrelevantDoctor = testGetDoctorsByDept_addDoctor(
				irrelevantDepartment, randomIrrelevantDoctor());

			page = doctorResource.getDoctorsByDept(irrelevantDepartment);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantDoctor), (List<Doctor>)page.getItems());
			assertValid(page);
		}

		Doctor doctor1 = testGetDoctorsByDept_addDoctor(
			department, randomDoctor());

		Doctor doctor2 = testGetDoctorsByDept_addDoctor(
			department, randomDoctor());

		page = doctorResource.getDoctorsByDept(department);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(doctor1, doctor2), (List<Doctor>)page.getItems());
		assertValid(page);
	}

	protected Doctor testGetDoctorsByDept_addDoctor(
			String department, Doctor doctor)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDoctorsByDept_getDepartment() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDoctorsByDept_getIrrelevantDepartment()
		throws Exception {

		return null;
	}

	@Test
	public void testGetDoctorsBySurname() throws Exception {
		String surname = testGetDoctorsBySurname_getSurname();
		String irrelevantSurname =
			testGetDoctorsBySurname_getIrrelevantSurname();

		Page<Doctor> page = doctorResource.getDoctorsBySurname(surname);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantSurname != null) {
			Doctor irrelevantDoctor = testGetDoctorsBySurname_addDoctor(
				irrelevantSurname, randomIrrelevantDoctor());

			page = doctorResource.getDoctorsBySurname(irrelevantSurname);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantDoctor), (List<Doctor>)page.getItems());
			assertValid(page);
		}

		Doctor doctor1 = testGetDoctorsBySurname_addDoctor(
			surname, randomDoctor());

		Doctor doctor2 = testGetDoctorsBySurname_addDoctor(
			surname, randomDoctor());

		page = doctorResource.getDoctorsBySurname(surname);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(doctor1, doctor2), (List<Doctor>)page.getItems());
		assertValid(page);
	}

	protected Doctor testGetDoctorsBySurname_addDoctor(
			String surname, Doctor doctor)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDoctorsBySurname_getSurname() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetDoctorsBySurname_getIrrelevantSurname()
		throws Exception {

		return null;
	}

	@Test
	public void testPostDoctor() throws Exception {
		Doctor randomDoctor = randomDoctor();

		Doctor postDoctor = testPostDoctor_addDoctor(randomDoctor);

		assertEquals(randomDoctor, postDoctor);
		assertValid(postDoctor);
	}

	protected Doctor testPostDoctor_addDoctor(Doctor doctor) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Doctor doctor, List<Doctor> doctors) {
		boolean contains = false;

		for (Doctor item : doctors) {
			if (equals(doctor, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(doctors + " does not contain " + doctor, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Doctor doctor1, Doctor doctor2) {
		Assert.assertTrue(
			doctor1 + " does not equal " + doctor2, equals(doctor1, doctor2));
	}

	protected void assertEquals(List<Doctor> doctors1, List<Doctor> doctors2) {
		Assert.assertEquals(doctors1.size(), doctors2.size());

		for (int i = 0; i < doctors1.size(); i++) {
			Doctor doctor1 = doctors1.get(i);
			Doctor doctor2 = doctors2.get(i);

			assertEquals(doctor1, doctor2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Doctor> doctors1, List<Doctor> doctors2) {

		Assert.assertEquals(doctors1.size(), doctors2.size());

		for (Doctor doctor1 : doctors1) {
			boolean contains = false;

			for (Doctor doctor2 : doctors2) {
				if (equals(doctor1, doctor2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				doctors2 + " does not contain " + doctor1, contains);
		}
	}

	protected void assertValid(Doctor doctor) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("contactNumber", additionalAssertFieldName)) {
				if (doctor.getContactNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("department", additionalAssertFieldName)) {
				if (doctor.getDepartment() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (doctor.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("employeeId", additionalAssertFieldName)) {
				if (doctor.getEmployeeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (doctor.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("govtId", additionalAssertFieldName)) {
				if (doctor.getGovtId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (doctor.getGroupId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("nationality", additionalAssertFieldName)) {
				if (doctor.getNationality() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("payGroup", additionalAssertFieldName)) {
				if (doctor.getPayGroup() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("surname", additionalAssertFieldName)) {
				if (doctor.getSurname() == null) {
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

	protected void assertValid(Page<Doctor> page) {
		boolean valid = false;

		java.util.Collection<Doctor> doctors = page.getItems();

		int size = doctors.size();

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
					com.liferay.rain.rest.dto.v1_0.Doctor.class)) {

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

	protected boolean equals(Doctor doctor1, Doctor doctor2) {
		if (doctor1 == doctor2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("contactNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getContactNumber(),
						doctor2.getContactNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("department", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getDepartment(), doctor2.getDepartment())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getEmail(), doctor2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("employeeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getEmployeeId(), doctor2.getEmployeeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getFirstName(), doctor2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("govtId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getGovtId(), doctor2.getGovtId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getGroupId(), doctor2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("nationality", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getNationality(), doctor2.getNationality())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("payGroup", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getPayGroup(), doctor2.getPayGroup())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("surname", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						doctor1.getSurname(), doctor2.getSurname())) {

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

		if (!(_doctorResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_doctorResource;

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
		EntityField entityField, String operator, Doctor doctor) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("contactNumber")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getContactNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("department")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getDepartment()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("employeeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("firstName")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getFirstName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("govtId")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getGovtId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("groupId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("nationality")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getNationality()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("payGroup")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getPayGroup()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("surname")) {
			sb.append("'");
			sb.append(String.valueOf(doctor.getSurname()));
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

	protected Doctor randomDoctor() throws Exception {
		return new Doctor() {
			{
				contactNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				department = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				employeeId = RandomTestUtil.randomLong();
				firstName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				govtId = StringUtil.toLowerCase(RandomTestUtil.randomString());
				groupId = RandomTestUtil.randomLong();
				nationality = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				payGroup = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				surname = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Doctor randomIrrelevantDoctor() throws Exception {
		Doctor randomIrrelevantDoctor = randomDoctor();

		return randomIrrelevantDoctor;
	}

	protected Doctor randomPatchDoctor() throws Exception {
		return randomDoctor();
	}

	protected DoctorResource doctorResource;
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
		LogFactoryUtil.getLog(BaseDoctorResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.rain.rest.resource.v1_0.DoctorResource _doctorResource;

}