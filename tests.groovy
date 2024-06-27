pipeline {
    agent {
        label "main"
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Run') {
            steps {
                java openSite
            }
        }
    }
}