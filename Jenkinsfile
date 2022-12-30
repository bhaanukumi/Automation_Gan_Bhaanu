pipeline {
    agent any

    tools {
        
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
               
                git 'https://github.com/bhaanukumi/Automation_Gan_Bhaanu.git'

                bat "mvn clean test -Drunner=TestRunnerTestng"
            }

            post {
             
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
