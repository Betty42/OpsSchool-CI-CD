#! groovy

node('docker') {

  def customImage = ''
  
  stage('create dockerfile') {
    sh '''
    tee Dockerfile <<-'EOF'
    FROM ubuntu:latest
    RUN touch file-01.txt
EOF
    '''
  }

  stage('build') {
    customImage = docker.build("training/webapp")
  }
  
  stage('test') {
    sh 'docker images'
  }
}
