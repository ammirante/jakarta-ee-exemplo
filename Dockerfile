FROM airhacks/glassfish
COPY ./target/jakarta-ee.war ${DEPLOYMENT_DIR}
