pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage ('Initialize') {
            steps {
                echo "Initialize success"
            }
        }

        stage ('Build') {
            steps {
                sh '''
                    mvn -version
                '''
                 sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                    echo "------- Post Build ----------"
                }
            }
        }
    }
}
