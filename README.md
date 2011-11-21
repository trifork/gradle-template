Introduction
============

This project is meant as starting point for Trifork projects that use Gradle
as build-system. It is a good idea to become familiar with Gradle, and the
[Gradle Userguide](http://gradle.org/documentation.html) is a very good
reference.

To get started make a git repository and add this repository as a remote:

    git remote add template git://github.com/trifork/gradle-template.git

That way you can also easily get any future additions:

    git pull template master

The template contains two example sub-projects, one Java and one Scala.

Suggestions and patches (or pull requests) are very welcome. If you encounter
any bugs please make an issue on Github.

Build Customization
-------------------

Take a look in 'gradle.properties', 'build.gradle', 'settings.gradle' and in
the config-directory to customize the build to fit your project.

There are very few things that actually need to be changed in the build
configuration – at least to start out with.
But there are though a couple of properties you need to change in
'gradle.properties'.

First off, you will have to change the name of the `projectName` and
`nextReleaseVersion` properties. These properties are defined in
`gradle.properties` file. The properties are described in greater detail in
the file itself.

If you do not want to use Jira or use some other SCM than Git you will also
have to change some settings in the `config/deployment.groovy` file.

Coding standards and formatting is checked using Checkstyle. You can edit them
to fit your project in `config/checkstyle/checkstyle.xml`.

Dependency Management
---------------------

It is a good idea to keep a list of dependencies you use in several
sub-projects in the `config/libraries.groovy` file. That way you can keep
versions consistent. There is of course nothing that is stopping your from
declaring dependencies on an ad-hoc basis in your sub-projects. But this can
quickly get out of hand for larger projects.

Plugins
-------

Gradle has a good plugin system.  By default Gradle comes with a lot of handy
plugins, but they are quite general and need some customization.  Therefore
there is a set plugin specificly made for Trifork projects. 

By default only the `deployment` plugin is added.  It helps you use the
Trifork nexus server correctly and use a consistent scheme for deployment of
artifacts, both class and source files.

All the plugins are described in the Plugin Project's README. You can find it
[here](https://github.com/trifork/gradle-plugins).

Releases & Snapshots
--------------------

When you apply the deployment-plugin you get a few extra tasks to help you
share your artifacts.

It is important to have a well-defined and consistent way of sharing jar files
and other artifacts. Maven repos are the de-facto standard for artifact
sharing and by using it you get a high degree of interoperability between
build systems.

When making a release it is important to make sure that you don't
depend on any snapshot artifacts. Since snapshots change over time, future
snapshot versions will potentially break your release (which is bad).

TODO: In future this check might be automated.

Git Tips
--------

It is a good idea to check your code before you push anything to other central
repositories. While you don't necessarily want to run tests and check code for
every commit you do locally.

You can setup a git command alias to check your code before you push anything.

    git config alias.publish '! gradle check && git push "$@"'

This will allow you to e.g. write:

    git publish origin master

as an alternative to `git push`. Please note that since you will be running
tests and other code checks this will usually take considerably longer than
a normal push.

Requirements
------------

This build setup is made for Gradle 1.0-milestone-6.

If you want to run the Scala subproject you will need to have install a
version of Scala.
