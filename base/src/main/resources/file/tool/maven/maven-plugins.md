#install:install-file

###Description

Installs a file in the local repository.

###Required Parameters

| Name   | Type   | Since | Description                                                  |
| :----- | :----- | :---- | :----------------------------------------------------------- |
| `file` | `File` | `-`   | The file to be installed in the local repository. **User property is**: `file`. |



### Optional Parameters

| Name                  | Type      | Since | Description                                                  |
| :-------------------- | :-------- | :---- | :----------------------------------------------------------- |
| `artifactId`          | `String`  | `-`   | ArtifactId of the artifact to be installed. Retrieved from POM file if one is specified or extracted from `pom.xml` in jar if available. **User property is**: `artifactId`. |
| `classifier`          | `String`  | `2.2` | Classifier type of the artifact to be installed. For example, "sources" or "javadoc". Defaults to none which means this is the project's main artifact. **User property is**: `classifier`. |
| `GeneratePom`         | `Boolean` | `2.1` | Generate a minimal POM for the artifact if none is supplied via the parameter `pomFile`. Defaults to `true` if there is no existing POM in the local repository yet. **User property is**: `generatePom`. |
| `groupId`             | `String`  | `-`   | GroupId of the artifact to be installed. Retrieved from POM file if one is specified or extracted from `pom.xml` in jar if available. **User property is**: `groupId`. |
| `javaDoc`             | `File`    | `2.3` | The bundled API docs for the artifact. **User property is**: `javadoc`. |
| `localRepositoryPath` | `File`    | `2.2` | The path for a specific local repository directory. If not specified the local repository path configured in the Maven settings will be used. **User property is**: `localRepositoryPath`. |
| `packaging`           | `String`  | `-`   | Packaging type of the artifact to be installed. Retrieved from POM file if one is specified or extracted from `pom.xml` in jar if available. **User property is**: `packaging`. |
| `pomFile`             | `File`    | `2.1` | Location of an existing POM file to be installed alongside the main artifact, given by the `file` parameter. **User property is**: `pomFile`. |
| `sources`             | `File`    | `2.3` | The bundled sources for the artifact. **User property is**: `sources`. |
| `version`             | `String`  | `-`   | Version of the artifact to be installed. Retrieved from POM file if one is specified or extracted from `pom.xml` in jar if available. **User property is**: `version`. |



### Example

将<path-to-file>安装到本地maven repository

####script

```
mvn install:install-file
-Dfile=<path-to-file>
-DgroupId=<group-id>
-DartifactId=<artifact-id>
-Dversion=<version>
```



set ov_version=4.5R2

set libs_path=..\ovlibs

```
mvn install:install-file
-Dfile=%libs_path%\cache-%ov_version%.jar
-DgroupId=com.alu.ov.ngnms
-DartifactId=cache
-Dversion=%ov_version%
-Dpackaging=jar
```



####maven-install-plugin

pom.xml可以直接使用该插件：

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-install-plugin</artifactId>
    <version>2.5</version>
    <executions>
        <execution>
            <id>cache</id>
            <phase>initialize/install/compile/...</phase>
            <goals>
                <goal>install-file</goal>
            </goals>
            <configuration>
                <file>${basedir}/ovlibs/cache-${ov.version}.jar</file>
                <groupId>com.alu.ov.ngnms</groupId>
                <artifactId>cache</artifactId>
                <version>${ov.version}</version>
                <packaging>jar</packaging>
            </configuration>
        </execution>
    </executions>
</plugin>
```



无论使用1和2哪种方式，需要在pom.xml中主动依赖已安装到本地的jar:

```xml
<dependency>
	<groupId>com.alu.ov.ngnms</groupId>
	<artifactId>cache</artifactId>
	<version>${ov.version}</version>
</dependency>
```



### Resolve

####解决依赖传递问题

依赖传递：

由scope定义

- **compile** - this is the default scope, used if none is specified. Compile dependencies are available in all classpaths. Furthermore, those dependencies are propagated to dependent projects.
- **provided** - this is much like compile, but indicates you expect the JDK or a container to provide it at runtime. It is only available on the compilation and test classpath, and is not transitive.
- **runtime** - this scope indicates that the dependency is not required for compilation, but is for execution. It is in the runtime and test classpaths, but not the compile classpath.
- **test** - this scope indicates that the dependency is not required for normal use of the application, and is only available for the test compilation and execution phases. It is not transitive.
- **system** - this scope is similar to `provided` except that you have to provide the JAR which contains it explicitly. The artifact is always available and is not looked up in a repository.



当A依赖B，B依赖C，如果A对B、B对C的依赖pom scope设置为**compile**，则A对C的依赖与B对C的依赖相同。

这样会产生一个问题：当B依赖的C(C可能是B端的本地包，不在公共仓库上)在A端没有，则使用maven build的时候会报错。



当使用install:install-file将依赖的B安装到本地后，查看本地maven仓库：

![install_install-file_cache](.\images\install_install-file_cache.png)



再查看cache.jar依赖的pom.xml

![cache](.\images\cache.png)



cache.jar原本的pom.xml依赖在安装到本地后，dependency节点全部被省略，包括parent节点。

所以不会产生A到C的传递依赖。



### Extend

####system scope

```xml
<scope>system</scope>
```

直接引用本地Jar包，不需要安装到本地maven仓库

e.g:

```xml
<dependency>
	<groupId>com.alu.ov.ngnms</groupId>
	<artifactId>cache</artifactId>
	<version>${ov.version}</version>
    <scope>system</scope>
	<systemPath>${basedir}/*.jar</systemPath>
</dependency>
```



#### common maven repository

Deploy the local JARs in the new maven repository as below:

```
mvn deploy:deploy-file
-Dfile=<path-to-file>
-DgroupId=<group-id>
-DartifactId=<artifact-id>
-Dversion=<version>
-Dpackaging=jar
-Durl=file:./maven-repository/
-DrepositoryId=maven-repository
-DupdateReleaseInfo=true
```



After installing the JARs, add the repository in pom.xml file:

```xml
<repositories>
    <repository>
        <id>maven-repository</id>
        <url>file:///${project.basedir}/maven-repository</url>
    </repository>
</repositories>
```



Then add the dependency into pom.xml:

```xml
<dependency>
	<groupId>com.roufid.tutorials</groupId>
	<artifactId>example-app</artifactId>
	<version>1.0</version>
</dependency>
```





