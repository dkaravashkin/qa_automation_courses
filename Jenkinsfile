pipeline {

    agent { label 'gcp_linux' }

    stages {
        stage('checkout'){
            steps {
                git branch: 'main',
                credentialsId: 'scm-creds',
                url: 'https://github.com/dkaravashkin/qa_automation_courses.git'
            }
        }
        stage('running tests'){
            steps {
                sh 'chmod +x mvnw'
                sh 'xvfb-run -a ./mvnw clean test'
            }
        }
    }
}
