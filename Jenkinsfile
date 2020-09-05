pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JAVA_HOME'
    }
    stages {
        stage ('Initialize') {
            steps {
                echo 'Initialize success'
            }
        }

        stage ('Build') {
            steps {
                 sh 'mvn clean install'
            }
            post {
                success {
                    echo '------- Post Build ----------'
                }
            }
        }

        stage ('JUnit Test') {
            steps {
                 sh 'mvn -Dmaven.test.failure.ignore=true test'
            }
            post {
                success {
                    echo '------- JUnit Test Pass  ----------'
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage ('Deploy') {
            steps {
                    echo "Deploy success"
            }
            post {
                success {
                    echo '------- Package done  ----------'
                }
            }
        }
    }
}
