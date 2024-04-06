package com.metaphore.basisutest.ios;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.badlogic.gdx.backends.iosrobovm.IOSAudio;
import com.metaphore.basisutest.App;

/** Launches the iOS (RoboVM) application. */
public class IOSLauncher extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration configuration = new IOSApplicationConfiguration();

        return new IOSApplication(new App(), configuration) {
            @Override
            protected IOSAudio createAudio(IOSApplicationConfiguration config) {
                // This helps to run the demo on a simulator inside
                // a virtualized macOS instance (with no audio support).
                return new MockIosAudio();
            }
        };

        // return new IOSApplication(new App(), configuration);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}
