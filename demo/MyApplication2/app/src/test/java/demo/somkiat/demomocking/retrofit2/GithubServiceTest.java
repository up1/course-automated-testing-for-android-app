package demo.somkiat.demomocking.retrofit2;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;

import demo.somkiat.demomocking.BuildConfig;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class GithubServiceTest {



    private String getDataFromFile(String resource) throws IOException {
        return Resources.toString(
                Resources.getResource(resource), Charsets.UTF_8);
    }


}


