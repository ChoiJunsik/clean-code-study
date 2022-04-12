package object_create_pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTestApplication {

	public static void main(String[] args)
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

		Settings settings = Settings.getInstance();

		/**
		 * 리플렉션 사용시 싱글톤이 깨진다
		 */
		Constructor<Settings> declaredConstructor = Settings.class.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		Settings newInstance = declaredConstructor.newInstance();

		System.out.println(settings == newInstance);

		/**
		 * 역직렬화 <-> 직렬화, readResolve로 대응
		 */
	}
}
