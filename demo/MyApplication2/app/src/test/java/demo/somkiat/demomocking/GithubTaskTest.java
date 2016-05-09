package demo.somkiat.demomocking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import demo.somkiat.demomocking.normal.GitHubTask;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class GithubTaskTest {

    public GitHubTask gitHubTask = Mockito.mock(GitHubTask.class);

    @Before
    public void setUp() {
        try {
            Mockito.when(gitHubTask.loadFromNetwork("http://www.google.com"))
                    .thenReturn("<!doctype html><html itemscope=\"\" itemtype=\"http://schema.org/WebPage\" lang=\"en\"><head>");
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void setGitHubTaskTest_ReturnsTrue() {
        try {
            assertThat(gitHubTask.loadFromNetwork("http://www.google.com"),
                    containsString("doctype"));
        } catch (IOException e) {
            fail();
        }
    }
}

