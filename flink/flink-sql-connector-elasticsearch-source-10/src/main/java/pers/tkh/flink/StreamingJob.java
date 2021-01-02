///*
// * Licensed to the Apache Software Foundation (ASF) under one
// * or more contributor license agreements.  See the NOTICE file
// * distributed with this work for additional information
// * regarding copyright ownership.  The ASF licenses this file
// * to you under the Apache License, Version 2.0 (the
// * "License"); you may not use this file except in compliance
// * with the License.  You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.tkh.flink;
//
//import org.apache.flink.api.common.functions.RuntimeContext;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
//import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
//import org.apache.flink.streaming.connectors.elasticsearch6.ElasticsearchSink;
//import org.apache.http.HttpHost;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.client.Requests;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Skeleton for a Flink Streaming Job.
// *
// * <p>For a tutorial how to write a Flink streaming application, check the
// * tutorials and examples on the <a href="https://flink.apache.org/docs/stable/">Flink Website</a>.
// *
// * <p>To package your application into a JAR file for execution, run
// * 'mvn clean package' on the command line.
// *
// * <p>If you change the name of the main class (with the public static void main(String[] args))
// * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
// */
//public class StreamingJob {
//
//	public static void main(String[] args) throws Exception {
//		// set up the streaming execution environment
//		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//
//		/*
//		 * Here, you can start creating your execution plan for Flink.
//		 *
//		 * Start with getting some data from the environment, like
//		 * 	env.readTextFile(textPath);
//		 *
//		 * then, transform the resulting DataStream<String> using operations
//		 * like
//		 * 	.filter()
//		 * 	.flatMap()
//		 * 	.join()
//		 * 	.coGroup()
//		 *
//		 * and many more.
//		 * Have a look at the programming guide for the Java API:
//		 *
//		 * https://flink.apache.org/docs/latest/apis/streaming/index.html
//		 *
//		 */
//		List<String> list = new ArrayList<>();
//		for (long i=0;i<1000000;i++ ) {
//			list.add("a" + i);
//		}
//		String[] strings = list.toArray(new String[list.size()]);
//		env.setParallelism(1);
//		DataStream<String> dataStream = env.fromElements(strings);
//
//		List<HttpHost> httpHosts = new ArrayList<>();
//		httpHosts.add(new HttpHost("127.0.0.1", 9200, "http"));
//		ElasticsearchSink.Builder<String> esSinkBuilder = new ElasticsearchSink.Builder<>(
//				httpHosts,
//				new ElasticsearchSinkFunction<String>() {
//					public IndexRequest createIndexRequest(String element) {
//						Map<String, String> json = new HashMap<>();
//						json.put("data", element);
//
//						return Requests.indexRequest()
//								.index("flink-demo")
//								.type("ip")
//								.source(json);
//					}
//
//					@Override
//					public void process(String element, RuntimeContext ctx, RequestIndexer indexer) {
//						indexer.add(createIndexRequest(element));
//					}
//				}
//		);
//		// esSinkBuilder.setBulkFlushMaxActions(1);
//		dataStream.addSink(esSinkBuilder.build());
//		// execute program
//		env.execute("Flink Streaming Java API Skeleton");
//	}
//}
