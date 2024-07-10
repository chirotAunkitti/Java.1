package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Author;
import com.aliboucoding.jpa.repositories.AuthorRepository;
import com.aliboucoding.jpa.repositories.VideoRepositor;
import com.aliboucoding.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepositor videoRepositor
	){
		return args -> {
			for(int i = 0; i <50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20, 80))
						.email(faker.name().username() + "@aliboucodign.com")
						.build();
				//repository.save(author);
			}
			/*var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepositor.save(video);*/
			// update
			/*var author = Author.builder()
					.id(1)
					.firstName("Ali")
					.lastName("Bouali")
					.age(34)
					.email("contact@aliboucodign.com")
					.build();*/
			//repository.save(author); แทนที่ด้วยความคิดเห็นแบบบล็อก
			//repository.updateAuthor(1000, 1);

			//update all authors อัพทั้งหมด
			//repository.updateAllAuthorsAges(99);

			//ค้นหาแบบสอบถาม ByName
			/*repository.findByNameQuery(70)
					.forEach(System.out::println);*/

			//อัพเดต with named query
			//repository.updateByNameQuery(12);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(22))
					//.and(AuthorSpecification.firstnameLike("Charles"))
					;
			repository.findAll(spec)
					.forEach(System.out::println);
		};
	}
}
