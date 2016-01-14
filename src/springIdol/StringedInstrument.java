package springIdol;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public  @interface StringedInstrument {
	
}
// 通过自定义的@StringedInstrument注解，可以用来代替@Qualifier来标注类。
//当Spring尝试装配instrument属性时，Spring会把可选择的乐器范围缩小到只有被@StringedInstrument
//注解所标识的Bean。
// 也可以在这个注解的基础上继续缩小范围 