package jadx.tests.integration.others;

import org.junit.jupiter.api.Test;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

import static jadx.tests.api.utils.JadxMatchers.containsOne;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCastOfNull extends IntegrationTest {

	public static class TestCls {

		public void test() {
			m((long[]) null);
			m((String) null);
		}

		public void m(long[] a) {
		}

		public void m(String s) {
		}
	}

	@Test
	public void test() {
		ClassNode cls = getClassNode(TestCls.class);
		String code = cls.getCode().toString();

		assertThat(code, containsOne("m((long[]) null);"));
		assertThat(code, containsOne("m((String) null);"));
	}
}
