
This plugin was made for cucable and cucumber-report users. Basically speaking,
 after the end of parallel execution, this plugin will collect all results and merge
  all Scenarios in its Feature file.

All 'myFeatureFileName_scenarioXXX_runXXX_IT.json' files, will be merged in a new file (myFeatureFileName.Json)
 and *deleted* in the end.

At the moment, you may clone or fork this repo and run a mvn clean install locally. I'll settle a better way to do that asap.

       <plugin>
            <groupId>br.alexandrefaraujo</groupId>
            <artifactId>get-reportfiles-merged</artifactId>
            <version>0.0.1</version>
            <executions>
                <execution>
                    <id>Merging all results</id>
                    <phase>post-integration-test</phase>
                    <goals>
                        <goal>merge-cucumber-results</goal>
                    </goals>
                    <!-- Both are optional -->
                    <!--<configuration>-->
                         <!--cucumberReportFolder: default value = target/cucumber-report-->
                         <!--regex: By default, will find all files containing '_scenario'-->

                        <!--<cucumberReportFolder>child-project/target/cucumber-report</cucumberReportFolder>-->
                        <!--<regex>yourRegex</regex>-->
                    <!--</configuration>-->
                </execution>
            </executions>
        </plugin>