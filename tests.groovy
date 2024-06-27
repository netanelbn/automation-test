pipeline {
    agent {
        label "main"
    }

    stages {
        stage('Build') {
            steps {
                sh "cd automation; mvn compile"
            }
        }
        stage('Run') {
            steps {
                java openSite
            }
        }
    }
}