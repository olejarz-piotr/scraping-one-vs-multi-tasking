package pl.olejarz.scrapingonevsmultitasking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ScrapingOneVsMultiTaskingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrapingOneVsMultiTaskingApplication.class, args);


        ExecutorService executorService = Executors.newFixedThreadPool(2);//numbers of threads
        executorService.submit(() -> numbers());
		executorService.submit(() -> numbers());
		executorService.shutdown();



	}

    private static Runnable numbers() {
        for (int i = 0; i < 999; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return null;
    }


//		Thread t1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 999; i++) {
//					System.out.println(Thread.currentThread().getName()+" "+i);
//
//				}
//
//			}
//		});
//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 999; i++) {
//					System.out.println(Thread.currentThread().getName()+" "+i);
//
//				}
//
//			}
//		});
//
//		t1.setName("t1");
//		t2.setName("t2");
//		t1.start();
//		t2.start();
}


