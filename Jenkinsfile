pipeline {
    agent any

    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('Build Image') {
            steps {
                sh "docker build -t cooper/selenium ."
            }
        }

        stage('Image Push') {
            steps {
                sh "docker push cooper/selenium"
            }
        }
    }
}
