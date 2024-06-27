pipeline {
    agent {
        label "main"
    }

    stages {
        stage('Build') {
            steps {
                sh "javac automation/src/test/java/openSite.java"
            }
        }
        stage('Run') {
            steps {
                java openSite
            }
        }
    }
}