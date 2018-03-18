/*
 * Copyright 2018 Google LLC
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pontem;

import com.google.api.services.dataflow.model.JobMetrics;
import com.google.api.services.dataflow.model.MetricStructuredName;
import com.google.api.services.dataflow.model.MetricUpdate;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Struct;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/** Class to provide functionality to help with tests. */
public class TestHelper {

  public static final String TABLE_NAME = "tableName";
  private static final String PROPERTY_A1 = "propertyA1";
  private static final String PROPERTY_B1 = "propertyB1";
  private static final long PROPERTY_C1 = 111L;
  public static final Struct STRUCT_1 =
      Struct.newBuilder()
          .set("property_a")
          .to(PROPERTY_A1)
          .set("property_b")
          .to(PROPERTY_B1)
          .set("property_c")
          .to(PROPERTY_C1)
          .build();
  public static final String STRUCT_1_BASE64_SERIALIZED =
      "rO0ABXNyAC9jb20uZ29vZ2xlLmNsb3VkLnNwYW5uZXIuU3RydWN0JFZhbHVlTGlzdFN0cnVjdCJPEfWmuB9hAgACTAAEdHlwZXQAH0xjb20vZ29vZ2xlL2Nsb3VkL3NwYW5uZXIvVHlwZTtMAAZ2YWx1ZXN0ABBMamF2YS91dGlsL0xpc3Q7eHIAH2NvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5TdHJ1Y3TreRgevRZR1wIAAHhwc3IAHWNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5UeXBl1U9P8MIRFWoCAARMABBhcnJheUVsZW1lbnRUeXBlcQB+AAFMAARjb2RldAAkTGNvbS9nb29nbGUvY2xvdWQvc3Bhbm5lci9UeXBlJENvZGU7TAAMZmllbGRzQnlOYW1ldAAPTGphdmEvdXRpbC9NYXA7TAAMc3RydWN0RmllbGRzdAApTGNvbS9nb29nbGUvY29tbW9uL2NvbGxlY3QvSW1tdXRhYmxlTGlzdDt4cHB+cgAiY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlR5cGUkQ29kZQAAAAAAAAAAEgAAeHIADmphdmEubGFuZy5FbnVtAAAAAAAAAAASAAB4cHQABlNUUlVDVHBzcgA2Y29tLmdvb2dsZS5jb21tb24uY29sbGVjdC5JbW11dGFibGVMaXN0JFNlcmlhbGl6ZWRGb3JtAAAAAAAAAAACAAFbAAhlbGVtZW50c3QAE1tMamF2YS9sYW5nL09iamVjdDt4cHVyABNbTGphdmEubGFuZy5PYmplY3Q7kM5YnxBzKWwCAAB4cAAAAANzcgApY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlR5cGUkU3RydWN0RmllbGR36UM9x2XCkgIAAkwABG5hbWV0ABJMamF2YS9sYW5nL1N0cmluZztMAAR0eXBlcQB+AAF4cHQACnByb3BlcnR5X2FzcQB+AAVwfnEAfgAKdAAGU1RSSU5HcHBzcQB+ABN0AApwcm9wZXJ0eV9icQB+ABdzcQB+ABN0AApwcm9wZXJ0eV9jc3EAfgAFcH5xAH4ACnQABUlOVDY0cHBzcQB+AA51cQB+ABEAAAADc3IAKWNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRTdHJpbmdJbXBsjNNcmhMipikCAAB4cgAyY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlZhbHVlJEFic3RyYWN0T2JqZWN0VmFsdWX/laoSsDtinQIAAUwABXZhbHVldAASTGphdmEvbGFuZy9PYmplY3Q7eHIALGNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRBYnN0cmFjdFZhbHVlWGHIp61Am88CAAJaAAZpc051bGxMAAR0eXBlcQB+AAF4cgAeY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlZhbHVltpagbFkjPDYCAAB4cABxAH4AF3QACnByb3BlcnR5QTFzcQB+ACMAcQB+ABd0AApwcm9wZXJ0eUIxc3IAKGNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRJbnQ2NEltcGwasOEnWHMLzgIAAUoABXZhbHVleHEAfgAmAHEAfgAeAAAAAAAAAG8=";

