package br.ufc.quixada.ui;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = "br.ufc.quixada")
@EntityScan("br.ufc.quixada.entity")
@EnableJpaRepositories("br.ufc.quixada.dao.jpa")
@Slf4j
public class MenuPrincipal implements CommandLineRunner {

	@Autowired
	private MenuProfile menuProfiles;

	@Autowired
	private MenuGame menuGames;

	@Autowired
	private MenuProgress menuProgress;


 public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MenuPrincipal.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		StringBuilder menu = new StringBuilder("Menu Principal\n")
			.append("1 - Profiles\n")
			.append("2 - Games\n")
			.append("3 - Progresso\n")
			.append("0 - Sair");
		char opcao = 'x';
		do {
			try {
				opcao = JOptionPane.showInputDialog(menu).charAt(0);
				switch (opcao) {
					case '1':     // Profiles
						menuProfiles.menu();
						break;
					case '2':     // Games
						menuGames.menu();
						break;
					case '3':     // GameStore
						menuProgress.menu();
						break;
					case '0':     // Sair
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}

		} while(opcao != '0');
	}
}
