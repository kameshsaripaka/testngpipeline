pipeline {
    agent {
        docker {
            image 'selenium/standalone-chrome:latest'
            args '--shm-size=2g'
        }
    }

    stages {
        stage('Build & Test') {
            steps {
                sh '''
                    echo "Running tests inside selenium/standalone-chrome"
                    apt-get update && apt-get install -y maven
                    mvn clean test
                '''
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
