
build:
	mvn dependency:copy-dependencies
	mvn package # alternatively: `mvn clean compile assembly:single`

run:
	java -cp target/cruxinabox-0.0.1-jar-with-dependencies.jar \
	-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory \
	cruxinabox.Box

sanity:
	java --version
	mvn --version
