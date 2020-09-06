/* groovylint-disable-next-line CompileStatic */
def CODE_CHANGES = getGitChanges()

pipeline {
    agent any
    tools {
        maven 'M3'
//         jdk 'JAVA_HOME'
    }
    stages {
        stage ('Build') {
            when {
                expression {
                    CODE_CHANGES == true
                }
            }
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
                // sh 'make check || true'
            }
        }
    }
}
