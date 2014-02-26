package consortium.psd.Course;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import consortium.psd.UI.Course;

public class CourseControllerTest {
	CourseController courseController = new CourseController();

	@Test
	public void testAddCourse() {
		String testName = "test name";
		String testType = "test type";
		courseController.addCourse(testName, testType);

		int latestIndex = courseController.getSize() - 1;
		Course c = courseController.getCourse(latestIndex);

		if (c.getId() == latestIndex && c.getName().equals(testName)
				&& c.getType().equals(testType)) {
			assertTrue(true);
		} else {
			fail("Latest record are different from what is added");
		}
	}

	@Test
	public void testViewCourse() {
		try {
			courseController.viewCourse();
			assertTrue(true);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testInitData() {
		try {
			courseController.initData();
			assertTrue(true);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
