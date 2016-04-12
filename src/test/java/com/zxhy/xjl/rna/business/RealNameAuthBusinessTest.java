package com.zxhy.xjl.rna.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext-mybatis.xml","classpath:ApplicationContextWorkflow.xml"})
public class RealNameAuthBusinessTest {
	@Autowired
	private RealNameAuthBusiness business;
	@Test
	public void register(){
		this.business.register("18900", "123456");
	}
	@Test
	public void getRealNameAuthTask(){
		RealNameAuthTask task  = this.business.getRealNameAuthTask("18900");
		Assert.assertNotNull(task);
		Assert.assertEquals("核名", task.getTaskName());
	}
}
