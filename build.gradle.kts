// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Versions are defined in module build files to keep root minimal
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
