pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Preparation') {
            steps {
                git 'https://github.com/nicks204/TestNg_MavenFeb22.git' 
            }
        }
        stage('Build') {
            steps {
                //sh "mvn clean test"
                bat "mvn clean test"
            }
        }
    }

}
