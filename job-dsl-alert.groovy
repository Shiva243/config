def REMOTE_URL = 'https://github.gapinc.com/OrderManage/alert-search'
job("alert_search_master") {
    displayName('Alert Search Master')
    wrappers {
        credentialsBinding {
            usernamePassword('ARTIFACTORY_USERNAME', 'ARTIFACTORY_PASSWORD', 'artifactory_credential')
        }
    }
    scm {
        git {
            remote {
                url("${REMOTE_URL}.git")
            }
            branch("master")
        }
    }
    triggers {
        scm('* * * * *') {
            ignorePostCommitHooks()
        }
    }
    steps {
        gradle {
            tasks('clean build')
        }
    }
}
