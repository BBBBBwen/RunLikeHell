package test;


import static org.junit.Assert.*;


import org.junit.After;


import org.junit.Before;


import org.junit.Test;

import model.Monster;



public class TestMonster {


	



Monster M;



	@Before


	public void setUP()


	{


		M = new Monster(1,1);


		


		//x=1;


		//y=1;


	}



	@Test


	public void Move() {


		M.Move();


		assertEquals(2,M.getX());


	}


	@Test


	public void notMove() {


	//	M.notMove();


		//boolean Nmove = M.notMove("")


		assertNotEquals(false,M.notMove());


	}



}
