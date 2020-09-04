pipeline {
    agent any
    tools {
        maven '/Users/ravi/Documents/apache-maven-3.6.3'
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
