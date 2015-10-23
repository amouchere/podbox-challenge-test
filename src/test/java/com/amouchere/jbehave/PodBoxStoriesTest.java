package com.amouchere.jbehave;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by LaBete on 22/10/2015.
 */
public class PodBoxStoriesTest  {


    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"),
                "jbehave/stories/*.story", "");
    }

    @Test
    public void runClasspathLoadedStoriesAsJUnit() {
        // Embedder defines the configuration and candidate steps
        Embedder embedder = new PodBoxEmbedder();
        List<String> storyPaths = storyPaths(); // use StoryFinder to look up paths
        embedder.runStoriesAsPaths(storyPaths);
    }


}
