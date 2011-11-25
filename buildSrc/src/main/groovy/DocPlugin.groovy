package com.trifork.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.apache.tools.ant.filters.ReplaceTokens

class DocPlugin implements Plugin<Project> {
    void apply(Project project) {
        
        project.task('doc') << {

            // We have to wait until the properties
            // have been filed to we can filter them in.

            project.file("build").mkdirs()

            project.copy {
                from "${project.rootDir}/config/doxygen.cfg"
                into "${project.projectDir}/build/"
                filter(ReplaceTokens, tokens: [version: project.version, name: project.name])
            }

            project.exec {
                executable = 'doxygen'
                args = ["${project.projectDir}/build/doxygen.cfg"]
            }
        }
    }
}
