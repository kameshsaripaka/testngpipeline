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
                    sh '''
                        java -cp "target/classes:target/test-classes:~/.m2/repository/org/testng/testng/7.7.0/testng-7.7.0.jar:~/.m2/repository/com/beust/jcommander/1.82/jcommander-1.82.jar" \
                        org.testng.TestNG testng.xml
                    '''
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
