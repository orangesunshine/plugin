package com.orange.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

open class CustomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("customPlugin")
        val ext = target.extensions.create("extension", Extension::class.java)
        target.tasks.register("sun") {
            it.doLast {
                println("title:${ext.title}, age: ${ext.age}, sub.name:${ext.sub?.name}")
            }
        }
    }
}

open class Extension {
    var title: String? = null
    var age: Int? = null
    var sub: SubExtension? = null

    constructor(project: Project) {
        sub = project.extensions.create("sub", SubExtension::class.java)
    }
}

open class SubExtension {
    var name: String? = null
}