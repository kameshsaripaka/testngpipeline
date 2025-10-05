pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Option 1: Let Maven handle testng.xml automatically
                sh 'mvn test'

                // Option 2: Run specific testng.xml file manually
                // sh 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
