pipeline {
    agent any

    environment {
        DOCKER_HUB = credentials('dockerhub-cred')
    }

    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                sh 'docker build -t cooper/selenium .'
            }
        }

        stage('Image Push') {
            steps {
                sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                sh 'docker push cooper/selenium'
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }
    }
}
