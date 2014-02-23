package consortium.psd.UI;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
public class Activator implements BundleActivator {
	public void start(BundleContext bundleContext) throws Exception {
		new Menu();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Goodbye from UI components!");
	}
}
