package org.gestion.backend;

import org.gestion.backend.entities.Payment;
import org.gestion.backend.entities.Student;
import org.gestion.backend.enums.PaymentStatus;
import org.gestion.backend.enums.PaymentType;
import org.gestion.backend.repositories.PaymentRepository;
import org.gestion.backend.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	CommandLineRunner start(StudentRepository studentRepository,
							PaymentRepository paymentRepository){
		return args -> {

			for (int i = 0; i < 10; i++) {
				Student student1 =  Student.builder()
						.firstName("John")
						.lastName("Doe")
						.email("john.doe@example.com")
						.major("Computer Science")
						.build();

				Student student2 =  Student.builder()
						.firstName("Jane")
						.lastName("Smith")
						.email("jane.smith@example.com")
						.major("Electrical Engineering")
						.build();

				Student student3 =  Student.builder()
						.firstName("Michael")
						.lastName("Johnson")
						.email("michael.johnson@example.com")
						.major("Mechanical Engineering")
						.build();
				studentRepository.save(student1);
				studentRepository.save(student2);
				studentRepository.save(student3);

				Payment payment1 = new Payment(null,"CODE1", new Date(), "CASH", "CREATED", "path/to/file1.pdf",student1);
				Payment payment2 = new Payment(null,"CODE2", new Date(), "CHECK", "VALIDATED", "path/to/file2.pdf",student2);
				Payment payment3 = new Payment(null,"CODE3", new Date(), "TRANSFER", "CREATED", "path/to/file3.pdf",student1);


				paymentRepository.save(payment1);
				paymentRepository.save(payment2);
				paymentRepository.save(payment3);

			}


		};
	}

}