  private static final String PROPERTY_A2 = "propertyA2";
  private static final String PROPERTY_B2 = "propertyB2";
  private static final long PROPERTY_C2 = 222L;
  public static final Struct STRUCT_2 =
      Struct.newBuilder()
          .set("property_a")
          .to(PROPERTY_A2)
          .set("property_b")
          .to(PROPERTY_B2)
          .set("property_c")
          .to(PROPERTY_C2)
          .build();
  public static final String STRUCT_2_BASE64_SERIALIZED =
      "rO0ABXNyAC9jb20uZ29vZ2xlLmNsb3VkLnNwYW5uZXIuU3RydWN0JFZhbHVlTGlzdFN0cnVjdCJPEfWmuB9hAgACTAAEdHlwZXQAH0xjb20vZ29vZ2xlL2Nsb3VkL3NwYW5uZXIvVHlwZTtMAAZ2YWx1ZXN0ABBMamF2YS91dGlsL0xpc3Q7eHIAH2NvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5TdHJ1Y3TreRgevRZR1wIAAHhwc3IAHWNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5UeXBl1U9P8MIRFWoCAARMABBhcnJheUVsZW1lbnRUeXBlcQB+AAFMAARjb2RldAAkTGNvbS9nb29nbGUvY2xvdWQvc3Bhbm5lci9UeXBlJENvZGU7TAAMZmllbGRzQnlOYW1ldAAPTGphdmEvdXRpbC9NYXA7TAAMc3RydWN0RmllbGRzdAApTGNvbS9nb29nbGUvY29tbW9uL2NvbGxlY3QvSW1tdXRhYmxlTGlzdDt4cHB+cgAiY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlR5cGUkQ29kZQAAAAAAAAAAEgAAeHIADmphdmEubGFuZy5FbnVtAAAAAAAAAAASAAB4cHQABlNUUlVDVHBzcgA2Y29tLmdvb2dsZS5jb21tb24uY29sbGVjdC5JbW11dGFibGVMaXN0JFNlcmlhbGl6ZWRGb3JtAAAAAAAAAAACAAFbAAhlbGVtZW50c3QAE1tMamF2YS9sYW5nL09iamVjdDt4cHVyABNbTGphdmEubGFuZy5PYmplY3Q7kM5YnxBzKWwCAAB4cAAAAANzcgApY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlR5cGUkU3RydWN0RmllbGR36UM9x2XCkgIAAkwABG5hbWV0ABJMamF2YS9sYW5nL1N0cmluZztMAAR0eXBlcQB+AAF4cHQACnByb3BlcnR5X2FzcQB+AAVwfnEAfgAKdAAGU1RSSU5HcHBzcQB+ABN0AApwcm9wZXJ0eV9icQB+ABdzcQB+ABN0AApwcm9wZXJ0eV9jc3EAfgAFcH5xAH4ACnQABUlOVDY0cHBzcQB+AA51cQB+ABEAAAADc3IAKWNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRTdHJpbmdJbXBsjNNcmhMipikCAAB4cgAyY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlZhbHVlJEFic3RyYWN0T2JqZWN0VmFsdWX/laoSsDtinQIAAUwABXZhbHVldAASTGphdmEvbGFuZy9PYmplY3Q7eHIALGNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRBYnN0cmFjdFZhbHVlWGHIp61Am88CAAJaAAZpc051bGxMAAR0eXBlcQB+AAF4cgAeY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlZhbHVltpagbFkjPDYCAAB4cABxAH4AF3QACnByb3BlcnR5QTJzcQB+ACMAcQB+ABd0AApwcm9wZXJ0eUIyc3IAKGNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRJbnQ2NEltcGwasOEnWHMLzgIAAUoABXZhbHVleHEAfgAmAHEAfgAeAAAAAAAAAN4=";

