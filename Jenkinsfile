pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'This is a Build Stage'
            }
        }
        stage('Test') {
            steps {
                echo 'This is a Test Stage'
            }
        }
         stage('Deploy') {
            steps {
                echo 'This is a Deploy Stage'
            }
        }
    }
 post{
    
  always{
    emailext body: 'EmailBody1', subject: 'EmailSubject1', to: 'bhaanureaka@gmail.com'
    }
    }
    
  
}