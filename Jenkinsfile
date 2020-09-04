pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    export M2="/Users/ravi/Documents/apache-maven-3.6.3/bin"
                    export M2_HOME="/Users/ravi/Documents/apache-maven-3.6.3"
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo $M2
                '''
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
