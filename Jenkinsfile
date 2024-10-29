pipeline {
    agent any

    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                sh 'docker build -t=sangram1989/selenium-docker:latest .'
            }
        }

        stage('Image Push') {

         environment{
                        DOCKER_HUB = credentials('dockercred')
                    }
            steps {

                sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin'
              sh 'docker push sangram1989/selenium-docker:latest'
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }
    }
}
