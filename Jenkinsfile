/* groovylint-disable-next-line CompileStatic */
 
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
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true test'
                // sh 'make check || true'
            }
        }
        stage("SonarQube") {
            steps {
                sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=user-service \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.login=d279845c5b28d6a0ddb213d83128564522fca544
                '''
            }
        }
    }
}
