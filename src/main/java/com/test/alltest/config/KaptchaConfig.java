package com.test.alltest.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

/**
 * @author MeiYF
 * @time 2018/11/20 10:31
 **/
@Component
public class KaptchaConfig {
	@Bean
	public DefaultKaptcha getDefaultKaptcha(){
		com.google.code.kaptcha.impl.DefaultKaptcha defaultKaptcha = new com.google.code.kaptcha.impl.DefaultKaptcha();
		Properties properties = new Properties();
		//图片边框【合法值：yes , no；默认值：yes】
		properties.setProperty("kaptcha.border", "yes");
		//边框颜色【合法值：r,g,b或者 white,black,blue；默认值：black】
		properties.setProperty("kaptcha.border.color", "105,179,90");
		//kaptcha.image.width【图片宽；默认值：200】
		properties.setProperty("kaptcha.image.width", "110");
		//kaptcha.image.height【图片高；默认值：50】
		properties.setProperty("kaptcha.image.height", "40");
		//kaptcha.textproducer.font.color【字体颜色，合法值： r,g,b  或者 white,black,blue；默认值：black】
		properties.setProperty("kaptcha.textproducer.font.color", "blue");
		//kaptcha.textproducer.font.size【字体大小；默认值：40px】
		properties.setProperty("kaptcha.textproducer.font.size", "30");
		//kaptcha.session.key【session key；默认值：KAPTCHA_SESSION_KEY】
		properties.setProperty("kaptcha.session.key", "code");
		//kaptcha.textproducer.char.length【验证码长度；默认值：5】
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		//kaptcha.textproducer.font.names【字体；默认值：Arial, Courier】
		//properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		//kaptcha.border.thickness【边框厚度，合法值：>0；默认值：1】
		//kaptcha.producer.impl【图片实现类；默认值：com.google.code.kaptcha.impl.DefaultKaptcha】
		//kaptcha.textproducer.imp【文本实现类；默认值：com.google.code.kaptcha.text.impl.DefaultTextCreator】
		properties.setProperty("kaptcha.textproducer.imp", "com.google.code.kaptcha.text.impl.DefaultTextCreator");
		//kaptcha.textproducer.char.string【文本集合，验证码值从此集合中获取；默认值：abcde2345678gfynmnpwx】
		//kaptcha.textproducer.char.space【文字间隔；默认值：2】
		//kaptcha.noise.impl【干扰实现类；默认值：com.google.code.kaptcha.impl.DefaultNoise】
		//kaptcha.noise.color【干扰颜色，合法值： r,g,b 或者 white,black,blue；默认值：black】
		/*kaptcha.obscurificator.impl
					【图片样式：
					水纹com.google.code.kaptcha.impl.WaterRipple
					鱼眼com.google.code.kaptcha.impl.FishEyeGimpy
					阴影com.google.code.kaptcha.impl.ShadowGimpy；
					默认值：com.google.code.kaptcha.impl.WaterRipple
					】
		* */
		properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
		//kaptcha.background.impl【背景实现类；默认值：com.google.code.kaptcha.impl.DefaultBackground】
		//kaptcha.background.clear.from【背景颜色渐变，开始颜色；默认值：light grey】
		//kaptcha.background.clear.to【背景颜色渐变，结束颜色；默认值：white】
		//kaptcha.word.impl【文字渲染器；默认值：com.google.code.kaptcha.text.impl.DefaultWordRenderer】
		//kaptcha.session.date【session date；默认值：KAPTCHA_SESSION_DATE】
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);
		return defaultKaptcha;
	}
}

