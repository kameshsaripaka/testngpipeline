pipeline {
    agent { 
        docker { 
            image 'selenium/standalone-chrome:latest'
            args '--user=root --shm-size=2g' // optional, for Chrome stability
        } 
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Reports') {
            steps {
                // Publish TestNG or Surefire reports (generated under target/surefire-reports)
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo "Pipeline completed. Check console and reports."
        }
    }
}
