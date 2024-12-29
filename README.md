# About

This Gradle Plugin displays some information about a project's dependencies.

# License

This software is released under the terms of the GNU Lesser General Public
License.

See  [LGPL.md](LGPL.md) and [GPL.md](GPL.md) for details.

# Development and testing

Before publishing the plugin to the Gradle plugin portal, it should be tested
locally. To help with that, there are a few testing-projects available within
this repository that use the locally built version. In order to test them, first
build the current version:

    ./gradlew -PpublishForTesting publish

The testing projects reside in the `test-local` directory. Have a look at what
the script `test.sh` does. It tests the plugin in different scenarios,
especially using different combinations of JDK and Gradle versions.
