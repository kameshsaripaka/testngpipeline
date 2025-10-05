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
        sh '''
   			set +e
  			 java -cp "$(cat classpath.txt):target/classes:target/test-classes" org.testng.TestNG testng.xml
   			echo "Exit code: $?"
   			set -e
			'''
           }
        }
          
    
    }
}
