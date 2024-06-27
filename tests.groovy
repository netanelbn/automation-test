pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                javac openSite.java
            }
        }
        stage('Run') {
            steps {
                java openSite
            }
        }
    }
}