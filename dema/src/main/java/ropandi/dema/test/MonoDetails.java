package ropandi.dema.test;

import reactor.core.publisher.Mono;

public class MonoDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mono.just("On Data").subscribe(s-> System.out::println);
		
		
		
	}

}
