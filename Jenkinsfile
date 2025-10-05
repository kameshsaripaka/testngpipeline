pipeline {
    agent any

    stages {
        stage('Run Tests in Docker') {
            steps {
                sh '''
                    echo "Running tests in Docker container..."
                    docker run --rm \
                        -v $PWD:/workspace \
                        -w /workspace \
                        --shm-size=2g \
                        selenium/standalone-chrome:latest \
                        bash -c "apt-get update && apt-get install -y maven && mvn clean test"
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