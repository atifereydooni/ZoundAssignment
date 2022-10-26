import com.zoundindustries.assignment.implementation

plugins {
    id(Plugins.library)
    id(Plugins.zoundPlugin)
    id(Plugins.composePlugin)
}

dependencies {
    implementation(project(Modules.themeModule))
}