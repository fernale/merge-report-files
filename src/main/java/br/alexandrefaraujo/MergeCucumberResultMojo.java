package br.alexandrefaraujo;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Collect all cucumber result files genetared by cucacle execution
 * and transform to single feature files like a non-parallel execution for the correct cucumber-report option
 *
 * @phase post-integration-test
 */
@Mojo(name = "merge-cucumber-results")
public class MergeCucumberResultMojo extends AbstractMojo {

    @Parameter(property="fileNameRegex",defaultValue = "_scenario")
    private String regex;

    @Parameter(property="cucumberReportFolder",defaultValue = "target/cucumber-report")
    private String cucumberReportFolder;


    public void execute() throws MojoExecutionException {
        getLog().info("Search files in "+cucumberReportFolder);
        getLog().info("Using file name Regex: "+regex);
        MergeCucumberResultHelper helper = new MergeCucumberResultHelper(regex, cucumberReportFolder);

        try {
            helper.mergeAndCreateFiles();
            helper.deleteUnusedFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getCucumberReportFolder() {
        return cucumberReportFolder;
    }

    public void setCucumberReportFolder(String cucumberReportFolder) {
        this.cucumberReportFolder = cucumberReportFolder;
    }
}
