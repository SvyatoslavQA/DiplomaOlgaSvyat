pipeline {
    agent any

    tools {
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'gui', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/SvyatoslavQA/DiplomaOlgaSvyat.git'
            }
        }
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                //git 'https://github.com/wildpioneer/AQA21onl.git'
                //checkout scmGit(branches: [[name: '*/ci_cd']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/wildpioneer/AQA21onl.git']])

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean test"
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}