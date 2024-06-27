pipeline {
    agent {
        label "main"
    }

    stages {
        stage('Build') {
            steps {
                sh "cd automation"
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