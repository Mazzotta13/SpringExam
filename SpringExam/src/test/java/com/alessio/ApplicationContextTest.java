package com.alessio;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alessio.container.BeanTest;
import com.alessio.container.ConfigurationBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigurationBean.class)
class ApplicationContextTest {
	@Autowired
	@Qualifier("beanTest")
	protected BeanTest beanTest;
	@Test
	void test() {
		System.out.println("Bean instance: " + beanTest);
		assertNotNull(beanTest);
	}

}
