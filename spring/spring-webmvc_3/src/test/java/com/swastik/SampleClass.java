package com.swastik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleClass {

	static String EMPTY_CONTENT = "";
	static String CODE_COMPLEXITY_CONSTANT = "Constant";
	static String CODE_COMPLEXITY_PASS_THRU = "PassThru";
	static String DATA_ELEMENT_IS_STATED = "N";

	public static void main(String[] args) {

		List<String> constantColumnNames = new ArrayList<>();

		constantColumnNames.add("ds_loadingdate");
		constantColumnNames.add("ds_filename");

		List<List<String>> transformationContents = new ArrayList<>();
		String appTechSystem = "appTechSystem";
		String appTechGroup = "appTechGroup";
		String configName = "configName";
		String inputDataset = "inputDataset";
		String clientSystem = "clientSystem";
		String inputTechGroup = "inputTechGroup";
		String inputtechSystem = "inputTechSystem";
		String hiveDataset = "hiveDataset";
		String hiveTechSystem = "hivetechSystem";

		List<Map> originalSchemaMapCollect = new ArrayList<>();
		List<Map> schemaMapCollect = new ArrayList<>();

		Map<String, String> origin1 = new HashMap<>();
		origin1.put(MetaConfigConst.FieldName, "EMP_ID");

		Map<String, String> origin2 = new HashMap<>();
		origin2.put(MetaConfigConst.FieldName, "EMP_NAME");

		Map<String, String> origin3 = new HashMap<>();
		origin3.put(MetaConfigConst.FieldName, "EMP_SALARY");

		originalSchemaMapCollect.add(origin1);
		originalSchemaMapCollect.add(origin2);
		originalSchemaMapCollect.add(origin3);

		Map<String, String> actual1 = new HashMap<>();
		actual1.put(MetaConfigConst.FieldName, "emp_id");

		Map<String, String> actual2 = new HashMap<>();
		actual2.put(MetaConfigConst.FieldName, "emp_name");

		Map<String, String> actual3 = new HashMap<>();
		actual3.put(MetaConfigConst.FieldName, "sntzd_emp_salary");

		Map<String, String> actual4 = new HashMap<>();
		actual4.put(MetaConfigConst.FieldName, "ds_loadingdate");

		Map<String, String> actual5 = new HashMap<>();
		actual5.put(MetaConfigConst.FieldName, "ds_filename");

		schemaMapCollect.add(actual1);
		schemaMapCollect.add(actual2);
		schemaMapCollect.add(actual3);
		schemaMapCollect.add(actual4);
		schemaMapCollect.add(actual5);
		enrichTransformationContents(transformationContents, appTechSystem, appTechGroup, originalSchemaMapCollect,
				schemaMapCollect, configName, constantColumnNames, inputDataset, clientSystem, inputTechGroup,
				inputtechSystem, hiveDataset, hiveTechSystem);

		System.out.println(transformationContents);

	}

	public static void enrichTransformationContents(List<List<String>> transformationContents, String appTechSystem,
			String appTechGroup, List<Map> originalSchemaMapCollect, List<Map> schemaMapCollect, String configName,
			List<String> constantColumnNames, String inputDataset, String clientSystem, String inputTechGroup,
			String inputTechSystem, String hiveDataset, String hiveTechSystem) {

		final List<Map> originalSchema = originalSchemaMapCollect;

		schemaMapCollect.stream().forEach(s1 -> transformationContents.add(Arrays.asList(appTechSystem, appTechGroup,
				configName, EMPTY_CONTENT, EMPTY_CONTENT,
				constantColumnNames.contains((String) s1.get(MetaConfigConst.FieldName)) ? CODE_COMPLEXITY_CONSTANT
						: CODE_COMPLEXITY_PASS_THRU,
				originalSchema.stream()
						.filter(t -> ((String) t.get(MetaConfigConst.FieldName))
								.equalsIgnoreCase((String) s1.get(MetaConfigConst.FieldName)))
						.findAny().isPresent()
								? (String) originalSchema.stream()
										.filter(t -> ((String) t.get(MetaConfigConst.FieldName))
												.equalsIgnoreCase((String) s1.get(MetaConfigConst.FieldName)))
										.findAny().get().get(MetaConfigConst.FieldName)
								: originalSchema.stream()
										.filter(t -> ((String) t.get(MetaConfigConst.FieldName))
												.equalsIgnoreCase(((String) s1.get(MetaConfigConst.FieldName))
														.substring("sntzd_".length())))
										.findAny().isPresent()
												? (String) originalSchema.stream()
														.filter(t -> ((String) t.get(MetaConfigConst.FieldName))
																.equalsIgnoreCase(
																		((String) s1.get(MetaConfigConst.FieldName)).substring("sntzd_".length())))
														.findAny().get().get(MetaConfigConst.FieldName)
												: EMPTY_CONTENT,
				inputDataset, inputTechGroup, inputTechSystem, (String) s1.get(MetaConfigConst.FieldName), hiveDataset,
				clientSystem, hiveTechSystem, DATA_ELEMENT_IS_STATED, DATA_ELEMENT_IS_STATED)));
	}

}

class MetaConfigConst {
	public static String FieldName = "fieldName";

}