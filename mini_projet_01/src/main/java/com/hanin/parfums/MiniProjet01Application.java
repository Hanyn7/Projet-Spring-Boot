package com.hanin.parfums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import com.hanin.parfums.entities.Parfum;
import com.hanin.parfums.service.ParfumService;

@SpringBootApplication
public class MiniProjet01Application implements CommandLineRunner {
	@Autowired
	ParfumService parfumService;

	public static void main(String[] args) {
		SpringApplication.run(MiniProjet01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void run(String... args) throws Exception {
		parfumService.saveParfum(new Parfum("PC Dell", 2600.0, new Date()));
		parfumService.saveParfum(new Parfum("PC Asus", 2800.0, new Date()));
		parfumService.saveParfum(new Parfum("Imprimante Epson", 900.0, new Date()));
	}*/
}