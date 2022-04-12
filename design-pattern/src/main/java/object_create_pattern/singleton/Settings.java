package object_create_pattern.singleton;

public class Settings {

	private Settings() {
	}

	// Double Checked Lock 을 위한 volatile
	private static volatile Settings instance;

	protected Object readResolve() {
		return getInstance();
	}

	/**
	 * 1. 멀티 스레드 환경에서 이 코드가 안전한가?, No
	 */
	public static Settings getInstance() {

		/**
		 * Race Condition, Thread A / Thread B
		 */
		if (instance == null) {
			instance = new Settings();
		}

		return instance;
	}

	/**
	 * 2. eager initialization
	 * 2.1 연산량이 많은 객체라면 초기화 과정에서 메모리 이슈가 있을 수도 있음
	 * 2.2 만들어놓고 사용하지 않을 수도 있음
	 */
	private static Settings INSTANCE = new Settings();

	/**
	 * 3. synchronized 사용
	 * 호출시마다, 동기화 처리(Lock) 가 이루어짐, 성능 저하
	 */
	public static synchronized Settings getInstanceSync() {

		if (instance == null) {
			instance = new Settings();
		}

		return instance;
	}

	public static Settings getInstanceDoubleCheckedLocking() {
		/**
		 * 4. Double Checked Locking, 이미 인스턴스가 있는 경우
		 * 동기화 매커니즘을 쓰지 않게 된다
		 */
		if (instance == null) {
			synchronized (Settings.class) {
				if (instance == null) {
					instance = new Settings();
				}
			}
		}

		return instance;
	}

	/**
	 * 5. static inner class 사용
	 * getInstance 호출 시점에서 static 클래스가 로딩 된다
	 */
	private static class SettingsHolder {
		private static final Settings INSTANCE = new Settings();
	}

	public static Settings getInstanceStaticInnerClass() {
		return SettingsHolder.INSTANCE;
	}
}
