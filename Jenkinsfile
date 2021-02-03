pipeline {

    parameters {
        choice(name: 'ENVIRONMENT',
               choices: ['dev', 'stage'],
               description: 'Environment variables'
        )
        string(name: 'GIT_BRANCH',
               defaultValue: 'main',
               description: 'Git branch to checkout'
        )
    }

    agent { label 'gcp_linux' }

    stages {
        stage('checkout'){
            steps {
                git branch: "${params.GIT_BRANCH}",
                credentialsId: 'scm-creds',
                url: 'https://github.com/dkaravashkin/qa_automation_courses.git'
            }
        }
        stage('running tests'){
            steps {
                sh 'chmod +x mvnw'
                sh "xvfb-run -a ./mvnw -DENV=${params.ENVIRONMENT} clean test"
            }
        }
    }

    post {
        always {
            allure([
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
