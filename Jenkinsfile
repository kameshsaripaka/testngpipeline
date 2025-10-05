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
                sh 'mvn clean compile test-compile'
            }
        }

       stage('Run TestNG Manually') {
            steps {
                script {
                    // Run TestNG directly using java command
                   sh 'mvn dependency:build-classpath -Dmdep.outputFile=classpath.txt'
                   sh 'java -cp "$(cat classpath.txt):target/classes:target/test-classes" org.testng.TestNG testng.xml'
                }
            }
        }
    }

       

    post {
        always {
            junit 'test-output/testng-results.xml'  // if TestNG generated XML reports
        }
    }
}
