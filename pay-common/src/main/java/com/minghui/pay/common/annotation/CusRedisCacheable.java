package com.minghui.pay.common.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface CusRedisCacheable {
	public String key() default "";
	public TimeUnit timeUnit() default TimeUnit.SECONDS;
	public long expire() default 0;
}
