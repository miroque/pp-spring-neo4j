/*******************************************************************************
 * Person System - Person Profile module
 * Copyright (C) 2018, 2019 Panov Aleksander (i.miroque@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.miroque.pp_spring_neo4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableNeo4jRepositories
@EntityScan(basePackages = "ru.miroque.pp.domains")
public class Application {

	private final static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner demo(PersonRepository personRepository) {
//		return args -> {
//
//			personRepository.deleteAll();
//
//			Person greg = new Person("Greg");
//			Person roy = new Person("Roy");
//			Person craig = new Person("Craig");
//
//			List<Person> team = Arrays.asList(greg, roy, craig);
//
//			log.info("Before linking up with Neo4j...");
//
//			team.stream().forEach(person -> log.info("\t" + person.toString()));
//
//			personRepository.save(greg);
//			personRepository.save(roy);
//			personRepository.save(craig);
//
//			greg = personRepository.findByName(greg.getName());
//			greg.worksWith(roy);
//			greg.worksWith(craig);
//			personRepository.save(greg);
//
//			roy = personRepository.findByName(roy.getName());
//			roy.worksWith(craig);
//			// We already know that roy works with greg
//			personRepository.save(roy);
//
//			// We already know craig works with roy and greg
//
//			log.info("Lookup each person by name...");
//			team.stream().forEach(person -> log.info(
//					"\t" + personRepository.findByName(person.getName()).toString()));
//		};
//	}

}
