pipeline {
    agent any

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