package group.lab1FINAL;


import group.lab1FINAL.Model.Cubes;
import group.lab1FINAL.Model.CubesProducer;
import group.lab1FINAL.Model.Producer;
import group.lab1FINAL.Model.Review;
import group.lab1FINAL.Repo.CubeRepo;
import group.lab1FINAL.Repo.CubesProducerRepo;
import group.lab1FINAL.Repo.ProducerRepo;
import group.lab1FINAL.Repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class Lab1FinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(Lab1FinalApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	@Autowired
	private CubeRepo cubeRepo;
	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private ProducerRepo producerRepo;

	@Autowired
	private CubesProducerRepo cubesProducerRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
//		Cubes cub1 = new Cubes("mirror",28,"FanXin Mirror 3x3x3","Standard Mirror cube",false);
//		Cubes cub2 = new Cubes("2x2x2",72,"Cyclone Boys 2x2x2","Metallic version of the original Cyclone Boys 2x2x2",false);
//		Cubes cub3 = new Cubes("magic",29,"FanXin Basketball v2","Basketball shaped 3x3x3 cube",false);
//		Cubes cub4 = new Cubes("7x7x7",98,"QiYi QiXing 7x7x7 S2","Qiyi Qixing S2 este un Speedcube 7x7 din categoria Entry Level. Este fabricat ținand cont de preț, dar este totuși un cub foarte ușor de maneuver. Straturile alunecă lin iar răsucirile multiple necesită puțin efort. Cubul taie colțurile foarte bine, este stabil și se ține bine in mană. Recomandat pentru incepătorii care doresc să incerce un 7x7 fără insă \"a sparge banca\"",false);
//		Cubes cub5 = new Cubes("3x3x3",399,"Gan 13 Maglev / Maglev UV ","GAN 13 MagLev este unul dintre cele mai populare lansări din anul 2022! Acest cub de viteză impresionant vine echipat cu nu mai puțin de 88 de magneți care servesc unor scopuri diferite, de la magneți de bază la magneți MagLev. După cum era de așteptat, GAN 13 Maglev este un cub de viteză impresionant, fiind unul dintre giganții dominanți ai speedcuburilor de viteză de pe piață, neexistand nicio indoială referitoare la locul său stabil pentru mult timp de acum inainte.",true);
//		Cubes cub6 = new Cubes("3x3x3",21,"QiYi MoFanGe Sail W 3x3x3","QiYi Sail W este o versiune actualizată a hit-ului QiYi Sail. Sail W aduce imbunătățiri și consolidări mecanismului, alături de o nouă schemă de culori half-bright care contribuie semnificativ la distingerea culorilor in timpul rezolvărilor. Design-ul de asemenea a fost updatat, piesa centrala fiind rotunjită pentru a reduce blocajele și spori fluiditatea.",false);
//		Cubes cub7 = new Cubes("14x14x14",1264,"ShengShou 14x14x14","Cubul are 14 straturi, ceea ce inseamnă că trebuie să mutați 196 de piese doar pentru a rezolva o singura față! Cu un total de 1176 pătrățele pe toate cele 6 fețe, rezolvarea acestui puzzle este un proiect mare chiar și pentru experți. In ciuda multitudinii absurde de straturi, cubul in sine este destul de mic și este confortabil de ținut in maini.",false);
//		Cubes cub8 = new Cubes("skewb",33,"MoYu Fisher Skewb Puzzle","Un design spectaculos realizat de MoYu in colaborare cu celebrul Nathan Wilson, care te provoacă să te intrebi care sunt centrele și care sunt colțurile. Nu iți rămane decat să afli!",false);
//		Cubes cub9 = new Cubes("4x4x4",63,"DianSheng Solar System 4M - 4x4x4 Magnetic","Standard version of a 4x4x4 cube from the Solar System lineup ",true);
//		Cubes cub10 = new Cubes("pyraminx",67,"Moyu Magnetic Pyraminx 3x3x3","Cea mai recentă versiune a Pyraminx-ului de la Moyu folosește magneți speciali in locul arcurilor clasice pentru o experiență tactilă net superioară in timpul rezolvărilor de viteză.",true);
//
//
//		Review rev1 = new Review("Elena","Chiar este un Pyraminx foarte bun.Se misca foarte bine si e foarte flexibil.Plasticul e de calitate .Eu il am pe cel alb , iar stickerele  sunt bune.Il recomand!", 5f,"08.04.2019",true,cub10);
//		Review rev2 = new Review("Iannis","Absolute unit of a cube", 4.9f,"29.09.2021",true,cub3);
//
//		Producer prod1 = new Producer("MoYu","Street 1","1234567890","moyu@outlook.com",500000);
//		Producer prod2 = new Producer("FanXin","Street 2","1234567890","fanxin@outlook.com",500000);
//		Producer prod3 = new Producer("CycloneBoys","Street 3","1234567890","cycloneboys@outlook.com",500000);
//		Producer prod4 = new Producer("ShengShou","Street 4","1234567890","shengshou@outlook.com",500000);
//		Producer prod5 = new Producer("Gan","Street 5","1234567890","gan@outlook.com",500000);
//		Producer prod6 = new Producer("QiYi","Street 6","1234567890","qiyi@outlook.com",500000);
//		Producer prod7 = new Producer("DianSheng","Street 7","1234567890","diansheng@outlook.com",100000);
//
//
//		CubesProducer cubesProducer1 = new CubesProducer(cub1,prod2,100,"20.10.2022");
//		CubesProducer cubesProducer2 = new CubesProducer(cub2,prod3,100,"20.10.2022");
//		CubesProducer cubesProducer3 = new CubesProducer(cub3,prod2,100,"20.10.2022");
//		CubesProducer cubesProducer4 = new CubesProducer(cub4,prod6,100,"20.10.2022");
//		CubesProducer cubesProducer5 = new CubesProducer(cub5,prod5,100,"20.10.2022");
//		CubesProducer cubesProducer6 = new CubesProducer(cub6,prod6,100,"20.10.2022");
//		CubesProducer cubesProducer7 = new CubesProducer(cub7,prod4,100,"20.10.2022");
//		CubesProducer cubesProducer8 = new CubesProducer(cub8,prod1,100,"20.10.2022");
//		CubesProducer cubesProducer9 = new CubesProducer(cub9,prod7,100,"20.10.2022");
//		CubesProducer cubesProducer10 = new CubesProducer(cub10,prod1,100,"20.10.2022");
//
//		cubeRepo.save(cub1);
//		cubeRepo.save(cub2);
//		cubeRepo.save(cub3);
//		cubeRepo.save(cub4);
//		cubeRepo.save(cub5);
//		cubeRepo.save(cub6);
//		cubeRepo.save(cub7);
//		cubeRepo.save(cub8);
//		cubeRepo.save(cub9);
//		cubeRepo.save(cub10);
//
//
//
//		producerRepo.save(prod1);
//		producerRepo.save(prod2);
//		producerRepo.save(prod3);
//		producerRepo.save(prod4);
//		producerRepo.save(prod5);
//		producerRepo.save(prod6);
//		producerRepo.save(prod7);
//
//
//		reviewRepo.save(rev1);
//		reviewRepo.save(rev2);
//
//		cubesProducerRepo.save(cubesProducer1);
//		cubesProducerRepo.save(cubesProducer2);
//		cubesProducerRepo.save(cubesProducer3);
//		cubesProducerRepo.save(cubesProducer4);
//		cubesProducerRepo.save(cubesProducer5);
//		cubesProducerRepo.save(cubesProducer6);
//		cubesProducerRepo.save(cubesProducer7);
//		cubesProducerRepo.save(cubesProducer8);
//		cubesProducerRepo.save(cubesProducer9);
//		cubesProducerRepo.save(cubesProducer10);
//
//		Cubes cub11 = new Cubes("mirror",28,"FanXin Mirror 3x3x3","Standard Mirror cube",false);
//		Cubes cub12 = new Cubes("2x2x2",72,"Cyclone Boys 2x2x2","Metallic version of the original Cyclone Boys 2x2x2",false);
//		Cubes cub13 = new Cubes("magic",29,"FanXin Basketball v2","Basketball shaped 3x3x3 cube",false);
//		Cubes cub14 = new Cubes("7x7x7",98,"QiYi QiXing 7x7x7 S2","Qiyi Qixing S2 este un Speedcube 7x7 din categoria Entry Level. Este fabricat ținand cont de preț, dar este totuși un cub foarte ușor de manevrat. Straturile alunecă lin iar răsucirile multiple necesită puțin efort. Cubul taie colțurile foarte bine, este stabil și se ține bine in mană. Recomandat pentru incepătorii care doresc să incerce un 7x7 fără insă \"a sparge banca\"",false);
//		Cubes cub15 = new Cubes("3x3x3",399,"Gan 13 Maglev / Maglev UV ","GAN 13 MagLev este unul dintre cele mai populare lansări din anul 2022! Acest cub de viteză impresionant vine echipat cu nu mai puțin de 88 de magneți care servesc unor scopuri diferite, de la magneți de bază la magneți MagLev. După cum era de așteptat, GAN 13 Maglev este un cub de viteză impresionant, fiind unul dintre giganții dominanți ai speedcuburilor de viteză de pe piață, neexistand nicio indoială referitoare la locul său stabil pentru mult timp de acum inainte.",true);
//		Cubes cub16 = new Cubes("3x3x3",21,"QiYi MoFanGe Sail W 3x3x3","QiYi Sail W este o versiune actualizată a hit-ului QiYi Sail. Sail W aduce imbunătățiri și consolidări mecanismului, alături de o nouă schemă de culori half-bright care contribuie semnificativ la distingerea culorilor in timpul rezolvărilor. Design-ul de asemenea a fost updatat, piesa centrala fiind rotunjită pentru a reduce blocajele și spori fluiditatea.",false);
//		Cubes cub17 = new Cubes("14x14x14",1264,"ShengShou 14x14x14","Cubul are 14 straturi, ceea ce inseamnă că trebuie să mutați 196 de piese doar pentru a rezolva o singura față! Cu un total de 1176 pătrățele pe toate cele 6 fețe, rezolvarea acestui puzzle este un proiect mare chiar și pentru experți. In ciuda multitudinii absurde de straturi, cubul in sine este destul de mic și este confortabil de ținut in maini.",false);
//		Cubes cub18 = new Cubes("skewb",33,"MoYu Fisher Skewb Puzzle","Un design spectaculos realizat de MoYu in colaborare cu celebrul Nathan Wilson, care te provoacă să te intrebi care sunt centrele și care sunt colțurile. Nu iți rămane decat să afli!",false);
//		Cubes cub19 = new Cubes("4x4x4",63,"DianSheng Solar System 4M - 4x4x4 Magnetic","Standard version of a 4x4x4 cube from the Solar System lineup ",true);
//		Cubes cub20 = new Cubes("pyraminx",67,"Moyu Magnetic Pyraminx 3x3x3","Cea mai recentă versiune a Pyraminx-ului de la Moyu folosește magneți speciali in locul arcurilor clasice pentru o experiență tactilă net superioară in timpul rezolvărilor de viteză.",true);
//
//
//		Review rev11 = new Review("Elena","Chiar este un Pyraminx foarte bun.Se misca foarte bine si e foarte flexibil.Plasticul e de calitate .Eu il am pe cel alb , iar stickerele  sunt bune.Il recomand!", 5f,"08.04.2019",true,cub10);
//		Review rev12 = new Review("Iannis","Absolute unit of a cube", 4.9f,"29.09.2021",true,cub3);
//
//		Producer prod11 = new Producer("MoYu","Street 1","1234567890","moyu@outlook.com",500000);
//		Producer prod12 = new Producer("FanXin","Street 2","1234567890","fanxin@outlook.com",500000);
//		Producer prod13 = new Producer("CycloneBoys","Street 3","1234567890","cycloneboys@outlook.com",500000);
//		Producer prod14 = new Producer("ShengShou","Street 4","1234567890","shengshou@outlook.com",500000);
//		Producer prod15 = new Producer("Gan","Street 5","1234567890","gan@outlook.com",500000);
//		Producer prod16 = new Producer("QiYi","Street 6","1234567890","qiyi@outlook.com",500000);
//		Producer prod17 = new Producer("DianSheng","Street 7","1234567890","diansheng@outlook.com",100000);
//
//
//		CubesProducer cubesProducer11 = new CubesProducer(cub1,prod2,100,"20.10.2022");
//		CubesProducer cubesProducer12 = new CubesProducer(cub2,prod3,100,"20.10.2022");
//		CubesProducer cubesProducer13 = new CubesProducer(cub3,prod2,100,"20.10.2022");
//		CubesProducer cubesProducer14 = new CubesProducer(cub4,prod6,100,"20.10.2022");
//		CubesProducer cubesProducer15 = new CubesProducer(cub5,prod5,100,"20.10.2022");
//		CubesProducer cubesProducer16 = new CubesProducer(cub6,prod6,100,"20.10.2022");
//		CubesProducer cubesProducer17 = new CubesProducer(cub7,prod4,100,"20.10.2022");
//		CubesProducer cubesProducer18 = new CubesProducer(cub8,prod1,100,"20.10.2022");
//		CubesProducer cubesProducer19 = new CubesProducer(cub9,prod7,100,"20.10.2022");
//		CubesProducer cubesProducer20 = new CubesProducer(cub10,prod1,100,"20.10.2022");
//
//		cubeRepo.save(cub11);
//		cubeRepo.save(cub12);
//		cubeRepo.save(cub13);
//		cubeRepo.save(cub14);
//		cubeRepo.save(cub15);
//		cubeRepo.save(cub16);
//		cubeRepo.save(cub17);
//		cubeRepo.save(cub18);
//		cubeRepo.save(cub19);
//		cubeRepo.save(cub20);
//
//
//
//		producerRepo.save(prod11);
//		producerRepo.save(prod12);
//		producerRepo.save(prod13);
//		producerRepo.save(prod14);
//		producerRepo.save(prod15);
//		producerRepo.save(prod16);
//		producerRepo.save(prod17);
//
//
//		reviewRepo.save(rev11);
//		reviewRepo.save(rev12);
//
//		cubesProducerRepo.save(cubesProducer11);
//		cubesProducerRepo.save(cubesProducer12);
//		cubesProducerRepo.save(cubesProducer13);
//		cubesProducerRepo.save(cubesProducer14);
//		cubesProducerRepo.save(cubesProducer15);
//		cubesProducerRepo.save(cubesProducer16);
//		cubesProducerRepo.save(cubesProducer17);
//		cubesProducerRepo.save(cubesProducer18);
//		cubesProducerRepo.save(cubesProducer19);
//		cubesProducerRepo.save(cubesProducer20);
//

	}
}
