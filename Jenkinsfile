pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk "JAVA_HOME"
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
                    export M2="/Users/ravi/Documents/apache-maven-3.6.3/bin"
                    echo $M2
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
