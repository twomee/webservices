package com.ido.sprniglogin;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ido.sprniglogin.bll.LogicRunner;
import com.ido.sprniglogin.configuration.HelloWorldConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes = {HelloWorldConfiguration.class})
public class SpringTest {
	
//	@Autowired
	LogicRunner logicRunner;
	
//	public SpringTest() {
//		this.logicRunner = new LogicRunner();
//	}
	
	@Test
	public void myTest() {
		
		assertEquals(true,logicRunner.insertUserToDB("idan","1111"));
	}
	
	public void main(String [] args) {
		logicRunner.insertUserToDB("idan","1111");
	}
}
