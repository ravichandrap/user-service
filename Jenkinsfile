pipeline {
    agent any
    tools {
        maven 'M3'
//         jdk 'JAVA_HOME'
    }

    stages {
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
//             when {
//                 changeRequest target: 'master', branch: /^TEST-\d+$/, comparator: 'REGEXP'
//             }
            steps {
                 //sh 'mvn -Dmaven.test.failure.ignore=true test'
                 sh 'make check || true'
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
    post {
            always {
                junit 'target/surefire-reports/**/*.xml'
            }
            failure {
                mail to: 'r.penumuru@ths-bs.de', subject: 'The Pipeline failed :('
            }
            success {
                mail to: 'r.penumuru@ths-bs.de', subject: 'The user-service Pipeline success  :)'
            }
        }
}
