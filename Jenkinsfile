pipeline {
    agent any

    environment {
        PATH = "/opt/homebrew/bin:/opt/homebrew/sbin:${env.PATH}"
    }

    stages {
        stage('Verificar herramientas') {
            steps {
                sh 'java -version && mvn -version'
            }
        }
        stage('Build & Test - Karate') {
            steps {
                sh 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            script {
                if (fileExists('target/karate-reports/karate-summary.html')) {
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/karate-reports',
                        reportFiles: 'karate-summary.html',
                        reportName: 'Reporte Karate'
                    ])
                } else {
                    echo 'No se generó karate-summary.html.'
                }
            }
            archiveArtifacts artifacts: 'target/karate-reports/**/*', allowEmptyArchive: true
        }
    }
}
