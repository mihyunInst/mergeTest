package edu.kh.abs.model.vo;

public class Whale extends TypeMammalia{

	@Override
	public void breastfeed() {
		System.out.println("고래도 수유를 하나요?");
		
	}

	@Override
	public void eat() {
		System.out.println("고래가 밥을 먹는다");
		
	}

	@Override
	public void cry() {
		System.out.println("고래가 운다");
		
	}

	@Override
	public void move() {
		System.out.println("고래가 움직인다");
		
	}



}
