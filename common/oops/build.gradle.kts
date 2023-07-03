plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(project(":common:core"))
}