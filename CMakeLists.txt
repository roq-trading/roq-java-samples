cmake_minimum_required(VERSION 3.12)

# cmake

set(CMAKE_MODULE_PATH "${CMAKE_CURRENT_SOURCE_DIR}/cmake"
                      "${CMAKE_CURRENT_SOURCE_DIR}/autogen/cmake" ${CMAKE_MODULE_PATH})

# config

include(RoqConfig)

# version (using git tag)

include(GetGitRepoVersion)

message("Using GIT_REPO_VERSION=${GIT_REPO_VERSION}")

# project

project(roq-java-samples VERSION ${GIT_REPO_VERSION})

# filesystem

include(GNUInstallDirs)

# java

include(UseJava)

find_package(Java COMPONENTS Development)

# note! something missing when using conda-build
if(NOT DEFINED ENV{CONDA_BUILD})
  find_package(JNI REQUIRED)
else()
  set(JAVA_INCLUDE_PATH $ENV{JAVA_HOME}/include)
  if(UNIX AND NOT APPLE)
    set(JAVA_INCLUDE_PATH2 $ENV{JAVA_HOME}/include/linux)
  else()
    set(JAVA_INCLUDE_PATH2 $ENV{JAVA_HOME}/include/darwin)
  endif()
endif()

# dependencies

find_program(CLANG_FORMAT clang-format REQUIRED)

# sub-projects

add_subdirectory("${CMAKE_CURRENT_SOURCE_DIR}/src/main/java")

# install

install(FILES "${CMAKE_SOURCE_DIR}/CHANGELOG.md"
        DESTINATION "${CMAKE_INSTALL_DATADIR}/doc/${PROJECT_NAME}")