  private static final int PROPERTY_A3 = 10;
  private static final String PROPERTY_B3 = null;
  public static final Struct STRUCT_3 = Struct.newBuilder()
          .set("property_a")
          .to(PROPERTY_A3)
          .set("property_b")
          .to(PROPERTY_B3)
          .build();
  public static final String STRUCT_3_BASE64_SERIALIZED =
      "rO0ABXNyAC9jb20uZ29vZ2xlLmNsb3VkLnNwYW5uZXIuU3RydWN0JFZhbHVlTGlzdFN0cnVjdCJPEfWmuB9hAgACTAAEdHlwZXQAH0xjb20vZ29vZ2xlL2Nsb3VkL3NwYW5uZXIvVHlwZTtMAAZ2YWx1ZXN0ABBMamF2YS91dGlsL0xpc3Q7eHIAH2NvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5TdHJ1Y3TreRgevRZR1wIAAHhwc3IAHWNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5UeXBl1U9P8MIRFWoCAARMABBhcnJheUVsZW1lbnRUeXBlcQB+AAFMAARjb2RldAAkTGNvbS9nb29nbGUvY2xvdWQvc3Bhbm5lci9UeXBlJENvZGU7TAAMZmllbGRzQnlOYW1ldAAPTGphdmEvdXRpbC9NYXA7TAAMc3RydWN0RmllbGRzdAApTGNvbS9nb29nbGUvY29tbW9uL2NvbGxlY3QvSW1tdXRhYmxlTGlzdDt4cHB+cgAiY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlR5cGUkQ29kZQAAAAAAAAAAEgAAeHIADmphdmEubGFuZy5FbnVtAAAAAAAAAAASAAB4cHQABlNUUlVDVHBzcgA2Y29tLmdvb2dsZS5jb21tb24uY29sbGVjdC5JbW11dGFibGVMaXN0JFNlcmlhbGl6ZWRGb3JtAAAAAAAAAAACAAFbAAhlbGVtZW50c3QAE1tMamF2YS9sYW5nL09iamVjdDt4cHVyABNbTGphdmEubGFuZy5PYmplY3Q7kM5YnxBzKWwCAAB4cAAAAAJzcgApY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlR5cGUkU3RydWN0RmllbGR36UM9x2XCkgIAAkwABG5hbWV0ABJMamF2YS9sYW5nL1N0cmluZztMAAR0eXBlcQB+AAF4cHQACnByb3BlcnR5X2FzcQB+AAVwfnEAfgAKdAAFSU5UNjRwcHNxAH4AE3QACnByb3BlcnR5X2JzcQB+AAVwfnEAfgAKdAAGU1RSSU5HcHBzcQB+AA51cQB+ABEAAAACc3IAKGNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRJbnQ2NEltcGwasOEnWHMLzgIAAUoABXZhbHVleHIALGNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRBYnN0cmFjdFZhbHVlWGHIp61Am88CAAJaAAZpc051bGxMAAR0eXBlcQB+AAF4cgAeY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlZhbHVltpagbFkjPDYCAAB4cABxAH4AFwAAAAAAAAAKc3IAKWNvbS5nb29nbGUuY2xvdWQuc3Bhbm5lci5WYWx1ZSRTdHJpbmdJbXBsjNNcmhMipikCAAB4cgAyY29tLmdvb2dsZS5jbG91ZC5zcGFubmVyLlZhbHVlJEFic3RyYWN0T2JqZWN0VmFsdWX/laoSsDtinQIAAUwABXZhbHVldAASTGphdmEvbGFuZy9PYmplY3Q7eHEAfgAiAXEAfgAccA==";

  public static final Mutation MUTATION_1 =
      Mutation.newInsertOrUpdateBuilder(TestHelper.TABLE_NAME)
          .set("property_a")
          .to(PROPERTY_A1)
          .set("property_b")
          .to(PROPERTY_B1)
          .set("property_c")
          .to(PROPERTY_C1)
          .build();

  public static final Mutation MUTATION_2 =
      Mutation.newInsertOrUpdateBuilder(TestHelper.TABLE_NAME)
          .set("property_a")
          .to(PROPERTY_A2)
          .set("property_b")
          .to(PROPERTY_B2)
          .set("property_c")
          .to(PROPERTY_C2)
          .build();

  public static final Mutation MUTATION_3 =
      Mutation.newInsertOrUpdateBuilder(TestHelper.TABLE_NAME)
          .set("property_a")
          .to(PROPERTY_A3)
          .build();

  public static JobMetrics getJobMetrics(Map<String, Long> tableRowCounts) {
    JobMetrics jobMetrics = new JobMetrics();
    List<MetricUpdate> metricUpdates = Lists.newArrayList();

    // Add a filler/noise metric
    MetricUpdate metricUpdate1 = new MetricUpdate();
    metricUpdate1.setScalar(new BigDecimal(267L));
    metricUpdate1.setUpdateTime("2017-10-23T19:10:48.566Z");
    MetricStructuredName structuredName1 = new MetricStructuredName();
    structuredName1.setOrigin("dataflow/v1b3");
    structuredName1.setName("MeanByteCount");
    structuredName1.setContext(
        ImmutableMap.of(
            "output_user_name",
            "Read Table List/SpannerIO.CreateTransaction/Createtransaction-out0",
            "original_name",
            "Read Table List/SpannerIO.CreateTransaction/Createtransaction-out0-"
                + "MeanByteCount"));
    metricUpdate1.setName(structuredName1);
    metricUpdates.add(metricUpdate1);

    for (Map.Entry<String, Long> entry : tableRowCounts.entrySet()) {
      String tableName = entry.getKey();
      Long numRows = entry.getValue();

      MetricUpdate metricUpdate2 = new MetricUpdate();
      metricUpdate2.setScalar(new BigDecimal(numRows));
      metricUpdate2.setUpdateTime("2017-10-23T19:10:48.566Z");
      MetricStructuredName structuredName2 = new MetricStructuredName();
      structuredName2.setOrigin("dataflow/v1b3");
      structuredName2.setName("ElementCount");
      structuredName2.setContext(
          ImmutableMap.of(
              "output_user_name",
              "Read_Data"
                  + Util.TRANSFORM_NODE_NAME_DELIMITER
                  + tableName
                  + "/Execute query-out0"));
      metricUpdate2.setName(structuredName2);
      metricUpdates.add(metricUpdate2);
    }

    jobMetrics.setMetrics(ImmutableList.copyOf(metricUpdates));
    return jobMetrics;
  }
}