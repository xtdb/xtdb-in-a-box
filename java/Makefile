
build:
	mvn dependency:copy-dependencies
	mvn package # alternatively: `mvn clean compile assembly:single`

# MacOS + JDK16/17 workarounds:
# (1) `XTDB_ENABLE_BYTEUTILS_SHA1` is required to change the SHA1 algorithm used.
# (2) `--add-opens java.base/java.util.concurrent=ALL-UNNAMED` is required to avoid
#     https://github.com/xtdb/xtdb/issues/1462
run:
	XTDB_ENABLE_BYTEUTILS_SHA1=true \
	java -cp target/xtdbinabox-0.0.2-jar-with-dependencies.jar \
	-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory \
	--add-opens java.base/java.util.concurrent=ALL-UNNAMED \
	xtdbinabox.Box

sanity:
	java --version
	mvn --version
