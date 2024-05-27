set(TARGET_NAME roq)

add_subdirectory(com)

set(JAR_NAME_VERSION ${TARGET_NAME}-${CMAKE_PROJECT_VERSION})
set(JAR_NAME ${TARGET_NAME})

set(TARGET_DIR ${CMAKE_INSTALL_DATADIR}/java)

set(SOURCE_DIR ${CMAKE_SOURCE_DIR}/src/main/java)

file(
  GLOB_RECURSE JAVA_SOURCES
  RELATIVE ${SOURCE_DIR}
  *.java)

message("SOURCE_DIR=${SOURCE_DIR}")
message("JAVA_SOURCES=${JAVA_SOURCES}")

set(SOURCES ${JAVA_SOURCES} MANIFEST META-INF/MANIFEST.MF)

add_jar(${JAR_NAME_VERSION} ${SOURCES})

add_custom_target(jar_symlink ALL COMMAND ${CMAKE_COMMAND} -E create_symlink
                                          ${JAR_NAME_VERSION}.jar ${JAR_NAME}.jar)

add_dependencies(${JAR_NAME_VERSION} autogen_java)

# install

install(FILES ${JAR_NAME_VERSION}.jar DESTINATION ${TARGET_DIR})
install(FILES ${JAR_NAME}.jar DESTINATION ${TARGET_DIR})
