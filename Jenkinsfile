pipeline {
    agent any

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
        
        //kamesh
        //stage('Build & Test') {
            //steps {
                // Run mvn inside a Docker container manually
                //sh '''
               // docker run --rm -v $PWD:/workspace -w /workspace selenium/standalone-chrome:latest \
                    //bash -c "apt-get update && apt-get install -y maven && mvn clean test"
                //'''
            //}
        //}

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