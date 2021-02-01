pipeline {
    agent { label 'gcp_linux' }
    stages {
        stage('checkout'){
            git branch: 'main',
            credentialsId: 'scm-creds',
            url: 'https://github.com/dkaravashkin/qa_automation_courses.git'
        }
        stage('running tests'){
            sh 'chmod +x mvnw'
            sh './mvnw clean test'
        }
    }
}
